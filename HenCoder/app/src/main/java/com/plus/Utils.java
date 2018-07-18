package com.plus;

import android.content.res.Resources;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/7/17 10:18
 */
public final class Utils {
    private Utils(){
        throw new RuntimeException("工具类禁止创建实例");
    }

    public static float dp2px(float dp){
        return Resources.getSystem().getDisplayMetrics().density * dp;
    }
    public static int screenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
