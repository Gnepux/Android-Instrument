package com.gnepux.instrument.activity.databindling;

import android.support.v4.util.ArrayMap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;
import com.gnepux.instrument.activity.BaseActivity;

public class DataBindingActivity extends BaseActivity implements View.OnClickListener {

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.data_binding_simple, "DataBinding基础");
            put(R.id.data_binding_recyclerview, "DataBinding在RecyclerView中的应用");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

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
            case R.id.data_binding_simple:
                readyGo(DataBindlingSimpleActivity.class);
                break;
            case R.id.data_binding_recyclerview:
                readyGo(DataBindingRecyclerViewActivity.class);
                break;
        }
    }
}
