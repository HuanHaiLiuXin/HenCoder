package com.jet.hencoder;

import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.hencoder.hencoderpracticedraw1.Activity11;
import com.hencoder.hencoderpracticedraw2.Activity12;
import com.hencoder.hencoderpracticedraw3.Activity13;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
