package com.wyu.iwork.presenter;

import com.wyu.iwork.interfaces.IPresenter;

/**
 * Created by jhj_Plus on 2016/10/27.
 */
public class BasePresenter<V> implements IPresenter<V> {
    private static final String TAG = "BasePresenter";

    private V mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

}
