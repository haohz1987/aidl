package com.hhz.aidl.mvp.model;

import com.hhz.aidl.base.IBasePresenter;
import com.hhz.aidl.base.IBaseView;

/**
 * Created by haohz on 2017/12/22.
 */

public interface BaseContract {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {


    }
}
