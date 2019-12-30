package com.bawei.hujintao.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseAcitivity;
import com.bawei.hujintao.view.fragment.HomeFragment;
import com.bawei.hujintao.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAcitivity {

    private ViewPager vp;
    private RadioGroup rg;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment ot1 = OtherFragment.getInstance("分类");
        OtherFragment ot2 = OtherFragment.getInstance("发现");
        OtherFragment ot3 = OtherFragment.getInstance("购物车");
        OtherFragment ot4 = OtherFragment.getInstance("我的");
        list.add(homeFragment);
        list.add(ot1);
        list.add(ot2);
        list.add(ot3);
        list.add(ot4);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
        vp.setCurrentItem(0);
        rg.check(rg.getChildAt(0).getId());
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
