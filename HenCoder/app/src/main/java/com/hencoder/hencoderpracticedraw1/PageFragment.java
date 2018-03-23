package com.hencoder.hencoderpracticedraw1;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.jet.hencoder.R;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 13:55
 */

public class PageFragment extends Fragment {
    @LayoutRes int sampleLayoutRes;
    @LayoutRes int practiceLayoutRes;

    public static PageFragment newInstance(@LayoutRes int sampleLayoutRes,@LayoutRes int practiceLayoutRes){
        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes",sampleLayoutRes);
        args.putInt("practiceLayoutRes",practiceLayoutRes);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            this.sampleLayoutRes = args.getInt("sampleLayoutRes");
            this.practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);
        ViewStub sampleStub = view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();
        ViewStub practiceStub = view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();
        return view;
    }
}