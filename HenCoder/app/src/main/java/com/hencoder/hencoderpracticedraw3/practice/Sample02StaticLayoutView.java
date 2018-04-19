package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/19 15:37
 */
public class Sample02StaticLayoutView extends View {
    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private String text = "Hello\nHenCoder";
    StaticLayout staticLayout;
    {
        textPaint.setTextSize(60);
        staticLayout = new StaticLayout(text,textPaint,600, Layout.Alignment.ALIGN_NORMAL,1,0,true);
    }

    public Sample02StaticLayoutView(Context context) {
        this(context,null,0);
    }
    public Sample02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(50,40);
        staticLayout.draw(canvas);
        canvas.restore();
    }
}
