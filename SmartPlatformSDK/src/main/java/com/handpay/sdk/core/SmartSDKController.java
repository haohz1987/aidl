package com.handpay.sdk.core;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.handpay.aidl.Bill;
import com.handpay.aidl.Data;
import com.handpay.sdk.encry.EncryptionManager;
import com.handpay.sdk.utils.CommonUtils;
import com.handpay.sdk.utils.Constant;
import com.handpay.sdk.utils.LogT;
import com.handpay.sdk.utils.OneHotUtils;

import java.util.Arrays;
import java.util.List;

/**
 * this is smartPos SDK Controller.All transfers related to payment operations need to be passed through this Controller.
 */
public class SmartSDKController {
    /**
     * 接口回调
     */
    public ControllerListener callBackListener=null;
    private Context mContext;
    private static SmartSDKController sdkController=null;
    private ServiceMessageReceiver serviceMessageReceiver=null;
    private static String ceretKey=null;

    public SmartSDKController(){
        LogT.w("SmartSDKController--builder");
    }
    /**
     * 实例化（双重锁校验）
     * @param context 最好是ApplicationContext传入
     * @return
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static SmartSDKController builder(Context context){
        if(context==null){
            throw new NullPointerException();
        }
        if(sdkController==null){
            synchronized (SmartSDKController.class){
                if(sdkController==null){
                    sdkController=new SmartSDKController();
                }
            }
        }
        sdkController.mContext=context;
        Constant.DEVICE_IMEI=((TelephonyManager) sdkController.mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return sdkController;
    }

    /**
     * 是否为debug模式
     * @param flag
     * @return
     */
//    public SmartSDKController setDebug(boolean flag){
//        SLog.isPrint=flag;
//        return this;
//    }

    /**
     * 数据回调，以及操作状态回调
     * @param mCallBackListener
     * @return
     */
    public SmartSDKController setCallBackListener(ControllerListener mCallBackListener){
        this.callBackListener=mCallBackListener;
        return this;
    }

    /**
     * 发起支付入口
     * @param id 商户ID
     * @param mPd 商户密钥
     * @param mMoney 交易金额以千分单位
     */
    public void smartPay(String id,String mPd,String mMoney){
        if (!isLegitimate(id,mPd,mMoney)){return;};
        if (mContext != null) {
            registerAction();
            if(!CommonUtils.isExitAppWithPackageName(mContext,Constant.KEY_TAGET_APPPACKAGENAME)){
                callback(Constant.CODE.CODE_NO_EXIST_APK,"智能POS应用未安装！");
                return;
            }
            try {
                String seed=EncryptionManager.getInstance().getPublicPseudoKey();
                byte[] kbs = OneHotUtils.generateOneHot(seed);
                LogT.w( "kbs="+Arrays.toString(kbs));
                seed= EncryptionManager.bytesToHexString(kbs);
                Data data = new Data();
                data.setUserName(EncryptionManager.getInstance().encryptMode(null, id));
                data.setPassword(EncryptionManager.getInstance().encryptMode(null, mPd));
                data.setMoney(EncryptionManager.getInstance().encryptMode(null, mMoney));
                LogT.w( "data="+data.toString());
                _pay(seed,data);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            callback(Constant.CODE.CODE_NO_INITIZATION,"SDK初始化失败！");
        }
    }

    /**
     * 调起支付
     * @param seed
     * @param data
     */
    private void _pay(String seed,Data data){
        Intent intent = new Intent();
        //参数是包名，类全限定名，注意直接用类名不行
        ComponentName cn = new ComponentName(Constant.KEY_TAGET_APPPACKAGENAME, Constant.KEY_TARGET_ACTIVITY_URI);
        intent.setComponent(cn);
        intent.putExtra(Constant.KEY_PAYFROMOTHERFLATFORM, true);
        intent.putExtra(Constant.KEY_SECRET, seed);
        intent.putExtra(Constant.KEY_USER,data);
        intent.putExtra(Constant.KEY_PKG_NAME,mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    private void registerAction(){
        serviceMessageReceiver=new ServiceMessageReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(mContext.getPackageName());
        mContext.registerReceiver(serviceMessageReceiver, intentFilter);
    }
    /**
     * 错误信息回调
     * @param code
     * @param msg
     */
    private void callback(int code,String msg){
        if (callBackListener!=null){
            callBackListener.Error(code,msg);
        }else {
            throw new RuntimeException("error:callBaclLintener==null");
        }
    }

    /***
     * 验证数据
     * @param mName
     * @param mPd
     * @param mMoney
     */
    private boolean isLegitimate(String mName,String mPd,String mMoney){
        if(TextUtils.isEmpty(mName)){
            callback(Constant.CODE.CODE_NO_ARG_NAME,"用户名为空");
            return false;
        }
        if(!CommonUtils.isLegitimateSecret(mPd)){
            callback(Constant.CODE.CODE_NO_ARG_PD,"密码为空");
            return false;
        }
        if(!CommonUtils.isNumeric(mMoney)){
            callback(Constant.CODE.CODE_NO_ARG_MONEY,"输入金额为空");
            return false;
        }
        try{
            Double temp= Double.parseDouble(mMoney);
            if(temp<=0){
                callback(Constant.CODE.CODE_ARG_MONEY_LESS0,"输入金额<=0");
                return false;
            }
        }catch (Exception e){
            callback(Constant.CODE.CODE_ARG_MONEY_FORMART_EXCEPTION,"金额数据元转换异常！");
            return false;
        }
        return true;
    }

    /**
     * 由于传入handler方式不好用，这里用广播用来接收服务器发来的消息
     */
    class ServiceMessageReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null){
                int broadcast_flag=intent.getIntExtra(Constant.KEY_BROADCAST_FLAG,-1);
                LogT.w("broadcast_flag="+broadcast_flag);
                if(broadcast_flag==Constant.BROADCAST_ACTION.ACTION_SECRET){
                    ceretKey=intent.getStringExtra(Constant.KEY_SECRET);
                    if(ceretKey!=null){
                        byte[] bts=EncryptionManager.hexStringToBytes(ceretKey);
                        ceretKey=OneHotUtils.parserByte2OntHot(bts);
                    }
                    LogT.w("sdk-recevier-ceretKey="+ceretKey);
                }else if(broadcast_flag==Constant.BROADCAST_ACTION.ACTION_BILL){
                    Bill bill=intent.getParcelableExtra(Constant.KEY_BILL);
                    if(bill==null){
                        return;
                    }
                    parserBill(bill);
                }else if(broadcast_flag==Constant.BROADCAST_ACTION.ACTION_ERROR){
                    int errorCode=intent.getIntExtra(Constant.KEY_ERROR_CODE,-1);
                    String errorMessage=intent.getStringExtra(Constant.KEY_ERROR_MSG);
                    LogT.w("errorCode="+errorCode+",errorMessage="+errorMessage);
                    if(callBackListener!=null){
                        callBackListener.Error(errorCode,errorMessage);
                    }
                    onDestroy();
                }
            }
        }
    }

    /**
     * 解析订单数据
     * @param mBill
     */
    private void parserBill(Bill mBill){
        Bill tempBill=mBill;
        LogT.w("--sendBill()收到数据回执："+tempBill.toString());
        Bill newBill=new Bill();
        try {
            newBill.setMerchantName(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getMerchantName()));
            newBill.setMerchantCode(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getMerchantCode()));
            newBill.setTradingAccount( EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getTradingAccount()));
            newBill.setTransactionAmount(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getTransactionAmount()));
            newBill.setTranState(tempBill.getTranState());
            newBill.setSerialNumber(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getSerialNumber()));
            newBill.setTransactionType(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getTransactionType()));
            newBill.setTradingHour(EncryptionManager.getInstance().decode3DES(ceretKey.getBytes("utf-8"), tempBill.getTradingHour()));
            if(newBill.getTranState()!=1){
                newBill.setFailDes(mBill.getFailDes());
            }
            LogT.w( "解密数据：" + newBill.toString());
        }catch (Exception e){
            LogT.w(e.toString());
        }
        if(newBill!=null&&!TextUtils.isEmpty(newBill.getTransactionAmount())) {
            String tempAmount = CommonUtils.changF2Y(newBill.getTransactionAmount());
            newBill.setTransactionAmount(tempAmount);
        }
        if(callBackListener!=null){
            callBackListener.tranResult(newBill);
        }
        onDestroy();
    }

    /**
     * 销毁释放资源
     */
    public void onDestroy(){
        LogT.w("--smartSDK--destoryResource--");
        EncryptionManager.getInstance().destoryResource();
        if(mContext!=null&&serviceMessageReceiver!=null){
            PackageManager pm = mContext.getPackageManager();
            List<ResolveInfo> resolveInfos = pm.queryBroadcastReceivers(new Intent(mContext.getPackageName()), 0);
            if(resolveInfos != null && !resolveInfos.isEmpty()){
                //查询到相应的BroadcastReceiver
                mContext.unregisterReceiver(serviceMessageReceiver);
            }
        }
        mContext=null;
        callBackListener=null;
        sdkController=null;
    }
}
