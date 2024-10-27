package com.easyfun.util;

import com.easyfun.entity.DataWrapper;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:15
 */


public class JsonDataWrapperUtil {

    public static DataWrapper success(Object data) {
        return create(data,"200","成功");
    }

    public static DataWrapper fail(Object data) {
        return create(data,"400","失败");
    }

    public static DataWrapper create(Object data,String status,String message) {
        return new DataWrapper(data,status,message);
    }
}