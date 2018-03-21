package com.handpay.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

import com.handpay.sdk.utils.Constant;
import com.handpay.sdk.utils.LogT;
import com.handpay.sdk.utils.SpUtils;

public class DataManagerService extends Service {
    private Data data=null;
    private String publicKey=null;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogT.w("---DataManagerService--onStartCommand---");
        if(intent!=null){
            String temp_action=intent.getAction();
            if(!TextUtils.isEmpty(temp_action)&&Constant.KEY_SERVICE_ACTION.equals(temp_action)){
                LogT.w("---DataManagerService--action:"+temp_action);
                data=SpUtils.getUserData(this);
                publicKey=SpUtils.getSelfTempKey(this);
                LogT.w("---DataManagerService--SelfTempKey:"+publicKey);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }


    private DataManager.Stub serviceBuilder=new DataManager.Stub() {
        @Override
        public Data getData() throws RemoteException {
            LogT.w("提供数据：[" + data.toString()+"]");
            data=SpUtils.getUserData(DataManagerService.this);
            return data;
        }

        @Override
        public boolean setData(Data isData) throws RemoteException {
            if (isData!=null){
                return true;
            }
            return false;
        }

        @Override
        public Bill getBill() throws RemoteException {
            return null;
        }

        @Override
        public boolean setBill(Bill mBill) throws RemoteException {
            LogT.w("setBill"+mBill==null?"mBill==null":"is not null");
            if(mBill!=null){

            }
            return true;
        }

        @Override
        public String tranferKey(String data, String time) throws RemoteException {
            int callUid=getCallingUid();
            LogT.w("callUid="+callUid);
            String[] callPkg=getPackageManager().getPackagesForUid(callUid);
            for(String pkg:callPkg){
                LogT.w("pkg="+pkg);
            }
            publicKey=SpUtils.getSelfTempKey(DataManagerService.this);
            LogT.w("--tranferKey--service.key:"+publicKey);
            return publicKey;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };



    @Override
    public IBinder onBind(Intent intent) {
        LogT.w("--sdk-onBind--");
        data=SpUtils.getUserData(this);
        publicKey=SpUtils.getSelfTempKey(this);
        LogT.w("--sdk-onBind--publicKey="+publicKey);
        return serviceBuilder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        LogT.w("--sdk-onUnbind--");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        LogT.w("--sdk-onRebind--");
        super.onRebind(intent);
    }
    @Override
    public void onDestroy() {
        LogT.w("--onDestroy--");
        data=null;
        publicKey=null;
        super.onDestroy();
    }
}
