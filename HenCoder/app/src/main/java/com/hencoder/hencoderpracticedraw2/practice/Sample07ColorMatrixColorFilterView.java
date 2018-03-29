package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 14:38
 */
public class Sample07ColorMatrixColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.5F);
        colorMatrix.setScale(2.0F,2.5F,2.5F,1.0F);
        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorFilter);
    }

    public Sample07ColorMatrixColorFilterView(Context context) {
        this(context,null,0);
    }
    public Sample07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
