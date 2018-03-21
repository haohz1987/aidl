package com.hhz.aidl.base;

/**
 * Created by luwang on 2017/5/5.
 */

public interface IBasePresenter<V> {

    void attachView(V view);

    void detachView();

    V getIView();

}
