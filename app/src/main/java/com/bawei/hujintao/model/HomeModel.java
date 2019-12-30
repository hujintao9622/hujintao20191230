package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.util.NetUtil;

/**
 * 功能:  M页面
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:40
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(final IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getJsonGet("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                iModelCallBack.onSuccess(json);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onFailure(throwable);
            }
        });
    }
}
