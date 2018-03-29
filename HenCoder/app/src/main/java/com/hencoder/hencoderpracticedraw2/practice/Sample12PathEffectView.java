package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 17:01
 */
public class Sample12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    CornerPathEffect cornerPathEffect = new CornerPathEffect(20);
    DiscretePathEffect discretePathEffect = new DiscretePathEffect(20,5);
    SumPathEffect sumPathEffect = new SumPathEffect(cornerPathEffect,discretePathEffect);
    DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20,10,10,5},0);
    ComposePathEffect composePathEffect = new ComposePathEffect(cornerPathEffect,dashPathEffect);
    PathDashPathEffect pathDashPathEffect;
    {
        paint.setStyle(Paint.Style.STROKE);
        //path路径
        path.moveTo(50,50);
        path.rLineTo(50,100);
        path.rLineTo(50,-50);
        path.rLineTo(40,100);
        path.rLineTo(50,-120);
        //
        Path dashPath = new Path();
        dashPath.moveTo(10,0);
        dashPath.rLineTo(10,15);
        dashPath.rLineTo(-20,0);
        dashPath.close();
        pathDashPathEffect = new PathDashPathEffect(dashPath,30,0, PathDashPathEffect.Style.MORPH);
    }

    public Sample12PathEffectView(Context context) {
        this(context,null,0);
    }
    public Sample12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(250,0);
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.save();
        canvas.translate(0,200);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.save();
        canvas.translate(250,200);
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.save();
        canvas.translate(0,400);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.save();
        canvas.translate(250,400);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
}
