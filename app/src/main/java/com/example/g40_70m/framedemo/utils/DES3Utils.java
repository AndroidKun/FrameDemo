package com.example.g40_70m.framedemo.utils;


import android.text.TextUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES加密解密工具类
 * Created by 坤 on 2016/7/29.
 */
public class DES3Utils {

    // 密钥
    private final static String secretKey = "kj92k00g21kdda8162dfeudl";
    // 向量
    private final static String iv = "92826898";
    // 加解密统一使用的编码方式
    private final static String encoding = "UTF-8";

    /**
     * 3DES加密并UrL转码
     *
     * @param plainText 普通文本
     * @return
     * @throws Exception
     */
    public static String encode(String plainText) {
        if(TextUtils.isEmpty(plainText)){
            return null;
        }
        try {
            SecretKey deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
            return URLEncoder.encode(Base64.encode(encryptData), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 3DES加密
     *
     * @param plainText 普通文本
     * @return
     * @throws Exception
     */
    public static String encodeNoUrl(String plainText) {
        if(TextUtils.isEmpty(plainText)){
            return null;
        }
        try {
            SecretKey deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
            return new String(encryptData, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText) {
        try {
            SecretKey deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
            byte[] decryptData = cipher.doFinal(Base64.decode(URLDecoder.decode(encryptText, "UTF-8")));

            return new String(decryptData, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
