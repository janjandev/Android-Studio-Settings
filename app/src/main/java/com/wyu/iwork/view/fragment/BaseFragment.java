package com.wyu.iwork.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyu.iwork.interfaces.IView;
import com.wyu.iwork.presenter.ComponentPresenter;

/**
 * Created by jhj_Plus on 2016/10/24.
 */
public abstract class BaseFragment extends Fragment implements IView {
    private static final String TAG = "BaseFragment";

    /**
     * 组件 Presenter 基类
     */
    protected ComponentPresenter presenter;

    /**
     * 初化 Fragment contentView
     */
    protected void initView(View rootView){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter != null) presenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState)
    {
        // 需要加载布局嵌入到 container 布局中
        return container;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        if (presenter != null) {
            presenter.loadData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) presenter.detachView();
    }
}
