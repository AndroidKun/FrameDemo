package com.example.g40_70m.framedemo.utils;

import android.widget.Toast;

import com.example.g40_70m.framedemo.MainApplication;


/**
 * Toast统一管理类
 */
public class T {

    private T() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(MainApplication.getApplication(), message, Toast.LENGTH_SHORT).show();
    }


    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong( CharSequence message) {
        if (isShow)
            Toast.makeText(MainApplication.getApplication(), message, Toast.LENGTH_LONG).show();
    }


    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(MainApplication.getApplication(), message, duration).show();
    }
    

  /*  public static void showFail(){
        if (isShow)
            Toast.makeText(MainApplication.getInstance().getApplicationContext(),MainApplication.getInstance().getApplicationContext().getResources().getString(R.string.request_fail), Toast.LENGTH_LONG).show();
    }*/

}