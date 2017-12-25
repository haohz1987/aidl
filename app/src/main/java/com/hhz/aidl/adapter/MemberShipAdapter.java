package com.hhz.aidl.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhz.aidl.R;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.util.LogT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohz on 2017/12/25.
 */

public class MemberShipAdapter extends BaseQuickAdapter<MemberShipBean.ResultBean, BaseViewHolder> {

    private List<MemberShipBean.ResultBean> dataList = new ArrayList<>();
    private Context context;

    public MemberShipAdapter(Context context, @Nullable List<MemberShipBean.ResultBean> dataList) {
        super(R.layout.item_member, dataList);
        this.dataList.clear();
        this.context = context;
        this.dataList = dataList;
    }

    public void appendData(ArrayList<MemberShipBean.ResultBean> dataList, int page) {
        if (page == 1) {
            this.dataList.clear();
        }
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, MemberShipBean.ResultBean item) {
//        final int position = helper.getLayoutPosition();
        helper.setText(R.id.tv_store_name, item.getTitle());
        if (item.getMembershipCardType() == 2) helper.setText(R.id.tv_card_type, "高级会员卡");
        else helper.setText(R.id.tv_card_type, "普通会员卡");
        helper.setText(R.id.tv_discount, Math.floor(item.getDiscountAmount() / 10) + "折");
        if (item.getCardColor() != -1)
            helper.setBackgroundRes(R.id.ll_membership, CouponColorType.getResID(item.getCardColor() + ""));
        helper.getView(R.id.btn_send_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogT.d("发卡");
            }
        });
    }
}
