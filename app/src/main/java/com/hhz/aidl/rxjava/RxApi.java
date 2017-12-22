package com.hhz.aidl.rxjava;

import com.google.gson.Gson;
import com.hhz.aidl.LogT;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by haohz on 2017/12/22.
 */

public class RxApi {
    private static RxApi mRxApi;
    private RxApiService mRxApiService;
    private Gson mGson = new Gson();
    private  HttpsUtils.SSLParams sslParams;


    private RxApi() {
        //https
//        try {
//            sslParams = HttpsUtils.getSslSocketFactory(
//                    new InputStream[]{getResources().getAssets().open("https.cer")},
//                    getResources().openRawResource(R.raw.****),
//                    "12****");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//                .hostnameVerifier(new UnSafeHostnameVerifier())
//                .addInterceptor(new HeaderInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RxApiService.API_BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRxApiService = retrofit.create(RxApiService.class);

    }

    public static synchronized RxApi getInstance() {
        if (mRxApi == null) {
            mRxApi = new RxApi();
        }
        return mRxApi;
    }


    private RequestBody convertToJson(HashMap<String, String> paramsMap) {
        String strEntity = mGson.toJson(paramsMap);
        LogT.w("strEntity="+strEntity);
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
    }


    private String convertToString(HashMap<String, String> paramsMap) {
        String strEntity = mGson.toJson(paramsMap);
        return strEntity;
    }
    private RequestBody convertToJsonObject(HashMap<String, Object> paramsMap) {
        String strEntity = mGson.toJson(paramsMap);
        LogT.w("请求体="+strEntity);
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), strEntity);
    }

    /**
     * 获取会员卡信息
     */
    public Observable<MemberShipBean> getOpenId(HashMap<String, Object> params) {
        LogT.w(RxApiService.API_BASE_URL+RxApiService.DO_GETOPENID);
        return mRxApiService.getOpenId(convertToJsonObject(params));
    }
    /**
     * 获取优惠券信息
     */
    public Observable<CouponBean> getCoupList(HashMap<String, Object> params) {
        LogT.w(RxApiService.API_BASE_URL+RxApiService.DO_GETCOUPLIST);
        return mRxApiService.getCoupList(convertToJsonObject(params));
    }
    /**
     * 获取优惠券记录
     */
    public Observable<RecordBean> getRecord(HashMap<String, Object> params) {
        LogT.w(RxApiService.API_BASE_URL+RxApiService.DO_GETRECORD);
        return mRxApiService.getRecord(convertToJsonObject(params));
    }
}
