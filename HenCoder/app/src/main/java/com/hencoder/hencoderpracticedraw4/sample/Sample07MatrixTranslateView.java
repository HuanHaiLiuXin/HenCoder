package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/20 17:43
 */
public class Sample07MatrixTranslateView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    Matrix matrix = new Matrix();

    public Sample07MatrixTranslateView(Context context) {
        this(context,null,0);
    }
    public Sample07MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample07MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        paint.setDither(true);
        paint.setFilterBitmap(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        //
        canvas.save();
        matrix.reset();
        matrix.postScale(1.40F,1.40F);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
        //
        canvas.save();
        matrix.reset();
        //1:先平移
        matrix.postTranslate(0.0F,100);
        //2:平移后,当前Bitmap的中心点是x:1.40*width + 0.50*width;y:100+0.50*height
        matrix.postRotate(45.0F,bitmapWidth * 1.90F,100+bitmapHeight*0.50F);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,bitmapWidth * 1.40F,0,paint);
        canvas.restore();
        //
        canvas.save();
        matrix.reset();
        matrix.postSkew(-0.60F,0.0F,bitmapWidth/2,bitmapHeight * 1.40F+bitmapHeight/2);
        matrix.postTranslate(100,0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,bitmapHeight * 1.40F,paint);
        canvas.restore();
        //
        canvas.save();
        matrix.reset();
        matrix.postSkew(0.60F,0.0F);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
        //
    }
}