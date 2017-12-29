package com.hhz.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import com.hhz.aidl.util.LogT;

/**
 * Created by haohz on 2017/12/21.
 */

public class ServiceDemo extends Service {
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            long endTime = System.currentTimeMillis() + 5 * 1000;
            while (System.currentTimeMillis() < endTime) {
                synchronized (this) {
                    try {
                        wait(endTime - System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            stopSelf(msg.arg1);
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);//在后台运行的线程
        thread.start();
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //当其他组件调用startService()方法时，此方法将会被调用
        //如果不想让这个service被绑定，在此返回null即可
        LogT.w("service starting");
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        return START_STICKY;
       /*
        返回值（START_STICKY），用来指定系统对当前线程的行为，必须是以下常量之一：
        1. START_NOT_STICKY,如果系统在onStartCommand()，返回后终止服务，则除非有挂起 Intent 要传递，
        否则系统不会重建服务。这是最安全的选项，可以避免在不必要时以及应用能够轻松重启所有未完成的作业时运行服务。
        2. START_STICKY， 如果系统在 onStartCommand() 返回后终止服务，则会重建服务并调用 onStartCommand()，
        但绝对不会重新传递最后一个 Intent。相反，除非有挂起 Intent 要启动服务（在这种情况下，将传递这些Intent），
        否则系统会通过空 Intent 调用 onStartCommand()。这适用于不执行命令、但无限期运行并等待作业的媒体播放器
        （或类似服务）
        3.START_REDELIVER_INTENT，如果系统在 onStartCommand() 返回后终止服务，则会重建服务，并通过传递
        给服务的最后一个 Intent 调用 onStartCommand()。任何挂起 Intent 均依次传递。这适用于主动执行应该
        立即恢复的作业（例如下载文件）的服务。
        */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /*
        继承service来实现的service，一定要记得，停止这个service。因为除非系统必须回收内存资源，否则系统
        不会停止或销毁service。事实上，如果这个service是与可见组件绑定，其几乎永远不会被停止或销毁。
        在这种情况下，如果你忘记了在其工作完成之后将其停止，势必会造成系统资源的浪费以及电池电量的消耗，
        而这应当是我们要极力避免的。
        */
    }

    @Override
    public IBinder onBind(Intent intent) {
        //当其他组件调用bindService()方法时，此方法将会被调用
        //如果不想让这个service被绑定，在此返回null即可

        return null;
    }

}
