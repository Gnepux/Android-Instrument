package com.gnepux.instrument.activity;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.main_rxjava, "RxJava");
            put(R.id.main_okhttp, "OkHttp3");
            put(R.id.main_retrofit, "Retrofit2");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_rxjava:   // RxJava
                readyGo(RxJavaActivity.class);
                break;
            case R.id.main_okhttp:  // OkHttp3
                readyGo(OkHttpActivity.class);
                break;
            case R.id.main_retrofit:    // Retrofit2
                readyGo(RetrofitActivity.class);
                break;
        }
    }
}
