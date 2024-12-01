package com.easyfun.util;

import com.easyfun.entity.JsonDataWrapper;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:15
 */


public class JsonDataWrapperUtil {

    public static JsonDataWrapper success_200(Object data, String message) {
        return create(data, "200", message);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static JsonDataWrapper success_200(Object data) {
        return success_200(data, "成功");
    }

    public static JsonDataWrapper fail_400(Object data, String message) {
        return create(data, "400", "失败");
    }

    /**
     * 失败
     * @param data
     * @return
     */
    public static JsonDataWrapper fail_400(Object data) {
        return fail_400(data, "失败");
    }

    public static JsonDataWrapper fail_401(Object data, String message) {
        return create(data, "401", message);
    }

    /**
     * 参数为空
     * @param data
     * @return
     */
    public static JsonDataWrapper fail_401(Object data) {
        return fail_401(data, "参数为空");
    }

    public static JsonDataWrapper fail_402(Object data, String message) {
        return create(data, "402", message);
    }

    /**
     * 参数错误
     * @param data
     * @return
     */
    public static JsonDataWrapper fail_402(Object data) {
        return fail_402(data, "参数错误");
    }

    public static JsonDataWrapper fail_403(Object data, String message) {
        return create(data, "403", message);
    }

    /**
     * 系统错误
     * @param data
     * @return
     */
    public static JsonDataWrapper fail_403(Object data) {
        return fail_403(data, "系统错误");
    }

    public static JsonDataWrapper create(Object data, String status, String message) {
        return new JsonDataWrapper(data, status, message);
    }
}