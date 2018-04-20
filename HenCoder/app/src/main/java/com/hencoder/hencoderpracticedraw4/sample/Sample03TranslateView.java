package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/20 17:18
 */
public class Sample03TranslateView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private Point point1 = new Point(100,0);
    private Point point2 = new Point(400,100);
    private Point point3 = new Point(100,400);
    private Point point4 = new Point(400,400);

    public Sample03TranslateView(Context context) {
        this(context,null,0);
    }
    public Sample03TranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample03TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        paint.setDither(true);
        paint.setFilterBitmap(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //
        canvas.save();
        canvas.translate(-100,0);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);
        canvas.restore();
        //
        canvas.save();
        canvas.scale(1.20F,1.20F,point2.x + bitmap.getWidth()/2,point2.y + bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap,point2.x,point2.y,paint);
        canvas.restore();
        //
        canvas.save();
        canvas.rotate(135.0F,point3.x + bitmap.getWidth()/2,point3.y+bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap,point3.x,point3.y,paint);
        canvas.restore();
        //
        canvas.save();
        canvas.skew(0.60F,0.0F);
        canvas.drawBitmap(bitmap,point4.x,point4.y,paint);
        canvas.restore();
    }
}