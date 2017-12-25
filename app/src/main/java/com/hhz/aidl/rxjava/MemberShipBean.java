package com.hhz.aidl.rxjava;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class MemberShipBean implements Parcelable{

    /**
     * responseCode : 0000
     * errorMessage : 请求成功
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * couponType : 2
     * membershipCardCount : 2
     * membershipCardTotal : 5
     * validRepertoryTerm : 30
     * result : [{"membershipCardId":"123456789","membershipCardType":1,"cardColor":1,"title":"梨花小店会员卡1","discountAmount":"9折","explain":"到店请出示优惠券","usedQty":10,"usedCount":2,"validPeriod":"30","receiveTime":"20171220112233","startDay":"","endDay":"","qrCode":"http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"membershipCardId":"123456789","membershipCardType":1,"cardColor":1,"title":"梨花小店会员卡1","discountAmount":"9折","explain":"到店请出示优惠券","usedQty":10,"usedCount":2,"validPeriod":"","receiveTime":"","startDay":"20171220112233","endDay":"20180120112233","qrCode":"http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
     */

    private String responseCode;
    private String errorMessage;
    private String logo;
    private String mechantName;
    private String mechantId;
    private int couponType;
    private int membershipCardCount;
    private int membershipCardTotal;
    private int validRepertoryTerm;
    private List<ResultBean> result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"validRepertoryTerm\":\"")
                .append(validRepertoryTerm).append('\"');
        sb.append(",\"result\":")
                .append(result);
        sb.append(",\"responseCode\":\"")
                .append(responseCode).append('\"');
        sb.append(",\"membershipCardTotal\":")
                .append(membershipCardTotal);
        sb.append(",\"membershipCardCount\":")
                .append(membershipCardCount);
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
        sb.append(",\"couponType\":")
                .append(couponType);
        sb.append('}');
        return sb.toString();
    }

    protected MemberShipBean(Parcel in) {
        responseCode = in.readString();
        errorMessage = in.readString();
        logo = in.readString();
        mechantName = in.readString();
        mechantId = in.readString();
        couponType = in.readInt();
        membershipCardCount = in.readInt();
        membershipCardTotal = in.readInt();
        validRepertoryTerm = in.readInt();
    }

    public static final Creator<MemberShipBean> CREATOR = new Creator<MemberShipBean>() {
        @Override
        public MemberShipBean createFromParcel(Parcel in) {
            return new MemberShipBean(in);
        }

        @Override
        public MemberShipBean[] newArray(int size) {
            return new MemberShipBean[size];
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

    public int getCouponType() {
        return couponType;
    }

    public void setCouponType(int couponType) {
        this.couponType = couponType;
    }

    public int getMembershipCardCount() {
        return membershipCardCount;
    }

    public void setMembershipCardCount(int membershipCardCount) {
        this.membershipCardCount = membershipCardCount;
    }

    public int getMembershipCardTotal() {
        return membershipCardTotal;
    }

    public void setMembershipCardTotal(int membershipCardTotal) {
        this.membershipCardTotal = membershipCardTotal;
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
        dest.writeString(logo);
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(couponType);
        dest.writeInt(membershipCardCount);
        dest.writeInt(membershipCardTotal);
        dest.writeInt(validRepertoryTerm);
    }

    public static class ResultBean implements Parcelable{
        /**
         * membershipCardId : 123456789
         * membershipCardType : 1
         * cardColor : 1
         * title : 梨花小店会员卡1
         * discountAmount : 9折
         * explain : 到店请出示优惠券
         * usedQty : 10
         * usedCount : 2
         * validPeriod : 30
         * receiveTime : 20171220112233
         * startDay :
         * endDay :
         * qrCode : http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
         */

        private String membershipCardId;
        private int membershipCardType;
        private int cardColor;
        private String title;
        private double discountAmount;
        private String explain;
        private int usedQty;
        private int usedCount;
        private String validPeriod;
        private String receiveTime;
        private String startDay;
        private String endDay;
        private String qrCode;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"validPeriod\":\"")
                    .append(validPeriod).append('\"');
            sb.append(",\"usedQty\":")
                    .append(usedQty);
            sb.append(",\"usedCount\":")
                    .append(usedCount);
            sb.append(",\"title\":\"")
                    .append(title).append('\"');
            sb.append(",\"startDay\":\"")
                    .append(startDay).append('\"');
            sb.append(",\"receiveTime\":\"")
                    .append(receiveTime).append('\"');
            sb.append(",\"qrCode\":\"")
                    .append(qrCode).append('\"');
            sb.append(",\"membershipCardType\":")
                    .append(membershipCardType);
            sb.append(",\"membershipCardId\":\"")
                    .append(membershipCardId).append('\"');
            sb.append(",\"explain\":\"")
                    .append(explain).append('\"');
            sb.append(",\"endDay\":\"")
                    .append(endDay).append('\"');
            sb.append(",\"discountAmount\":")
                    .append(discountAmount);
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"cardColor\":")
                    .append(cardColor);
            sb.append('}');
            return sb.toString();
        }

        protected ResultBean(Parcel in) {
            membershipCardId = in.readString();
            membershipCardType = in.readInt();
            cardColor = in.readInt();
            title = in.readString();
            discountAmount = in.readDouble();
            explain = in.readString();
            usedQty = in.readInt();
            usedCount = in.readInt();
            validPeriod = in.readString();
            receiveTime = in.readString();
            startDay = in.readString();
            endDay = in.readString();
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

        public String getMembershipCardId() {
            return membershipCardId;
        }

        public void setMembershipCardId(String membershipCardId) {
            this.membershipCardId = membershipCardId;
        }

        public int getMembershipCardType() {
            return membershipCardType;
        }

        public void setMembershipCardType(int membershipCardType) {
            this.membershipCardType = membershipCardType;
        }

        public int getCardColor() {
            return cardColor;
        }

        public void setCardColor(int cardColor) {
            this.cardColor = cardColor;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(double discountAmount) {
            this.discountAmount = discountAmount;
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

        public String getValidPeriod() {
            return validPeriod;
        }

        public void setValidPeriod(String validPeriod) {
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
            dest.writeString(membershipCardId);
            dest.writeInt(membershipCardType);
            dest.writeInt(cardColor);
            dest.writeString(title);
            dest.writeDouble(discountAmount);
            dest.writeString(explain);
            dest.writeInt(usedQty);
            dest.writeInt(usedCount);
            dest.writeString(validPeriod);
            dest.writeString(receiveTime);
            dest.writeString(startDay);
            dest.writeString(endDay);
            dest.writeString(qrCode);
        }
    }
}
