package com.example.g40_70m.framedemo.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by 坤 on 2016/8/15.
 */
public class FileUtlis {

    private static final String CACHE_NAME = "cache";

    /**
     * 获取文件大小
     * @param path
     * @return
     */
    public static long getFileSize(String path) {
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }
    /**
     * 清空文件夹
     */
    public static void cleanFile(String path){
        File file = new File(path);
        if(!file.exists()) return;

        if(file.isFile()){
            file.delete();
            return;
        }
        if(file.isDirectory()){
            File[] childFile = file.listFiles();
            if(childFile == null || childFile.length == 0){
                file.delete();
                return;
            }
            for(File f : childFile){
                cleanFile(f.getPath());
            }
            file.delete();
        }
    }

    public static boolean isSDcardExist() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取外部存储路径
     * @return
     */
    public static String getStorageDirectoryCachePath(Context context){
        if(isSDcardExist()){
            return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator +CACHE_NAME;
        }
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)+ File.separator +CACHE_NAME;
    }
}
