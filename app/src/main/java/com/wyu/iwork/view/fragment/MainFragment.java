package com.wyu.iwork.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wyu.iwork.R;
import com.wyu.iwork.interfaces.TabCallback;
import com.wyu.iwork.utils.Logger;

/**
 * Created by jhj_Plus on 2016/10/24.
 */
public class MainFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "MainFragment";
    private static final int TAB_COUNT = 5;
    private TabCallback mCallback;

    private ViewPager mViewPager;
    private RadioGroup mTabGroup;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TabCallback) {
            mCallback= (TabCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    public void initView(View rootView) {
        mTabGroup = (RadioGroup) rootView.findViewById(R.id.tabGroup);
        for (int i = 0; i < mTabGroup.getChildCount(); i++) {
            ((RadioButton) mTabGroup.getChildAt(i)).setOnCheckedChangeListener(this);
        }
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            final int position=mTabGroup.indexOfChild(buttonView);
            if (mCallback != null) {
                Logger.e(TAG, "onCheckedChanged=" + position);
                mCallback.onTabSelected(position);
            }
            mViewPager.setCurrentItem(position, false);
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Logger.e(TAG,"getItem=>"+position);
            switch (position) {
                case 0:
                    return new AppFragment();
                case 1:
                    return new CommuFragment();
                case 2:
                    return new WorkFragment();
                case 3:
                    return new DynamicFragment();
                case 4:
                    return new MyFragment();
            }
            return new AppFragment();
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }
}
