package com.bawei.hujintao.contract;

/**
 * 功能:  契约
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:45
 */
public interface IHomeContract {
    interface IView{
        void onSuccess(String json);
        void onFailure(Throwable e);
    }
    interface IPresenter{
        void getHomeData();
    }
    interface IModel{
        void getHomeData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onSuccess(String json);
            void onFailure(Throwable e);
        }
    }
}
