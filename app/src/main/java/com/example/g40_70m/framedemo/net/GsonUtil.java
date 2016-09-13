package com.example.g40_70m.framedemo.net;

import com.google.gson.Gson;

/**
 * Created by G40-70M on 2016/9/8.
 */
public class GsonUtil {

    private static Gson gson = new Gson();

    public static Gson getGson(){
        return gson;
    }
}
