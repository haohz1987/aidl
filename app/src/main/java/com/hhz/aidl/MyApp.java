package com.hhz.aidl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import java.util.Stack;

/**
 * Created by haohz on 2017/12/21.
 */

public class MyApp extends Application {
    private static Stack<Activity> activityStack;


    @Override
    public void onCreate() {
        super.onCreate();
        LogT.init(true);

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    /**
     * add Activity 添加Activity到栈
     */
    public static void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
}
