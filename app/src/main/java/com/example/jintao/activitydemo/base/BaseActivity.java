package com.example.jintao.activitydemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.jintao.activitydemo.mvp.IView;
import com.example.jintao.activitydemo.utils.LogUtils;

/**
 * Created by JinTao on 2017/2/16.
 */

public abstract class BaseActivity<P extends  BasePresenter> extends AppCompatActivity implements IView,View.OnClickListener {

    protected View view;
    protected  P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        mPresenter = lodaPresenter();
        initCommponData();
        initView();
        initListener();
        initData();
    }

    protected  abstract  P lodaPresenter();

    private void initCommponData()
    {
        if(mPresenter != null)
        {
            mPresenter.attachView(this);
        }
    }

    protected  abstract int  getLayoutId();
    protected  abstract void  initView();
    protected  abstract void  initData();
    protected  abstract void  initListener();
    protected  abstract void  otherViewClick(View view);



    /**
     * @return 显示的内容
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            default: otherViewClick(view);
               break;
        }
    }

    public void toast(String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

    public void toast(int  contentId)
    {
        Toast.makeText(this,contentId+"",Toast.LENGTH_LONG).show();
    }

    /**
     * 日志的处理
     */

    public void LogE(String str)
    {
        LogUtils.e(getClass(),str);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (mPresenter != null)
        {
            mPresenter.dettachView();
            mPresenter = null;
        }
    }
}
