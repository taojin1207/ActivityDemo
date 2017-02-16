package com.example.jintao.activitydemo.mvp;

/**
 * Created by JinTao on 2017/2/16.
 */

public interface IPresenter<V extends IView> {

    /**
     *presenter绑定view
     */

    void attachView(V view);

    /**
     * 防止内存泄露清除presenter与view的绑定
     */

    void dettachView();

    /**
     * 获取view
     */

    IView getIView();



}
