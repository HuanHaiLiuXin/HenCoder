package com.plus.chapter6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.jet.hencoder.R;

public class Plus6Activity extends BaseActivity {
    private DemoView demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus6);
        getSupportActionBar().hide();
        demo = findViewById(R.id.demo);
    }

    public void change(View view) {
//        demo.setValue(7.6F);
//        demo.setOutSegment(1);
    }
}
