package com.example.g40_70m.framedemo.net;

/**
 * Created by G40-70M on 2016/9/8.
 */
public interface RequestCallBack {
    void startRequest(String url);
    void finishRequest(String url);
    void onFail(String url, String error);
    void onSuccess(String url, String data);
}
