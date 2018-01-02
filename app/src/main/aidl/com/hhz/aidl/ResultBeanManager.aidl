// ResultBeanManager.aidl
package com.hhz.aidl;

// Declare any non-default types here with import statements
import com.hhz.aidl.ResultBean;
interface ResultBeanManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    ResultBean getResultBean();
    boolean setResultBean(in ResultBean isData);
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
