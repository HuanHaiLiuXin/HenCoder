package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/19 16:01
 */
public class Sample04SetTypefaceView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Typeface typeface;
    private String text = "Hello HenCoder";

    public Sample04SetTypefaceView(Context context) {
        this(context,null,0);
    }
    public Sample04SetTypefaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample04SetTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint.setTextSize(60);
        typeface = Typeface.createFromAsset(getContext().getAssets(),"Satisfy-Regular.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText(text,100,100,paint);
        paint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText(text,100,200,paint);
        paint.setTypeface(typeface);
        canvas.drawText(text,100,300,paint);
    }
}
