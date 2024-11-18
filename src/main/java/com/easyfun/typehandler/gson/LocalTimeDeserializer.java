package com.easyfun.typehandler.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 下午5:35
 */


public class LocalTimeDeserializer implements JsonDeserializer<LocalTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalTime.parse(json.getAsString(), formatter);
    }
}