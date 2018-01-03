package com.hhz.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.hhz.aidl.Results;
import com.hhz.aidl.ResultsManager;
import com.hhz.aidl.util.LogT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohz on 2018/1/3.
 */

public class AIDLService extends Service {

    private List<Results> resultBeans = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        resultBeans.clear();
        Results results = new Results();
        results.setDiscount(0.12);
        results.setConsumeLite(100);
        results.setCouponAmount(10);
        results.setCouponType(1);
        results.setRecordDate("这是服务端原始数据");
        resultBeans.add(results);
    }

    //由AIDL文件生成的manager,stub实现this.attachInterface(this, DESCRIPTOR);
    private ResultsManager.Stub mResultsManager = new ResultsManager.Stub() {
        @Override
        public List<Results> getResults() throws RemoteException {
            LogT.w("服务端_getResults="+resultBeans);
            if (resultBeans != null)
                return resultBeans;
            return new ArrayList<>();
        }

        @Override
        public boolean setResults(Results isData) throws RemoteException {
            return false;
        }

        @Override
        public void addResult(Results result) throws RemoteException {
            synchronized(this){
                if(resultBeans==null){
                    resultBeans=new ArrayList<>();
                }
                if(result==null){
                    LogT.w("客户端_inout_results is null");
                    result=new Results();
                }
                if(!resultBeans.contains(result)){
                    resultBeans.add(result);
                }
                LogT.w("服务端_客户端传过来的值："+resultBeans.toString());
                resultBeans.clear();
                //尝试修改book的参数，主要为了观察客户端的反馈
                result.setDiscount(3.12);
                result.setOrderAmount(1000000);
                result.setCouponAmount(1000);
                result.setRecordDate("这是服务端修改后的值");
                if(!resultBeans.contains(result)){
                    resultBeans.add(result);
                }
                LogT.w("服务端_服务端修改后的值："+resultBeans.toString());
            }
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogT.w("服务端_建立连接的规则_filter："+intent.toString());
        return mResultsManager;
    }
}
