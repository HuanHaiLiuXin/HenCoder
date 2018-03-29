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
 * 2018/3/29 20:13
 */
public class Sample15FillPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();
    {
        pathPaint.setStyle(Paint.Style.STROKE);
        path.moveTo(50,100);
        path.rLineTo(100,50);
        path.rLineTo(100,-60);
        path.rLineTo(100,110);
    }

    public Sample15FillPathView(Context context) {
        this(context,null,0);
    }
    public Sample15FillPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample15FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);
        paint.getFillPath(path,path1);
        canvas.drawPath(path,paint);

        canvas.save();
        canvas.translate(500,0);
        canvas.drawPath(path1,pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0,200);
        paint.setStyle(Paint.Style.STROKE);
        paint.getFillPath(path,path2);
        canvas.drawPath(path,paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500,200);
        canvas.drawPath(path2,pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0,400);
        paint.setStrokeWidth(40);
        paint.getFillPath(path,path3);
        canvas.drawPath(path,paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500,400);
        canvas.drawPath(path3,pathPaint);
        canvas.restore();
    }
}
