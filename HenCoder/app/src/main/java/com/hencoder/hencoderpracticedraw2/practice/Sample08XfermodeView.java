package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 14:53
 */
public class Sample08XfermodeView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap1;
    Bitmap bitmap2;
    Xfermode xfermode1 = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    Xfermode xfermode2 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    Xfermode xfermode3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    {
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ii1);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.ii3);
    }

    public Sample08XfermodeView(Context context) {
        this(context,null,0);
    }
    public Sample08XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveId = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG);
        //
        canvas.drawBitmap(bitmap1,0,0,paint);
        paint.setXfermode(xfermode1);
        canvas.drawBitmap(bitmap2,bitmap1.getWidth()-80,0,paint);
        paint.setXfermode(null);
        canvas.drawBitmap(bitmap1,bitmap1.getWidth()+bitmap2.getWidth(),0,paint);
        paint.setXfermode(xfermode2);
        canvas.drawBitmap(bitmap2,bitmap1.getWidth()+bitmap2.getWidth()+100,0,paint);
        paint.setXfermode(null);
        canvas.drawBitmap(bitmap1,0,bitmap1.getHeight()+100,paint);
        paint.setXfermode(xfermode3);
        canvas.drawBitmap(bitmap2,bitmap1.getWidth()-80,bitmap1.getHeight()+100,paint);
        paint.setXfermode(null);
        //
        canvas.restoreToCount(saveId);
    }
}
