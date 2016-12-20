package com.wyu.iwork.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jhj.expandablerecyclerview.adapter.ExpandableAdapter;
import com.wyu.iwork.R;
import com.wyu.iwork.adapter.OrgnzAdapter;
import com.wyu.iwork.adapter.viewholder.CommuOrgnzParentViewHolder;

/**
 * Created by jhj_Plus on 2016/10/25.
 */
public class CommuOrgnzFragment extends BaseFragment {
    private static final String TAG = "MyFragment";
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState)
    {
        ViewGroup content= (ViewGroup) inflater.inflate(R.layout.fragment_commu_orgnz,container,false);
        return super.onCreateView(inflater, content, savedInstanceState);
    }

    @Override
    public void initView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OrgnzAdapter adapter = new OrgnzAdapter(getActivity());
        adapter.addParentExpandCollapseListener(new ExpandableAdapter.OnParentExpandCollapseListener() {

            @Override
            public void onParentExpanded(int parentPosition, int parentAdapterPosition,
                    boolean byUser)
            {
                CommuOrgnzParentViewHolder vh= (CommuOrgnzParentViewHolder) mRecyclerView
                        .findViewHolderForAdapterPosition(parentAdapterPosition);
                if (vh==null) return;
                final ImageView arrow = vh.getView(R.id.indicator);
                final float currRotate=arrow.getRotation();
                //重置为从0开始旋转
                if (currRotate == 360) {
                    arrow.setRotation(0);
                }
                arrow.animate().rotation(180).setDuration(300).start();
                vh.getView(R.id.divider).setVisibility(View.GONE);
            }

            @Override
            public void onParentCollapsed(int parentPosition, int parentAdapterPosition,
                    boolean byUser)
            {
                CommuOrgnzParentViewHolder vh= (CommuOrgnzParentViewHolder) mRecyclerView
                        .findViewHolderForAdapterPosition(parentAdapterPosition);
                if (vh==null) return;
                final ImageView arrow = vh.getView(R.id.indicator);
                final float currRotate=arrow.getRotation();
                float rotate = 360;
                //未展开完全并且当前旋转角度小于180，逆转回去
                if (currRotate < 180) {
                    rotate = 0;
                }
                arrow.animate().rotation(rotate).setDuration(300).start();
                vh.getView(R.id.divider).setVisibility(View.VISIBLE);
            }
        });
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
    }

}
