package com.example.jintao.activitydemo.model;

import com.example.jintao.activitydemo.mvp.IModel;

/**
 * Created by JinTao on 2017/2/16.
 */

public class LoginModel implements IModel {

    public boolean loginSuccess(String userName,String pwd)
    {
        boolean isLogin = false;
        if("zhangsan".equals(userName)&&"123456".equals(pwd
        ))
        {
            isLogin = true;
        }else{
            isLogin = false;
        }
        return  isLogin;
    }
}
