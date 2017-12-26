package com.hhz.aidl.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.mvp.model.MainModel;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;

/**
 * Created by haohz on 2017/12/22.
 */

public class Record extends BaseActivity<MainModel.View, MainPresenter>
        implements MainModel.View{

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_record;
    }

    @Override
    protected void initializeView() {
        findViewById(R.id.iv_message).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.toolbar_title)).setText("记录");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setToolbar(toolbar);
    }

    @Override
    protected void initializeData() {

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


}
