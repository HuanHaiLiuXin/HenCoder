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
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.jet.hencoder.R;

public class Sample13CameraRotateHittingFaceView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap originalBitmap;
    Bitmap bitmap;
    Camera camera = new Camera();
    private float degree;
    private ObjectAnimator animator = ObjectAnimator.ofFloat(this,"degree",0.0F,360.0F);
    Matrix matrix = new Matrix();
    private Point point = new Point(200, 50);
    float centerX;
    float centerY;

    public void setDegree(float degree) {
        this.degree = degree;
        this.invalidate();
    }

    public Sample13CameraRotateHittingFaceView(Context context) {
        this(context,null,0);
    }
    public Sample13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        originalBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.maps);
        bitmap = Bitmap.createScaledBitmap(originalBitmap,originalBitmap.getWidth() * 2, originalBitmap.getHeight() * 2,true);
        centerX = point.x + bitmap.getWidth()/2;
        centerY = point.y + bitmap.getHeight()/2;
        originalBitmap.recycle();
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        camera.setLocation(0,0,-10000);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        matrix.reset();
        camera.save();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point.x,point.y,paint);
        canvas.restore();
    }
}