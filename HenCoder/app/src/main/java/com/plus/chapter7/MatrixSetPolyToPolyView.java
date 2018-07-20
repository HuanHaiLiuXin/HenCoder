package com.plus.chapter7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
 * 2018/7/20 10:27
 */
public class MatrixSetPolyToPolyView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private float imageSize = Utils.dp2px(160.0F);
    private float centerX;
    private float centerY;
    private float offsetX;
    private float offsetY;
    float[] src;
    int srcIndex = 0;
    float[] dst;
    int dstIndex = 0;
    int pointCount = 4;
    private Matrix matrix = new Matrix();
    private float currValue = 0.0F;
    private ObjectAnimator animator = ObjectAnimator.ofFloat(this,"currValue",1.0F);

    public float getCurrValue() {
        return currValue;
    }
    public void setCurrValue(float currValue) {
        this.currValue = currValue;
        this.invalidate();
    }

    {
        bitmap = gainAppropriateBitmap((int) imageSize);
        animator.setDuration(8000);
        animator.setRepeatMode(ObjectAnimator.RESTART);
//        animator.setRepeatCount(ObjectAnimator.INFINITE);
    }
    public void go(){
        animator.start();
    }

    public MatrixSetPolyToPolyView(Context context) {
        super(context);
    }

    public MatrixSetPolyToPolyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MatrixSetPolyToPolyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        src = new float[]{offsetX,offsetY,offsetX + imageSize,offsetY,offsetX,offsetY+imageSize,offsetX+imageSize,offsetY+imageSize};
        dst = new float[]{offsetX + imageSize / 4 * currValue,offsetY - imageSize / 4 * currValue,offsetX + imageSize - imageSize / 4 * currValue,offsetY - imageSize / 4 * currValue,offsetX - imageSize / 4 * currValue,offsetY+imageSize + imageSize / 4 * currValue,offsetX+imageSize + imageSize / 4 * currValue,offsetY+imageSize + imageSize / 4 * currValue};
        matrix.setPolyToPoly(src,srcIndex,dst,dstIndex,pointCount);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,offsetX,offsetY,paint);
    }
}
