package com.bawei.hujintao.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.presenter.HomePresenter;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 9:01
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {
    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layoutId() {
        return R.layout.home;
    }

    @Override
    protected void initData() {
        mpresenter.getHomeData();
    }

    @Override
    public void onSuccess(String json) {
        //成功吐司
        Toast.makeText(getContext(), ""+json, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable e) {
        Log.e("tag",e.getMessage());
    }
}
