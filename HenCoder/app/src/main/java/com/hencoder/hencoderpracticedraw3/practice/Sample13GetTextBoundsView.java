package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/19 17:22
 */
public class Sample13GetTextBoundsView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String[] strs = new String[]{"Java","C++","C#","Python"};
    private float[] widths = new float[]{0,0,0,0};
    private float[] heights = new float[]{0,0,0,0};
    {
        paint.setTextSize(60);
        Rect rect = new Rect();
        for(int i=0;i<strs.length;i++){
            paint.getTextBounds(strs[i],0,strs[i].length(),rect);
            widths[i] = rect.right - rect.left;
            heights[i] = rect.bottom - rect.top;
        }
    }

    public Sample13GetTextBoundsView(Context context) {
        this(context,null,0);
    }
    public Sample13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(strs[0],100,100,paint);
        canvas.drawText(strs[1],100 + widths[0],100,paint);
        canvas.drawText(strs[2],100 + widths[0] + widths[1],100,paint);
        canvas.drawText(strs[3],100 + widths[0] + widths[1] + widths[2],100,paint);
        paint.setColor(Color.RED);
        canvas.drawText(strs[0],300,200,paint);
        canvas.drawText(strs[1],300,200 + heights[0],paint);
        canvas.drawText(strs[2],300,200 + heights[0] + heights[1],paint);
        canvas.drawText(strs[3],300,200 + heights[0] + heights[1] + heights[2],paint);
    }
}
