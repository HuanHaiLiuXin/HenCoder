package com.hencoder.hencoderpracticedraw4.sample;

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
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.jet.hencoder.R;

public class Sample14FlipboardView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private float centerX;
    private float centerY;
    private float left;
    private float top;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private float degree;
    private ObjectAnimator animator = ObjectAnimator.ofFloat(this,"degree",0.0F,180.0F);
    public void setDegree(float degree) {
        this.degree = degree;
        this.invalidate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    public Sample14FlipboardView(Context context) {
        this(context,null,0);
    }
    public Sample14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.maps);
        animator.setDuration(2000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centerX = getWidth()/2;
        centerY = getHeight()/2;
        left = centerX - bitmap.getWidth() / 2;
        top = centerY - bitmap.getHeight() / 2;
        //1:绘制上半部分
        canvas.save();
        canvas.clipRect(0,0,getWidth(),centerY);
        canvas.drawBitmap(bitmap,left,top,paint);
        canvas.restore();
        //2:绘制下半部分
        matrix.reset();
        camera.save();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        canvas.save();
        if(degree<90.0F){
            canvas.clipRect(0,centerY,getWidth(),getHeight());
        }else{
            canvas.clipRect(0,0,getWidth(),centerY);
        }
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,left,top,paint);
        canvas.restore();
    }
}