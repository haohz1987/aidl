package com.handpay.sdk.encry;

import com.handpay.sdk.utils.LogT;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 加解密数据辅助
 */
public class EncryptionManager {
    private final static char[] mChars = "0123456789ABCDEF".toCharArray();
    private final static String mHexStr = "0123456789ABCDEF";
    // 向量
    public final static String iv = "12345678";
    // 加解密统一使用的编码方式
    public final static String encoding = "utf-8";
    // 3des加密
    public static final String algorithm = "desede";

    private SecretManager secretManager = null;
    private static EncryptionManager encryManager = null;

    private EncryptionManager() {
        secretManager = SecretManager.builder();
    }

    public static EncryptionManager getInstance() {
        if (encryManager == null) {
            synchronized (EncryptionManager.class) {
                if (encryManager == null) {
                    encryManager = new EncryptionManager();
                }
            }
        }
        return encryManager;
    }

    /**
     * 获取密钥种子
     *
     * @return
     */
    public String getPublicPseudoKey() {
        return secretManager.createSeed();
    }

    /**
     * @param str 需要加密的文字
     * @return 加密后的文字
     * @throws Exception 加密失败
     */
    public String encryptMode(byte[] keyByte, final String str) throws Exception {
        byte[] temp_key = secretManager.createSeed().getBytes(encoding);
        LogT.w("加密密钥：" + new String(temp_key));
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(temp_key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(algorithm);
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(str.getBytes(encoding));
        return Base64.encode(encryptData);
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public String decode3DES(byte[] keyByte, String encryptText) throws Exception {
        if (keyByte == null) {
            return null;
        }
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(keyByte);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(algorithm);
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

        return new String(decryptData, encoding);
    }

    public static class Base64 {
        private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                .toCharArray();

        public static String encode(byte[] data) {
            int start = 0;
            int len = data.length;
            StringBuffer buf = new StringBuffer(data.length * 3 / 2);

            int end = len - 3;
            int i = start;
            int n = 0;

            while (i <= end) {
                int d = ((((int) data[i]) & 0x0ff) << 16)
                        | ((((int) data[i + 1]) & 0x0ff) << 8)
                        | (((int) data[i + 2]) & 0x0ff);

                buf.append(legalChars[(d >> 18) & 63]);
                buf.append(legalChars[(d >> 12) & 63]);
                buf.append(legalChars[(d >> 6) & 63]);
                buf.append(legalChars[d & 63]);

                i += 3;

                if (n++ >= 14) {
                    n = 0;
                    buf.append(" ");
                }
            }

            if (i == start + len - 2) {
                int d = ((((int) data[i]) & 0x0ff) << 16)
                        | ((((int) data[i + 1]) & 255) << 8);

                buf.append(legalChars[(d >> 18) & 63]);
                buf.append(legalChars[(d >> 12) & 63]);
                buf.append(legalChars[(d >> 6) & 63]);
                buf.append("=");
            } else if (i == start + len - 1) {
                int d = (((int) data[i]) & 0x0ff) << 16;

                buf.append(legalChars[(d >> 18) & 63]);
                buf.append(legalChars[(d >> 12) & 63]);
                buf.append("==");
            }

            return buf.toString();
        }

        private static int decode(char c) {
            if (c >= 'A' && c <= 'Z')
                return ((int) c) - 65;
            else if (c >= 'a' && c <= 'z')
                return ((int) c) - 97 + 26;
            else if (c >= '0' && c <= '9')
                return ((int) c) - 48 + 26 + 26;
            else
                switch (c) {
                    case '+':
                        return 62;
                    case '/':
                        return 63;
                    case '=':
                        return 0;
                    default:
                        throw new RuntimeException("unexpected code: " + c);
                }
        }

        /**
         * Decodes the given Base64 encoded String to a new byte array. The byte
         * array holding the decoded data is returned.
         */

        public static byte[] decode(String s) {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                decode(s, bos);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            byte[] decodedBytes = bos.toByteArray();
            try {
                bos.close();
                bos = null;
            } catch (IOException ex) {
                System.err.println("Error while decoding BASE64: " + ex.toString());
            }
            return decodedBytes;
        }

        private static void decode(String s, OutputStream os) throws IOException {
            int i = 0;

            int len = s.length();

            while (true) {
                while (i < len && s.charAt(i) <= ' ')
                    i++;

                if (i == len)
                    break;

                int tri = (decode(s.charAt(i)) << 18)
                        + (decode(s.charAt(i + 1)) << 12)
                        + (decode(s.charAt(i + 2)) << 6)
                        + (decode(s.charAt(i + 3)));

                os.write((tri >> 16) & 255);
                if (s.charAt(i + 2) == '=')
                    break;
                os.write((tri >> 8) & 255);
                if (s.charAt(i + 3) == '=')
                    break;
                os.write(tri & 255);

                i += 4;
            }
        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 字符串转换成十六进制字符串
     *
     * @param str String 待转换的ASCII字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {
        StringBuilder sb = new StringBuilder();
        byte[] bs = str.getBytes();

        for (int i = 0; i < bs.length; i++) {
            sb.append(mChars[(bs[i] & 0xFF) >> 4]);
            sb.append(mChars[bs[i] & 0x0F]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 十六进制字符串转换成 ASCII字符串
     *
     * @param hexStr String Byte字符串
     * @return String 对应的字符串
     */
    public static String hexStr2Str(String hexStr) {
        hexStr = hexStr.toString().trim().replace(" ", "").toUpperCase(Locale.US);
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int iTmp = 0x00;
        ;

        for (int i = 0; i < bytes.length; i++) {
            iTmp = mHexStr.indexOf(hexs[2 * i]) << 4;
            iTmp |= mHexStr.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (iTmp & 0xFF);
        }
        return new String(bytes);
    }


    //if exit app
    public void destoryResource() {
        if (secretManager != null) {
            secretManager.releaseSource();
        }
        encryManager = null;
    }
}
