package com.example.g40_70m.framedemo.utils;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * 自定义配置Glide
 * 需要配置AndroidManifest.xml 和混淆文件
 * Created by 坤 on 2016/9/1.
 */
public class MyGlideModule implements GlideModule{
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();//获取系统分配给应用的总内存大小
        int memoryCacheSize = maxMemory / 8;//设置图片内存缓存占用八分之一
        //设置内存缓存大小
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));

        // SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
        File cacheDir = context.getExternalCacheDir();//指定的是数据的缓存地址
        if(cacheDir==null){
            cacheDir = context.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        }
        int diskCacheSize = 1024 * 1024 * 30;//最多可以缓存多少字节的数据
        //设置磁盘缓存大小
        builder.setDiskCache(new DiskLruCacheFactory(cacheDir.getPath(), "glide", diskCacheSize));

        //设置图片解码格式
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }

}
