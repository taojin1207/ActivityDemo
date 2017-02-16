package com.example.jintao.activitydemo.presenter;

import com.example.jintao.activitydemo.activity.LoginActivity;
import com.example.jintao.activitydemo.base.BasePresenter;
import com.example.jintao.activitydemo.contract.LoginContract;
import com.example.jintao.activitydemo.model.LoginModel;


/**
 * Created by JinTao on 2017/2/16.
 */

public class LoginPresenter extends BasePresenter<LoginModel,LoginActivity> implements LoginContract.LoginPresenter{
    @Override
    protected LoginModel loadModel() {
        return new LoginModel();
    }

    @Override
    public void login(String userName, String pwd) {
        if(!getIView().checkNull())
        {
            if(getiModel().loginSuccess(userName,pwd))
            {
                getIView().loginSuccess();
            }else{
                getIView().loginFailed("密码或者账号不对");
            }
        }
    }
}
