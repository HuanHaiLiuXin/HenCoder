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
 * 2018/3/23 15:28
 */

public class Practice4DrawPointView extends View{
    private Paint paint;
    public Practice4DrawPointView(Context context) {
        this(context,null,0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(40);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setColor(Color.BLACK);
        canvas.drawPoint(40,40,paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.RED);
        canvas.drawPoint(200,40,paint);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setColor(Color.GREEN);
        canvas.drawPoints(new float[]{100,300,200,300,100,400,200,400},paint);
    }
}
