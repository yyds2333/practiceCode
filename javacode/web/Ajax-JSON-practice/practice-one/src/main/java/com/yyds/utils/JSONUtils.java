package com.yyds.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JSONUtils {

    //重载方法
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object,String dateFormat){
        //1，创建一个ObjectMapper对象
        ObjectMapper om = new ObjectMapper();
        //2.设置Date对象的时间戳功能关闭
        om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //3.让mapper指定时间日期为指定的格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        om.setDateFormat(sdf);

        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
