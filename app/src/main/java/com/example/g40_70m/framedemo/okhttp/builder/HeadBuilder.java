package com.example.g40_70m.framedemo.okhttp.builder;


import com.example.g40_70m.framedemo.okhttp.OkHttpUtils;
import com.example.g40_70m.framedemo.okhttp.request.OtherRequest;
import com.example.g40_70m.framedemo.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
