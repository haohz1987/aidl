package com.hhz.aidl.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.base.BaseActivity;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.service.BinderService;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.util.LogT;
import com.hhz.aidl.view.ActionSheetCoupon;
import com.hhz.aidl.view.CalendarDialogView;
import com.hhz.aidl.view.CalendarView;
import com.hhz.aidl.view.ColorSelectDialog;
import com.hhz.aidl.view.ZZTShowDialog;

import java.util.Date;
import java.util.HashMap;

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
//        findViewById(R.id.startDateRow).setOnClickListener(this);
//        findViewById(R.id.endDateRow).setOnClickListener(this);
//        mCalendarDialog =  new ZZTShowDialog<CalendarDialogView>(this, new CalendarDialogView(this), R.style.dialog);
//        mCalendarDialog.getContentView().getCalendar().setOnItemClickListener(this);
//        startDateShowTextView = findViewById(R.id.startDateShowTextView);
//        endDateShowTextView = findViewById(R.id.endDateShowTextView);
//        Date today = DateUtils.formatStringToDate(DateUtils.formatDateToString(new Date(), "yyyyMMdd"), "yyyyMMdd");
//        this.startDate = today;
//        this.endDate = new Date(today.getTime() + (24 * 60 * 60 * 1000) - 1);
//
//        this.startDateShowTextView.setText(DateUtils.formatDateToString(startDate, "yyyy-MM-dd"));
//        this.endDateShowTextView.setText(DateUtils.formatDateToString(today, "yyyy-MM-dd"));

    }

    @Override
    protected void initializeData() {
        params = new HashMap<>();
        params.put("userId", "10");

    }

    //客户端配置
     /*方法一：继承binder*/
    private BinderService mService;
    //BinderDemo是在ServiceDemo里面的一个继承了Binder的内部类，这是一种得到IBinder接口的方式
    private BinderService.BinderDemo mBinder;

    /*方法二：使用Messenger类*/
    static final int MSG_SAY_HELLO = 1;
    Messenger mServiceMessenger = null;



    boolean mBound = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        //系统会调用该方法以传递服务的onBind() 方法返回的 IBinder。
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /*方法一：继承binder*/
            //我们可以使用接口定义的方法开始调用服务。隐含了使用该方法的条件：
            //客户端和服务端应当在同一个进程中，即服务端进程中一定要有mBinder实例。
//            mBinder = (BinderService.BinderDemo) service;
//            //在此处可以利用得到的ServiceDemo对象调用该类中的构造方法
//            mService = mBinder.getService();

            /*方法二：使用Messenger类*/
            //接收onBind()传回来的IBinder，并用它构造Messenger
            mServiceMessenger = new Messenger(service);

            mBound = true;

        }

        //Android系统会在与服务的连接意外中断时（例如当服务崩溃或被终止时）调用该方法。
        // 当客户端取消绑定时，系统“绝对不会”调用该方法。
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
             /*方法二：使用Messenger类*/
            mServiceMessenger = null;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        /*方法一：继承binder*/
//        bindService(new Intent(MainActivity.this, BinderService.class),
//                mConnection, Context.BIND_AUTO_CREATE);
        /*方法二：使用Messenger类*/
        Intent intent = new Intent();
        intent.setAction("com.hhz.aidl.Messenger");
        intent.setPackage("com.hhz.aidl");
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    public void sayHello(View v){
        if(!mBound) return;
        //发送一条消息给服务端
        Message msg = Message.obtain(null,MSG_SAY_HELLO,0,0);
        try {
            mServiceMessenger.send(msg);
            LogT.w("发送一条消息给服务端--"+msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


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
                sayHello(v);
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
//            case R.id.startDateRow:
//                isDateStartPicked =true;
//                mCalendarDialog.getContentView().setCalendarData(startDate);
//                mCalendarDialog.show();
//                break;
//            case R.id.endDateRow:
//                isDateStartPicked =false;
//                mCalendarDialog.getContentView().setCalendarData(endDate);
//                mCalendarDialog.show();
//                break;
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
        /*mCalendarDialog.dismiss();
        if(this.isDateStartPicked){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(downDate);
            this.startDate = calendar.getTime();
            this.startDateShowTextView.setText(DateUtils.formatDateToString(startDate, "yyyy-MM-dd"));
            this.startDateShowTextView.setTextColor(getResources().getColor(android.R.color.black));
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(downDate);
            this.endDate = new Date(calendar.getTimeInMillis() + (24 * 60 * 60 * 1000) - 1);
            this.endDateShowTextView.setText(DateUtils.formatDateToString(endDate, "yyyy-MM-dd"));
            this.endDateShowTextView.setTextColor(getResources().getColor(android.R.color.black));
        }*/
    }
}