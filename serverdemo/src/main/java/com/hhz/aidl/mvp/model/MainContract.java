package com.hhz.aidl.mvp.model;

import com.hhz.aidl.base.IBasePresenter;
import com.hhz.aidl.base.IBaseView;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;

import java.util.HashMap;

/**
 * Created by haohz on 2017/12/22.
 */

public interface MainContract {
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
