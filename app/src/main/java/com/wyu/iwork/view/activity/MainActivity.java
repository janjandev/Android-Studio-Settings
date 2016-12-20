package com.wyu.iwork.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.wyu.iwork.R;
import com.wyu.iwork.view.fragment.MainFragment;
import com.wyu.iwork.interfaces.TabCallback;
import com.wyu.iwork.utils.Logger;

public class MainActivity extends BaseActivity implements TabCallback {
    private static final String TAG = "MainActivity";

    /**
     * 保存 Toolbar 中间的 customView
     */
    private SparseArray<View> mCustomViews = new SparseArray<>(3);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onTabSelected(0);
    }

    @Override
    public Fragment getFragment() {
        return new MainFragment();
    }

    @Override
    public void onTabSelected(int position) {
        int viewId = 0;
        String title = "";
        switch (position) {
            case 0:
                viewId = R.layout.tab_layout_toolbar_app;
                break;
            case 1:
                viewId = R.layout.tab_layout_toolbar_commu;
                break;
            case 2:
                viewId = R.layout.title_toolbar;
                title = getString(R.string.tab_work);
                break;
            case 3:
                viewId = R.layout.title_toolbar;
                title = getString(R.string.tab_dynamic);
                break;
            case 4:
                viewId = R.layout.title_toolbar;
                title = getString(R.string.tab_my);
                break;
        }

        View customView = mCustomViews.get(viewId);
        if (customView == null) {
            customView = setCustomViewForToolbar(viewId);
            mCustomViews.put(viewId, customView);
            Logger.e(TAG,"onTabSelected///init"+customView);
        } else {
            Logger.e(TAG,"onTabSelected///reuse"+customView);
            setCustomViewForToolbar(customView);
        }

        if (customView instanceof TextView) {
            TextView tv_title = (TextView) customView;
            tv_title.setText(title);
        }
    }

    public View getCustomViewByLayoutId(int layoutResId) {
        return mCustomViews.get(layoutResId);
    }

}
