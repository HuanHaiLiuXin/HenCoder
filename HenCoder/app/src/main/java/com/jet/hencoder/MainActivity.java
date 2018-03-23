package com.jet.hencoder;

import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.hencoder.hencoderpracticedraw1.Activity11;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goPracticeDraw1(View view) {
        jump(Activity11.class);
    }
}
