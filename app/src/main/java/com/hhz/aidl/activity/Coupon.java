package com.hhz.aidl.activity;

import android.view.View;

import com.hhz.aidl.mvp.model.MainModel;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;

/**
 * Created by haohz on 2017/12/22.
 */

public class Coupon extends BaseActivity<MainModel.View, MainPresenter>
        implements MainModel.View,View.OnClickListener{
    @Override
    public void onClick(View v) {

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

    }

    @Override
    public void onGetCoupListSuccess(CouponBean couponBean) {

    }

    @Override
    public void onGetRecordSuccess(RecordBean recordBean) {

    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initializeView() {

    }

    @Override
    protected void initializeData() {

    }
}
