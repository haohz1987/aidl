package com.hhz.aidl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.adapter.CouponAdapter;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by haohz on 2017/12/22.
 */

public class Coupon extends BaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View{
    private RecyclerView listContainer;
    public static CouponAdapter couponAdapter;
    @SuppressWarnings("unchecked")
    private ArrayList<CouponBean.ResultBean> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_membership;
    }

    @Override
    protected void initializeView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setToolbar(toolbar);
        ((TextView)findViewById(R.id.toolbar_title)).setText("优惠券");
        listContainer = findViewById(R.id.list_container);
        listContainer.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        findViewById(R.id.iv_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Coupon.this,Record.class));
            }
        });

    }

    private void initAdapter() {
        dataList.clear();
        couponAdapter = new CouponAdapter(this, dataList);
        listContainer.setAdapter(couponAdapter);
    }

    @Override
    protected void initializeData() {
        HashMap params = new HashMap<>();
        params.put("userId", "10");
        mPresenter.getCoupList(params);
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
    private final MyHandler myHandler= new MyHandler(this);
    @Override
    public void onGetOpenIdSuccess(MemberShipBean couponBean) {

    }
    private static class MyHandler extends Handler {
        private final WeakReference<Coupon> mActivty;

        public MyHandler(Coupon activity) {
            mActivty = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Coupon activity = mActivty.get();
            super.handleMessage(msg);
            if (activity != null) {
                Bundle data = msg.getData();
                ArrayList<CouponBean.ResultBean> list = data.getParcelableArrayList("list");
//                int page = data.getInt("page");
                if (couponAdapter != null && list != null) {
                    couponAdapter.appendData(list, 1);//初始化数据
                }
            }
        }
    }
    @Override
    public void onGetCoupListSuccess(CouponBean couponBean) {
        dataList = (ArrayList<CouponBean.ResultBean>) couponBean.getResult();
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dataList);
        msg.setData(bundle);
        myHandler.sendMessage(msg);
    }

    @Override
    public void onGetRecordSuccess(RecordBean recordBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);//清除消息队列
        couponAdapter=null;
    }
}
