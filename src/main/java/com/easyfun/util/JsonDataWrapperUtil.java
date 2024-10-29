package com.easyfun.util;

import com.easyfun.entity.JsonDataWrapper;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:15
 */


public class JsonDataWrapperUtil {

    public static JsonDataWrapper success(Object data) {
        return create(data,"200","成功");
    }

    public static JsonDataWrapper success(Object data,String message) {
        return create(data,"200",message);
    }

    public static JsonDataWrapper success(Object data, String status, String message) {
        return create(data,status,message);
    }

    public static JsonDataWrapper fail(Object data) {
        return create(data,"400","失败");
    }

    public static JsonDataWrapper fail(Object data,String message) {
        return create(data,"400",message);
    }

    public static JsonDataWrapper fail(Object data, String status, String message) {
        return create(data,status,message);
    }

    public static JsonDataWrapper create(Object data, String status, String message) {
        return new JsonDataWrapper(data,status,message);
    }
}