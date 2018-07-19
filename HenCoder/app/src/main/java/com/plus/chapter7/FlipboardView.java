package com.plus.chapter7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jet.hencoder.R;
import com.plus.Utils;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/7/18 16:43
 */
public class FlipboardView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private float imageSize = Utils.dp2px(240.0F);
    private float centerX;
    private float centerY;
    private float offsetX;
    private float offsetY;
    private Matrix matrix = new Matrix();
    private Camera camera = new Camera();
    private float currValue = 0.0F;
    private ObjectAnimator animator = ObjectAnimator.ofFloat(this,"currValue",0.0F,0.25F,0.75F,1.0F);

    public float getCurrValue() {
        return currValue;
    }
    public void setCurrValue(float currValue) {
        this.currValue = currValue;
        this.invalidate();
    }

    {
        bitmap = gainAppropriateBitmap((int) imageSize);
        animator.setDuration(1200);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        camera.setLocation(0,0,-16);
    }
    public void go(){
        animator.start();
    }

    public FlipboardView(Context context) {
        super(context);
    }
    public FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //头像Bitmap
    private Bitmap gainAppropriateBitmap(int width){
        Log.e("Jet","gainAppropriateBitmap:"+width);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //单纯获取图片原始宽度:inJustDecodeBounds = true
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.head,options);
        //获取到图片原始宽度后,inJustDecodeBounds变更为false
        options.inJustDecodeBounds = false;
        //inDensity:Bitmap原始像素值
        options.inDensity = options.outWidth;
        //inTargetDensity:生成的Bitmap被绘制到屏幕上的实际像素值
        options.inTargetDensity = width;
        Bitmap head = BitmapFactory.decodeResource(getResources(),R.mipmap.head,options);
        return head;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centerX = getWidth()/2;
        centerY = getHeight()/2;
        offsetX = (getWidth() - imageSize)/2;
        offsetY = (getHeight() - imageSize)/2;
        //重置Matrix
        matrix.reset();
        if(currValue <= 0.25F){
            //左半边正常绘制
            canvas.save();
            canvas.clipRect(0,0,centerX,getHeight());
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
            //右半边Y轴旋转
            camera.save();
            camera.rotateY(-45.0F * currValue / 0.25F);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-centerX,-centerY);
            matrix.postTranslate(centerX,centerY);
            canvas.save();
            canvas.clipRect(centerX,0,getWidth(),getHeight());
            canvas.concat(matrix);
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
        }else if(currValue <= 0.75F){
            //变化部分
            camera.save();
            camera.rotateX(-45.0F);
            canvas.save();
            canvas.translate(centerX,centerY);
            canvas.rotate(-180.0F * (currValue - 0.25F) / 0.50F);
            camera.applyToCanvas(canvas);
            camera.restore();
            canvas.clipRect(-centerX,-centerY,centerX,0);
            canvas.rotate(180.0F * (currValue - 0.25F) / 0.50F);
            canvas.translate(-centerX,-centerY);
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
            //不变部分
            canvas.save();
            canvas.rotate(-180.0F * (currValue - 0.25F) / 0.50F,centerX,centerY);
            canvas.clipRect(0,centerY,getWidth(),getHeight());
            canvas.rotate(180.0F * (currValue - 0.25F) / 0.50F,centerX,centerY);
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
        }else{
            //上半部分渐进沿X轴旋转至45度
            camera.save();
            camera.rotateX(-45.0F * (currValue - 0.75F) / 0.25F);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-centerX,-centerY);
            matrix.postTranslate(centerX,centerY);
            canvas.save();
            canvas.clipRect(0,0,getWidth(),centerY);
            canvas.concat(matrix);
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
            //下半部分沿X轴固定旋转-45度
            matrix.reset();
            camera.save();
            camera.rotateX(45.0F);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-centerX,-centerY);
            matrix.postTranslate(centerX,centerY);
            canvas.save();
            canvas.clipRect(0,centerY,getWidth(),getHeight());
            canvas.concat(matrix);
            canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
            canvas.restore();
        }
    }
}
