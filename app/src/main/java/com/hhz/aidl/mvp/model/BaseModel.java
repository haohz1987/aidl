package com.hhz.aidl.mvp.model;

import com.hhz.aidl.mvp.IBasePresenter;
import com.hhz.aidl.mvp.IBaseView;

/**
 * Created by haohz on 2017/12/22.
 */

public interface BaseModel {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {


    }
}
