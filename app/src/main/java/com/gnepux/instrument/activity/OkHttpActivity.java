package com.gnepux.instrument.activity;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;
import com.gnepux.instrument.constant.Constant;
import com.gnepux.instrument.utils.Utils;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "OkHttpActivity";

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.okhttp_get, "Get请求");
            put(R.id.okhttp_post, "Post请求");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        for (int i = 0; i < mBtnProp.size(); i++) {
            Button button = new Button(this);
            button.setText(mBtnProp.valueAt(i));
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(this);
            button.setId(mBtnProp.keyAt(i));
            linearLayout.addView(button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okhttp_get:
                okHttpGet();
                break;
            case R.id.okhttp_post:
                okHttpPost();
                break;
        }
    }

    private void okHttpGet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                        .build();
                Request request = new Request.Builder()
                        .url("http://www.baidu.com")
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Logger.e(e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();
                        Logger.d(result);
                    }
                });
            }
        }).start();
    }

    private void okHttpPost() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] value = { "15010551", "-1", "", "-1" };
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .connectTimeout(5000, TimeUnit.MILLISECONDS).build();
                FormBody formBody = new FormBody.Builder()
                        .add("interfaceName", "login")
                        .add("userCode", "15010551")
                        .add("password", "q")
                        .add("ip", "0.0.0.0")
                        .add("hostname", "android")
                        .add("functionName", "")
                        .add("paramName", "")
                        .add("paramValue", "")
                        .add("ports", Utils.getStringValue(value))
                        .build();

                final Request request = new Request.Builder()
                        .url(Constant.REMOTE_BASE_URL_POST + Constant.URL_LOGIN)
                        .post(formBody)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Logger.e(e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Logger.d(response.body().string());
                    }
                });
            }
        }).start();
    }

}
