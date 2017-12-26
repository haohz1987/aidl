package com.hhz.aidl.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhz.aidl.R;
import com.hhz.aidl.activity.GrantMemberCard;
import com.hhz.aidl.rxjava.MemberShipBean;
import com.hhz.aidl.util.ACache;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.util.glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohz on 2017/12/25.
 */

public class MemberShipAdapter extends BaseQuickAdapter<MemberShipBean.ResultBean, BaseViewHolder> {

    private List<MemberShipBean.ResultBean> dataList = new ArrayList<>();
    private Context context;
    private ACache mACache;

    public MemberShipAdapter(Context context, @Nullable List<MemberShipBean.ResultBean> dataList) {
        super(R.layout.item_member, dataList);
        this.dataList.clear();
        this.context = context;
        this.dataList = dataList;
        mACache = ACache.get(context);
    }

    public void appendData(ArrayList<MemberShipBean.ResultBean> dataList, int page) {
        if (page == 1) {
            this.dataList.clear();
        }
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final MemberShipBean.ResultBean item) {
//        final int position = helper.getLayoutPosition();
        helper.setText(R.id.tv_store_name, item.getTitle());
        String membershipCardType = "";
        if (item.getMembershipCardType() == 2)  membershipCardType = "高级会员卡";
        else membershipCardType = "普通会员卡";
        helper.setText(R.id.tv_card_type, membershipCardType);
        helper.setText(R.id.tv_discount, Math.floor(item.getDiscountAmount() / 10) + "折");
        if (item.getCardColor() != -1)
            helper.setBackgroundRes(R.id.ll_membership, CouponColorType.getResID(item.getCardColor() + ""));
        final String finalMembershipCardType = membershipCardType;
        helper.getView(R.id.btn_send_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GrantMemberCard.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("membershipCardType", finalMembershipCardType);
                intent.putExtra("discountAmount", Math.floor(item.getDiscountAmount() / 10) + "折");
                intent.putExtra("backgroundRes",CouponColorType.getResID(item.getCardColor() + ""));
                intent.putExtra("qrCode", item.getQrCode());
                intent.putExtra("mechantLogo",item.getMechantLogo());
                context.startActivity(intent);
            }
        });

        ImageView iv_store_logo = helper.getView(R.id.iv_store_logo);
        GlideUtils.readCache(context,iv_store_logo,item.getMechantLogo(),mACache,item.getTitle());

    }
}
