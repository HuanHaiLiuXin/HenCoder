package com.hencoder.hencoderpracticedraw1.practice;

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
 * 2018/3/23 15:46
 */

public class Practice6DrawLineView extends View{
    private Paint paint;

    public Practice6DrawLineView(Context context) {
        this(context,null,0);
    }
    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        canvas.drawLine(100,100,300,400,paint);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(8);
        canvas.drawLines(new float[]{100,500,400,500,20,600,480,600,250,500,250,600},paint);
    }
}