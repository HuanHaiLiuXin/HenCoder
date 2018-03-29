package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/29 14:08
 */
public class Sample05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.batman_logo);
        BitmapShader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        ComposeShader shader = new ComposeShader(shader1,shader2, PorterDuff.Mode.SRC_OVER);
        paint.setShader(shader);
    }

    public Sample05ComposeShaderView(Context context) {
        this(context,null,0);
    }
    public Sample05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Sample05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300,300,300,paint);
    }
}
