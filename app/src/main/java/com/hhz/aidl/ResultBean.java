package com.hhz.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haohz on 2018/1/2.
 */

public class ResultBean implements Parcelable{

    /**
     * usedLimit : 1
     * usedCount : 5
     * serialNo : 123456789
     * recordType : 1
     * recordDate : 20171218103311
     * recordCount : 0
     * orderAmount : 53.23
     * discount : 0.0
     * describeContents : 0
     * couponType : 1
     * couponNo : 12345678922
     * couponAmount : 10
     * consumeLite : 100
     */

    private int usedLimit;
    private int usedCount;
    private String serialNo;
    private int recordType;
    private String recordDate;
    private int recordCount;
    private double orderAmount;
    private String discount;
    private int describeContents;
    private int couponType;
    private String couponNo;
    private int couponAmount;
    private int consumeLite;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"usedLimit\":")
                .append(usedLimit);
        sb.append(",\"usedCount\":")
                .append(usedCount);
        sb.append(",\"serialNo\":\"")
                .append(serialNo).append('\"');
        sb.append(",\"recordType\":")
                .append(recordType);
        sb.append(",\"recordDate\":\"")
                .append(recordDate).append('\"');
        sb.append(",\"recordCount\":")
                .append(recordCount);
        sb.append(",\"orderAmount\":")
                .append(orderAmount);
        sb.append(",\"discount\":\"")
                .append(discount).append('\"');
        sb.append(",\"describeContents\":")
                .append(describeContents);
        sb.append(",\"couponType\":")
                .append(couponType);
        sb.append(",\"couponNo\":\"")
                .append(couponNo).append('\"');
        sb.append(",\"couponAmount\":")
                .append(couponAmount);
        sb.append(",\"consumeLite\":")
                .append(consumeLite);
        sb.append('}');
        return sb.toString();
    }

    protected ResultBean(Parcel in) {
        usedLimit = in.readInt();
        usedCount = in.readInt();
        serialNo = in.readString();
        recordType = in.readInt();
        recordDate = in.readString();
        recordCount = in.readInt();
        orderAmount = in.readDouble();
        discount = in.readString();
        describeContents = in.readInt();
        couponType = in.readInt();
        couponNo = in.readString();
        couponAmount = in.readInt();
        consumeLite = in.readInt();
    }

    public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
        @Override
        public ResultBean createFromParcel(Parcel in) {
            return new ResultBean(in);
        }

        @Override
        public ResultBean[] newArray(int size) {
            return new ResultBean[size];
        }
    };

    public int getUsedLimit() {
        return usedLimit;
    }

    public void setUsedLimit(int usedLimit) {
        this.usedLimit = usedLimit;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getRecordType() {
        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getDescribeContents() {
        return describeContents;
    }

    public void setDescribeContents(int describeContents) {
        this.describeContents = describeContents;
    }

    public int getCouponType() {
        return couponType;
    }

    public void setCouponType(int couponType) {
        this.couponType = couponType;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public int getConsumeLite() {
        return consumeLite;
    }

    public void setConsumeLite(int consumeLite) {
        this.consumeLite = consumeLite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(usedLimit);
        dest.writeInt(usedCount);
        dest.writeString(serialNo);
        dest.writeInt(recordType);
        dest.writeString(recordDate);
        dest.writeInt(recordCount);
        dest.writeDouble(orderAmount);
        dest.writeString(discount);
        dest.writeInt(describeContents);
        dest.writeInt(couponType);
        dest.writeString(couponNo);
        dest.writeInt(couponAmount);
        dest.writeInt(consumeLite);
    }
}
