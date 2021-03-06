package com.gnepux.instrument.convert;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by xupeng on 17/1/19.
 */
public class MyRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private Gson gson = new Gson();

    @Override
    public RequestBody convert(T value) throws IOException {
        String string = gson.toJson(value);
        return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"),string);
    }
}
