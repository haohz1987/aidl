package com.hhz.aidl.rxjava;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class CouponBean implements Parcelable{

    /**
     * respCode : 0000
     * respMsg : 请求成功
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * cardTotal : 5
     * validRepertoryTerm : 30
     * result : {"cashCoup":{"coupType":1,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"discountCoup":{"coupType":2,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]},"exchangeCoup":{"coupType":3,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}}
     */

    private String respCode;
    private String respMsg;
    private String logo;
    private String mechantName;
    private String mechantId;
    private int cardTotal;
    private String validRepertoryTerm;
    private ResultBean result;


    protected CouponBean(Parcel in) {
        respCode = in.readString();
        respMsg = in.readString();
        logo = in.readString();
        mechantName = in.readString();
        mechantId = in.readString();
        cardTotal = in.readInt();
        validRepertoryTerm = in.readString();
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
        dest.writeString(respCode);
        dest.writeString(respMsg);
        dest.writeString(logo);
        dest.writeString(mechantName);
        dest.writeString(mechantId);
        dest.writeInt(cardTotal);
        dest.writeString(validRepertoryTerm);
    }

    public static class ResultBean implements Parcelable{
        /**
         * cashCoup : {"coupType":1,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * discountCoup : {"coupType":2,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         * exchangeCoup : {"coupType":3,"CoupCount":2,"CoupList":[{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]}
         */

        private CashCoupBean cashCoup;
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
            sb.append(",\"cashCoup\":")
                    .append(cashCoup);
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

        public CashCoupBean getCashCoup() {
            return cashCoup;
        }

        public void setCashCoup(CashCoupBean cashCoup) {
            this.cashCoup = cashCoup;
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

        public static class CashCoupBean implements Parcelable{
            /**
             * coupType : 1
             * CoupCount : 2
             * CoupList : [{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"201712181033","endDay":"coupTitle","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int coupType;
            private int CoupCount;
            private List<CoupListBean> CoupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"coupType\":")
                        .append(coupType);
                sb.append(",\"CoupList\":")
                        .append(CoupList);
                sb.append(",\"coupList\":")
                        .append(getCoupList());
                sb.append(",\"CoupCount\":")
                        .append(CoupCount);
                sb.append(",\"coupCount\":")
                        .append(getCoupCount());
                sb.append('}');
                return sb.toString();
            }

            protected CashCoupBean(Parcel in) {
                coupType = in.readInt();
                CoupCount = in.readInt();
                CoupList = in.createTypedArrayList(CoupListBean.CREATOR);
            }

            public static final Creator<CashCoupBean> CREATOR = new Creator<CashCoupBean>() {
                @Override
                public CashCoupBean createFromParcel(Parcel in) {
                    return new CashCoupBean(in);
                }

                @Override
                public CashCoupBean[] newArray(int size) {
                    return new CashCoupBean[size];
                }
            };

            public int getCoupType() {
                return coupType;
            }

            public void setCoupType(int coupType) {
                this.coupType = coupType;
            }

            public int getCoupCount() {
                return CoupCount;
            }

            public void setCoupCount(int CoupCount) {
                this.CoupCount = CoupCount;
            }

            public List<CoupListBean> getCoupList() {
                return CoupList;
            }

            public void setCoupList(List<CoupListBean> CoupList) {
                this.CoupList = CoupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(coupType);
                dest.writeInt(CoupCount);
                dest.writeTypedList(CoupList);
            }

            public static class CoupListBean implements Parcelable{
                /**
                 * coupNo : 201712181033
                 * coupColor : 0
                 * coupTitle : coupTitle
                 * coupAmount : 2.03
                 * discount :
                 * consumeLite : 10000.63
                 * validPeriod : 30
                 * receiveTime : 201712181033
                 * startDay : 201712181033
                 * endDay : coupTitle
                 * repertoryAmount : 100
                 * usedLimit : 1
                 * explain : 到店请出示优惠券
                 * usedPerson : 2
                 * usedCount : 2
                 * cancelCount : 1
                 * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
                 */

                private String coupNo;
                private int coupColor;
                private String coupTitle;
                private double coupAmount;
                private String discount;
                private double consumeLite;
                private String validPeriod;
                private String receiveTime;
                private String startDay;
                private String endDay;
                private int repertoryAmount;
                private int usedLimit;
                private String explain;
                private int usedPerson;
                private int usedCount;
                private int cancelCount;
                private String qrCode;

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("{");
                    sb.append("\"validPeriod\":\"")
                            .append(validPeriod).append('\"');
                    sb.append(",\"usedPerson\":")
                            .append(usedPerson);
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
                    sb.append(",\"discount\":\"")
                            .append(discount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
                    sb.append(",\"coupTitle\":\"")
                            .append(coupTitle).append('\"');
                    sb.append(",\"coupNo\":\"")
                            .append(coupNo).append('\"');
                    sb.append(",\"coupColor\":")
                            .append(coupColor);
                    sb.append(",\"coupAmount\":")
                            .append(coupAmount);
                    sb.append(",\"consumeLite\":")
                            .append(consumeLite);
                    sb.append(",\"cancelCount\":")
                            .append(cancelCount);
                    sb.append('}');
                    return sb.toString();
                }

                protected CoupListBean(Parcel in) {
                    coupNo = in.readString();
                    coupColor = in.readInt();
                    coupTitle = in.readString();
                    coupAmount = in.readDouble();
                    discount = in.readString();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
                    receiveTime = in.readString();
                    startDay = in.readString();
                    endDay = in.readString();
                    repertoryAmount = in.readInt();
                    usedLimit = in.readInt();
                    explain = in.readString();
                    usedPerson = in.readInt();
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

                public String getCoupNo() {
                    return coupNo;
                }

                public void setCoupNo(String coupNo) {
                    this.coupNo = coupNo;
                }

                public int getCoupColor() {
                    return coupColor;
                }

                public void setCoupColor(int coupColor) {
                    this.coupColor = coupColor;
                }

                public String getCoupTitle() {
                    return coupTitle;
                }

                public void setCoupTitle(String coupTitle) {
                    this.coupTitle = coupTitle;
                }

                public double getCoupAmount() {
                    return coupAmount;
                }

                public void setCoupAmount(double coupAmount) {
                    this.coupAmount = coupAmount;
                }

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
                    this.discount = discount;
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
                    dest.writeString(coupNo);
                    dest.writeInt(coupColor);
                    dest.writeString(coupTitle);
                    dest.writeDouble(coupAmount);
                    dest.writeString(discount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
                    dest.writeString(receiveTime);
                    dest.writeString(startDay);
                    dest.writeString(endDay);
                    dest.writeInt(repertoryAmount);
                    dest.writeInt(usedLimit);
                    dest.writeString(explain);
                    dest.writeInt(usedPerson);
                    dest.writeInt(usedCount);
                    dest.writeInt(cancelCount);
                    dest.writeString(qrCode);
                }
            }
        }

        public static class DiscountCoupBean implements Parcelable{
            /**
             * coupType : 2
             * CoupCount : 2
             * CoupList : [{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int coupType;
            private int CoupCount;
            private List<CoupListBeanX> CoupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"coupType\":")
                        .append(coupType);
                sb.append(",\"CoupList\":")
                        .append(CoupList);
                sb.append(",\"coupList\":")
                        .append(getCoupList());
                sb.append(",\"CoupCount\":")
                        .append(CoupCount);
                sb.append(",\"coupCount\":")
                        .append(getCoupCount());
                sb.append('}');
                return sb.toString();
            }

            protected DiscountCoupBean(Parcel in) {
                coupType = in.readInt();
                CoupCount = in.readInt();
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

            public int getCoupType() {
                return coupType;
            }

            public void setCoupType(int coupType) {
                this.coupType = coupType;
            }

            public int getCoupCount() {
                return CoupCount;
            }

            public void setCoupCount(int CoupCount) {
                this.CoupCount = CoupCount;
            }

            public List<CoupListBeanX> getCoupList() {
                return CoupList;
            }

            public void setCoupList(List<CoupListBeanX> CoupList) {
                this.CoupList = CoupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(coupType);
                dest.writeInt(CoupCount);
            }

            public static class CoupListBeanX implements Parcelable{
                /**
                 * coupNo : 201712181033
                 * coupColor : 0
                 * coupTitle : coupTitle
                 * coupAmount : 2.03
                 * discount :
                 * consumeLite : 10000.63
                 * validPeriod : 30
                 * receiveTime : 201712181033
                 * startDay :
                 * endDay :
                 * repertoryAmount : 100
                 * usedLimit : 1
                 * explain : 到店请出示优惠券
                 * usedPerson : 2
                 * usedCount : 2
                 * cancelCount : 1
                 * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
                 */

                private String coupNo;
                private int coupColor;
                private String coupTitle;
                private double coupAmount;
                private String discount;
                private double consumeLite;
                private String validPeriod;
                private String receiveTime;
                private String startDay;
                private String endDay;
                private int repertoryAmount;
                private int usedLimit;
                private String explain;
                private int usedPerson;
                private int usedCount;
                private int cancelCount;
                private String qrCode;

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("{");
                    sb.append("\"validPeriod\":\"")
                            .append(validPeriod).append('\"');
                    sb.append(",\"usedPerson\":")
                            .append(usedPerson);
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
                    sb.append(",\"discount\":\"")
                            .append(discount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
                    sb.append(",\"coupTitle\":\"")
                            .append(coupTitle).append('\"');
                    sb.append(",\"coupNo\":\"")
                            .append(coupNo).append('\"');
                    sb.append(",\"coupColor\":")
                            .append(coupColor);
                    sb.append(",\"coupAmount\":")
                            .append(coupAmount);
                    sb.append(",\"consumeLite\":")
                            .append(consumeLite);
                    sb.append(",\"cancelCount\":")
                            .append(cancelCount);
                    sb.append('}');
                    return sb.toString();
                }

                protected CoupListBeanX(Parcel in) {
                    coupNo = in.readString();
                    coupColor = in.readInt();
                    coupTitle = in.readString();
                    coupAmount = in.readDouble();
                    discount = in.readString();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
                    receiveTime = in.readString();
                    startDay = in.readString();
                    endDay = in.readString();
                    repertoryAmount = in.readInt();
                    usedLimit = in.readInt();
                    explain = in.readString();
                    usedPerson = in.readInt();
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

                public String getCoupNo() {
                    return coupNo;
                }

                public void setCoupNo(String coupNo) {
                    this.coupNo = coupNo;
                }

                public int getCoupColor() {
                    return coupColor;
                }

                public void setCoupColor(int coupColor) {
                    this.coupColor = coupColor;
                }

                public String getCoupTitle() {
                    return coupTitle;
                }

                public void setCoupTitle(String coupTitle) {
                    this.coupTitle = coupTitle;
                }

                public double getCoupAmount() {
                    return coupAmount;
                }

                public void setCoupAmount(double coupAmount) {
                    this.coupAmount = coupAmount;
                }

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
                    this.discount = discount;
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
                    dest.writeString(coupNo);
                    dest.writeInt(coupColor);
                    dest.writeString(coupTitle);
                    dest.writeDouble(coupAmount);
                    dest.writeString(discount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
                    dest.writeString(receiveTime);
                    dest.writeString(startDay);
                    dest.writeString(endDay);
                    dest.writeInt(repertoryAmount);
                    dest.writeInt(usedLimit);
                    dest.writeString(explain);
                    dest.writeInt(usedPerson);
                    dest.writeInt(usedCount);
                    dest.writeInt(cancelCount);
                    dest.writeString(qrCode);
                }
            }
        }

        public static class ExchangeCoupBean implements Parcelable{
            /**
             * coupType : 3
             * CoupCount : 2
             * CoupList : [{"coupNo":"201712181033","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"30","receiveTime":"201712181033","startDay":"","endDay":"","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"},{"coupNo":"201712181133","coupColor":0,"coupTitle":"coupTitle","coupAmount":2.03,"discount":"","consumeLite":10000.63,"validPeriod":"","receiveTime":"","startDay":"201712181033","endDay":"201712181033","repertoryAmount":100,"usedLimit":1,"explain":"到店请出示优惠券","usedPerson":2,"usedCount":2,"cancelCount":1,"qrCode":"http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100"}]
             */

            private int coupType;
            private int CoupCount;
            private List<CoupListBeanXX> CoupList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"describeContents\":")
                        .append(describeContents());
                sb.append(",\"coupType\":")
                        .append(coupType);
                sb.append(",\"CoupList\":")
                        .append(CoupList);
                sb.append(",\"coupList\":")
                        .append(getCoupList());
                sb.append(",\"CoupCount\":")
                        .append(CoupCount);
                sb.append(",\"coupCount\":")
                        .append(getCoupCount());
                sb.append('}');
                return sb.toString();
            }

            protected ExchangeCoupBean(Parcel in) {
                coupType = in.readInt();
                CoupCount = in.readInt();
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

            public int getCoupType() {
                return coupType;
            }

            public void setCoupType(int coupType) {
                this.coupType = coupType;
            }

            public int getCoupCount() {
                return CoupCount;
            }

            public void setCoupCount(int CoupCount) {
                this.CoupCount = CoupCount;
            }

            public List<CoupListBeanXX> getCoupList() {
                return CoupList;
            }

            public void setCoupList(List<CoupListBeanXX> CoupList) {
                this.CoupList = CoupList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(coupType);
                dest.writeInt(CoupCount);
            }

            public static class CoupListBeanXX implements Parcelable{
                /**
                 * coupNo : 201712181033
                 * coupColor : 0
                 * coupTitle : coupTitle
                 * coupAmount : 2.03
                 * discount :
                 * consumeLite : 10000.63
                 * validPeriod : 30
                 * receiveTime : 201712181033
                 * startDay :
                 * endDay :
                 * repertoryAmount : 100
                 * usedLimit : 1
                 * explain : 到店请出示优惠券
                 * usedPerson : 2
                 * usedCount : 2
                 * cancelCount : 1
                 * qrCode : http://1.smartpos.applinzi.com/qrCode.png?wechatNo=122&mechantId=1000&coupNo=1005&coupType=2&coupAmount=10&discount=&consumeLite=100
                 */

                private String coupNo;
                private int coupColor;
                private String coupTitle;
                private double coupAmount;
                private String discount;
                private double consumeLite;
                private String validPeriod;
                private String receiveTime;
                private String startDay;
                private String endDay;
                private int repertoryAmount;
                private int usedLimit;
                private String explain;
                private int usedPerson;
                private int usedCount;
                private int cancelCount;
                private String qrCode;

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("{");
                    sb.append("\"validPeriod\":\"")
                            .append(validPeriod).append('\"');
                    sb.append(",\"usedPerson\":")
                            .append(usedPerson);
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
                    sb.append(",\"discount\":\"")
                            .append(discount).append('\"');
                    sb.append(",\"describeContents\":")
                            .append(describeContents());
                    sb.append(",\"coupTitle\":\"")
                            .append(coupTitle).append('\"');
                    sb.append(",\"coupNo\":\"")
                            .append(coupNo).append('\"');
                    sb.append(",\"coupColor\":")
                            .append(coupColor);
                    sb.append(",\"coupAmount\":")
                            .append(coupAmount);
                    sb.append(",\"consumeLite\":")
                            .append(consumeLite);
                    sb.append(",\"cancelCount\":")
                            .append(cancelCount);
                    sb.append('}');
                    return sb.toString();
                }

                protected CoupListBeanXX(Parcel in) {
                    coupNo = in.readString();
                    coupColor = in.readInt();
                    coupTitle = in.readString();
                    coupAmount = in.readDouble();
                    discount = in.readString();
                    consumeLite = in.readDouble();
                    validPeriod = in.readString();
                    receiveTime = in.readString();
                    startDay = in.readString();
                    endDay = in.readString();
                    repertoryAmount = in.readInt();
                    usedLimit = in.readInt();
                    explain = in.readString();
                    usedPerson = in.readInt();
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

                public String getCoupNo() {
                    return coupNo;
                }

                public void setCoupNo(String coupNo) {
                    this.coupNo = coupNo;
                }

                public int getCoupColor() {
                    return coupColor;
                }

                public void setCoupColor(int coupColor) {
                    this.coupColor = coupColor;
                }

                public String getCoupTitle() {
                    return coupTitle;
                }

                public void setCoupTitle(String coupTitle) {
                    this.coupTitle = coupTitle;
                }

                public double getCoupAmount() {
                    return coupAmount;
                }

                public void setCoupAmount(double coupAmount) {
                    this.coupAmount = coupAmount;
                }

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
                    this.discount = discount;
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
                    dest.writeString(coupNo);
                    dest.writeInt(coupColor);
                    dest.writeString(coupTitle);
                    dest.writeDouble(coupAmount);
                    dest.writeString(discount);
                    dest.writeDouble(consumeLite);
                    dest.writeString(validPeriod);
                    dest.writeString(receiveTime);
                    dest.writeString(startDay);
                    dest.writeString(endDay);
                    dest.writeInt(repertoryAmount);
                    dest.writeInt(usedLimit);
                    dest.writeString(explain);
                    dest.writeInt(usedPerson);
                    dest.writeInt(usedCount);
                    dest.writeInt(cancelCount);
                    dest.writeString(qrCode);
                }
            }
        }
    }
}
