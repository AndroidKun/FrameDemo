package com.example.g40_70m.framedemo.utils;

import android.text.TextUtils;
import android.util.Log;


/**
 * Log统一管理类
 *
 * @author way
 */
public class L {

    /**********日志开关******/
    private static boolean isDebug = true;// 是否需要打印bug，
    /**********日子前缀******/
    private static final String TAG = "AAA";

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }



    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            if(TextUtils.isEmpty(msg)) msg = "获取不到错误信息";
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }
}