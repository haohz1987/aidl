package com.hhz.aidl.base;

import java.lang.ref.WeakReference;

/**
 * Created by luwang on 2017/5/5.
 */

public class BasePresenterImpl<V> implements IBasePresenter<V> {

    protected WeakReference<V> mView;

    @Override
    public void attachView(V view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if(mView != null){
            mView.clear();
        }
    }

    @Override
    public V getIView() {
        return mView != null ? mView.get() : null;
    }



}
