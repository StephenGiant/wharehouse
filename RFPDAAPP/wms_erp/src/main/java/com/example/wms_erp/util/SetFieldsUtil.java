package com.example.wms_erp.util;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/9/9.
 */
public class SetFieldsUtil {

    public static void setFields(Class<?> type,Class<?> data,Object obj){
        //将data中与type中相同字段的值复制过去
        Field[] declaredFields = type.getClass().getDeclaredFields();
        Field[] declaredFields1 = data.getClass().getDeclaredFields();
        for(Field field:declaredFields){
            String name = field.getName();
            for(Field field1:declaredFields1){
                if(field1.getName().equals(name)){
                    try {
                        Object o = field1.get(obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
