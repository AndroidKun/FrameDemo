package com.example.g40_70m.framedemo.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Glide工具类
 * Created by 坤 on 2016/9/1.
 */
public class GlideUtils {

    /**
     * 普通加载
     * @param context
     * @param url
     * @param imageView
     */
    public static void disPlay(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 加载圆形图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void disPlayCircleImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url) .bitmapTransform(new CropCircleTransformation(context)).into(imageView);
    }

    /**
     * 加载圆角图片
     * @param context
     * @param url
     * @param imageView
     * @param round
     */
    public static void disPlayRoundImage(Context context, String url, ImageView imageView,int round){
        Glide.with(context).load(url) .bitmapTransform(new CropCircleTransformation(context)).bitmapTransform(new RoundedCornersTransformation(context,round,0, RoundedCornersTransformation.CornerType.ALL)).into(imageView);
    }

   /* *//**
     * 加载灰度处理图片
     * @param url
     * @param imageView
     *//*
    public static void disPlayGrayImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).bitmapTransform(new GrayscaleTransformation(context)).into(imageView);
    }
*/
    public static void disPlay(Activity activity, String url, ImageView imageView){
        Glide.with(activity).load(url).into(imageView);
    }
    public static void disPlayCircleImage(Activity activity, String url, ImageView imageView){
        Glide.with(activity).load(url) .bitmapTransform(new CropCircleTransformation(activity)).into(imageView);
    }
    public static void disPlayRoundImage(Activity activity, String url, ImageView imageView,int round){
        Glide.with(activity).load(url) .bitmapTransform(new CropCircleTransformation(activity)).bitmapTransform(new RoundedCornersTransformation(activity,round,0, RoundedCornersTransformation.CornerType.ALL)).into(imageView);
    }

    public static void disPlay(FragmentActivity activity, String url, ImageView imageView){
        Glide.with(activity).load(url).into(imageView);
    }
    public static void disPlayCircleImage(FragmentActivity activity, String url, ImageView imageView){
        Glide.with(activity).load(url) .bitmapTransform(new CropCircleTransformation(activity)).into(imageView);
    }
    public static void disPlayRoundImage(FragmentActivity activity, String url, ImageView imageView,int round){
        Glide.with(activity).load(url) .bitmapTransform(new CropCircleTransformation(activity)).bitmapTransform(new RoundedCornersTransformation(activity,round,0, RoundedCornersTransformation.CornerType.ALL)).into(imageView);
    }

    public static void disPlay(android.app.Fragment fragment, String url, ImageView imageView){
        Glide.with(fragment).load(url).into(imageView);
    }
    public static void disPlayCircleImage(android.app.Fragment fragment, String url, ImageView imageView){
        Glide.with(fragment).load(url) .bitmapTransform(new CropCircleTransformation(fragment.getActivity())).into(imageView);
    }
    public static void disPlayRoundImage(android.app.Fragment fragment, String url, ImageView imageView,int round){
        Glide.with(fragment).load(url) .bitmapTransform(new CropCircleTransformation(fragment.getActivity())).bitmapTransform(new RoundedCornersTransformation(fragment.getActivity(),round,0, RoundedCornersTransformation.CornerType.ALL)).into(imageView);
    }

    public static void disPlay(Fragment fragment, String url, ImageView imageView){
        Glide.with(fragment).load(url).into(imageView);
    }
    public static void disPlayCircleImage(Fragment fragment, String url, ImageView imageView){
        Glide.with(fragment).load(url) .bitmapTransform(new CropCircleTransformation(fragment.getActivity())).into(imageView);
    }
    public static void disPlayRoundImage(Fragment fragment, String url, ImageView imageView,int round){
        Glide.with(fragment).load(url) .bitmapTransform(new CropCircleTransformation(fragment.getActivity())).bitmapTransform(new RoundedCornersTransformation(fragment.getActivity(),round,0, RoundedCornersTransformation.CornerType.ALL)).into(imageView);
    }


    /**
     * 清除缓存
     */
    public static void cleanCache(final Context context){
        if(Thread.currentThread() == Looper.getMainLooper().getThread()) {
            //清除内存缓存需要在Ui线程执行
            Glide.get(context).clearMemory();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //清除磁盘缓存需要在非ui线程执行
                    Glide.get(context.getApplicationContext()).clearDiskCache();
                }
            }).start();
        }else{
            new Handler(context.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Glide.get(context).clearMemory();
                }
            });
            Glide.get(context.getApplicationContext()).clearDiskCache();
        }
    }
}
