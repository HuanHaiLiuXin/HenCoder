package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 17:48
 */
public class Sample13ShadowLayerView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setColor(Color.parseColor("#296229"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(48);
        paint.setShadowLayer(10,5,5, Color.GREEN);
    }

    public Sample13ShadowLayerView(Context context) {
        this(context,null,0);
    }
    public Sample13ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample13ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("傻逼,当然选择原谅她呀!",0,100,paint);
    }
}
