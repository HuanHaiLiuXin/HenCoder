package com.hencoder.hencoderpracticedraw4;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.BaseActivity;
import com.PageFragment;
import com.jet.hencoder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 10:43
 */

public class Activity14 extends BaseActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();
    {
        pageModels.add(new PageModel(R.layout.sample_clip_rect,R.layout.sample_clip_rect,R.string.title_clip_rect));
        pageModels.add(new PageModel(R.layout.sample_clip_path,R.layout.sample_clip_path,R.string.title_clip_path));
        pageModels.add(new PageModel(R.layout.sample_translate,R.layout.sample_translate,R.string.title_translate));
        pageModels.add(new PageModel(R.layout.sample_matrix_translate,R.layout.sample_matrix_translate,R.string.title_matrix_translate));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate,R.layout.sample_camera_rotate,R.string.title_camera_rotate));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_fixed,R.layout.sample_camera_rotate_fixed,R.string.title_camera_rotate_fixed));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_hitting_face,R.layout.sample_camera_rotate_hitting_face,R.string.title_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.layout.sample_flipboard,R.layout.sample_flipboard,R.string.title_flipboard));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_11);
        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PageFragment.newInstance(pageModels.get(position).sampleLayoutRes,pageModels.get(position).practiceLayoutRes);
            }
            @Override
            public int getCount() {
                return pageModels.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });
        tableLayout.setupWithViewPager(viewPager);
    }

    class PageModel{
        @LayoutRes int sampleLayoutRes;
        @LayoutRes int practiceLayoutRes;
        @StringRes int titleRes;

        public PageModel(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes, @StringRes int titleRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.practiceLayoutRes = practiceLayoutRes;
            this.titleRes = titleRes;
        }
    }
}
