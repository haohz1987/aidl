package com.handpay.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.handpay.aidl.Data;

/**
 * @author tliang
 * Created on 2017/6/8.
 */
public class SpUtils {
    private static SharedPreferences sp=null;
    private static final String SP_NAME="AIDL";
    private static final String TEMP_SELF_KEY="tempSelfKey";
    private static final String TEMP_CLIENT_KEY="tempClientKey";
    private static final String USER_NAME="username";
    private static final String USER_PWD="password";
    private static final String TRANS_MONEY="money";
    private static Data data;

    public static void saveSelfTempKey(Context context,String temp){
        save(context,TEMP_SELF_KEY,temp);
    }

    public static void saveClientTempKey(Context context,String temp){
        save(context,TEMP_CLIENT_KEY,temp);
    }

    public static String getSelfTempKey(Context context){
        return get(context,TEMP_SELF_KEY);
    }

    public static String getClientTempKey(Context context){
        return get(context,TEMP_CLIENT_KEY);
    }

    public static void saveUserData(Context context,Data data){
        save(context,USER_NAME,data.getUserName());
        save(context,USER_PWD,data.getPassword());
        save(context,TRANS_MONEY,data.getMoney()+"");
    }

    public static Data getUserData(Context context){
        data=new Data();
        data.setUserName(get(context,USER_NAME));
        data.setPassword(get(context,USER_PWD));
        data.setMoney(get(context,TRANS_MONEY));
        return data;
    }
    public static void removeAll(Context context){
        sp=context.getSharedPreferences(SP_NAME,Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sp.edit();
        editor.remove(TEMP_SELF_KEY);
        editor.remove(TEMP_CLIENT_KEY);
        editor.remove(USER_NAME);
        editor.remove(USER_PWD);
        editor.remove(TRANS_MONEY);
        editor.commit();
    }
    private static void save(Context context,String key,String data){
        sp=context.getSharedPreferences(SP_NAME,Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sp.edit();
        if(sp.contains(key)){
            editor.remove(key);
        }
        editor.putString(key,data);
        editor.commit();
    }
    private static String get(Context context,String key){
        sp=context.getSharedPreferences(SP_NAME,Context.MODE_MULTI_PROCESS);
        return sp.getString(key,"");
    }

}
