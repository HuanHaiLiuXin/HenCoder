package com.hencoder.hencoderpracticedraw1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;

import com.BaseActivity;
import com.jet.hencoder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/3/23 10:43
 */

public class Activity11 extends BaseActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();
    {
        pageModels.add(new PageModel(R.layout.sample_color,R.layout.practice_color,R.string.title_draw_color));
        pageModels.add(new PageModel(R.layout.sample_circle,R.layout.practice_circle,R.string.title_draw_circle));
        pageModels.add(new PageModel(R.layout.sample_rect,R.layout.practice_rect,R.string.title_draw_rect));
        pageModels.add(new PageModel(R.layout.sample_point, R.layout.practice_point,R.string.title_draw_point));
        pageModels.add(new PageModel(R.layout.sample_oval, R.layout.practice_oval,R.string.title_draw_oval));
        pageModels.add(new PageModel(R.layout.sample_line, R.layout.practice_line,R.string.title_draw_line));
        pageModels.add(new PageModel(R.layout.sample_round_rect, R.layout.practice_round_rect,R.string.title_draw_round_rect));
        pageModels.add(new PageModel(R.layout.sample_arc,R.layout.practice_arc,R.string.title_draw_arc));
        pageModels.add(new PageModel(R.layout.sample_path,R.layout.practice_path,R.string.title_draw_path));
        pageModels.add(new PageModel(R.layout.sample_histogram,R.layout.practice_histogram,R.string.title_draw_histogram));
        pageModels.add(new PageModel(R.layout.sample_pie_chart,R.layout.practice12_pie_chart,R.string.title_draw_pie_chart));
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
