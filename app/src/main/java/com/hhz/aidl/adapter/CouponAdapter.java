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
import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.util.ACache;
import com.hhz.aidl.util.CouponColorType;
import com.hhz.aidl.util.LogT;
import com.hhz.aidl.util.glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohz on 2017/12/25.
 */

public class CouponAdapter extends BaseQuickAdapter<CouponBean.ResultBean, BaseViewHolder> {

    private List<CouponBean.ResultBean> dataList = new ArrayList<>();
    private Context context;
    private ACache mACache;

    public CouponAdapter(Context context, @Nullable List<CouponBean.ResultBean> dataList) {
        super(R.layout.item_coupon, dataList);
        this.dataList.clear();
        this.context = context;
        this.dataList = dataList;
        mACache = ACache.get(context);
    }

    public void appendData(ArrayList<CouponBean.ResultBean> dataList, int page) {
        if (page == 1) {
            this.dataList.clear();
        }
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final CouponBean.ResultBean item) {
        LogT.w(item.toString());
//        final int position = helper.getLayoutPosition();
        //优惠券类型：代金券：1,折扣券:2，兑换券：3
        switch (item.getCouponType()){
            case 1:
                //满100-10
                helper.setText(R.id.tv_store_name, "满"+item.getConsumeLite()+"-"+item.getCouponAmount());
                helper.setText(R.id.tv_consume_lite,"满"+item.getConsumeLite()+"可用");
                helper.setText(R.id.tv_card_type,"有效期"+item.getValidPeriod()+"天"); //并非还剩余天数
                helper.setText(R.id.tv_discount,item.getCouponAmount()+"元");

                break;
            case 2:
                helper.setText(R.id.tv_store_name, Math.floor(item.getDiscountAmount()/10)+"折");
                helper.setText(R.id.tv_consume_lite,"");
                helper.setText(R.id.tv_card_type,"有效期"+item.getValidPeriod()+"天"); //并非还剩余天数
                helper.setText(R.id.tv_discount,"");
                break;
            case 3:
                helper.setText(R.id.tv_store_name, item.getCouponTitle());
                helper.setText(R.id.tv_consume_lite,"");
                helper.setText(R.id.tv_card_type,"有效期"+item.getValidPeriod()+"天"); //并非还剩余天数
                helper.setText(R.id.tv_discount,"");
                break;
        }
        String membershipCardType = "";
        if (item.getCouponColor() != -1)
            helper.setBackgroundRes(R.id.ll_membership, CouponColorType.getResID(item.getCouponColor() + ""));
        final String finalMembershipCardType = membershipCardType;
        //发券
        helper.getView(R.id.btn_send_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GrantMemberCard.class);
                intent.putExtra("title", item.getCouponTitle());
                intent.putExtra("membershipCardType", finalMembershipCardType);
                intent.putExtra("discountAmount", Math.floor(item.getDiscountAmount() / 10) + "折");
                intent.putExtra("backgroundRes",CouponColorType.getResID(item.getCouponColor() + ""));
                intent.putExtra("qrCode", item.getQrCode());
                intent.putExtra("mechantLogo",item.getMechantLogo());
                context.startActivity(intent);
            }
        });
        //查看
        helper.getView(R.id.btn_find).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView iv_store_logo = helper.getView(R.id.iv_store_logo);
        GlideUtils.readCache(context,iv_store_logo,item.getMechantLogo(),mACache,item.getCouponTitle());

    }
}
