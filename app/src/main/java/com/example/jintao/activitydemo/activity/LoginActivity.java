package com.example.jintao.activitydemo.activity;

import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.jintao.activitydemo.R;
import com.example.jintao.activitydemo.base.BaseActivity;
import com.example.jintao.activitydemo.contract.LoginContract;
import com.example.jintao.activitydemo.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by JinTao on 2017/2/16.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    @InjectView(R.id.input_email)
    EditText emial;
    @InjectView(R.id.input_pwd)
    EditText pwd;
    @InjectView(R.id.btn_login)
    AppCompatButton btnLogin;



    @Override
    protected LoginPresenter lodaPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void otherViewClick(View view) {
        mPresenter.login(getUserName(),getPwd());
    }


    @Override
    public String getUserName() {
        return emial.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return pwd.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        toast("成功");
    }

    @Override
    public void loginFailed(String errorMsg) {
        toast(errorMsg);
    }

    public boolean checkNull()
    {
      boolean isNull = false;
        if(TextUtils.isEmpty(getUserName()))
        {
            emial.setError("账号不能为空");
            isNull = true;
        }
        if(TextUtils.isEmpty(getPwd())){
            pwd.setError("密码不能为空");
            isNull = true;
        }
        return  isNull;
    }
}
