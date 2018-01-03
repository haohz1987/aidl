package com.hhz.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haohz on 2018/1/2.
 */

public class Results implements Parcelable {
    /**
     * recordDate : 201712181033
     * couponType : 1
     * recordType : 1
     * serialNo : 123456789
     * couponNo : 12345678922
     * orderAmount : 53.23
     * couponAmount : 10
     * discount :
     * consumeLite : 100
     * usedCount : 5
     * usedLimit : 1
     * recordCount : 2
     */

    private String recordDate;
    private int couponType;
    private int recordType;
    private String serialNo;
    private String couponNo;
    private double orderAmount;
    private int couponAmount;
    private double discount;
    private int consumeLite;
    private int usedCount;
    private int usedLimit;
    private int recordCount;

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
                .append(describeContents());
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

    public Results(Parcel in) {
        recordDate = in.readString();
        couponType = in.readInt();
        recordType = in.readInt();
        serialNo = in.readString();
        couponNo = in.readString();
        orderAmount = in.readDouble();
        couponAmount = in.readInt();
        discount = in.readDouble();
        consumeLite = in.readInt();
        usedCount = in.readInt();
        usedLimit = in.readInt();
        recordCount = in.readInt();
    }
    public Results(){}

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getCouponType() {
        return couponType;
    }

    public void setCouponType(int couponType) {
        this.couponType = couponType;
    }

    public int getRecordType() {
        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getConsumeLite() {
        return consumeLite;
    }

    public void setConsumeLite(int consumeLite) {
        this.consumeLite = consumeLite;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public int getUsedLimit() {
        return usedLimit;
    }

    public void setUsedLimit(int usedLimit) {
        this.usedLimit = usedLimit;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(recordDate);
        dest.writeInt(couponType);
        dest.writeInt(recordType);
        dest.writeString(serialNo);
        dest.writeString(couponNo);
        dest.writeDouble(orderAmount);
        dest.writeInt(couponAmount);
        dest.writeDouble(discount);
        dest.writeInt(consumeLite);
        dest.writeInt(usedCount);
        dest.writeInt(usedLimit);
        dest.writeInt(recordCount);
    }

    //        //dest用来存储与传输数据，且顺序要与writeToParcel()方法中一致
    public void readFromParcel(Parcel dest) {
        recordDate = dest.readString();
        couponType = dest.readInt();
        recordType = dest.readInt();
        serialNo = dest.readString();
        couponNo = dest.readString();
        orderAmount = dest.readDouble();
        couponAmount = dest.readInt();
        discount = dest.readDouble();
        consumeLite = dest.readInt();
        usedCount = dest.readInt();
        usedLimit = dest.readInt();
        recordCount = dest.readInt();
    }
}
