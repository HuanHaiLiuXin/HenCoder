package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 15:53
 */

public class Practice7DrawRoundRectView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice7DrawRoundRectView(Context context) {
        this(context,null,0);
    }
    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF1 = new RectF(100,100,500,300);
        canvas.drawRoundRect(rectF1,32,32,paint);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(12);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF2 = new RectF(100,320,500,520);
        canvas.drawRoundRect(rectF2,32,32,paint);
    }
}