package com.plus.chapter9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.jet.hencoder.R;

public class Plus9Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus9);
        getSupportActionBar().hide();
    }

    public void goSquareImageView(View view) {
        jump(SquareImageViewActivity.class);
    }

    public void goCircleView(View view) {
        jump(CircleViewActivity.class);
    }

    public void goTagLayout(View view) {
        jump(TagLayoutActivity.class);
    }
}
