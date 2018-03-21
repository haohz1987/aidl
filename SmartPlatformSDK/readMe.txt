SmartPlatformSDK
项目主要是使用AIDL技术与智能POS进行进程间数据通信。
SDK中主要是对操作只能POS和数据回调进行统一管理，避免繁杂的接入调试。

接口描述：
SmartSDKController.java
    2 getInstance()实例化对象
    3 setContext(Context context) 设置引用context最好为ApplicationContext
    4 setDebug(boolean isdebug) 设置当前模式是否为debug，debug模式会输出日志
    5 setCallBackLinstener(DataCallBaclLintener mCallBaclLintener) 设置数据回调监听
    6 smartPay(String mName,String mPd,String mMoney) 调起支付（mName：用户名，mPd：密码，mMoney：交易金额）
    7 decryptClientData(string src) 解密客户端数据
    8 destoryResource() 退出需要和重新生成密钥释放资源

