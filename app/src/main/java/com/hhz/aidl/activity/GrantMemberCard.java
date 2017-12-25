package com.hhz.aidl.activity;

import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hhz.aidl.R;
import com.hhz.aidl.mvp.model.BaseModel;
import com.hhz.aidl.mvp.presenter.BasePresenter;
import com.hhz.aidl.util.ACache;
import com.hhz.aidl.util.glide.GlideUtils;
import com.hhz.aidl.util.glide.MyGlideCacheListener;

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
        readCache(qrCodeUrl);


    }

    private void readCache(String qrCodeUrl) {
        ImageView iv_qrcode = findViewById(R.id.iv_qrcode);

        //有缓存的网址
        if (!ACache.isEmpty(mACache.getAsString("qrCodeUrl"))) {
            String qrCodeUrlCache = mACache.getAsString("qrCodeUrl");
            //没有缓存图片
            if (!GlideUtils.haveCache(this, qrCodeUrlCache)) {
                noCache(iv_qrcode, qrCodeUrl, "qrCodeUrl");
                return;
            }
            //网络请求错误，读缓存
            if(ACache.isEmpty(qrCodeUrl)){
                Glide.with(this).load(GlideUtils.getCache(this, qrCodeUrlCache)).into(iv_qrcode);
                return;
            }
            //网址同缓存地址
            if (qrCodeUrl.equals(qrCodeUrlCache)) {
                Glide.with(this).load(GlideUtils.getCache(this, qrCodeUrl)).into(iv_qrcode);
            }
            //缓存地址错误或不是最新
            else {
                noCache(iv_qrcode, qrCodeUrl, "qrCodeUrl");
            }
        }
        //没有缓存网址
        else {
            noCache(iv_qrcode, qrCodeUrl, "qrCodeUrl");
        }
    }

    /**
     * 没有缓存 或 缓存不是最新
     *
     * @param imageView
     * @param imageUrl  网址
     * @param urlKey    要缓存的网址名称
     */
    private void noCache(ImageView imageView, String imageUrl, String urlKey) {
        Glide.with(GrantMemberCard.this).load(imageUrl).placeholder(R.color.placeholder_color).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        GlideUtils.cacheImage(imageUrl, GrantMemberCard.this, new MyGlideCacheListener());
        mACache.put(urlKey, imageUrl);
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
