package com.handpay.sdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    static Pattern pattern = Pattern.compile("[0-9]*");

    public static String changF2Y(String amount){
        if(TextUtils.isEmpty(amount)){
            return null;
        }
        return BigDecimal.valueOf(Double.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 检测是否安装应用
     * @param mContext
     * @param pkName
     * @return
     */
    public static boolean isExitAppWithPackageName(Context mContext, String pkName){
        if (TextUtils.isEmpty(pkName)) {
            return false;
        }
        try {
            ApplicationInfo info = mContext.getPackageManager()
                    .getApplicationInfo(pkName,
                            PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {

            return false;
        }
    }

    /**
     * 是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if(TextUtils.isEmpty(str)){
            return false;
        }
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 密码合法
     * @param mSecret
     * @return
     */
    public static boolean isLegitimateSecret(String mSecret){
        if(TextUtils.isEmpty(mSecret)){
            return false;
        }
        return mSecret.length() >= 6 && mSecret.length() <= 20;
    }


    /**
     * 数字和字符
     * @param str
     * @return
     */
    public static boolean isNumAndChar(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] s = str.toLowerCase(Locale.US).toCharArray();
        boolean hasDigit = false;
        boolean hasChar = false;
        boolean hasOther = false;
        for (int i = 0; i < s.length; i++) {
            if ('0' <= s[i] && '9' >= s[i]) {
                hasDigit = true;
                continue;
            }
            if ('a' <= s[i] && 'z' >= s[i]) {
                hasChar = true;
                continue;
            }
            hasOther = true;
            break;
        }
        return hasDigit && hasChar && !hasOther;
    }

}
