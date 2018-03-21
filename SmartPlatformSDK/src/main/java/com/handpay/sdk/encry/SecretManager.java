package com.handpay.sdk.encry;

import android.text.TextUtils;

import com.handpay.sdk.utils.Constant;
import com.handpay.sdk.utils.LogT;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecretManager {
    public static SecretManager stmanager=null;
    private static String secretKey=null;
    private long beginTime=-1;
    public static SecretManager builder(){
        if(stmanager==null){
            synchronized (SecretManager.class) {
                if(stmanager==null) {
                    stmanager = new SecretManager();
                }
            }
        }
        return stmanager;
    }

    /**
     * create key with every 6 hours
     * @return
     */
    public String createSeed(){
        if(TextUtils.isEmpty(secretKey)){
            LogT.w("---secretKey==null");
            char[] ds=seed0();
            String seed1=seed1();
            LogT.w("seed1="+seed1);
            char[] ds1= seed1.toCharArray();
            String t_imei=Constant.DEVICE_IMEI;
            if(TextUtils.isEmpty(Constant.DEVICE_IMEI)){
                t_imei=Constant.KEY_DEFAULT;
            }
            char[] ds2=t_imei.substring(0,8).toCharArray();
            StringBuffer sbuf=new StringBuffer();
            //分散
            for(int i=0;i<ds.length;i++){
                sbuf.append(ds[ds.length-i-1]+ds1[i]+ds2[ds2.length-i-1]);
            }
            secretKey=sbuf.toString().toLowerCase();
        }
        LogT.w("---createSeed::secretKey="+secretKey);
        return secretKey;
    }

    /**
     * 生成第1个种子
     * @return
     */
    private String seed1(){
        SecureRandom ranGen = new SecureRandom();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<8;i++){
            int nt=ranGen.nextInt(10);
            stringBuffer.append(nt);
        }
        return stringBuffer.toString();
    }

    private boolean isGreater6h(){
        if(beginTime==-1){
            return true;
        }
        long nowtime = System.currentTimeMillis();
        if ((nowtime - this.beginTime) > 1000 * 60 * 60 * 6) {
            return true;
        }
        if ((nowtime - this.beginTime) > 1000 * 60) {
            return true;
        }
        return false;
    }

    /**
     * 生成第0个种子
     * @return
     */
    private char[] seed0(){
        beginTime=System.currentTimeMillis();
        char[] ch8=new char[8];
        String temp=String.valueOf(beginTime);
        StringBuilder sbu=new StringBuilder();
        //防止篡改时间导致error
        if(temp.length()<8){
            sbu.append(temp);
            for(int i=0;i<8-temp.length();i++){
                sbu.append("3");
            }
        }else{
            sbu.append(temp.substring(temp.length()-8, temp.length()));
        }
        for(int j=0;j<sbu.length();j++){
            ch8[j]=sbu.charAt(j);
        }
        return ch8;
    }
    public String stringToMD5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    /**
     * 重置
     */
    public void releaseSource(){
        secretKey=null;
        beginTime=-1;
    }
}
