package com.hhz.aidl.rxjava;

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
     * couponTotal : 5
     * validRepertoryTerm : 30
     * result : {"cashCoupon":{"couponType":1,"couponCount":2,"cashCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"discountCoupon":{"couponType":2,"couponCount":2,"discountCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"exchangeCoupon":{"couponType":3,"couponCount":2,"exchangeCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}}
     */

    private String responseCode;
    private String errorMessage;
    private String mechantName;
    private String mechantId;
    private int couponTotal;
    private int validRepertoryTerm;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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
    }

    public static class ResultBean implements Parcelable{
        /**
         * cashCoupon : {"couponType":1,"couponCount":2,"cashCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * discountCoupon : {"couponType":2,"couponCount":2,"discountCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * exchangeCoupon : {"couponType":3,"couponCount":2,"exchangeCouponList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         */

        private CashCouponBean cashCoupon;
        private DiscountCouponBean discountCoupon;
        private ExchangeCouponBean exchangeCoupon;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"exchangeCoupon\":")
                    .append(exchangeCoupon);
            sb.append(",\"discountCoupon\":")
                    .append(discountCoupon);
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"cashCoupon\":")
                    .append(cashCoupon);
            sb.append('}');
            return sb.toString();
        }

        protected ResultBean(Parcel in) {
            cashCoupon = in.readParcelable(CashCouponBean.class.getClassLoader());
            discountCoupon = in.readParcelable(DiscountCouponBean.class.getClassLoader());
            exchangeCoupon = in.readParcelable(ExchangeCouponBean.class.getClassLoader());
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

        public CashCouponBean getCashCoupon() {
            return cashCoupon;
        }

        public void setCashCoupon(CashCouponBean cashCoupon) {
            this.cashCoupon = cashCoupon;
        }

        public DiscountCouponBean getDiscountCoupon() {
            return discountCoupon;
        }

        public void setDiscountCoupon(DiscountCouponBean discountCoupon) {
            this.discountCoupon = discountCoupon;
        }

        public ExchangeCouponBean getExchangeCoupon() {
            return exchangeCoupon;
        }

        public void setExchangeCoupon(ExchangeCouponBean exchangeCoupon) {
            this.exchangeCoupon = exchangeCoupon;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(cashCoupon, flags);
            dest.writeParcelable(discountCoupon, flags);
            dest.writeParcelable(exchangeCoupon, flags);
        }

        public static class CashCouponBean implements Parcelable{
            /**
             * couponType : 1
             * couponCount : 2
             * cashCouponList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<CashCouponListBean> cashCouponList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append(",\"cashCouponList\":")
                        .append(cashCouponList);
                sb.append('}');
                return sb.toString();
            }

            protected CashCouponBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
                cashCouponList = in.createTypedArrayList(CashCouponListBean.CREATOR);
            }

            public static final Creator<CashCouponBean> CREATOR = new Creator<CashCouponBean>() {
                @Override
                public CashCouponBean createFromParcel(Parcel in) {
                    return new CashCouponBean(in);
                }

                @Override
                public CashCouponBean[] newArray(int size) {
                    return new CashCouponBean[size];
                }
            };

            public int getCouponType() {
                return couponType;
            }

            public void setCouponType(int couponType) {
                this.couponType = couponType;
            }

            public int getCouponCount() {
                return couponCount;
            }

            public void setCouponCount(int couponCount) {
                this.couponCount = couponCount;
            }

            public List<CashCouponListBean> getCashCouponList() {
                return cashCouponList;
            }

            public void setCashCouponList(List<CashCouponListBean> cashCouponList) {
                this.cashCouponList = cashCouponList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
                dest.writeTypedList(cashCouponList);
            }

            public static class CashCouponListBean implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
                 * mechantLogo : http://api.map.baidu.com/images/weather/day/duoyun.png
                 * couponAmount : 2.03
                 * discountAmount :
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
                private int couponColor;
                private String couponTitle;
                private String mechantLogo;
                private double couponAmount;
                private String discountAmount;
                private double consumeLite;
                private String validPeriod;
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
                    sb.append(",\"discountAmount\":\"")
                            .append(discountAmount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
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

                protected CashCouponListBean(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
                    mechantLogo = in.readString();
                    couponAmount = in.readDouble();
                    discountAmount = in.readString();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
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

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
                    dest.writeString(mechantLogo);
                    dest.writeDouble(couponAmount);
                    dest.writeString(discountAmount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
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

                @Override
                public int describeContents() {
                    return 0;
                }

                public static final Creator<CashCouponListBean> CREATOR = new Creator<CashCouponListBean>() {
                    @Override
                    public CashCouponListBean createFromParcel(Parcel in) {
                        return new CashCouponListBean(in);
                    }

                    @Override
                    public CashCouponListBean[] newArray(int size) {
                        return new CashCouponListBean[size];
                    }
                };

                public String getCouponNo() {
                    return couponNo;
                }

                public void setCouponNo(String couponNo) {
                    this.couponNo = couponNo;
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

                public String getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(String discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public double getConsumeLite() {
                    return consumeLite;
                }

                public void setConsumeLite(double consumeLite) {
                    this.consumeLite = consumeLite;
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
            }
        }

        public static class DiscountCouponBean implements Parcelable{
            /**
             * couponType : 2
             * couponCount : 2
             * discountCouponList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<DiscountCouponListBean> discountCouponList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"discountCouponList\":")
                        .append(discountCouponList);
                sb.append(",\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append('}');
                return sb.toString();
            }

            protected DiscountCouponBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
                discountCouponList = in.createTypedArrayList(DiscountCouponListBean.CREATOR);
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
                dest.writeTypedList(discountCouponList);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<DiscountCouponBean> CREATOR = new Creator<DiscountCouponBean>() {
                @Override
                public DiscountCouponBean createFromParcel(Parcel in) {
                    return new DiscountCouponBean(in);
                }

                @Override
                public DiscountCouponBean[] newArray(int size) {
                    return new DiscountCouponBean[size];
                }
            };

            public int getCouponType() {
                return couponType;
            }

            public void setCouponType(int couponType) {
                this.couponType = couponType;
            }

            public int getCouponCount() {
                return couponCount;
            }

            public void setCouponCount(int couponCount) {
                this.couponCount = couponCount;
            }

            public List<DiscountCouponListBean> getDiscountCouponList() {
                return discountCouponList;
            }

            public void setDiscountCouponList(List<DiscountCouponListBean> discountCouponList) {
                this.discountCouponList = discountCouponList;
            }

            public static class DiscountCouponListBean implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
                 * mechantLogo : http://api.map.baidu.com/images/weather/day/duoyun.png
                 * couponAmount : 2.03
                 * discountAmount :
                 * consumeLite : 10000.63
                 * validPeriod :
                 * receiveTime :
                 * startDay : 201712181033
                 * endDay : 201801181033
                 * repertoryAmount : 100
                 * usedLimit : 1
                 * explain : 到店请出示优惠券
                 * usedQty : 2
                 * usedCount : 2
                 * cancelCount : 1
                 * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
                 */

                private String couponNo;
                private int couponColor;
                private String couponTitle;
                private String mechantLogo;
                private double couponAmount;
                private String discountAmount;
                private double consumeLite;
                private String validPeriod;
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
                    sb.append(",\"discountAmount\":\"")
                            .append(discountAmount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
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

                protected DiscountCouponListBean(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
                    mechantLogo = in.readString();
                    couponAmount = in.readDouble();
                    discountAmount = in.readString();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
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

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
                    dest.writeString(mechantLogo);
                    dest.writeDouble(couponAmount);
                    dest.writeString(discountAmount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
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

                @Override
                public int describeContents() {
                    return 0;
                }

                public static final Creator<DiscountCouponListBean> CREATOR = new Creator<DiscountCouponListBean>() {
                    @Override
                    public DiscountCouponListBean createFromParcel(Parcel in) {
                        return new DiscountCouponListBean(in);
                    }

                    @Override
                    public DiscountCouponListBean[] newArray(int size) {
                        return new DiscountCouponListBean[size];
                    }
                };

                public String getCouponNo() {
                    return couponNo;
                }

                public void setCouponNo(String couponNo) {
                    this.couponNo = couponNo;
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

                public String getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(String discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public double getConsumeLite() {
                    return consumeLite;
                }

                public void setConsumeLite(double consumeLite) {
                    this.consumeLite = consumeLite;
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
            }
        }

        public static class ExchangeCouponBean implements Parcelable{
            /**
             * couponType : 3
             * couponCount : 2
             * exchangeCouponList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","mechantLogo":"http://api.map.baidu.com/images/weather/day/duoyun.png","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<ExchangeCouponListBean> exchangeCouponList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"exchangeCouponList\":")
                        .append(exchangeCouponList);
                sb.append(",\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append('}');
                return sb.toString();
            }

            protected ExchangeCouponBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
                exchangeCouponList = in.createTypedArrayList(ExchangeCouponListBean.CREATOR);
            }

            public static final Creator<ExchangeCouponBean> CREATOR = new Creator<ExchangeCouponBean>() {
                @Override
                public ExchangeCouponBean createFromParcel(Parcel in) {
                    return new ExchangeCouponBean(in);
                }

                @Override
                public ExchangeCouponBean[] newArray(int size) {
                    return new ExchangeCouponBean[size];
                }
            };

            public int getCouponType() {
                return couponType;
            }

            public void setCouponType(int couponType) {
                this.couponType = couponType;
            }

            public int getCouponCount() {
                return couponCount;
            }

            public void setCouponCount(int couponCount) {
                this.couponCount = couponCount;
            }

            public List<ExchangeCouponListBean> getExchangeCouponList() {
                return exchangeCouponList;
            }

            public void setExchangeCouponList(List<ExchangeCouponListBean> exchangeCouponList) {
                this.exchangeCouponList = exchangeCouponList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
                dest.writeTypedList(exchangeCouponList);
            }

            public static class ExchangeCouponListBean implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
                 * mechantLogo : http://api.map.baidu.com/images/weather/day/duoyun.png
                 * couponAmount : 2.03
                 * discountAmount :
                 * consumeLite : 10000.63
                 * validPeriod :
                 * receiveTime :
                 * startDay : 201712181033
                 * endDay : coupTitle
                 * repertoryAmount : 100
                 * usedLimit : 1
                 * explain : 到店请出示优惠券
                 * usedQty : 2
                 * usedCount : 2
                 * cancelCount : 1
                 * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
                 */

                private String couponNo;
                private int couponColor;
                private String couponTitle;
                private String mechantLogo;
                private double couponAmount;
                private double discountAmount;
                private double consumeLite;
                private String validPeriod;
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
                    sb.append(",\"discountAmount\":\"")
                            .append(discountAmount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
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

                protected ExchangeCouponListBean(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
                    mechantLogo = in.readString();
                    couponAmount = in.readDouble();
                    discountAmount = in.readDouble();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
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

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
                    dest.writeString(mechantLogo);
                    dest.writeDouble(couponAmount);
                    dest.writeDouble(discountAmount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
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

                @Override
                public int describeContents() {
                    return 0;
                }

                public static final Creator<ExchangeCouponListBean> CREATOR = new Creator<ExchangeCouponListBean>() {
                    @Override
                    public ExchangeCouponListBean createFromParcel(Parcel in) {
                        return new ExchangeCouponListBean(in);
                    }

                    @Override
                    public ExchangeCouponListBean[] newArray(int size) {
                        return new ExchangeCouponListBean[size];
                    }
                };

                public String getCouponNo() {
                    return couponNo;
                }

                public void setCouponNo(String couponNo) {
                    this.couponNo = couponNo;
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

                public double getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(double discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public double getConsumeLite() {
                    return consumeLite;
                }

                public void setConsumeLite(double consumeLite) {
                    this.consumeLite = consumeLite;
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
            }
        }
    }
}
