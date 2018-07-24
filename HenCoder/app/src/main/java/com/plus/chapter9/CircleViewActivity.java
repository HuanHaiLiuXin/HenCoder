package com.plus.chapter9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.BaseActivity;
import com.jet.hencoder.R;

public class CircleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_view);
        getSupportActionBar().hide();
    }
}
