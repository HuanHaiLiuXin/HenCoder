package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/26 10:55
 */

public class Practice12PieChartView extends View{
    //flyme6中7配色
    public static final int color_flyme_blue_sky = 0XFF198DED;      //天蓝
    public static final int color_flyme_blue_green = 0XFF04C0CF;    //蓝绿
    public static final int color_flyme_green = 0XFF3BC06B;         //绿
    public static final int color_flyme_yellow = 0XFFFFBE26;        //黄
    public static final int color_flyme_orange = 0XFFFC5B23;        //橙
    public static final int color_flyme_red_dark = 0XFFD33A2A;      //深红
    public static final int color_flyme_red_bright = 0XFFF12528;    //鲜红
    private List<PieData> items = new ArrayList<PieData>();
    {
        items.add(new PieData("天蓝",11,color_flyme_blue_sky,5,false));
        items.add(new PieData("蓝绿",33,color_flyme_blue_green,5,false));
        items.add(new PieData("绿",22,color_flyme_green,5,false));
        items.add(new PieData("黄",77,color_flyme_yellow,5,true));
        items.add(new PieData("橙",55,color_flyme_orange,5,false));
        items.add(new PieData("深红",8,color_flyme_red_dark,5,false));
        items.add(new PieData("鲜红",36,color_flyme_red_bright,5,false));
    }
    //画笔
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice12PieChartView(Context context) {
        this(context,null,0);
    }
    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //首先计算相关尺寸数值
        int totalWidth = getWidth();
        int totalHeight = getHeight();
        int topSpace = 80;
        int bottomSpace = 80;
        int drawHeight = totalHeight - topSpace - bottomSpace;
        int circleRadius = 0;
        circleRadius = drawHeight <= totalWidth/2 ? drawHeight /2 : totalWidth / 4;
        int centerX = totalWidth / 2;
        int centerY = topSpace + circleRadius;
        int obliqueLineLength = 30;
        int straightLineLength = 60;
        int separateDistance = 20;
        //将原始数据中的数值转换为实际角度值
        float totalValue = 0.0F;
        float totalPaddingAngle = 0.0F;
        for (PieData item:items){
            totalValue += item.value;
            totalPaddingAngle += item.rightPadding;
        }
        float totalDrawAngle = 360.0F - totalPaddingAngle;
        float calculatedAngle = 0;
        for(int i = 0; i< items.size(); i++){
            PieData item = items.get(i);
            if (i == items.size() - 1){
                item.realAngle = totalDrawAngle - calculatedAngle;
            }else{
                item.realAngle = totalDrawAngle * item.value / totalValue;
                calculatedAngle += item.realAngle;
            }
        }
        RectF pie = new RectF(centerX - circleRadius,centerY - circleRadius,centerX + circleRadius,centerY+circleRadius);
        //1:绘制背景色
        canvas.drawColor(Color.parseColor("#4B82A7"));
        //2:绘制饼图
        float startAngle = 0.0F;
        float halfAngle = 0.0F;
        for(PieData item:items){
            halfAngle = startAngle + item.realAngle / 2;
            if(!item.separate){
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(item.color);
                canvas.drawArc(pie,startAngle,item.realAngle,true,paint);
                //绘制标识文字
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(2);
                paint.setColor(Color.WHITE);
                float obliqueLineStartX = (float) (centerX + circleRadius * Math.cos(halfAngle * Math.PI / 180.0));
                float obliqueLineStartY = (float) (centerY + circleRadius * Math.sin(halfAngle * Math.PI / 180.0));
                float obliqueLineEndX = (float) (obliqueLineStartX + obliqueLineLength * Math.cos(halfAngle * Math.PI / 180.0));
                float obliqueLineEndY = (float) (obliqueLineStartY + obliqueLineLength * Math.sin(halfAngle * Math.PI / 180.0));
                if(halfAngle <= 90.0F || halfAngle >= 270.0F){
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2);
                    canvas.drawLines(new float[]{obliqueLineStartX,obliqueLineStartY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX + straightLineLength,obliqueLineEndY},paint);
                    paint.setStrokeWidth(0F);
                    paint.setTextSize(24);
                    paint.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText(item.msg,obliqueLineEndX + straightLineLength,obliqueLineEndY,paint);
                }else{
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2);
                    canvas.drawLines(new float[]{obliqueLineStartX,obliqueLineStartY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX - straightLineLength,obliqueLineEndY},paint);
                    paint.setStrokeWidth(0F);
                    paint.setTextSize(24);
                    paint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(item.msg,obliqueLineEndX - straightLineLength,obliqueLineEndY,paint);
                }
            }else{
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(item.color);
                float currCenterX = (float) (centerX + separateDistance * Math.cos(halfAngle * Math.PI / 180.0));
                float currCenterY = (float) (centerY + separateDistance * Math.sin(halfAngle * Math.PI / 180.0));
                RectF currPie = new RectF(currCenterX-circleRadius,currCenterY-circleRadius,currCenterX+circleRadius,currCenterY+circleRadius);
                canvas.drawArc(currPie,startAngle,item.realAngle,true,paint);
                //绘制标识文字
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(2);
                paint.setColor(Color.WHITE);
                float obliqueLineStartX = (float) (currCenterX + circleRadius * Math.cos(halfAngle * Math.PI / 180.0));
                float obliqueLineStartY = (float) (currCenterY + circleRadius * Math.sin(halfAngle * Math.PI / 180.0));
                float obliqueLineEndX = (float) (obliqueLineStartX + obliqueLineLength * Math.cos(halfAngle * Math.PI / 180.0));
                float obliqueLineEndY = (float) (obliqueLineStartY + obliqueLineLength * Math.sin(halfAngle * Math.PI / 180.0));
                if(halfAngle <= 90.0F || halfAngle >= 270.0F){
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2);
                    canvas.drawLines(new float[]{obliqueLineStartX,obliqueLineStartY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX + straightLineLength,obliqueLineEndY},paint);
                    paint.setStrokeWidth(0F);
                    paint.setTextSize(24);
                    paint.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText(item.msg,obliqueLineEndX + straightLineLength,obliqueLineEndY,paint);
                }else{
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2);
                    canvas.drawLines(new float[]{obliqueLineStartX,obliqueLineStartY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX,obliqueLineEndY,obliqueLineEndX - straightLineLength,obliqueLineEndY},paint);
                    paint.setStrokeWidth(0F);
                    paint.setTextSize(24);
                    paint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(item.msg,obliqueLineEndX - straightLineLength,obliqueLineEndY,paint);
                }
            }
            startAngle += item.realAngle + item.rightPadding;
        }
        //绘制底部文字"饼图"
        paint.setTextSize(48);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("饼图",totalWidth/2,totalHeight - 48,paint);
    }

    class PieData{
        public String msg;
        public float value;
        public @ColorInt int color;
        public int rightPadding;
        public boolean separate = false;
        public float realAngle;
        public PieData(String msg,float value,@ColorInt int color,int rightPadding,boolean separate){
            this.msg = msg;
            this.value = value;
            this.color = color;
            this.rightPadding = rightPadding;
            this.separate = separate;
        }
    }
}
