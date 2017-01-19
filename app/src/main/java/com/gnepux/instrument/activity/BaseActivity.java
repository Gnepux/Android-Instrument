package com.gnepux.instrument.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xupeng on 17/1/17.
 */

public class BaseActivity extends AppCompatActivity {

    protected void readyGo(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}
