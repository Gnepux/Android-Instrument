package com.gnepux.instrument.convert;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by xupeng on 17/1/18.
 */

public class MyResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private Gson gson = new Gson();

    private Type type;

    public MyResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        T t = gson.fromJson(value.string(), type);
        return t;
    }
}
