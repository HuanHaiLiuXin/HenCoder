package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 14:19
 */
public class Sample06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    ColorFilter colorFilter1;
    ColorFilter colorFilter2;
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i3);
        colorFilter1 = new LightingColorFilter(0X00FFFF,0X000000);
        colorFilter2 = new LightingColorFilter(0XFFFFFF,0X003000);
    }
    public Sample06LightingColorFilterView(Context context) {
        this(context,null,0);
    }
    public Sample06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColorFilter(colorFilter1);
        canvas.drawBitmap(bitmap,0,0,paint);
        paint.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap,bitmap.getWidth()+100,bitmap.getHeight(),paint);
    }
}
