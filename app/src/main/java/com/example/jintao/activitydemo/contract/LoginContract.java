package com.example.jintao.activitydemo.contract;

/**
 * Created by JinTao on 2017/2/16.
 */

public class LoginContract {

    public interface LoginView{
        String getUserName();
        String getPwd();
        void loginSuccess();
        void loginFailed(String errorMsg);
    }

    public interface LoginPresenter{
        void login(String userName,String pwd);
    }

}
