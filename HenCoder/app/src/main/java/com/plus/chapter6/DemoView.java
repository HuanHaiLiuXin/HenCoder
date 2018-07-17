package com.plus.chapter6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jet.hencoder.R;
import com.plus.Utils;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/7/17 16:03
 */
public class DemoView extends View {
    //仪表盘
    /*private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();
    private Path dash = new Path();
    private float DASH_WIDTH = Utils.dp2px(2);
    private PathDashPathEffect pathEffect;
    private float PADDING = Utils.dp2px(20);
    private float RADIUS;
    private float POINTER_LENGTH;
    private float START_ANGLE = 120.0F;
    PathMeasure pathMeasure = new PathMeasure();
    private float currValue = 0.0F;
    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(2));
        dash.addRect(0,0, Utils.dp2px(2),Utils.dp2px(8), Path.Direction.CW);
    }*/

    //饼图
    /*private float PADDING = Utils.dp2px(20);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float RADIUS;
    private float OFFSET_LENGTH = Utils.dp2px(8);
    private int[] colors = new int[]{
            Color.parseColor("#69AC2B"),
            Color.parseColor("#7BC2DB"),
            Color.parseColor("#F8C864"),
            Color.parseColor("#FF6F43")
    };
    private float[] values = new float[]{12.0F,34.0F,22.0F,60.0F};
    private RectF rectF = new RectF();
    private int outSegment = 2;
    {
        paint.setStyle(Paint.Style.FILL);
    }*/

    //圆形头像
    private float PADDING = Utils.dp2px(20);
    private float RADIUS;
    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private float borderWidth = Utils.dp2px(4);
    private RectF rectF = new RectF();
    {
        paint.setStyle(Paint.Style.FILL);
    }

    public DemoView(Context context) {
        super(context);
    }
    public DemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public DemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("Jet","DemoView:onDraw");
        super.onDraw(canvas);
        //仪表盘
        /*RADIUS = Math.min(getWidth(),getHeight()) / 2 - PADDING;
        POINTER_LENGTH = RADIUS - Utils.dp2px(12);
        path.reset();
        path.addArc(new RectF(getWidth()/2 - RADIUS,getHeight()/2 - RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS),START_ANGLE,360.0F - (START_ANGLE - 90.0F) * 2);
        pathMeasure.setPath(path,false);
        float pathLength = pathMeasure.getLength();
        canvas.drawPath(path,paint);
        pathEffect = new PathDashPathEffect(dash,(pathLength - DASH_WIDTH)/20,0, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathEffect);
        canvas.drawPath(path,paint);
        paint.setPathEffect(null);
        float currAngle = START_ANGLE + (360.0F - (START_ANGLE - 90.0F) * 2) * currValue / 20;
        double currRadian = Math.PI * currAngle / 180.0F;
        canvas.drawLine(getWidth()/2,getHeight()/2,(float)(getWidth()/2 + POINTER_LENGTH * Math.cos(currRadian)),(float) (getHeight()/2+POINTER_LENGTH*Math.sin(currRadian)),paint);*/

        //饼图
        /*RADIUS = Math.min(getWidth()/2,getHeight()/2) - PADDING;
        rectF.set(getWidth()/2 - RADIUS, getHeight()/2 - RADIUS, getWidth()/2 + RADIUS, getHeight()/2 + RADIUS);
        float totalValue = 0.0F;
        for (float value:values){
            totalValue += value;
        }
        float oneUnitAngle = 360.0F / totalValue;
        float usedAngle = 0.0F;
        for(int i = 0; i < colors.length; i++){
            paint.setColor(colors[i]);
            if(i == outSegment){
                float currMiddleAngle = usedAngle + values[i] * oneUnitAngle / 2;
                double currMiddleRadian = Math.PI * currMiddleAngle / 180.0F;
                rectF.offset((float) (OFFSET_LENGTH * Math.cos(currMiddleRadian)),(float)(OFFSET_LENGTH * Math.sin(currMiddleRadian)));
                canvas.drawArc(rectF,usedAngle,values[i] * oneUnitAngle,true,paint);
                rectF.offset((float) (-OFFSET_LENGTH * Math.cos(currMiddleRadian)),(float)(-OFFSET_LENGTH * Math.sin(currMiddleRadian)));
            }else{
                canvas.drawArc(rectF,usedAngle,values[i] * oneUnitAngle,true,paint);
            }
            usedAngle += values[i] * oneUnitAngle;
        }*/

        //圆形头像
        RADIUS = Math.min(getWidth()/2,getHeight()/2) - PADDING;
        canvas.drawCircle(getWidth()/2,getHeight()/2,RADIUS,paint);
        float innerRadius = RADIUS-borderWidth;
        rectF.set(getWidth()/2 -innerRadius,getHeight()/2 - innerRadius,getWidth()/2 + innerRadius,getHeight()/2 + innerRadius);
        Bitmap bitmap = gainAppropriateBitmap((int) (innerRadius * 2));
        int saveCount = canvas.saveLayer(rectF,paint);
        canvas.drawCircle(getWidth()/2,getHeight()/2,innerRadius,paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap,getWidth()/2 - innerRadius,getHeight()/2-innerRadius,paint);
        canvas.restoreToCount(saveCount);
        paint.setXfermode(null);
    }
    //圆形头像
    private Bitmap gainAppropriateBitmap(int width){
        Log.e("Jet","gainAppropriateBitmap:"+width);
        Bitmap headOri = BitmapFactory.decodeResource(getResources(), R.mipmap.head);
        Bitmap head = Bitmap.createScaledBitmap(headOri,width,width,true);
        return head;
    }
    //饼图
    /*public void setOutSegment(int outSegment){
        this.outSegment = outSegment % this.colors.length;
        invalidate();
    }*/
    //仪表盘
    /*public void setValue(float value){
        this.currValue = value;
        invalidate();
    }*/
}
