package com.example.g40_70m.framedemo.net;

import java.io.File;

/**
 * Created by G40-70M on 2016/9/8.
 */
public interface LoadFileCallBack {
    void inProgress(int progress);
    void loadFail(String url, String error);
    void loadSuccess(String url, File file);
}
