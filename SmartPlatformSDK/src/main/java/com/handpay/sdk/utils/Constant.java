package com.handpay.sdk.utils;

public class Constant {
    //生成密钥种子有值为空时，默认使用
    public static final String KEY_DEFAULT="30303030";
    public static final String KEY_USER="DATA";
    public static final String KEY_SECRET="secret";
    public static final String KEY_BILL="bill";
    public static final String KEY_PKG_NAME="pkg";
    public static final String KEY_ERROR_CODE="errorCode";
    public static final String KEY_ERROR_MSG="errorMsg";
    //标记广播类型
    public static final String KEY_BROADCAST_FLAG="BROADCAST_FLAG";
    public static final String KEY_PAYFROMOTHERFLATFORM="payFromOtherFlatform";
    //启动目标
    public static final String KEY_TARGET_ACTIVITY_URI="com.handpay.zztong.hp.guid.WelcomeActivity";
    //包名
    public static final String KEY_TAGET_APPPACKAGENAME="com.handpay.zztong.smartpos.n900";
    //启动服务action
    public static final String KEY_SERVICE_ACTION="com.handPay.smartPos.DataManagerService.Action";

    public static class CODE{
        //未初始化
        public static final int CODE_NO_INITIZATION=-100;
        //用户名参数没有
        public static final int CODE_NO_ARG_NAME=-101;
        //登入密码参数没有
        public static final int CODE_NO_ARG_PD=-102;
        //金额参数没有
        public static final int CODE_NO_ARG_MONEY=-103;
        //金额小于0
        public static final int CODE_ARG_MONEY_LESS0=-104;
        //访问的应用不存在
        public static final int CODE_NO_EXIST_APK=-105;
        //bind 服务被销毁
        public static final int CODE_SERVICE_DESTORY=-106;
        //金额格式转换异常
        public static final int CODE_ARG_MONEY_FORMART_EXCEPTION=-107;
    }

    public static class BROADCAST_ACTION{
        //密钥数据
        public static final int ACTION_SECRET=0;
        //订单数据
        public static final int ACTION_BILL=1;
        //错误数据
        public static final int ACTION_ERROR=-1;
    }

    public static String DEVICE_IMEI="";
}
