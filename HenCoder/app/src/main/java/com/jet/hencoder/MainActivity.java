package com.jet.hencoder;

import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.hencoder.hencoderpracticedraw1.Activity11;
import com.hencoder.hencoderpracticedraw2.Activity12;
import com.hencoder.hencoderpracticedraw3.Activity13;
import com.hencoder.hencoderpracticedraw4.Activity14;
import com.plus.HenCoderPlusMainActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void goPracticeDraw1(View view) {
        jump(Activity11.class);
    }

    public void goPracticeDraw2(View view) {
        jump(Activity12.class);
    }

    public void goPracticeDraw3(View view) {
        jump(Activity13.class);
    }

    public void goPracticeDraw4(View view) {
        jump(Activity14.class);
    }

    public void goPlus(View view) {
        jump(HenCoderPlusMainActivity.class);
    }
}
