package com.example.g40_70m.framedemo;

import android.app.Application;

import com.example.g40_70m.framedemo.okhttp.OkHttpUtils;
import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by G40-70M on 2016/9/12.
 */
public class MainApplication extends Application{
    private static MainApplication mainApplication;


    public static MainApplication getApplication(){
        if(mainApplication==null){
            synchronized (MainApplication.class){
                if(mainApplication==null){
                    mainApplication = new MainApplication();
                }
            }
        }
        return mainApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        LeakCanary.install(this);
        initOkHttp();
    }

    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
