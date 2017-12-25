package com.hhz.aidl.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.hhz.aidl.R;
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
    public void setToolbar(Toolbar toolbar) {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.toolbar_bg_selector));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.this.finish();
            }
        });
    }

    @Override
    public <t> LifecycleTransformer<t> bindToLife() {
        return this.bindToLifecycle();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        highApiEffects();
//        MyApp.addActivity(this);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
        mContext = this;
        initializeView();
        initializeData();
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void highApiEffects() {
        getWindow().getDecorView().setFitsSystemWindows(true);
        //透明状态栏 @顶部
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getAttributes().verticalMargin = -30;
        //透明导航栏 @底部    这一句不要加，目的是防止沉浸式状态栏和部分底部自带虚拟按键的手机（比如华为）发生冲突，注释掉就好了
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
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
