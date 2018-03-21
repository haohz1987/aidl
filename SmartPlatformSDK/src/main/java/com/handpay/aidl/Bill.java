package com.handpay.aidl;

import android.os.Parcel;
import android.os.Parcelable;


public class Bill implements Parcelable {
    private String merchantName;//商户名称
    private String merchantCode;//商户编号
    private String tradingAccount;//交易账号
    private String transactionType;//交易类别
    private String serialNumber;//流水号
    private String tradingHour;//交易时间
    private String transactionAmount;//交易金额
    private int tranState;//交易状态  >=0 交易成功；<0交易失败
    private String failDes;
    public Bill(String merchantName, String merchantCode, String tradingAccount, String transactionType,
                String serialNumber, String tradingHour, String transactionAmount, int mTranState, String mFailDes) {
        this.merchantName = merchantName;
        this.merchantCode = merchantCode;
        this.tradingAccount = tradingAccount;
        this.transactionType = transactionType;
        this.serialNumber = serialNumber;
        this.tradingHour = tradingHour;
        this.transactionAmount = transactionAmount;
        this.tranState=mTranState;
        this.failDes=mFailDes;
    }

    public Bill() {
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getTradingAccount() {
        return tradingAccount;
    }

    public void setTradingAccount(String tradingAccount) {
        this.tradingAccount = tradingAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTradingHour() {
        return tradingHour;
    }

    public void setTradingHour(String tradingHour) {
        this.tradingHour = tradingHour;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTranState(int tranState) {
        this.tranState = tranState;
    }

    public int getTranState() {
        return tranState;
    }

    public String getFailDes() {
        return failDes;
    }

    public void setFailDes(String failDes) {
        this.failDes = failDes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"tranState\":")
                .append(tranState);
        sb.append(",\"transactionType\":\"")
                .append(transactionType).append('\"');
        sb.append(",\"transactionAmount\":\"")
                .append(transactionAmount).append('\"');
        sb.append(",\"tradingHour\":\"")
                .append(tradingHour).append('\"');
        sb.append(",\"tradingAccount\":\"")
                .append(tradingAccount).append('\"');
        sb.append(",\"serialNumber\":\"")
                .append(serialNumber).append('\"');
        sb.append(",\"merchantName\":\"")
                .append(merchantName).append('\"');
        sb.append(",\"merchantCode\":\"")
                .append(merchantCode).append('\"');
        sb.append(",\"failDes\":\"")
                .append(failDes).append('\"');
        sb.append(",\"describeContents\":")
                .append(describeContents());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.merchantName);
        dest.writeString(this.merchantCode);
        dest.writeString(this.tradingAccount);
        dest.writeString(this.transactionType);
        dest.writeString(this.serialNumber);
        dest.writeString(this.tradingHour);
        dest.writeString(this.transactionAmount);
        dest.writeInt(this.tranState);
        dest.writeString(this.failDes);
    }

    protected Bill(Parcel in) {
        this.merchantName = in.readString();
        this.merchantCode = in.readString();
        this.tradingAccount = in.readString();
        this.transactionType = in.readString();
        this.serialNumber = in.readString();
        this.tradingHour = in.readString();
        this.transactionAmount = in.readString();
        this.tranState = in.readInt();
        this.failDes = in.readString();
    }

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel source) {
            return new Bill(source);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };
}
