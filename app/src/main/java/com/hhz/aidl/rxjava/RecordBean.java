package com.hhz.aidl.rxjava;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohz on 2017/12/22.
 */

public class RecordBean implements Parcelable{

    /**
     * respCode : 0000
     * respMsg : 请求成功
     * logo : http://api.map.baidu.com/images/weather/day/duoyun.png
     * mechantName : 商户01
     * mechantId : 0123456789
     * result : {"cancelRecord":{"recordType":1,"recordCount":2,"recordList":[{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]},"provideRecord":{"recordType":2,"recordCount":2,"recordList":[{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}}
     */

    private String respCode;
    private String respMsg;
    private String logo;
    private String mechantName;
    private String mechantId;
    private ResultBean result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"result\":")
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
        sb.append('}');
        return sb.toString();
    }

    protected RecordBean(Parcel in) {
        respCode = in.readString();
        respMsg = in.readString();
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
    }

    public static class ResultBean implements Parcelable{
        /**
         * cancelRecord : {"recordType":1,"recordCount":2,"recordList":[{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}
         * provideRecord : {"recordType":2,"recordCount":2,"recordList":[{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]}
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
             * recordList : [{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]
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
                 * coupType : 1
                 * serialNo : 123456789
                 * coupNo : 12345678922
                 * orderAmount : 53.23
                 * coupAmount : 10
                 * discount :
                 * consumeLite : 100
                 * usedCount : 5
                 * usedLimit : 1
                 */

                private String recordDate;
                private int coupType;
                private String serialNo;
                private String coupNo;
                private double orderAmount;
                private int coupAmount;
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
                    sb.append(",\"coupType\":")
                            .append(coupType);
                    sb.append(",\"coupNo\":\"")
                            .append(coupNo).append('\"');
                    sb.append(",\"coupAmount\":")
                            .append(coupAmount);
                    sb.append(",\"consumeLite\":")
                            .append(consumeLite);
                    sb.append('}');
                    return sb.toString();
                }

                protected RecordListBean(Parcel in) {
                    recordDate = in.readString();
                    coupType = in.readInt();
                    serialNo = in.readString();
                    coupNo = in.readString();
                    orderAmount = in.readDouble();
                    coupAmount = in.readInt();
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

                public int getCoupType() {
                    return coupType;
                }

                public void setCoupType(int coupType) {
                    this.coupType = coupType;
                }

                public String getSerialNo() {
                    return serialNo;
                }

                public void setSerialNo(String serialNo) {
                    this.serialNo = serialNo;
                }

                public String getCoupNo() {
                    return coupNo;
                }

                public void setCoupNo(String coupNo) {
                    this.coupNo = coupNo;
                }

                public double getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(double orderAmount) {
                    this.orderAmount = orderAmount;
                }

                public int getCoupAmount() {
                    return coupAmount;
                }

                public void setCoupAmount(int coupAmount) {
                    this.coupAmount = coupAmount;
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
                    dest.writeInt(coupType);
                    dest.writeString(serialNo);
                    dest.writeString(coupNo);
                    dest.writeDouble(orderAmount);
                    dest.writeInt(coupAmount);
                    dest.writeString(discount);
                    dest.writeInt(consumeLite);
                    dest.writeInt(usedCount);
                    dest.writeInt(usedLimit);
                }
            }
        }

        public static class ProvideRecordBean implements Parcelable{
            /**
             * recordType : 2
             * recordCount : 2
             * recordList : [{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":10,"discount":"","consumeLite":100,"usedCount":5,"usedLimit":1},{"recordDate":"201712181033","coupType":1,"serialNo":"123456789","coupNo":"12345678922","orderAmount":53.23,"coupAmount":0,"discount":"8折","consumeLite":100,"usedCount":5,"usedLimit":1}]
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
                sb.append(",\"describeContents\":")
                        .append(describeContents());
                sb.append('}');
                return sb.toString();
            }

            protected ProvideRecordBean(Parcel in) {
                recordType = in.readInt();
                recordCount = in.readInt();
                recordList = in.createTypedArrayList(RecordListBeanX.CREATOR);
            }

            public static final Creator<ProvideRecordBean> CREATOR = new Creator<ProvideRecordBean>() {
                @Override
                public ProvideRecordBean createFromParcel(Parcel in) {
                    return new ProvideRecordBean(in);
                }

                @Override
                public ProvideRecordBean[] newArray(int size) {
                    return new ProvideRecordBean[size];
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

            public List<RecordListBeanX> getRecordList() {
                return recordList;
            }

            public void setRecordList(List<RecordListBeanX> recordList) {
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
                dest.writeTypedList(recordList);
            }

            public static class RecordListBeanX implements Parcelable{
                /**
                 * recordDate : 201712181033
                 * coupType : 1
                 * serialNo : 123456789
                 * coupNo : 12345678922
                 * orderAmount : 53.23
                 * coupAmount : 10
                 * discount :
                 * consumeLite : 100
                 * usedCount : 5
                 * usedLimit : 1
                 */

                private String recordDate;
                private int coupType;
                private String serialNo;
                private String coupNo;
                private double orderAmount;
                private int coupAmount;
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
                    sb.append(",\"coupType\":")
                            .append(coupType);
                    sb.append(",\"coupNo\":\"")
                            .append(coupNo).append('\"');
                    sb.append(",\"coupAmount\":")
                            .append(coupAmount);
                    sb.append(",\"consumeLite\":")
                            .append(consumeLite);
                    sb.append('}');
                    return sb.toString();
                }

                protected RecordListBeanX(Parcel in) {
                    recordDate = in.readString();
                    coupType = in.readInt();
                    serialNo = in.readString();
                    coupNo = in.readString();
                    orderAmount = in.readDouble();
                    coupAmount = in.readInt();
                    discount = in.readString();
                    consumeLite = in.readInt();
                    usedCount = in.readInt();
                    usedLimit = in.readInt();
                }

                public static final Creator<RecordListBeanX> CREATOR = new Creator<RecordListBeanX>() {
                    @Override
                    public RecordListBeanX createFromParcel(Parcel in) {
                        return new RecordListBeanX(in);
                    }

                    @Override
                    public RecordListBeanX[] newArray(int size) {
                        return new RecordListBeanX[size];
                    }
                };

                public String getRecordDate() {
                    return recordDate;
                }

                public void setRecordDate(String recordDate) {
                    this.recordDate = recordDate;
                }

                public int getCoupType() {
                    return coupType;
                }

                public void setCoupType(int coupType) {
                    this.coupType = coupType;
                }

                public String getSerialNo() {
                    return serialNo;
                }

                public void setSerialNo(String serialNo) {
                    this.serialNo = serialNo;
                }

                public String getCoupNo() {
                    return coupNo;
                }

                public void setCoupNo(String coupNo) {
                    this.coupNo = coupNo;
                }

                public double getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(double orderAmount) {
                    this.orderAmount = orderAmount;
                }

                public int getCoupAmount() {
                    return coupAmount;
                }

                public void setCoupAmount(int coupAmount) {
                    this.coupAmount = coupAmount;
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
                    dest.writeInt(coupType);
                    dest.writeString(serialNo);
                    dest.writeString(coupNo);
                    dest.writeDouble(orderAmount);
                    dest.writeInt(coupAmount);
                    dest.writeString(discount);
                    dest.writeInt(consumeLite);
                    dest.writeInt(usedCount);
                    dest.writeInt(usedLimit);
                }
            }
        }
    }
}
