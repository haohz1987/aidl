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
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * couponTotal : 5
     * validRepertoryTerm : 30
     * result : {"cashCoupon":{"couponType":1,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"discountCoup":{"couponType":2,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"exchangeCoup":{"couponType":3,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}}
     */

    private String responseCode;
    private String errorMessage;
    private String logo;
    private String mechantName;
    private String mechantId;
    private int couponTotal;
    private int validRepertoryTerm;
    private ResultBean result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"validRepertoryTerm\":\"")
                .append(validRepertoryTerm).append('\"');
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
        sb.append(",\"couponTotal\":")
                .append(couponTotal);
        sb.append('}');
        return sb.toString();
    }

    protected CouponBean(Parcel in) {
        responseCode = in.readString();
        errorMessage = in.readString();
        logo = in.readString();
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
        dest.writeString(logo);
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(couponTotal);
        dest.writeInt(validRepertoryTerm);
    }

    public static class ResultBean implements Parcelable{
        /**
         * cashCoupon : {"couponType":1,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * discountCoup : {"couponType":2,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * exchangeCoup : {"couponType":3,"couponCount":2,"coupList":[{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         */

        private CashCouponBean cashCoupon;
        private DiscountCoupBean discountCoup;
        private ExchangeCoupBean exchangeCoup;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"exchangeCoup\":")
                    .append(exchangeCoup);
            sb.append(",\"discountCoup\":")
                    .append(discountCoup);
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"cashCoupon\":")
                    .append(cashCoupon);
            sb.append('}');
            return sb.toString();
        }

        protected ResultBean(Parcel in) {
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

        public DiscountCoupBean getDiscountCoup() {
            return discountCoup;
        }

        public void setDiscountCoup(DiscountCoupBean discountCoup) {
            this.discountCoup = discountCoup;
        }

        public ExchangeCoupBean getExchangeCoup() {
            return exchangeCoup;
        }

        public void setExchangeCoup(ExchangeCoupBean exchangeCoup) {
            this.exchangeCoup = exchangeCoup;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class CashCouponBean implements Parcelable{
            /**
             * couponType : 1
             * couponCount : 2
             * coupList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<CoupListBean> coupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append(",\"coupList\":")
                        .append(coupList);
                sb.append('}');
                return sb.toString();
            }

            protected CashCouponBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
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

            public List<CoupListBean> getCoupList() {
                return coupList;
            }

            public void setCoupList(List<CoupListBean> coupList) {
                this.coupList = coupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
            }

            public static class CoupListBean implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
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

                protected CoupListBean(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
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

                public static final Creator<CoupListBean> CREATOR = new Creator<CoupListBean>() {
                    @Override
                    public CoupListBean createFromParcel(Parcel in) {
                        return new CoupListBean(in);
                    }

                    @Override
                    public CoupListBean[] newArray(int size) {
                        return new CoupListBean[size];
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
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
            }
        }

        public static class DiscountCoupBean implements Parcelable{
            /**
             * couponType : 2
             * couponCount : 2
             * coupList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201801181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<CoupListBeanX> coupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append(",\"coupList\":")
                        .append(coupList);
                sb.append('}');
                return sb.toString();
            }

            protected DiscountCoupBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
            }

            public static final Creator<DiscountCoupBean> CREATOR = new Creator<DiscountCoupBean>() {
                @Override
                public DiscountCoupBean createFromParcel(Parcel in) {
                    return new DiscountCoupBean(in);
                }

                @Override
                public DiscountCoupBean[] newArray(int size) {
                    return new DiscountCoupBean[size];
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

            public List<CoupListBeanX> getCoupList() {
                return coupList;
            }

            public void setCoupList(List<CoupListBeanX> coupList) {
                this.coupList = coupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
            }

            public static class CoupListBeanX implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
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

                protected CoupListBeanX(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
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

                public static final Creator<CoupListBeanX> CREATOR = new Creator<CoupListBeanX>() {
                    @Override
                    public CoupListBeanX createFromParcel(Parcel in) {
                        return new CoupListBeanX(in);
                    }

                    @Override
                    public CoupListBeanX[] newArray(int size) {
                        return new CoupListBeanX[size];
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
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
            }
        }

        public static class ExchangeCoupBean implements Parcelable{
            /**
             * couponType : 3
             * couponCount : 2
             * coupList : [{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店1","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"couponNo":"201712181033","couponColor":0,"couponTitle":"小店2","couponAmount":2.03,"discountAmount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedQty":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantCode=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int couponType;
            private int couponCount;
            private List<CoupListBeanXX> coupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"couponType\":")
                        .append(couponType);
                sb.append(",\"couponCount\":")
                        .append(couponCount);
                sb.append(",\"coupList\":")
                        .append(coupList);
                sb.append('}');
                return sb.toString();
            }

            protected ExchangeCoupBean(Parcel in) {
                couponType = in.readInt();
                couponCount = in.readInt();
            }

            public static final Creator<ExchangeCoupBean> CREATOR = new Creator<ExchangeCoupBean>() {
                @Override
                public ExchangeCoupBean createFromParcel(Parcel in) {
                    return new ExchangeCoupBean(in);
                }

                @Override
                public ExchangeCoupBean[] newArray(int size) {
                    return new ExchangeCoupBean[size];
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

            public List<CoupListBeanXX> getCoupList() {
                return coupList;
            }

            public void setCoupList(List<CoupListBeanXX> coupList) {
                this.coupList = coupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(couponType);
                dest.writeInt(couponCount);
            }

            public static class CoupListBeanXX implements Parcelable{
                /**
                 * couponNo : 201712181033
                 * couponColor : 0
                 * couponTitle : 小店1
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

                protected CoupListBeanXX(Parcel in) {
                    couponNo = in.readString();
                    couponColor = in.readInt();
                    couponTitle = in.readString();
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

                public static final Creator<CoupListBeanXX> CREATOR = new Creator<CoupListBeanXX>() {
                    @Override
                    public CoupListBeanXX createFromParcel(Parcel in) {
                        return new CoupListBeanXX(in);
                    }

                    @Override
                    public CoupListBeanXX[] newArray(int size) {
                        return new CoupListBeanXX[size];
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(couponNo);
                    dest.writeInt(couponColor);
                    dest.writeString(couponTitle);
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
            }
        }
    }
}
