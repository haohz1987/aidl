package com.hhz.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.hhz.aidl.util.LogT;

/**
 * Created by haohz on 2018/1/2.
 */

public class MessengerService extends Service {
    static final int MSG_SAY_HELLO = 1;
    final Messenger mMessenger = new Messenger(new ServiceHandler());
    class ServiceHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    LogT.w("service收到客户端的message");
                    Toast.makeText(MessengerService.this,"service收到的消息:"+msg,Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogT.w("binding------");
        //返回给客户端一个IBinder实例
        return mMessenger.getBinder();
    }
}
