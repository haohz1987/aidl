package com.hhz.aidl.activity;

import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhz.aidl.R;
import com.hhz.aidl.mvp.model.BaseModel;
import com.hhz.aidl.mvp.presenter.BasePresenter;
import com.hhz.aidl.util.ACache;
import com.hhz.aidl.util.glide.GlideUtils;

/**
 * Created by haohz on 2017/12/25.
 */

public class GrantMemberCard extends BaseActivity<BaseModel.View, BasePresenter> implements BaseModel.View {

    private ACache mACache;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_send_card;
    }

    @Override
    protected void initializeView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setToolbar(toolbar);
        ((TextView) findViewById(R.id.toolbar_title)).setText("发放会员卡");
        mACache = ACache.get(GrantMemberCard.this);
    }

    @Override
    protected void initializeData() {
        if (getIntent() == null) {
            return;
        }
        String title = getIntent().getStringExtra("title");
        String membershipCardType = getIntent().getStringExtra("membershipCardType");
        String discountAmount = getIntent().getStringExtra("discountAmount");
        int backgroundRes = getIntent().getIntExtra("backgroundRes", 0);
        String qrCodeUrl = getIntent().getStringExtra("qrCode");

        ((TextView) findViewById(R.id.tv_store_name)).setText(title);
        ((TextView) findViewById(R.id.tv_card_type)).setText(membershipCardType);
        ((TextView) findViewById(R.id.tv_discount)).setText(discountAmount);
        findViewById(R.id.ll_grant).setBackgroundResource(backgroundRes);
        ImageView iv_qrcode = findViewById(R.id.iv_qrcode);
        /**
         * Glide缓存
         * @param context
         * @param imageView 放入的图片
         * @param qrCodeUrl 请求网址
         * @param mACache 本地缓存工具
         * @param cacheName 缓存到本地的网址标签名
         */
        GlideUtils.readCache(this,iv_qrcode,qrCodeUrl,mACache,title);
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
}
