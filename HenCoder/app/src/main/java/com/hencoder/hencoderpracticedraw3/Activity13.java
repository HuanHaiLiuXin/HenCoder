package com.hencoder.hencoderpracticedraw3;

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

public class Activity13 extends BaseActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();
    {
        pageModels.add(new PageModel(R.layout.sample_draw_text,R.layout.sample_draw_text,R.string.title_draw_text));
        pageModels.add(new PageModel(R.layout.sample_static_layout, R.layout.sample_static_layout,R.string.title_static_layout));
        pageModels.add(new PageModel(R.layout.sample_set_text_size, R.layout.sample_set_text_size,R.string.title_set_text_size));
        pageModels.add(new PageModel(R.layout.sample_set_typeface, R.layout.sample_set_typeface,R.string.title_set_typeface));
        pageModels.add(new PageModel(R.layout.sample_set_fake_bold_text, R.layout.sample_set_fake_bold_text,R.string.title_set_fake_bold_text));
        pageModels.add(new PageModel(R.layout.sample_set_text_skew_x, R.layout.sample_set_text_skew_x,R.string.title_set_text_skew_x));
        pageModels.add(new PageModel(R.layout.sample_get_font_spacing, R.layout.sample_get_font_spacing,R.string.title_get_font_spacing));
        pageModels.add(new PageModel(R.layout.sample_measure_text, R.layout.sample_measure_text,R.string.title_measure_text));
        pageModels.add(new PageModel(R.layout.sample_get_text_bounds, R.layout.sample_get_text_bounds,R.string.title_get_text_bounds));
        pageModels.add(new PageModel(R.layout.sample_get_font_metrics, R.layout.sample_get_font_metrics,R.string.title_get_font_metrics));
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
