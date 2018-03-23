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
 * 2018/3/23 15:09
 */

public class Practice2DrawCircleView extends View{
    private Paint paint;

    public Practice2DrawCircleView(Context context) {
        this(context,null,0);
    }
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200,100,100,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500,100,100,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200,400,100,paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        canvas.drawCircle(500,400,100,paint);
    }
}
