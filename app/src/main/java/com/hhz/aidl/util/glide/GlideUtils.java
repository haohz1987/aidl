package com.hhz.aidl.util.glide;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 缓存、文件判断、md5时间戳加密
 */
public class GlideUtils {
    /**
     * 获取缓存的路径
     *
     * @param context
     * @param fileUrl
     * @return 有:路径    无:null
     */
    public static String getCache(Context context, String fileUrl) {
//        LogT.d("缓存="+fileUrl);
        String path = context.getExternalCacheDir() + getFileName(fileUrl);
        return haveCache(context, fileUrl) ? path : null;
    }

    /**
     * 判断是否有缓存
     *
     * @param context
     * @param fileUrl
     * @return
     */
    public static boolean haveCache(Context context, String fileUrl) {
        return GlideUtils.fileIsExists(context.getExternalCacheDir() + getFileName(fileUrl));
    }

    /**
     * 缓存图片
     * @param fileUrl
     * @param context
     */
    public static void cacheImage(String fileUrl, Context context) {
        cacheImage(fileUrl, context, null, null);
    }

    /**
     * 缓存图片
     * @param fileUrl
     * @param context
     * @param cacheFile
     */
    public static void cacheImage(String fileUrl, Context context, File cacheFile) {
        cacheImage(fileUrl, context, cacheFile, null);
    }

    /**
     * 缓存图片
     *
     * @param fileUrl
     * @param context
     * @param listener
     */
    public static void cacheImage(String fileUrl, Context context, GlideCacheListener listener) {
//        LogT.d("写入缓存:"+fileUrl);
        cacheImage(fileUrl, context, null, listener);
    }

    /**
     * 缓存图片
     *
     * @param fileUrl
     * @param context
     * @param cacheFile
     * @param listener
     */
    public static void cacheImage(String fileUrl, Context context, File cacheFile, GlideCacheListener listener) {
        new GlideCacheTask(context, cacheFile, listener).execute(fileUrl);
    }

    /**
     * 缓存多张图片
     * @param fileUrls
     * @param context
     */
    public static void cacheImage(List<String> fileUrls, Context context ) {
        for (String fileUrl : fileUrls) {
            cacheImage(fileUrl, context, null, null);
        }
    }

    /**
     * 缓存多张图片
     * @param fileUrls
     * @param context
     * @param cacheFile
     */
    public static void cacheImage(List<String> fileUrls, Context context, File cacheFile) {
        for (String fileUrl : fileUrls) {
            cacheImage(fileUrl, context, cacheFile, null);
        }
    }
    /**
     * 判断文件是否存在
     */
    public static boolean fileIsExists(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
    //判断文件是否存在
    public static boolean fileIsExists(File f) {
        try {
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 附加加密时间戳
     */
    private static String defaultDateFormat = "yyyyMMddHHmmss";

    public static String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        return String.valueOf(time);
    }

    public static String getTimestamp(String dateFormat) {
        if (!TextUtils.isEmpty(dateFormat)) {
            defaultDateFormat = dateFormat;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        SimpleDateFormat format = new SimpleDateFormat(defaultDateFormat);
        return format.format(time);
    }
    public static long getTimestampF() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        return time;
    }

    /**
     * MD5加密时间戳
     */
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String hexdigest(String string) {
        String s = null;

        try {
            s = hexdigest(string.getBytes());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return s;
    }

    public static String hexdigest(byte[] bytes) {
        String s = null;

        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(bytes);
            byte[] tmp = e.digest();
            char[] str = new char[32];
            int k = 0;

            for (int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            s = new String(str);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return s;
    }

    public static String getFileName(String url) {
        return hexdigest(url) == null ? GlideUtils.getTimestamp() : hexdigest(url);
    }
}
