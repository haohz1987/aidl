package com.handpay.sdk.utils;

import android.text.TextUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * one-hot类型数据解析，
 */
public class OneHotUtils {
    private static final String division = "3";
    /*向量长度*/
    private static int vectorLength = 10;

    /***
     * 构建one-hot类型数据
     */
    public static byte[] generateOneHot(String orig) {
        char[] keys = orig.toCharArray();
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            //生成长度为vectorLength的向量数据
            String zs = zeorsOnes(keys[i]);
            sbu.append(zs);
            sbu.append(division);
        }
        String result = sbu.substring(0, sbu.length() - 1);
        return getBytes(result);
    }

    /**
     * 解析one-hot类型数据，byte[]转one_hot String
     */
    public static String parserByte2OntHot(byte[] bs) {
        if (bs != null) {
            String ontHotString = getChars(bs);
            if (!TextUtils.isEmpty(ontHotString)) {
                String[] ones = ontHotString.split(division);
                StringBuffer sbu = new StringBuffer();
                for (String onehot : ones) {
                    sbu.append(calculationOneHot(onehot));
                }
                return sbu.toString();
            }
        }
        return null;
    }

    /**
     * 计算单个数据
     */
    private static int calculationOneHot(String str) {
        char[] chs = str.toCharArray();
        int num = -1;
        for (int i = 0; i < chs.length; i++) {
            //返回指定的Unicode字符表示的int值。例如，字符' u216C'(罗马数字50)将返回一个int 值50
            int ic = Character.getNumericValue(chs[i]);
            //仅有一个有效位，找到即可赋值
            if (ic == 1) {
                num = i;
                break;
            }
        }
        return num;
    }

    /**
     * 生成长度为vectorLength的向量数据
     */
    private static String zeorsOnes(char c) {
        StringBuffer sbf = new StringBuffer();
        //返回指定的Unicode字符表示的int值。例如，字符' u216C'(罗马数字50)将返回一个int 值50
        int ic = Character.getNumericValue(c);
        for (int i = 0; i < vectorLength; i++) {
            if (i == ic) {
                sbf.append(1);
            } else {
                sbf.append(0);
            }
        }
        return sbf.toString();
    }
    /**
     * String转byte[]
     */
    private static byte[] getBytes(String oneHot) {
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);
        try {
            bw.write(oneHot);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer sb = sw.getBuffer();
        return sb.toString().getBytes(Charset.forName("UTF-8"));
    }
    /**
     * byte[]转String
     */
    public static String getChars(byte[] bytes) {
        return new String(bytes);
    }

}

    /*
       One-Hot编码，又称为一位有效编码，主要是采用位状态寄存器来对个状态进行编码。
    在数据处理和特征工程中，经常会遇到类型数据，如性别分为[男，女]，手机运营商分为[移动，联通，电信]等，
    我们通常将其转为数值带入模型，如[0,1],[-1,0,1]等，但模型往往默认为连续型数值进行处理，这样其实是违背我们最初设计的，也会影响模型效果。

    独热编码便是解决这个问题，其方法是使用N位状态寄存器来对N个状态进行编码，每个状态都由他独立的寄存器位，并且在任意时候，其中只有一位有效。

    如自然编码为：0，1，独热编码为：10，01
    可以理解为对有m个取值的特征，经过独热编码处理后，转为m个二元特征，每次只有一个激活。如数字字体识别0~9中，6的独热编码为：0000001000


    优点：独热编码的优点为：
    1.能够处理非连续型数值特征。
    2.在一定程度上也扩充了特征。比如性别本身是一个特征，经过one hot编码以后，就变成了男或女两个特征。
    缺点：当特征类别较多时，数据经过独热编码可能会变得过于稀疏。

    在实际的机器学习的应用任务中，特征有时候并不总是连续值，有可能是一些分类值，如性别可分为“male”和“female”。在机器学习任务中，
    对于这样的特征，通常我们需要对其进行特征数字化，如下面的例子：
    有如下三个特征属性：
    性别：["male"，"female"]
    地区：["Europe"，"US"，"Asia"]
    浏览器：["Firefox"，"Chrome"，"Safari"，"Internet Explorer"]
    对于某一个样本，如["male"，"US"，"Internet Explorer"]，我们需要将这个分类值的特征数字化，最直接的方法，
    我们可以采用序列化的方式：[0,1,3]。但是这样的特征处理并不能直接放入机器学习算法中。
    One-Hot Encoding的处理方法

    对于上述的问题，性别的属性是二维的，同理，地区是三维的，浏览器则是思维的，这样，我们可以采用One-Hot编码的方式对上述的样本
    “["male"，"US"，"Internet Explorer"]”编码，“male”则对应着[1，0]，同理“US”对应着[0，1，0]，“Internet Explorer”
    对应着[0,0,0,1]。则完整的特征数字化的结果为：[1,0,0,1,0,0,0,0,1]。这样导致的一个结果就是数据会变得非常的稀疏。

    */