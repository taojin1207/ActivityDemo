package com.example.jintao.activitydemo.utils;

import android.util.Log;

import com.example.jintao.activitydemo.BuildConfig;

/**
 * Created by JinTao on 2017/2/16.
 */

public class LogUtils {
    public static final boolean isDebug = BuildConfig.DEBUG;


    /**
     * 打印一个debug等级的 log
     */
    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d("demo_" + tag, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e("demo" + tag, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (isDebug) {
            Log.e("demo" + cls.getSimpleName(), msg);
        }
    }
}
