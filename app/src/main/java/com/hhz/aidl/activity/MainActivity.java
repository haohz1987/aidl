package com.hhz.aidl.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;
import com.hhz.aidl.service.IntentServiceDemo;
import com.hhz.aidl.service.ServiceDemo;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.view.ActionSheetCoupon;
import com.hhz.aidl.view.CalendarDialogView;
import com.hhz.aidl.view.CalendarView;
import com.hhz.aidl.view.ColorSelectDialog;
import com.hhz.aidl.view.ZZTShowDialog;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends BaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View,View.OnClickListener, ActionSheetCoupon.OnActionSheetSelected,
        ColorSelectDialog.OnColorSelected,CalendarView.OnItemClickListener{

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
        params.put("userId","10");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_service:
                startService(new Intent(MainActivity.this, ServiceDemo.class));
                break;
            case R.id.btn_intentservice:
                startService(new Intent(MainActivity.this, IntentServiceDemo.class));
                break;
            //会员卡颜色选择
            case R.id.btn_color_select:
                ColorSelectDialog.selectColor(MainActivity.this, MainActivity.this, new DialogInterface.OnCancelListener() {
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

                startActivity(new Intent(MainActivity.this,MemberShip.class));
                break;
            case R.id.btn_getCoupList:
                startActivity(new Intent(MainActivity.this,Coupon.class));
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
        String tag="";
        switch (whichButton) {
            case R.id.btn_cashcoupon:
                tag="代金券";
                break;
            case R.id.btn_discount:
                tag="折扣券";
                break;
            case R.id.btn_exchange:
                tag="兑换券";
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