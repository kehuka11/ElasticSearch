package com.elasticsearch.demo.service.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapperConverter {
    public static Map<String, Object> convertObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // プライベートフィールドにアクセスするため
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }
}
