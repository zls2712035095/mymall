package com.zls.api.common;

import com.google.gson.Gson;

import java.nio.charset.Charset;


public class GsonUtil {
    private final static Gson gson = new Gson();

    public static <T> T fromJson(String value, Class<T> type) {
        return gson.fromJson(value, type);
    }

    public static String toJson(Object value) {
        return gson.toJson(value);
    }

    public static byte[] toJSONBytes(Object value) {
        return gson.toJson(value).getBytes(Charset.forName("UTF-8"));
    }
}
