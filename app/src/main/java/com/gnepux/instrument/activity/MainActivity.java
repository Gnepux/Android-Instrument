package com.gnepux.instrument.activity;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;
import com.gnepux.instrument.activity.databindling.DataBindingActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.main_rxjava, "RxJava");
            put(R.id.main_okhttp, "OkHttp3");
            put(R.id.main_retrofit, "Retrofit2");
            put(R.id.main_dagger, "Dagger2");
            put(R.id.main_databinding, "DataBinding");
        }
    };

//    SparseArray<String> array = new SparseArray<>();
//    {
//        array.append(R.id.main_rxjava, "RxJava");
//        array.append(R.id.main_okhttp, "OkHttp3");
//        array.append(R.id.main_retrofit, "Retrofit2");
//        array.append(R.id.main_dagger, "Dagger2");
//        array.append(R.id.main_databinding, "DataBinding");
//    }

//    Map<Integer, String> map = new HashMap<Integer, String>(){
//        {
//            put(R.id.main_rxjava, "RxJava");
//            put(R.id.main_okhttp, "OkHttp3");
//            put(R.id.main_retrofit, "Retrofit2");
//            put(R.id.main_dagger, "Dagger2");
//            put(R.id.main_databinding, "DataBinding");
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);
//        Set<Map.Entry<Integer, String>> set = map.entrySet();
//        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> entry = iterator.next();
//            Button button = new Button(this);
//            button.setText(entry.getValue());
//            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT));
//            button.setOnClickListener(this);
//            button.setId(entry.getKey());
//            linearLayout.addView(button);
//        }

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
            case R.id.main_dagger:  // Dagger2
                readyGo(DaggerActivity.class);
                break;
            case R.id.main_databinding: // DataBinding
                readyGo(DataBindingActivity.class);
                break;
        }
    }
}
