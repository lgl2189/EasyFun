package com.easyfun.typehandler.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 下午5:35
 */

public class LocalTimeSerializer implements JsonSerializer<LocalTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(formatter));
    }
}