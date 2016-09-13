package com.example.g40_70m.framedemo.net;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 坤 on 2016/8/10.
 */
public class BeanUtils {

    /**
     * 将JavaBean转换成HashMap
     * @param bean
     * @return
     */
    public static Map<String, String> jsonToMap(Object bean) {
        JSONObject jsonObject ;
        String json = GsonUtil.getGson().toJson(bean);
        try {
            jsonObject = new JSONObject(json);
            Iterator<String> keyIter= jsonObject.keys();
            String key;
            String value ;
            Map<String, String> valueMap = new HashMap<String, String>();
            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = jsonObject.getString(key);
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}
