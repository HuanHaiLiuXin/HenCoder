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
 * 2018/4/19 16:10
 */
public class Sample05SetFakeBoldTextView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String text = "Hello HenCoder";
    {
        paint.setTextSize(60);
    }

    public Sample05SetFakeBoldTextView(Context context) {
        this(context,null,0);
    }
    public Sample05SetFakeBoldTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample05SetFakeBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setFakeBoldText(true);
        canvas.drawText(text,50,100,paint);
        paint.setFakeBoldText(false);
        paint.setStrikeThruText(true);
        canvas.drawText(text,50,200,paint);
        paint.setStrikeThruText(false);
        paint.setUnderlineText(true);
        canvas.drawText(text,50,300,paint);
    }
}
