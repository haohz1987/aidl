package com.hhz.aidl;

import android.app.Application;

/**
 * Created by haohz on 2017/12/21.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogT.init(true);

    }
}
