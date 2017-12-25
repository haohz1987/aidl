package com.hhz.aidl.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhz.aidl.view.ActionSheetCoupon;
import com.hhz.aidl.view.ColorSelectDialog;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.R;
import com.hhz.aidl.mvp.model.MainModel;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;
import com.hhz.aidl.service.IntentServiceDemo;
import com.hhz.aidl.service.ServiceDemo;

import java.util.HashMap;

public class MainActivity extends BaseActivity<MainModel.View, MainPresenter>
        implements MainModel.View,View.OnClickListener, ActionSheetCoupon.OnActionSheetSelected,
        ColorSelectDialog.OnColorSelected {

    private HashMap<String, Object> params;

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
        findViewById(R.id.btn_getRecord).setOnClickListener(this);
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
                mPresenter.getCoupList(params);
                break;
            case R.id.btn_getRecord:
                mPresenter.getRecord(params);
                break;
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
}
