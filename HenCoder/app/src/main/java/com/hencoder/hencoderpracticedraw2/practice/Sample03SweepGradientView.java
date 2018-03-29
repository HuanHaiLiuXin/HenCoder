package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/28 17:14
 */
public class Sample03SweepGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setShader(new SweepGradient(300,300, Color.parseColor("#2A5380"),Color.parseColor("#FFCE44")));
    }
    public Sample03SweepGradientView(Context context) {
        this(context,null,0);
    }
    public Sample03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300,300,300,paint);
        canvas.drawCircle(600,300,100,paint);
        canvas.drawCircle(900,500,100,paint);
        canvas.drawCircle(100,100,100,paint);
    }
}
