package com.bawei.hujintao.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 功能:  Fragment基类
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:43
 */
public abstract class BaseFragment <P extends BasePresenter>extends Fragment {
    protected P mpresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),layoutId(),null);
        mpresenter=providePresenter();
        if (mpresenter != null) {
            mpresenter.attach(this);
        }
        initView(view);
        return view;
    }

    protected abstract P providePresenter();

    protected abstract void initView(View view);

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mpresenter != null) {
            mpresenter.detach();
        }
    }
}
