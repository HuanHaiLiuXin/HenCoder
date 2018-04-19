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
 * 2018/4/19 16:18
 */
public class Sample08setTextSkewXView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setTextSize(40);
    }

    public Sample08setTextSkewXView(Context context) {
        this(context,null,0);
    }
    public Sample08setTextSkewXView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample08setTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = 100;
        paint.setTextSkewX(-0.60F);
        canvas.drawText("paint.setTextSkewX(-0.60F)",x,60,paint);
        paint.setTextSkewX(0.60F);
        canvas.drawText("paint.setTextSkewX(0.60F)",x,120,paint);
        paint.setTextSkewX(0.0F);
        paint.setTextScaleX(1.20F);
        canvas.drawText("paint.setTextScaleX(1.20F)",x,180,paint);
        paint.setTextScaleX(1.80F);
        canvas.drawText("paint.setTextScaleX(1.80F)",x,240,paint);
        paint.setTextScaleX(0.60F);
        canvas.drawText("paint.setTextScaleX(0.60F)",x,300,paint);
        paint.setTextScaleX(1.0F);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("paint.setTextAlign(Paint.Align.CENTER)",300,360,paint);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("paint.setTextAlign(Paint.Align.LEFT)",300,420,paint);
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("paint.setTextAlign(Paint.Align.RIGHT",300,480,paint);
    }
}
