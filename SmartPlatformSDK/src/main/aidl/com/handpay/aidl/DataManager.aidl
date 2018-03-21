// IService.aidl
package com.handpay.aidl;
import  com.handpay.aidl.Data;
import  com.handpay.aidl.Bill;
// Declare any non-default types here with import statements

interface DataManager {
    Data getData();
    boolean setData(in Data isData);
    Bill getBill();
    boolean setBill(in Bill isBill);
    String tranferKey(String data,String time);
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
