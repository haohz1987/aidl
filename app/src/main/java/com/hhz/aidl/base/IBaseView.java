package com.hhz.aidl.base;

import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by luwang on 2017/5/5.
 */

public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 数据为空
     */
    void showNoData();


//    /**
//     * 显示网络错误
//     *
//     * @param onRetryListener 点击监听
//     */
//    void showNetError(EmptyLayout.OnRetryListener onRetryListener);

    /**
     * 绑定生命周期
     *
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();
}
