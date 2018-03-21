package com.hhz.aidl.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hhz.aidl.R;
import com.hhz.aidl.Results;
import com.hhz.aidl.ResultsManager;
import com.hhz.aidl.base.BaseActivity;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.util.LogT;
import com.hhz.aidl.view.ActionSheetCoupon;
import com.hhz.aidl.view.CalendarDialogView;
import com.hhz.aidl.view.CalendarView;
import com.hhz.aidl.view.ColorSelectDialog;
import com.hhz.aidl.view.ZZTShowDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View, View.OnClickListener, ActionSheetCoupon.OnActionSheetSelected,
        ColorSelectDialog.OnColorSelected, CalendarView.OnItemClickListener {

    private HashMap<String, Object> params;
    private ZZTShowDialog<CalendarDialogView> mCalendarDialog;
    private boolean isDateStartPicked = false;
    // 起始日期
    private Date startDate;
    // 结束日期
    private Date endDate;
    private TextView startDateShowTextView;
    private TextView endDateShowTextView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeView() {
        findViewById(R.id.btn_service).setOnClickListener(this);
        findViewById(R.id.btn_intentservice).setOnClickListener(this);
        findViewById(R.id.btn_color_select).setOnClickListener(this);
        findViewById(R.id.btn_coupon_select).setOnClickListener(this);

        findViewById(R.id.btn_getOpenId).setOnClickListener(this);
        findViewById(R.id.btn_getCoupList).setOnClickListener(this);
        ((TextView) findViewById(R.id.toolbar_title)).setText("Demo合集");
    }

    @Override
    protected void initializeData() {
        params = new HashMap<>();
        params.put("userId", "10");

    }

    //客户端配置
    //标志当前与服务端连接状况的布尔值，false为未连接，true为连接中
    private boolean mBound = false;

    /*方法一：继承binder*/
//    private BinderService mService;
//    //BinderDemo是在ServiceDemo里面的一个继承了Binder的内部类，这是一种得到IBinder接口的方式
//    private BinderService.BinderDemo mBinder;

    /*方法二：使用Messenger类*/
//    static final int MSG_SAY_HELLO = 1;
//    Messenger mServiceMessenger = null;

    /*方法三：AIDL*/
    //由AIDL文件生成的java类
    private ResultsManager resultsManager =null;
    private List<Results> resultBeans = new ArrayList<>();

    /*方法三：AIDL*/
    //客户端定义的操作，
    public void addResults(View view){
        if(!mBound){
            attemptToBindService();
            Toast.makeText(this, "当前与服务端处于未连接状态，正在尝试重连，请稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }
        if(resultsManager==null) return;
         Results results =new Results();
         results.setRecordDate("这是客户端数据");
         results.setCouponType(2);
         results.setCouponAmount(200);
         results.setDiscount(3.00);
         results.setOrderAmount(500);
        try {
            resultsManager.addResult(results);
            LogT.w("客户端_读服务端修改后的结果="+results.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    /*方法三：AIDL*/
    //尝试与服务端建立连接
    private void attemptToBindService(){
        Intent intent = new Intent();
        intent.setAction("com.hhz.aidlLink");
        intent.setPackage("com.hhz.aidl");
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        //系统会调用该方法以传递服务的onBind() 方法返回的 IBinder。
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogT.w("服务连接");
            mBound = true;
            /*方法一：继承binder*/
            //我们可以使用接口定义的方法开始调用服务。隐含了使用该方法的条件：
            //客户端和服务端应当在同一个进程中，即服务端进程中一定要有mBinder实例。
//            mBinder = (BinderService.BinderDemo) service;
//            //在此处可以利用得到的ServiceDemo对象调用该类中的构造方法
//            mService = mBinder.getService();

            /*方法二：使用Messenger类*/
//            //接收onBind()传回来的IBinder，并用它构造Messenger
//            mServiceMessenger = new Messenger(service);
            /*方法三：AIDL*/
            resultsManager = ResultsManager.Stub.asInterface(service);
            if(resultsManager!=null){
                try {
                    resultBeans=resultsManager.getResults();
                    LogT.w("aidl_数据交换_inout");
                    LogT.w("客户端_连接中，读取的服务端数据："+resultBeans.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        //Android系统会在与服务的连接意外中断时（例如当服务崩溃或被终止时）调用该方法。
        // 当客户端取消绑定时，系统“绝对不会”调用该方法。
        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogT.w("服务断开");
            mBound = false;
             /*方法二：使用Messenger类*/
//            mServiceMessenger = null;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        /*方法一：继承binder*/
//        bindService(new Intent(MainActivity.this, BinderService.class),
//                mConnection, Context.BIND_AUTO_CREATE);
        /*方法二：使用Messenger类*/
//        Intent intent = new Intent();
//        intent.setAction("com.hhz.aidl.Messenger");
//        intent.setPackage("com.hhz.aidl");
//        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
        /*方法三：AIDL*/
        if(!mBound){
            attemptToBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }
//    /*方法二：使用Messenger类*/
//    public void sayHello(View v){
//        if(!mBound) return;
//        //发送一条消息给服务端
//        Message msg = Message.obtain(null,MSG_SAY_HELLO,0,0);
//        try {
//            mServiceMessenger.send(msg);
//            LogT.w("发送一条消息给服务端--"+msg);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_service:
                /*方法一：继承binder*/
                //onStart()尝试与目标service绑定，点击时，如果绑定已经完成，就可以调用service中的方法。
//                if (mBound) {
//                    int num = mService.getRandomNumber();
//                    LogT.w(num);
//                }
                /*方法二：使用Messenger类*/
//                sayHello(v);
                /*方法三：AIDL*/
                addResults(v);

                break;
            case R.id.btn_intentservice:

//                startService(new Intent(MainActivity.this, IntentServiceDemo.class));
                break;
            //会员卡颜色选择
            case R.id.btn_color_select:
                ColorSelectDialog.selectColor(MainActivity.this, MainActivity.this,
                        new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {

                            }
                        });
                break;
            //会优惠券选择
            case R.id.btn_coupon_select:
                ActionSheetCoupon.showSheet(MainActivity.this, MainActivity.this,
                        new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {

                            }
                        });
                break;
            case R.id.btn_getOpenId:

                startActivity(new Intent(MainActivity.this, MemberShip.class));
                break;
            case R.id.btn_getCoupList:
                startActivity(new Intent(MainActivity.this, Coupon.class));
                break;

        }
    }


    @Override
    public void onSheetClick(int whichButton) {
        String tag = "";
        switch (whichButton) {
            case R.id.btn_cashcoupon:
                tag = "代金券";
                break;
            case R.id.btn_discount:
                tag = "折扣券";
                break;
            case R.id.btn_exchange:
                tag = "兑换券";
                break;
        }
        ((TextView) findViewById(R.id.tv_coupon)).setText(tag);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onColorSelected(int position) {
        ((ImageView) findViewById(R.id.iv_select)).setImageResource(CouponColorType.getResID("" + (position + 1)));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNoData() {

    }

    @Override
    public void onGetOpenIdSuccess(MemberShipBean memberShipBean) {
        ((TextView) findViewById(R.id.tv_request)).setText(memberShipBean.toString());
    }

    @Override
    public void onGetCoupListSuccess(CouponBean couponBean) {
        ((TextView) findViewById(R.id.tv_request)).setText(couponBean.toString());
    }

    @Override
    public void onGetRecordSuccess(RecordBean recordBean) {
        ((TextView) findViewById(R.id.tv_request)).setText(recordBean.toString());
    }

    @Override
    public void OnItemClick(Date selectedStartDate, Date selectedEndDate, Date downDate) {

    }
}