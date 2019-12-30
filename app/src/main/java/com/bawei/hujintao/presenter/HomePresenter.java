package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.model.HomeModel;

/**
 * 功能:  P页面
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:55
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView>  implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomeContract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(String json) {
                view.onSuccess(json);
            }

            @Override
            public void onFailure(Throwable e) {
                view.onFailure(e);
            }
        });
    }
}
