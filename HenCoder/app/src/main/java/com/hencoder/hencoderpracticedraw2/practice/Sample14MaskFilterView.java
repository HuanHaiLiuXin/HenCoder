package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 19:33
 */
public class Sample14MaskFilterView extends View {
    BlurMaskFilter filter1 = new BlurMaskFilter(50,BlurMaskFilter.Blur.NORMAL);
    BlurMaskFilter filter2 = new BlurMaskFilter(50,BlurMaskFilter.Blur.INNER);
    BlurMaskFilter filter3 = new BlurMaskFilter(50,BlurMaskFilter.Blur.OUTER);
    BlurMaskFilter filter4 = new BlurMaskFilter(50,BlurMaskFilter.Blur.SOLID);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Sample14MaskFilterView(Context context) {
        this(context,null,0);
    }
    public Sample14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ii3);
        paint.setMaskFilter(filter1);
        canvas.drawBitmap(bitmap,100,50,paint);
        paint.setMaskFilter(filter2);
        canvas.drawBitmap(bitmap,100 + bitmap.getWidth() + 50,50,paint);
        paint.setMaskFilter(filter3);
        canvas.drawBitmap(bitmap,100,50 + bitmap.getHeight() + 50,paint);
        paint.setMaskFilter(filter4);
        canvas.drawBitmap(bitmap,100 + bitmap.getWidth() + 50,50 + bitmap.getHeight() + 50,paint);
    }
}
