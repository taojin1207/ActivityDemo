package com.example.jintao.activitydemo.base;

import com.example.jintao.activitydemo.mvp.IModel;
import com.example.jintao.activitydemo.mvp.IPresenter;
import com.example.jintao.activitydemo.mvp.IView;

import java.lang.ref.WeakReference;

/**
 * Created by JinTao on 2017/2/16.
 */

public abstract  class BasePresenter <M extends IModel,V extends IView> implements IPresenter{

    private WeakReference weakReference;
    protected V iView;
    protected M iModel;

    public M getiModel()
    {
        iModel = loadModel();
        return  iModel;
    }

    protected abstract M loadModel();

    @Override
    public void attachView(IView view) {
        weakReference = new WeakReference(view);
    }

    @Override
    public void dettachView() {
        if(weakReference != null)
        {
            weakReference.clear();

            weakReference = null;
        }
    }

    @Override
    public V getIView() {
        return (V) weakReference.get();
    }
}
