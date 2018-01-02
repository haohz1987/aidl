package com.hhz.aidl.activity.fragment;

import android.os.Bundle;

import com.hhz.aidl.R;
import com.hhz.aidl.base.BaseFragment;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;

/**
 * Created by haohz on 2017/12/26.
 */

public class RecordFragment extends BaseFragment<MainContract.View, MainPresenter>
        implements MainContract.View{
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_record;
    }

    @Override
    protected void initializeView() {


    }
    public static RecordFragment newInstance(String title) {
        RecordFragment gankFragment = new RecordFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        gankFragment.setArguments(bundle);
        return gankFragment;
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
