package com.hhz.aidl.rxjava;

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
     * result : {"cancelRecord":{"recordType":1,"recordCount":2,"recordList":[{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]},"provideRecord":{"recordType":2,"recordCount":2,"recordList":[{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}}
     */

    private String responseCode;
    private String errorMessage;
    private String logo;
    private String mechantName;
    private String mechantId;
    private ResultBean result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"result\":")
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
    }

    public static class ResultBean implements Parcelable{
        /**
         * cancelRecord : {"recordType":1,"recordCount":2,"recordList":[{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}
         * provideRecord : {"recordType":2,"recordCount":2,"recordList":[{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}
         */

        private CancelRecordBean cancelRecord;
        private ProvideRecordBean provideRecord;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"provideRecord\":")
                    .append(provideRecord);
            sb.append(",\"describeContents\":")
                    .append(describeContents());
            sb.append(",\"cancelRecord\":")
                    .append(cancelRecord);
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

        public CancelRecordBean getCancelRecord() {
            return cancelRecord;
        }

        public void setCancelRecord(CancelRecordBean cancelRecord) {
            this.cancelRecord = cancelRecord;
        }

        public ProvideRecordBean getProvideRecord() {
            return provideRecord;
        }

        public void setProvideRecord(ProvideRecordBean provideRecord) {
            this.provideRecord = provideRecord;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class CancelRecordBean implements Parcelable{
            /**
             * recordType : 1
             * recordCount : 2
             * recordList : [{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]
             */

            private int recordType;
            private int recordCount;
            private List<RecordListBean> recordList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"recordType\":")
                        .append(recordType);
                sb.append(",\"recordList\":")
                        .append(recordList);
                sb.append(",\"recordCount\":")
                        .append(recordCount);
                sb.append(",\"describeContents\":")
                        .append(describeContents());
                sb.append('}');
                return sb.toString();
            }

            protected CancelRecordBean(Parcel in) {
                recordType = in.readInt();
                recordCount = in.readInt();
            }

            public static final Creator<CancelRecordBean> CREATOR = new Creator<CancelRecordBean>() {
                @Override
                public CancelRecordBean createFromParcel(Parcel in) {
                    return new CancelRecordBean(in);
                }

                @Override
                public CancelRecordBean[] newArray(int size) {
                    return new CancelRecordBean[size];
                }
            };

            public int getRecordType() {
                return recordType;
            }

            public void setRecordType(int recordType) {
                this.recordType = recordType;
            }

            public int getRecordCount() {
                return recordCount;
            }

            public void setRecordCount(int recordCount) {
                this.recordCount = recordCount;
            }

            public List<RecordListBean> getRecordList() {
                return recordList;
            }

            public void setRecordList(List<RecordListBean> recordList) {
                this.recordList = recordList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(recordType);
                dest.writeInt(recordCount);
            }

            public static class RecordListBean implements Parcelable{
                /**
                 * recordDate : 201712181033
                 * couponType : 1
                 * serialNo : 123456789
                 * couponNo : 12345678922
                 * orderAmount : 53.23
                 * couponAmount : 10
                 * discount :
                 * consumeLite : 100
                 * usedCount : 5
                 * usedLimit : 1
                 */

                private String recordDate;
                private int couponType;
                private String serialNo;
                private String couponNo;
                private double orderAmount;
                private int couponAmount;
                private String discount;
                private int consumeLite;
                private int usedCount;
                private int usedLimit;

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("{");
                    sb.append("\"usedLimit\":")
                            .append(usedLimit);
                    sb.append(",\"usedCount\":")
                            .append(usedCount);
                    sb.append(",\"serialNo\":\"")
                            .append(serialNo).append('\"');
                    sb.append(",\"recordDate\":\"")
                            .append(recordDate).append('\"');
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

                protected RecordListBean(Parcel in) {
                    recordDate = in.readString();
                    couponType = in.readInt();
                    serialNo = in.readString();
                    couponNo = in.readString();
                    orderAmount = in.readDouble();
                    couponAmount = in.readInt();
                    discount = in.readString();
                    consumeLite = in.readInt();
                    usedCount = in.readInt();
                    usedLimit = in.readInt();
                }

                public static final Creator<RecordListBean> CREATOR = new Creator<RecordListBean>() {
                    @Override
                    public RecordListBean createFromParcel(Parcel in) {
                        return new RecordListBean(in);
                    }

                    @Override
                    public RecordListBean[] newArray(int size) {
                        return new RecordListBean[size];
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

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(recordDate);
                    dest.writeInt(couponType);
                    dest.writeString(serialNo);
                    dest.writeString(couponNo);
                    dest.writeDouble(orderAmount);
                    dest.writeInt(couponAmount);
                    dest.writeString(discount);
                    dest.writeInt(consumeLite);
                    dest.writeInt(usedCount);
                    dest.writeInt(usedLimit);
                }
            }
        }

        public static class ProvideRecordBean {
            /**
             * recordType : 2
             * recordCount : 2
             * recordList : [{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","couponType":1,"serialNo":"123456789","couponNo":"12345678922","orderAmount":53.23,"couponAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]
             */

            private int recordType;
            private int recordCount;
            private List<RecordListBeanX> recordList;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"recordType\":")
                        .append(recordType);
                sb.append(",\"recordList\":")
                        .append(recordList);
                sb.append(",\"recordCount\":")
                        .append(recordCount);
                sb.append('}');
                return sb.toString();
            }

            public int getRecordType() {
                return recordType;
            }

            public void setRecordType(int recordType) {
                this.recordType = recordType;
            }

            public int getRecordCount() {
                return recordCount;
            }

            public void setRecordCount(int recordCount) {
                this.recordCount = recordCount;
            }

            public List<RecordListBeanX> getRecordList() {
                return recordList;
            }

            public void setRecordList(List<RecordListBeanX> recordList) {
                this.recordList = recordList;
            }

            public static class RecordListBeanX {
                /**
                 * recordDate : 201712181033
                 * couponType : 1
                 * serialNo : 123456789
                 * couponNo : 12345678922
                 * orderAmount : 53.23
                 * couponAmount : 10
                 * discount :
                 * consumeLite : 100
                 * usedCount : 5
                 * usedLimit : 1
                 */

                private String recordDate;
                private int couponType;
                private String serialNo;
                private String couponNo;
                private double orderAmount;
                private int couponAmount;
                private String discount;
                private int consumeLite;
                private int usedCount;
                private int usedLimit;

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("{");
                    sb.append("\"usedLimit\":")
                            .append(usedLimit);
                    sb.append(",\"usedCount\":")
                            .append(usedCount);
                    sb.append(",\"serialNo\":\"")
                            .append(serialNo).append('\"');
                    sb.append(",\"recordDate\":\"")
                            .append(recordDate).append('\"');
                    sb.append(",\"orderAmount\":")
                            .append(orderAmount);
                    sb.append(",\"discount\":\"")
                            .append(discount).append('\"');
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

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
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
            }
        }
    }
}
