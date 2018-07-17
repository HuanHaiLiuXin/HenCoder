package com.plus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.BaseActivity;
import com.jet.hencoder.R;
import com.plus.chapter6.Plus6Activity;

public class HenCoderPlusMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen_coder_plus_main);
        getSupportActionBar().hide();
    }

    public void goPlus6(View view) {
        jump(Plus6Activity.class);
    }
}
