package com.hhz.aidl.mvp.model;

import com.hhz.aidl.mvp.IBasePresenter;
import com.hhz.aidl.mvp.IBaseView;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;

import java.util.HashMap;

/**
 * Created by haohz on 2017/12/22.
 */

public interface MainModel {
    interface View extends IBaseView {
        void onGetOpenIdSuccess(MemberShipBean memberShipBean);
        void onGetCoupListSuccess(CouponBean couponBean);
        void onGetRecordSuccess(RecordBean recordBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getOpenId(HashMap<String, Object> params);
        void getCoupList(HashMap<String, Object> params);
        void getRecord(HashMap<String, Object> params);

    }
}
