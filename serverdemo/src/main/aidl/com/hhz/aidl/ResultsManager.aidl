// ResultBeanManager.aidl
package com.hhz.aidl;

// Declare any non-default types here with import statements
import com.hhz.aidl.Results;
interface ResultsManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Results> getResults();
    boolean setResults(in Results isData);
    void addResult(inout Results result);
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
