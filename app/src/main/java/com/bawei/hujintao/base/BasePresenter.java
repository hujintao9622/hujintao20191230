package com.bawei.hujintao.base;

/**
 * 功能:  Presenter基类
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:55
 */
public abstract class BasePresenter <V>{
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
