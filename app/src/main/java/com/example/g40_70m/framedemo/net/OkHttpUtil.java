package com.example.g40_70m.framedemo.net;

import android.content.Context;

import com.example.g40_70m.framedemo.okhttp.OkHttpUtils;
import com.example.g40_70m.framedemo.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by 坤 on 2016/9/8.
 */
public class OkHttpUtil {

    private static OkHttpUtil okHttpUtil;

    private OkHttpUtil(){

    }

    public static OkHttpUtil getOkHttpUtil() {
        if (okHttpUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    /**
     * post&get请求
     * @param context
     * @param method
     * @param url
     * @param param
     * @param requestCallBack
     */
    public void requestData( Context context,int method, String url, Object param,RequestCallBack requestCallBack){
        if(method == URL.GET){
            if(param!=null) {
                OkHttpUtils.get().tag(context).url(url).params(BeanUtils.jsonToMap(param)).build().execute(new ResponseCallback(context,url,requestCallBack));
            }else{
                OkHttpUtils.get().tag(context).url(url).build().execute(new ResponseCallback(context,url,requestCallBack));
            }
        }else{
            if(param!=null) {
                OkHttpUtils.post().tag(context).url(url).params(BeanUtils.jsonToMap(param)).build().execute(new ResponseCallback(context,url,requestCallBack));
            }else{
                OkHttpUtils.post().tag(context).url(url).build().execute(new ResponseCallback(context,url,requestCallBack));
            }
        }
    }

    /**
     * 下载文件
     * @param url
     * @param filePath
     * @param fileName
     * @param callBack
     */
    public void loadFile(Context context,final String url, String filePath, String fileName, final LoadFileCallBack callBack){
        OkHttpUtils.get().tag(context).url(url).build().execute(new FileCallBack(filePath,fileName) {
            private long currentTimeMillis;
            @Override
            public void inProgress(float progress) {
                if(System.currentTimeMillis()-currentTimeMillis>1000){//1秒更新一次进度
                    callBack.inProgress((int) (progress*100));
                    currentTimeMillis = System.currentTimeMillis();
                }
            }

            @Override
            public void onError(Call call, Exception onError, int id) {
                callBack.loadFail(url,onError.getMessage());
            }

            @Override
            public void onResponse(File file, int id) {
                callBack.loadSuccess(url,file);
            }
        });
    }

    /**
     * 上传文件
     * @param context
     * @param url
     * @param file
     * @param requestCallBack
     */
    public void uploadFile(Context context,String url, File file,RequestCallBack requestCallBack){
        OkHttpUtils.postFile().tag(context).url(url).file(file).build().execute(new ResponseCallback(context,url,requestCallBack));
    }

    /**
     * 取消请求
     * @param context
     */
    public void cancleRequest(Context context){
        if(context==null) return;
        OkHttpUtils.getInstance().cancelTag(context);
    }
}
