package com.handpay.sdk.core;

import com.handpay.aidl.Bill;

/**
 *
 * this is use to callback data from smartPos.
 */
public interface ControllerListener {
    /**
     * 交易数据回调
     * @param mBill
     */
    void tranResult(Bill mBill);

    /**
     * 异常
     * @param code
     * @param message
     */
    void Error(int code,String message);

}
