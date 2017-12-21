package com.hhz.aidl.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by haohz on 2017/12/21.
 */

public class IntentServiceDemo extends IntentService {

    public IntentServiceDemo(String name) {
        super(name);

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
