package com.hhz.aidl.rxjava;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class MemberShipBean implements Parcelable{

    /**
     * respCode : 0000
     * respMsg : 请求成功
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * couponType : 2
     * cardAccount : 2
     * cardTotal : 5
     * validRepertoryTerm : 30
     * result : [{"merchantId":"123456789","mechantType":1,"cardColor":1,"title":"梨花小店会员卡1","couponAmount":"9折","explain":"到店请出示优惠券","usedPerson":10,"usedCount":2,"validPeriod":"20171220112233","startDay":"","endDay":"","qrCode":"http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"merchantId":"123456780","mechantType":1,"cardColor":1,"title":"梨花小店会员卡2","couponAmount":"9折","explain":"到店请出示优惠券","usedPerson":10,"usedCount":2,"validPeriod":"","startDay":"20171220112233","endDay":"20180120112233","qrCode":"http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
     */

    private String respCode;
    private String respMsg;
    private String logo;
    private String mechantName;
    private String mechantId;
    private int couponType;
    private int cardAccount;
    private int cardTotal;
    private String validRepertoryTerm;
    private List<ResultBean> result;

    protected MemberShipBean(Parcel in) {
        respCode = in.readString();
        respMsg = in.readString();
        logo = in.readString();
        mechantName = in.readString();
        mechantId = in.readString();
        couponType = in.readInt();
        cardAccount = in.readInt();
        cardTotal = in.readInt();
        validRepertoryTerm = in.readString();
        result = in.createTypedArrayList(ResultBean.CREATOR);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"validRepertoryTerm\":\"")
                .append(validRepertoryTerm).append('\"');
        sb.append(",\"result\":")
                .append(result);
        sb.append(",\"respMsg\":\"")
                .append(respMsg).append('\"');
        sb.append(",\"respCode\":\"")
                .append(respCode).append('\"');
        sb.append(",\"mechantName\":\"")
                .append(mechantName).append('\"');
        sb.append(",\"mechantId\":\"")
                .append(mechantId).append('\"');
        sb.append(",\"logo\":\"")
                .append(logo).append('\"');
        sb.append(",\"describeContents\":")
                .append(describeContents());
        sb.append(",\"couponType\":")
                .append(couponType);
        sb.append(",\"cardTotal\":")
                .append(cardTotal);
        sb.append(",\"cardAccount\":")
                .append(cardAccount);
        sb.append('}');
        return sb.toString();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
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

    public String getmechantId() {
        return mechantId;
    }

    public void setmechantId(String mechantId) {
        this.mechantId = mechantId;
    }

    public int getCouponType() {
        return couponType;
    }

    public void setCouponType(int couponType) {
        this.couponType = couponType;
    }

    public int getCardAccount() {
        return cardAccount;
    }

    public void setCardAccount(int cardAccount) {
        this.cardAccount = cardAccount;
    }

    public int getCardTotal() {
        return cardTotal;
    }

    public void setCardTotal(int cardTotal) {
        this.cardTotal = cardTotal;
    }

    public String getValidRepertoryTerm() {
        return validRepertoryTerm;
    }

    public void setValidRepertoryTerm(String validRepertoryTerm) {
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
        dest.writeString(respCode);
        dest.writeString(respMsg);
        dest.writeString(logo);
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(couponType);
        dest.writeInt(cardAccount);
        dest.writeInt(cardTotal);
        dest.writeString(validRepertoryTerm);
        dest.writeTypedList(result);
    }

    public static class ResultBean implements Parcelable{
        /**
         * merchantId : 123456789
         * mechantType : 1
         * cardColor : 1
         * title : 梨花小店会员卡1
         * couponAmount : 9折
         * explain : 到店请出示优惠券
         * usedPerson : 10
         * usedCount : 2
         * validPeriod : 20171220112233
         * startDay :
         * endDay :
         * qrCode : http://1.hpaypos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
         */

        private String merchantId;
        private int mechantType;
        private int cardColor;
        private String title;
        private String couponAmount;
        private String explain;
        private int usedPerson;
        private int usedCount;
        private String validPeriod;
        private String startDay;
        private String endDay;
        private String qrCode;

        protected ResultBean(Parcel in) {
            merchantId = in.readString();
            mechantType = in.readInt();
            cardColor = in.readInt();
            title = in.readString();
            couponAmount = in.readString();
            explain = in.readString();
            usedPerson = in.readInt();
            usedCount = in.readInt();
            validPeriod = in.readString();
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"validPeriod\":\"")
                    .append(validPeriod).append('\"');
            sb.append(",\"usedPerson\":")
                    .append(usedPerson);
            sb.append(",\"usedCount\":")
                    .append(usedCount);
            sb.append(",\"title\":\"")
                    .append(title).append('\"');
            sb.append(",\"startDay\":\"")
                    .append(startDay).append('\"');
            sb.append(",\"qrCode\":\"")
                    .append(qrCode).append('\"');
            sb.append(",\"merchantId\":\"")
                    .append(merchantId).append('\"');
            sb.append(",\"mechantType\":")
                    .append(mechantType);
            sb.append(",\"explain\":\"")
                    .append(explain).append('\"');
            sb.append(",\"endDay\":\"")
                    .append(endDay).append('\"');
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"couponAmount\":\"")
                    .append(couponAmount).append('\"');
            sb.append(",\"cardColor\":")
                    .append(cardColor);
            sb.append('}');
            return sb.toString();
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public int getMechantType() {
            return mechantType;
        }

        public void setMechantType(int mechantType) {
            this.mechantType = mechantType;
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

        public String getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(String couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public int getUsedPerson() {
            return usedPerson;
        }

        public void setUsedPerson(int usedPerson) {
            this.usedPerson = usedPerson;
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
            dest.writeString(merchantId);
            dest.writeInt(mechantType);
            dest.writeInt(cardColor);
            dest.writeString(title);
            dest.writeString(couponAmount);
            dest.writeString(explain);
            dest.writeInt(usedPerson);
            dest.writeInt(usedCount);
            dest.writeString(validPeriod);
            dest.writeString(startDay);
            dest.writeString(endDay);
            dest.writeString(qrCode);
        }
    }
}
