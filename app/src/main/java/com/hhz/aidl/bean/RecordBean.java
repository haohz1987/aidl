package com.hhz.aidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class RecordBean implements Parcelable{

    /**
     * responseCode : 0000
     * errorMessage : 请求成功
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * totalPage : 2
     * result : [{"recordDate":"201712181033","couponType":1,"recordType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"recordType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"recordCount":2,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"recordCount":2,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]
     */

    private String responseCode;
    private String errorMessage;
    private String logo;
    private String mechantName;
    private String mechantId;
    private int totalPage;
    private List<ResultBean> result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"totalPage\":")
                .append(totalPage);
        sb.append(",\"result\":")
                .append(result);
        sb.append(",\"responseCode\":\"")
                .append(responseCode).append('\"');
        sb.append(",\"mechantName\":\"")
                .append(mechantName).append('\"');
        sb.append(",\"mechantId\":\"")
                .append(mechantId).append('\"');
        sb.append(",\"logo\":\"")
                .append(logo).append('\"');
        sb.append(",\"errorMessage\":\"")
                .append(errorMessage).append('\"');
        sb.append(",\"describeContents\":")
                .append(describeContents());
        sb.append('}');
        return sb.toString();
    }

    protected RecordBean(Parcel in) {
        responseCode = in.readString();
        errorMessage = in.readString();
        logo = in.readString();
        mechantName = in.readString();
        mechantId = in.readString();
        totalPage = in.readInt();
        result = in.createTypedArrayList(ResultBean.CREATOR);
    }

    public static final Creator<RecordBean> CREATOR = new Creator<RecordBean>() {
        @Override
        public RecordBean createFromParcel(Parcel in) {
            return new RecordBean(in);
        }

        @Override
        public RecordBean[] newArray(int size) {
            return new RecordBean[size];
        }
    };

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMechantName() {
        return mechantName;
    }

    public void setMechantName(String mechantName) {
        this.mechantName = mechantName;
    }

    public String getMechantId() {
        return mechantId;
    }

    public void setMechantId(String mechantId) {
        this.mechantId = mechantId;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(responseCode);
        dest.writeString(errorMessage);
        dest.writeString(logo);
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(totalPage);
        dest.writeTypedList(result);
    }
//    //dest用来存储与传输数据，且顺序要与writeToParcel()方法中一致
//    public void readFromParcel(Parcel dest){
//        responseCode = dest.readString();
//        errorMessage=dest.readString();
//        logo=dest.readString();
//        mechantName=dest.readString();
//        mechantId = dest.readString();
//        totalPage=dest.readInt();
//        dest.readTypedList(result,Results.CREATOR);
//    }


    public static class ResultBean implements Parcelable{
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
        private double couponAmount;
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

        protected ResultBean(Parcel in) {
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

        public double getCouponAmount() {
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
            dest.writeDouble(couponAmount);
            dest.writeDouble(discount);
            dest.writeInt(consumeLite);
            dest.writeInt(usedCount);
            dest.writeInt(usedLimit);
            dest.writeInt(recordCount);
        }
//        //dest用来存储与传输数据，且顺序要与writeToParcel()方法中一致
        public void readFromParcel(Parcel dest){
            recordDate = dest.readString();
            couponType=dest.readInt();
            recordType=dest.readInt();
            serialNo=dest.readString();
            couponNo=dest.readString();
            orderAmount=dest.readDouble();
            couponAmount=dest.readInt();
            discount=dest.readDouble();
            consumeLite=dest.readInt();
            usedCount=dest.readInt();
            usedLimit=dest.readInt();
            recordCount=dest.readInt();
        }
    }
}
