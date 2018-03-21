package com.handpay.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private String userName;
    private String password;
    private String money;

    public Data() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMoney() {
        return money;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"money\":\"")
                .append(money).append('\"');
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
        dest.writeString(this.userName);
        dest.writeString(this.password);
        dest.writeString(this.money);
    }

    protected Data(Parcel in) {
        this.userName = in.readString();
        this.password = in.readString();
        this.money = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
