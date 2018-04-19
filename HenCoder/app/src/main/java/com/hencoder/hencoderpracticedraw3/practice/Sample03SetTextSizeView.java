package com.hencoder.hencoderpracticedraw3.practice;

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
 * 2018/4/19 15:54
 */
public class Sample03SetTextSizeView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String text = "Hello HenCoder";

    public Sample03SetTextSizeView(Context context) {
        this(context,null,0);
    }
    public Sample03SetTextSizeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample03SetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = 50;
        float y = 100;
        paint.setTextSize(16);
        canvas.drawText(text,x,y,paint);
        y += 30;
        paint.setTextSize(24);
        canvas.drawText(text,x,y,paint);
        y += 40;
        paint.setTextSize(32);
        canvas.drawText(text,x,y,paint);
        y += 50;
        paint.setTextSize(40);
        canvas.drawText(text,x,y,paint);
    }
}
