package com.wyu.iwork.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.wyu.iwork.R;

/**
 * Created by jhj_Plus on 2016/10/24.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    protected Toolbar mToolbar;

    public abstract Fragment getFragment();

    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setSupportActionBar(getToolbar());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment content = fragmentManager.findFragmentById(getFragmentContainerId());
        if (content == null) {
            content = getFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, content).commit();
        }
    }

    protected Toolbar getToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        }
        return mToolbar;
    }

    public View setCustomViewForToolbar(int resId) {
        View view = getLayoutInflater().inflate(resId, null);
        setCustomViewForToolbar(view);
        return view;
    }

    public View getCustomViewForToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return null;
        return actionBar.getCustomView();
    }

    public void setCustomViewForToolbar(View view) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        actionBar.setCustomView(view, lp);
    }

}
