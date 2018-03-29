package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 15:43
 */
public class Sample11StrokeMiterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    {
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        path.rLineTo(200,0);
        path.rLineTo(-160,120);
    }

    public Sample11StrokeMiterView(Context context) {
        this(context,null,0);
    }
    public Sample11StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample11StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(100,100);
        paint.setStrokeMiter(1);
        canvas.drawPath(path,paint);
        canvas.translate(300,0);
        paint.setStrokeMiter(3);
        canvas.drawPath(path,paint);
        canvas.translate(300,0);
        paint.setStrokeMiter(5);
        canvas.drawPath(path,paint);
    }
}
