package com.hhz.aidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class CouponBean implements Parcelable{

    /**
     * responseCode : 0000
     * errorMessage : 请求成功
     * mechantName : 商户01
     * mechantId : 0123456789
     * couponTotal : 8
     * validRepertoryTerm : 30
     * result : [{"couponNo":"201712181033","couponType":1,"couponColor":8,"couponTitle":"小店1","mechantLogo":"http://1.smartpos.applinzi.com/image/cart.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":1,"couponColor":1,"couponTitle":"小店2","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping_cart_remove.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":1,"couponColor":2,"couponTitle":"小店3","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":2,"couponColor":3,"couponTitle":"小店4","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping_cart_remove.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":2,"couponColor":4,"couponTitle":"小店5","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping_cart_remove.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":2,"couponColor":5,"couponTitle":"小店6","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping_cart_info.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":3,"couponColor":6,"couponTitle":"小店7","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponType":3,"couponColor":7,"couponTitle":"小店8","mechantLogo":"http://1.smartpos.applinzi.com/image/shopping_cart_info.png","couponAmount":2.03,"discountAmount":0,"consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
     */

    private String responseCode;
    private String errorMessage;
    private String mechantName;
    private String mechantId;
    private int couponTotal;
    private int validRepertoryTerm;
    private List<ResultBean> result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"validRepertoryTerm\":")
                .append(validRepertoryTerm);
        sb.append(",\"result\":")
                .append(result);
        sb.append(",\"responseCode\":\"")
                .append(responseCode).append('\"');
        sb.append(",\"mechantName\":\"")
                .append(mechantName).append('\"');
        sb.append(",\"mechantId\":\"")
                .append(mechantId).append('\"');
        sb.append(",\"errorMessage\":\"")
                .append(errorMessage).append('\"');
        sb.append(",\"describeContents\":")
                .append(describeContents());
        sb.append(",\"couponTotal\":")
                .append(couponTotal);
        sb.append('}');
        return sb.toString();
    }

    protected CouponBean(Parcel in) {
        responseCode = in.readString();
        errorMessage = in.readString();
        mechantName = in.readString();
        mechantId = in.readString();
        couponTotal = in.readInt();
        validRepertoryTerm = in.readInt();
        result = in.createTypedArrayList(ResultBean.CREATOR);
    }

    public static final Creator<CouponBean> CREATOR = new Creator<CouponBean>() {
        @Override
        public CouponBean createFromParcel(Parcel in) {
            return new CouponBean(in);
        }

        @Override
        public CouponBean[] newArray(int size) {
            return new CouponBean[size];
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

    public int getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(int couponTotal) {
        this.couponTotal = couponTotal;
    }

    public int getValidRepertoryTerm() {
        return validRepertoryTerm;
    }

    public void setValidRepertoryTerm(int validRepertoryTerm) {
        this.validRepertoryTerm = validRepertoryTerm;
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
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(couponTotal);
        dest.writeInt(validRepertoryTerm);
        dest.writeTypedList(result);
    }


    public static class ResultBean implements Parcelable{
        /**
         * couponNo : 201712181033
         * couponType : 1
         * couponColor : 8
         * couponTitle : 小店1
         * mechantLogo : http://1.smartpos.applinzi.com/image/cart.png
         * couponAmount : 2.03
         * discountAmount : 0
         * consumeLite : 10000.63
         * validPeriod : 30
         * receiveTime : 201712181033
         * startDay :
         * endDay :
         * repertoryAmount : 100
         * usedLimit : 1
         * explain : 到店请出示优惠券
         * usedQty : 2
         * usedCount : 2
         * cancelCount : 1
         * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
         */

        private String couponNo;
        private int couponType;
        private int couponColor;
        private String couponTitle;
        private String mechantLogo;
        private double couponAmount;
        private int discountAmount;
        private double consumeLite;
        private int validPeriod;
        private String receiveTime;
        private String startDay;
        private String endDay;
        private int repertoryAmount;
        private int usedLimit;
        private String explain;
        private int usedQty;
        private int usedCount;
        private int cancelCount;
        private String qrCode;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"validPeriod\":\"")
                    .append(validPeriod).append('\"');
            sb.append(",\"usedQty\":")
                    .append(usedQty);
            sb.append(",\"usedLimit\":")
                    .append(usedLimit);
            sb.append(",\"usedCount\":")
                    .append(usedCount);
            sb.append(",\"startDay\":\"")
                    .append(startDay).append('\"');
            sb.append(",\"repertoryAmount\":")
                    .append(repertoryAmount);
            sb.append(",\"receiveTime\":\"")
                    .append(receiveTime).append('\"');
            sb.append(",\"qrCode\":\"")
                    .append(qrCode).append('\"');
            sb.append(",\"mechantLogo\":\"")
                    .append(mechantLogo).append('\"');
            sb.append(",\"explain\":\"")
                    .append(explain).append('\"');
            sb.append(",\"endDay\":\"")
                    .append(endDay).append('\"');
            sb.append(",\"discountAmount\":")
                    .append(discountAmount);
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"couponType\":")
                    .append(couponType);
            sb.append(",\"couponTitle\":\"")
                    .append(couponTitle).append('\"');
            sb.append(",\"couponNo\":\"")
                    .append(couponNo).append('\"');
            sb.append(",\"couponColor\":")
                    .append(couponColor);
            sb.append(",\"couponAmount\":")
                    .append(couponAmount);
            sb.append(",\"consumeLite\":")
                    .append(consumeLite);
            sb.append(",\"cancelCount\":")
                    .append(cancelCount);
            sb.append('}');
            return sb.toString();
        }

        protected ResultBean(Parcel in) {
            couponNo = in.readString();
            couponType = in.readInt();
            couponColor = in.readInt();
            couponTitle = in.readString();
            mechantLogo = in.readString();
            couponAmount = in.readDouble();
            discountAmount = in.readInt();
            consumeLite = in.readDouble();
            validPeriod = in.readInt();
            receiveTime = in.readString();
            startDay = in.readString();
            endDay = in.readString();
            repertoryAmount = in.readInt();
            usedLimit = in.readInt();
            explain = in.readString();
            usedQty = in.readInt();
            usedCount = in.readInt();
            cancelCount = in.readInt();
            qrCode = in.readString();
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

        public String getCouponNo() {
            return couponNo;
        }

        public void setCouponNo(String couponNo) {
            this.couponNo = couponNo;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public int getCouponColor() {
            return couponColor;
        }

        public void setCouponColor(int couponColor) {
            this.couponColor = couponColor;
        }

        public String getCouponTitle() {
            return couponTitle;
        }

        public void setCouponTitle(String couponTitle) {
            this.couponTitle = couponTitle;
        }

        public String getMechantLogo() {
            return mechantLogo;
        }

        public void setMechantLogo(String mechantLogo) {
            this.mechantLogo = mechantLogo;
        }

        public double getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(double couponAmount) {
            this.couponAmount = couponAmount;
        }

        public int getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(int discountAmount) {
            this.discountAmount = discountAmount;
        }

        public double getConsumeLite() {
            return consumeLite;
        }

        public void setConsumeLite(double consumeLite) {
            this.consumeLite = consumeLite;
        }

        public int getValidPeriod() {
            return validPeriod;
        }

        public void setValidPeriod(int validPeriod) {
            this.validPeriod = validPeriod;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getStartDay() {
            return startDay;
        }

        public void setStartDay(String startDay) {
            this.startDay = startDay;
        }

        public String getEndDay() {
            return endDay;
        }

        public void setEndDay(String endDay) {
            this.endDay = endDay;
        }

        public int getRepertoryAmount() {
            return repertoryAmount;
        }

        public void setRepertoryAmount(int repertoryAmount) {
            this.repertoryAmount = repertoryAmount;
        }

        public int getUsedLimit() {
            return usedLimit;
        }

        public void setUsedLimit(int usedLimit) {
            this.usedLimit = usedLimit;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public int getUsedQty() {
            return usedQty;
        }

        public void setUsedQty(int usedQty) {
            this.usedQty = usedQty;
        }

        public int getUsedCount() {
            return usedCount;
        }

        public void setUsedCount(int usedCount) {
            this.usedCount = usedCount;
        }

        public int getCancelCount() {
            return cancelCount;
        }

        public void setCancelCount(int cancelCount) {
            this.cancelCount = cancelCount;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(couponNo);
            dest.writeInt(couponType);
            dest.writeInt(couponColor);
            dest.writeString(couponTitle);
            dest.writeString(mechantLogo);
            dest.writeDouble(couponAmount);
            dest.writeInt(discountAmount);
            dest.writeDouble(consumeLite);
            dest.writeInt(validPeriod);
            dest.writeString(receiveTime);
            dest.writeString(startDay);
            dest.writeString(endDay);
            dest.writeInt(repertoryAmount);
            dest.writeInt(usedLimit);
            dest.writeString(explain);
            dest.writeInt(usedQty);
            dest.writeInt(usedCount);
            dest.writeInt(cancelCount);
            dest.writeString(qrCode);
        }
    }
}
