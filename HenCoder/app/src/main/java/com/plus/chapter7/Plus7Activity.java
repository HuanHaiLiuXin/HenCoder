package com.plus.chapter7;

import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.jet.hencoder.R;

public class Plus7Activity extends BaseActivity {
//    private FlipboardView demo;
    private MatrixSetPolyToPolyView demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus7);
        getSupportActionBar().hide();
        demo = findViewById(R.id.demo);
//        demo.go();
    }

    public void change(View view) {
        demo.go();
    }
}
