package com.hencoder.hencoderpracticedraw4.sample;

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
import android.view.View;

import com.jet.hencoder.R;


public class Sample11CameraRotateView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private Camera camera = new Camera();
    private Point point1 = new Point(100,100);
    private Point point2 = new Point(500,300);

    public Sample11CameraRotateView(Context context) {
        this(context,null,0);
    }
    public Sample11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample11CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.maps);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerx1 = point1.x + bitmap.getWidth()/2;
        float centery1 = point1.y + bitmap.getHeight()/2;
        float centerx2 = point2.x + bitmap.getWidth()/2;
        float centery2 = point2.y + bitmap.getHeight()/2;

        Matrix matrix = new Matrix();
        //
        matrix.reset();
        camera.save();
        camera.rotateX(40.0F);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerx1,-centery1);
        matrix.postTranslate(centerx1,centery1);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);
        canvas.restore();
        //
        matrix.reset();
        camera.save();
        camera.rotateY(40.0F);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerx2,-centery2);
        matrix.postTranslate(centerx2,centery2);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point2.x,point2.y,paint);
        canvas.restore();
    }
}
