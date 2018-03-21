package com.hhz.aidl.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hhz.aidl.R;
import com.hhz.aidl.adapter.MemberShipAdapter;
import com.hhz.aidl.base.BaseActivity;
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.util.LogT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

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

    private String loadlocalData() {
        AssetManager assetManager = mContext.getAssets();
        try {
            InputStream is = assetManager.open("getOpenId.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuffer = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
            return stringBuffer.toString();

        } catch (IOException e) {
            return null;
        }
    }

    private void initAdapter() {


        dataList.clear();
        memberShipAdapter = new MemberShipAdapter(MemberShip.this, dataList);
        listContainer.setAdapter(memberShipAdapter);
    }

    @Override
    protected void initializeData() {
        String temp = loadlocalData();
        if (TextUtils.isEmpty(temp)) {
            return;
        }

        MemberShipBean memberbean = new Gson().fromJson(temp, MemberShipBean.class);
        dataList.clear();
        dataList.addAll(memberbean.getResult());

        dataList = (ArrayList<MemberShipBean.ResultBean>) memberbean.getResult();

        LogT.w(dataList.toString());
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dataList);
        msg.setData(bundle);
        myHandler.sendMessage(msg);
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
