package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 16:25
 */

public class Practice9DrawPathView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice9DrawPathView(Context context) {
        this(context,null,0);
    }
    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        Path path = new Path();
        RectF r1 = new RectF(100,100,400,400);
//        path.addArc(r1,135,225);
        path.addArc(r1,0,-225);
//        path.arcTo(r1,135,225);
        RectF r2 = new RectF(500,100,800,400);
//        path.arcTo(r2,-180,225,true);
        path.arcTo(r2,-180,225,false);
        path.lineTo(400,600);
        canvas.drawPath(path,paint);
    }
}