package com.easyfun.util;

import com.easyfun.entity.JsonDataWrapper;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:15
 */


public class JsonDataWrapperUtil {

    public static JsonDataWrapper success_200(Object data) {
        return create(data,"200","成功");
    }

    public static JsonDataWrapper fail(Object data) {
        return create(data,"400","失败");
    }

    public static JsonDataWrapper fail_401(Object data) {
        return create(data,"401","参数为空");
    }

    public static JsonDataWrapper fail_402(Object data) {
        return create(data,"402","参数错误");
    }

    public static JsonDataWrapper fail_403(Object data) {
        return create(data,"403","系统错误");
    }

    public static JsonDataWrapper create(Object data, String status, String message) {
        return new JsonDataWrapper(data,status,message);
    }
}