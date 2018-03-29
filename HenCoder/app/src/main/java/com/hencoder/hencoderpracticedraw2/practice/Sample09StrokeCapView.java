package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 15:19
 */
public class Sample09StrokeCapView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Sample09StrokeCapView(Context context) {
        this(context,null,0);
    }
    public Sample09StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample09StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,100,500,100,paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,200,500,200,paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,300,500,300,paint);
    }
}
