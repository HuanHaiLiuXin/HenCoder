package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/28 17:05
 */
public class Sample02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        paint.setShader(new RadialGradient(300,300,50,Color.BLUE,Color.RED, Shader.TileMode.REPEAT));
    }

    public Sample02RadialGradientView(Context context) {
        this(context,null,0);
    }
    public Sample02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300,300,200,paint);
    }
}
