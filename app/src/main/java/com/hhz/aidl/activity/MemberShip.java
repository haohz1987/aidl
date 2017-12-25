package com.hhz.aidl.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hhz.aidl.R;
import com.hhz.aidl.adapter.MemberShipAdapter;
import com.hhz.aidl.mvp.model.MainModel;
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

public class MemberShip extends BaseActivity<MainModel.View, MainPresenter>
        implements MainModel.View, View.OnClickListener {

    private RecyclerView listContainer;
    public static MemberShipAdapter memberShipAdapter;
    @SuppressWarnings("unchecked")
    private ArrayList<MemberShipBean.ResultBean> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_membership;
    }

    @Override
    protected void initializeView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setToolbar(toolbar);
        listContainer = findViewById(R.id.list_container);
        listContainer.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
    }

    private void initAdapter() {
        dataList.clear();
        memberShipAdapter = new MemberShipAdapter(MemberShip.this, dataList);
        listContainer.setAdapter(memberShipAdapter);
    }

    @Override
    protected void initializeData() {
        HashMap params = new HashMap<>();
        params.put("userId", "10");
        mPresenter.getOpenId(params);
    }

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
    private final MyHandlerNotice myHandler= new MyHandlerNotice(this);
    @Override
    public void onGetOpenIdSuccess(MemberShipBean memberShipBean) {
        dataList = (ArrayList<MemberShipBean.ResultBean>) memberShipBean.getResult();
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dataList);
        msg.setData(bundle);
        myHandler.sendMessage(msg);
    }
    private static class MyHandlerNotice extends Handler {
        private final WeakReference<MemberShip> mActivty;

        public MyHandlerNotice(MemberShip activity) {
            mActivty = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MemberShip activity = mActivty.get();
            super.handleMessage(msg);
            if (activity != null) {
                Bundle data = msg.getData();
                ArrayList<MemberShipBean.ResultBean> list = data.getParcelableArrayList("list");
//                int page = data.getInt("page");
                if (memberShipAdapter != null && list != null) {
                    memberShipAdapter.appendData(list, 1);//初始化数据
                }
            }
        }
    }
    @Override
    public void onGetCoupListSuccess(CouponBean couponBean) {

    }

    @Override
    public void onGetRecordSuccess(RecordBean recordBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);//清除消息队列
        memberShipAdapter=null;
    }
}
