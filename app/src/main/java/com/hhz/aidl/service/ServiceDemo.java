package com.hhz.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by haohz on 2017/12/21.
 */

public class ServiceDemo extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
