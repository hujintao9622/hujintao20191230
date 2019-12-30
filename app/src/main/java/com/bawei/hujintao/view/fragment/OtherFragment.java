package com.bawei.hujintao.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.base.BasePresenter;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 9:04
 */
public class OtherFragment extends BaseFragment {

    private TextView name;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        name = view.findViewById(R.id.ot);
    }

    @Override
    protected int layoutId() {
        return R.layout.other;
    }

    @Override
    protected void initData() {
        String key = getArguments().getString("key");
        name.setText(key);
    }
//传值方法
    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
