package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/4/20 16:53
 */
public class Sample02ClipPathView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Path path1 = new Path();
    Path path2 = new Path();
    Point point1 = new Point(200,200);
    Point point2 = new Point(600,200);

    public Sample02ClipPathView(Context context) {
        this(context,null,0);
    }
    public Sample02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        path1.addCircle(point1.x + 200, point1.y + 200, 150, Path.Direction.CW);
        path2.setFillType(Path.FillType.INVERSE_WINDING);
        path2.addCircle(point2.x + 200, point2.y + 200, 150, Path.Direction.CW);
        paint.setDither(true);
        paint.setFilterBitmap(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);
        canvas.restore();
        canvas.save();
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap,point2.x,point2.y,paint);
        canvas.restore();
    }
}