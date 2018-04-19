package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample14GetFontMetricsView extends View {
    private String texts = "AaJjÂâ";
    Paint.FontMetrics fontMetrics;
    private float top = 200;
    private float bottom = 400;
    private float rectStrokeWidth = 20;
    private float textY = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setTextSize(bottom - top - rectStrokeWidth * 2);
        fontMetrics = paint.getFontMetrics();
//        textY = (top + bottom) / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;
        textY = (top + bottom) / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent;
    }

    public Sample14GetFontMetricsView(Context context) {
        this(context,null,0);
    }
    public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(rectStrokeWidth);
        paint.setColor(Color.RED);
        canvas.drawRect(100,top,getWidth()-100,bottom,paint);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(0);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(texts,100,textY,paint);
    }
}
