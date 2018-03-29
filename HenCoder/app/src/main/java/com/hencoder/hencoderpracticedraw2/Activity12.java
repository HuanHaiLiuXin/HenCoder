package com.hencoder.hencoderpracticedraw2;

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

public class Activity12 extends BaseActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();
    {
        pageModels.add(new PageModel(R.layout.practice_linear_gradient,R.layout.practice_linear_gradient,R.string.title_linear_gradient));
        pageModels.add(new PageModel(R.layout.practice_radial_gradient,R.layout.practice_radial_gradient,R.string.title_radial_gradient));
        pageModels.add(new PageModel(R.layout.practice_sweep_gradient,R.layout.practice_sweep_gradient,R.string.title_sweep_gradient));
        pageModels.add(new PageModel(R.layout.practice_bitmap_shader,R.layout.practice_bitmap_shader,R.string.title_bitmap_shader));
        pageModels.add(new PageModel(R.layout.practice_compose_shader,R.layout.practice_compose_shader,R.string.title_compose_shader));
        pageModels.add(new PageModel(R.layout.practice_lighting_color_filter,R.layout.practice_lighting_color_filter,R.string.title_lighting_color_filter));
        pageModels.add(new PageModel(R.layout.practice_porterduff_color_filter,R.layout.practice_porterduff_color_filter,R.string.title_porterduff_color_filter));
        pageModels.add(new PageModel(R.layout.practice_color_matrix_color_filter,R.layout.practice_color_matrix_color_filter,R.string.title_color_matrix_color_filter));
        pageModels.add(new PageModel(R.layout.practice_xfermode,R.layout.practice_xfermode,R.string.title_xfermode));
        pageModels.add(new PageModel(R.layout.practice_stroke_cap,R.layout.practice_stroke_cap,R.string.title_stroke_cap));
        pageModels.add(new PageModel(R.layout.practice_stroke_join,R.layout.practice_stroke_join,R.string.title_stroke_join));
        pageModels.add(new PageModel(R.layout.practice_stroke_miter,R.layout.practice_stroke_miter,R.string.title_stroke_miter));
        pageModels.add(new PageModel(R.layout.practice_path_effect,R.layout.practice_path_effect,R.string.title_path_effect));
        pageModels.add(new PageModel(R.layout.practice_shadow_layer,R.layout.practice_shadow_layer,R.string.title_shader_layer));
        pageModels.add(new PageModel(R.layout.practice_mask_filter,R.layout.practice_mask_filter,R.string.title_mask_filter));
        pageModels.add(new PageModel(R.layout.practice_fill_path,R.layout.practice_fill_path,R.string.title_fill_path));
        pageModels.add(new PageModel(R.layout.practice_text_path,R.layout.practice_text_path,R.string.title_text_path));
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
