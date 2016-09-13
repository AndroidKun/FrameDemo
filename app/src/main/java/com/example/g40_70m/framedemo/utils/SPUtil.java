package com.example.g40_70m.framedemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 坤 on 2016/6/17.
 */
public class SPUtil {

    //存储的sharedpreferences文件名
    private static final String FILE_NAME = "app_data";
    //启动页判断
    public static final String SP_ISFIRST = "1";

    /**
     * 帐号信息
     */
    public static final String SP_PHONE_DES3 = "SP_PHONE_DES3";
    public static final String SP_PWD_DES3 = "SP_PWD_DES3";


    /**
     * 第三方登录信息
     */
    public static final String SP_OPENID = "SP_OPENID";
    public static final String SP_NICKNAME = "SP_NICKNAME";
    public static final String SP_TYPE = "SP_TYPE";
    public static final String SP_GENDER = "SP_GENDER";
    public static final String SP_USERHEADIMAGE = "SP_USERHEADIMAGE";


    public static final String SP_FIRST_START = "FIRST_START";


    /**
     * 保存数据到文件
     *
     * @param context
     * @param key
     * @param data
     */
    public static void saveData(Context context, String key, Object data) {
        String type;
        if (data == null) {
            type = "".getClass().getSimpleName();
        } else {
            type = data.getClass().getSimpleName();
        }
        SharedPreferences sharedPreferences = context
                .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) data);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) data);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) data);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) data);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) data);
        }

        editor.commit();
    }

    /**
     * 从文件中读取数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static Object getData(Context context, String key, Object defValue) {
        String type;
        if (defValue == null) {
            type = "".getClass().getSimpleName();
        } else {
            type = defValue.getClass().getSimpleName();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences
                (FILE_NAME, Context.MODE_PRIVATE);

        //defValue为为默认值，如果当前获取不到数据就返回它
        if ("Integer".equals(type)) {
            return sharedPreferences.getInt(key, (Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return sharedPreferences.getBoolean(key, (Boolean) defValue);
        } else if ("String".equals(type)) {
            return sharedPreferences.getString(key, (String) defValue);
        } else if ("Float".equals(type)) {
            return sharedPreferences.getFloat(key, (Float) defValue);
        } else if ("Long".equals(type)) {
            return sharedPreferences.getLong(key, (Long) defValue);
        }

        return null;
    }

    public static void cleanData(Context context) {
        saveData(context, SP_PHONE_DES3, null);
        saveData(context, SP_PWD_DES3, null);
        /* saveData(context,SP_OPENID,null);
        saveData(context,SP_NICKNAME,null);
        saveData(context,SP_TYPE,null);
        saveData(context,SP_GENDER,null);
        saveData(context,SP_USERHEADIMAGE,null);*/
    }
}
