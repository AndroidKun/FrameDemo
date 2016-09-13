package com.example.g40_70m.framedemo.net;

import android.content.Context;

import com.example.g40_70m.framedemo.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by G40-70M on 2016/9/8.
 */
public class ResponseCallback extends Callback<String> {

    private final Context context;
    private final String url;
    private RequestCallBack requestCallBack;

    public ResponseCallback(Context context, String url,RequestCallBack requestCallBack){
        this.context = context;
        this.url = url;
        this.requestCallBack = requestCallBack;
    }

    @Override
    public void onBefore(Request request, int id) {
        requestCallBack.startRequest(url);
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {
        return response.body().string();
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        requestCallBack.onFail(url,e.getMessage());
    }

    @Override
    public void onResponse(String response, int id) {
        requestCallBack.onSuccess(url,response);
    }

    @Override
    public void onAfter(int id) {
        requestCallBack.finishRequest(url);
    }
}
