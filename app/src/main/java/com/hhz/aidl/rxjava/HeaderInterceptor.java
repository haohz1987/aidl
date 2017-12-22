package com.hhz.aidl.rxjava;

import com.hhz.aidl.LogT;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by zgh on 6/27/2017.
 */

public final class HeaderInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        Charset charset = UTF8;
        MediaType mediaType = body.contentType();
        if (mediaType != null) {
            mediaType.charset(UTF8);
        }
        String string = buffer.readString(charset);

        try {
            JSONObject jsonObject = new JSONObject(string);
            HashMap<String, String> map = new HashMap();
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = String.valueOf(keys.next());
                String value = (String) jsonObject.get(key);
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(request.url());

        Request.Builder builder = request.newBuilder();
        builder.method(request.method(), body);
        builder.url(stringBuilder.toString());
        builder.addHeader("Content-Type", "application/json;charset = UTF-8");
        builder.addHeader("Accept", "application/json");

        Response response = chain.proceed(builder.build());
        MediaType mediaType1 = response.body().contentType();
        String content = response.body().string();
        LogT.w("-------------ResponseBody =  " + content);

        return response.newBuilder().body(ResponseBody.create(mediaType1, content)).build();
    }


}
