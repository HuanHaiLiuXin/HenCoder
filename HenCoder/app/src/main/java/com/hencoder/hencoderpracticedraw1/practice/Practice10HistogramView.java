package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 17:17
 */

public class Practice10HistogramView extends View{
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice10HistogramView(Context context) {
        this(context,null,0);
    }
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        //72B916
        super.onDraw(canvas);
        String[] items = new String[]{
                "Froyo",
                "GB",
                "ICS",
                "JB",
                "KitKat",
                "L",
                "M"
        };
        canvas.drawColor(Color.parseColor("#4B82A7"));
        int width = getWidth();
        int height = 500;
        int startX = 40;
        int endX = width - 40;
        int space = (items.length + 1) * 30;
        int itemWidth = (width - 40 * 2 - space) / items.length;
        int itemTotalWidth = itemWidth + 30;
        int itemStartX = startX + 30;
        //绘制柱形
        mPaint.setColor(Color.parseColor("#72B916"));
        mPaint.setStyle(Paint.Style.FILL);
        for(int i=0;i<items.length;i++){
            int itemHeight = new Random().nextInt(height);
            int currStartX = itemStartX + itemTotalWidth * i;
            int currStartY = height - itemHeight + 50;
            canvas.drawRect(currStartX,currStartY,currStartX+itemWidth,500 + 50,mPaint);
        }
        //绘制坐标轴线
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawLines(new float[]{startX,50,startX,height+50,startX,height+50-4/2,width-40,height+50-4/2},mPaint);
        //绘制柱形下方的注释文字
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(32);
        for(int i=0;i<items.length;i++){
            int currStartX = itemStartX + itemTotalWidth * i;
            canvas.drawText(items[i],currStartX,height+ 50 + 40,mPaint);
        }
        //绘制底部文字"直方图"
        int bottom = getHeight() - 80;
        mPaint.setTextSize(48);
        canvas.drawText("直方图",width/2 - 80,bottom,mPaint);
    }
}
