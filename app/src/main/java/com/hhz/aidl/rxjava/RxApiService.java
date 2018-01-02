package com.hhz.aidl.rxjava;

import com.hhz.aidl.bean.CouponBean;
import com.hhz.aidl.bean.MemberShipBean;
import com.hhz.aidl.bean.RecordBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by luwang on 2017/5/5.
 */

public interface RxApiService {

    public static final String API_BASE_URL = "http://1.smartpos.applinzi.com/";
    public static final String DO_GETOPENID = "getOpenId",  //获取会员卡信息
            DO_GETCOUPLIST = "getCoupList",                  //获取优惠券信息
            DO_GETRECORD = "getRecord";               //获取优惠券记录

    /**
     *  获取会员卡信息
     */
    @POST(DO_GETOPENID)
    Observable<MemberShipBean> getOpenId(@Body RequestBody requestBody);
    /**
     *  获取优惠券信息
     *
     */
    @POST(DO_GETCOUPLIST)
    Observable<CouponBean> getCoupList(@Body RequestBody requestBody);
    /**
     *  获取优惠券记录
     *
     */
    @POST(DO_GETRECORD)
    Observable<RecordBean> getRecord(@Body RequestBody requestBody);

}
