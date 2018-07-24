package com.plus.chapter9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.plus.Utils;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/7/24 15:20
 */
public class CircleView extends View {
    private int PADDING = (int) Utils.dp2px(30);
    private int RADIUS = (int) Utils.dp2px(100);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int width = (PADDING + RADIUS) * 2;
        int height = (PADDING + RADIUS) * 2;
        setMeasuredDimension(resolveSizeAndState(width,widthMeasureSpec,0),resolveSizeAndState(height,heightMeasureSpec,0));
        Log.e("Jet","CircleView width:"+getMeasuredWidth() + ";height:" + getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#F55328"));
        paint.setColor(Color.RED);
        canvas.drawCircle(PADDING + RADIUS,PADDING+RADIUS,RADIUS,paint);
    }
}
