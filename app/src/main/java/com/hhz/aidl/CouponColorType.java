package com.hhz.aidl;

public enum CouponColorType {
    CouponColorType01("1", R.color.couponColor01),
    CouponColorType02("2", R.color.couponColor02),
    CouponColorType03("3", R.color.couponColor03),
    CouponColorType04("4", R.color.couponColor04),
    CouponColorType05("5", R.color.couponColor05),
    CouponColorType06("6", R.color.couponColor06),
    CouponColorType07("7", R.color.couponColor07),
    CouponColorType08("8", R.color.couponColor08),
    CouponColorType09("9", R.color.couponColor09),
    CouponColorType10("10", R.color.couponColor10);
    // 成员变量
    private String typeId;
    private int resId;

    CouponColorType(String typeId, int resId) {
        this.typeId = typeId;
        this.resId = resId;
    }

    public static int getResID(String typeId) {
        for (CouponColorType c : CouponColorType.values()) {
            if (c.getTypeId().equals(typeId) ) {
                return c.resId;
            }
        }
        return 0;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}