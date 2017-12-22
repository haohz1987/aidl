package com.hhz.aidl.mvp.presenter;

import com.hhz.aidl.util.LogT;
import com.hhz.aidl.mvp.BasePresenterImpl;
import com.hhz.aidl.mvp.model.MainModel;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;
import com.hhz.aidl.rxjava.RxApi;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by haohz on 2017/12/22.
 */

public class MainPresenter extends BasePresenterImpl<MainModel.View> implements MainModel.Presenter {

    @Override
    public void getOpenId(HashMap<String, Object> params) {
        if (getIView() != null)
            RxApi.getInstance().getOpenId(params)
                    .compose(getIView().<MemberShipBean>bindToLife())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MemberShipBean>() {
                        @Override
                        public void onStart() {
                            super.onStart();
                            getIView().showLoading();
                        }

                        @Override
                        public void onCompleted() {
                            getIView().hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            getIView().hideLoading();
                            LogT.w("onError" + e.getMessage());
                        }

                        @Override
                        public void onNext(MemberShipBean memberShipBean) {
                            LogT.w(memberShipBean.toString());
                            getIView().onGetOpenIdSuccess(memberShipBean);

                        }
                    });
    }

    @Override
    public void getCoupList(HashMap<String, Object> params) {
        LogT.w("getCoupList");
        if (getIView() != null)
            RxApi.getInstance().getCoupList(params)
                    .compose(getIView().<CouponBean>bindToLife())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<CouponBean>() {
                        @Override
                        public void onStart() {
                            super.onStart();
                            getIView().showLoading();
                        }
                        @Override
                        public void onCompleted() {
                            getIView().hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            getIView().hideLoading();
                            LogT.w("onError" + e.getMessage());
                        }

                        @Override
                        public void onNext(CouponBean couponBean) {
                            LogT.w(couponBean.toString());
                            getIView().onGetCoupListSuccess(couponBean);
                        }
                    });
    }

    @Override
    public void getRecord(HashMap<String, Object> params) {
        LogT.w("getRecord");
        if (getIView() != null)
            RxApi.getInstance().getRecord(params)
                    .compose(getIView().<RecordBean>bindToLife())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<RecordBean>() {
                        @Override
                        public void onStart() {
                            super.onStart();
                            getIView().showLoading();
                        }
                        @Override
                        public void onCompleted() {
                            getIView().hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            getIView().hideLoading();
                            LogT.w("onError" + e.getMessage());
                        }

                        @Override
                        public void onNext(RecordBean recordBean) {
                            LogT.w(recordBean.toString());
                            getIView().onGetRecordSuccess(recordBean);
                        }
                    });
    }
}