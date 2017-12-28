package com.hhz.aidl.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.adapter.RecordAdapter;
import com.hhz.aidl.mvp.model.MainContract;
import com.hhz.aidl.mvp.presenter.MainPresenter;
import com.hhz.aidl.rxjava.CouponBean;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.rxjava.RecordBean;
import com.hhz.aidl.util.DateUtils;
import com.hhz.aidl.view.CalendarDialogView;
import com.hhz.aidl.view.CalendarView;
import com.hhz.aidl.view.ZZTShowDialog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by haohz on 2017/12/22.
 */

public class Record extends BaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View, CalendarView.OnItemClickListener, View.OnClickListener {

    private ListView listView;
    private ZZTShowDialog<CalendarDialogView> mCalendarDialog;
    private boolean isDateStartPicked = false;
    // 起始日期
    private Date startDate;
    // 结束日期
    private Date endDate;
    private TextView startDateShowTextView;
    private TextView endDateShowTextView;
    private HashMap<String, Object> params;
    private LinearLayout queryBillsListViewFooterView;
    private TextView tvPageInfo;
    private Button btnIndex;
    private Button btnEnd;
    private Button btnLast;
    private Button btnNext;

    @SuppressWarnings("unchecked")
    private ArrayList<RecordBean.ResultBean> dataList = new ArrayList<>();
    public static RecordAdapter recordAdapter;
    private static int pageTotal;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_record;
    }

    @Override
    protected void initializeView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setToolbar(toolbar);
        findViewById(R.id.iv_message).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.toolbar_title)).setText("记录");
        listView = findViewById(R.id.lv_record);

        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout headerView = (RelativeLayout) inflater.inflate(R.layout.list_record_header, null);
        ((Button) headerView.findViewById(R.id.btn_query)).setOnClickListener(this);
        ((TableRow) headerView.findViewById(R.id.startDateRow)).setOnClickListener(this);
        ((TableRow) headerView.findViewById(R.id.endDateRow)).setOnClickListener(this);
        headerView.findViewById(R.id.btn_query).setOnClickListener(this);


        mCalendarDialog = new ZZTShowDialog<CalendarDialogView>(this, new CalendarDialogView(this), R.style.dialog);
        mCalendarDialog.getContentView().getCalendar().setOnItemClickListener(this);

        startDateShowTextView = headerView.findViewById(R.id.startDateShowTextView);
        endDateShowTextView = headerView.findViewById(R.id.endDateShowTextView);
        Date today = DateUtils.formatStringToDate(DateUtils.formatDateToString(new Date(), "yyyyMMdd"), "yyyyMMdd");
        this.startDate = today;
        this.endDate = new Date(today.getTime() + (24 * 60 * 60 * 1000) - 1);

        this.startDateShowTextView.setText(DateUtils.formatDateToString(startDate, "yyyy-MM-dd"));
        this.endDateShowTextView.setText(DateUtils.formatDateToString(today, "yyyy-MM-dd"));
        listView.addHeaderView(headerView);

        LayoutInflater footInflater = LayoutInflater.from(this);
        this.queryBillsListViewFooterView = (LinearLayout) footInflater.inflate(R.layout.more_item, null);
        tvPageInfo = (TextView) queryBillsListViewFooterView.findViewById(R.id.tvPageInfo);
        btnIndex = (Button) this.queryBillsListViewFooterView.findViewById(R.id.btnIndex);
        btnEnd = (Button) this.queryBillsListViewFooterView.findViewById(R.id.btnEnd);
        btnLast = (Button) this.queryBillsListViewFooterView.findViewById(R.id.btnLast);
        btnNext = (Button) this.queryBillsListViewFooterView.findViewById(R.id.btnNext);
        this.btnIndex.setOnClickListener(this);
        this.btnEnd.setOnClickListener(this);
        this.btnLast.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.listView.addFooterView(this.queryBillsListViewFooterView);

        queryBillsListViewFooterView.setVisibility(View.VISIBLE);

        this.listView.setAdapter(null);
    }

    @Override
    protected void initializeData() {
        params = new HashMap<>();
        params.put("userId", "10");

        initAdapter();
        mCalendarDialog = new ZZTShowDialog<CalendarDialogView>(this, new CalendarDialogView(this), R.style.dialog);
        mCalendarDialog.getContentView().getCalendar().setOnItemClickListener(this);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
    private void initAdapter() {
        dataList.clear();
        recordAdapter = new RecordAdapter(Record.this, dataList);
        listView.setAdapter(recordAdapter);
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
        dataList = (ArrayList<RecordBean.ResultBean>) recordBean.getResult();
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", dataList);
        bundle.putInt("pageTotal",recordBean.getTotalPage());
        msg.setData(bundle);
        myHandler.sendMessage(msg);
    }
    private final MyHandler myHandler= new MyHandler(this);
    private static class MyHandler extends Handler {
        private final WeakReference<Record> mActivty;

        public MyHandler(Record activity) {
            mActivty = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Record activity = mActivty.get();
            super.handleMessage(msg);
            if (activity != null) {
                Bundle data = msg.getData();
                ArrayList<RecordBean.ResultBean> list = data.getParcelableArrayList("list");
//                int page = data.getInt("page");
                pageTotal = data.getInt("pageTotal");

                if (recordAdapter != null && list != null) {
                    recordAdapter.appendData(list, 1);//初始化数据
                }
            }
        }
    }
    @Override
    public void OnItemClick(Date selectedStartDate, Date selectedEndDate, Date downDate) {
        mCalendarDialog.dismiss();
        if (this.isDateStartPicked) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(downDate);
            this.startDate = calendar.getTime();
            this.startDateShowTextView.setText(DateUtils.formatDateToString(startDate, "yyyy-MM-dd"));
            this.startDateShowTextView.setTextColor(getResources().getColor(android.R.color.black));
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(downDate);
            this.endDate = new Date(calendar.getTimeInMillis() + (24 * 60 * 60 * 1000) - 1);
            this.endDateShowTextView.setText(DateUtils.formatDateToString(endDate, "yyyy-MM-dd"));
            this.endDateShowTextView.setTextColor(getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.startDateRow) {
            isDateStartPicked = true;
            mCalendarDialog.getContentView().setCalendarData(startDate);
            mCalendarDialog.show();
        } else if (v.getId() == R.id.endDateRow) {
            isDateStartPicked = false;
            mCalendarDialog.getContentView().setCalendarData(endDate);
            mCalendarDialog.show();
        } else if (v.getId() == R.id.btn_query) {
            mPresenter.getRecord(params);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);//清除消息队列
        recordAdapter = null;
    }
}
