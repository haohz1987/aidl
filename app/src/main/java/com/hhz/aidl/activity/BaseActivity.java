package com.hhz.aidl.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hhz.aidl.mvp.BasePresenterImpl;
import com.hhz.aidl.mvp.IBaseView;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;

/**
 * Created by haohz on 2017/12/22.
 */

public abstract class BaseActivity<V extends IBaseView, T extends BasePresenterImpl<V>> extends RxAppCompatActivity
        implements IBaseView{
    protected T mPresenter;
    public Context mContext;

    private <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | ClassCastException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <t> LifecycleTransformer<t> bindToLife() {
        return this.bindToLifecycle();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
//        MyApp.addActivity(this);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
        mContext = this;
        initializeView();
        initializeData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        MyApp.finishActivity(this);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void initializeView();

    protected abstract void initializeData();
}
