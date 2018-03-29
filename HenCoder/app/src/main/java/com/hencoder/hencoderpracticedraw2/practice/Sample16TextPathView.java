package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 20:32
 */
public class Sample16TextPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path textPath = new Path();
    String text = "Hello HenCoder";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(120);
        paint.getTextPath(text,0,text.length(),100,400,textPath);
        canvas.drawText(text,0,120,paint);
        pathPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(textPath,pathPaint);
    }

    public Sample16TextPathView(Context context) {
        this(context,null,0);
    }
    public Sample16TextPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample16TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
