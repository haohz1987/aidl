package com.hhz.aidl.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.adapter.MemberShipAdapter;
import com.hhz.aidl.base.BaseActivity;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by haohz on 2017/12/22.
 */

public class MemberShip extends BaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View{

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
        ((TextView)findViewById(R.id.toolbar_title)).setText("会员卡");
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
    public void onGetOpenIdSuccess(MemberShipBean memberShipBean) {
        dataList = (ArrayList<MemberShipBean.ResultBean>) memberShipBean.getResult();
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dataList);
        msg.setData(bundle);
        myHandler.sendMessage(msg);
    }
    private static class MyHandler extends Handler {
        private final WeakReference<MemberShip> mActivty;

        public MyHandler(MemberShip activity) {
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
                if (memberShipAdapter != null && list != null && list.size()>0) {
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
