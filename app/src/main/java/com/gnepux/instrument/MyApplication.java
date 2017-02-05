package com.gnepux.instrument;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

/**
 * Created by xupeng on 17/2/4.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy.Builder threadBuilder = new StrictMode.ThreadPolicy.Builder();
            StrictMode.ThreadPolicy threadPolicy = threadBuilder.detectAll().penaltyLog().build();
            StrictMode.setThreadPolicy(threadPolicy);

            StrictMode.VmPolicy.Builder vmBuilder = new StrictMode.VmPolicy.Builder();
            StrictMode.VmPolicy vmPolicy = vmBuilder.detectAll().penaltyLog().build();
            StrictMode.setVmPolicy(vmPolicy);
        }
    }
}
