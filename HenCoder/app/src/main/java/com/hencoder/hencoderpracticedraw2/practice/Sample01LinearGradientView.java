package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/28 16:44
 */
public class Sample01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setShader(new LinearGradient(50,50,100,100, Color.parseColor("#024597"),Color.parseColor("#DCAB55"), Shader.TileMode.CLAMP));
    }

    public Sample01LinearGradientView(Context context) {
        this(context,null,0);
    }
    public Sample01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(300,300,300,paint);
        canvas.drawRect(0,0,250,250,paint);
        canvas.drawCircle(350,100,50,paint);
        paint.setShader(new LinearGradient(75,375,125,425,Color.parseColor("#DB6958"),Color.parseColor("#3BB150"), Shader.TileMode.MIRROR));
        canvas.drawCircle(100,400,100,paint);
    }
}
