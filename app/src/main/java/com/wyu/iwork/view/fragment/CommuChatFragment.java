package com.wyu.iwork.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyu.iwork.R;
import com.wyu.iwork.adapter.CommuChatAdapter;

/**
 * Created by jhj_Plus on 2016/10/25.
 */
public class CommuChatFragment extends BaseFragment {
    private static final String TAG = "MyFragment";
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState)
    {
        ViewGroup content= (ViewGroup) inflater.inflate(R.layout.fragment_commu_chat,container,false);
        return super.onCreateView(inflater, content, savedInstanceState);
    }

    @Override
    public void initView(View rootView) {
        mRecyclerView= (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CommuChatAdapter adapter = new CommuChatAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
    }


}
