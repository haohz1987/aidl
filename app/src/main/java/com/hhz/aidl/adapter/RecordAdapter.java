package com.hhz.aidl.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.activity.BaseActivity;
import com.hhz.aidl.rxjava.RecordBean;
import com.hhz.aidl.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwl on 16/9/6.
 */
public class RecordAdapter extends BaseAdapter {

    private List<RecordBean.ResultBean> recordList = new ArrayList<>();


    private LayoutInflater inflater;
    private Activity mActivity;

    public RecordAdapter(BaseActivity activity, @Nullable List<RecordBean.ResultBean> recordList) {
        this.recordList.clear();
        this.recordList = recordList;
        this.
        mActivity = activity;
        inflater = LayoutInflater.from(activity);
    }

    public void appendData(ArrayList<RecordBean.ResultBean> recordList, int page) {
        if (page == 1) {
            this.recordList.clear();
        }
        this.recordList.addAll(recordList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        RecordBean.ResultBean recordListBean = this.recordList.get(position);
        if(convertView==null){
            convertView = (RelativeLayout) inflater.inflate(R.layout.item_record,null);
            viewHolder.tv_date = convertView.findViewById(R.id.tv_date);
            viewHolder.tv_type = convertView.findViewById(R.id.tv_type);
            viewHolder.tv_flow = convertView.findViewById(R.id.tv_flow);
            viewHolder.tv_consume_lite = convertView.findViewById(R.id.tv_consume_lite);
            viewHolder.tv_coupon_no = convertView.findViewById(R.id.tv_coupon_no);
            viewHolder.tv_order_amount = convertView.findViewById(R.id.tv_order_amount);
            viewHolder.tv_order_discount = convertView.findViewById(R.id.tv_order_discount);
            viewHolder.tv_order_pay = convertView.findViewById(R.id.tv_order_pay);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //记录类型：核销记录：1，发放记录：2
        if(recordList.get(position).getRecordType()==1){
            //
            viewHolder.tv_date.setText(DateUtils.formatDateToString(
                    DateUtils.formatStringToDate(recordListBean.getRecordDate(), "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss"));
            //优惠券类型：代金券：1折扣券:2，兑换券：3
            if(recordListBean.getCouponType()==1){
                viewHolder.tv_type.setText("使用代金券");
            }else if(recordListBean.getCouponType()==2){
                viewHolder.tv_type.setText("使用折扣券");
            }else if(recordListBean.getCouponType()==3){
                viewHolder.tv_type.setText("使用兑换券");
            }
            viewHolder.tv_flow.setText("流水号："+recordListBean.getSerialNo());//流水号
            viewHolder.tv_consume_lite.setText("满"+recordListBean.getConsumeLite()+"-"+recordListBean.getCouponAmount());

        }else {

        }

        return convertView;
    }
    class ViewHolder{
        public TextView tv_date;//日期
        public TextView tv_type;//使用代金券

        public TextView tv_flow;//流水号
        public TextView tv_consume_lite;//满减
        public TextView tv_coupon_no;//券编号

        public TextView tv_order_amount;//订单金额
        public TextView tv_order_discount;//优惠金额
        public TextView tv_order_pay;//实收金额
    }
}
