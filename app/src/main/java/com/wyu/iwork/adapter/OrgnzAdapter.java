package com.wyu.iwork.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhj.expandablerecyclerview.adapter.ExpandableAdapter;
import com.jhj.expandablerecyclerview.model.ParentItem;
import com.wyu.iwork.R;
import com.wyu.iwork.adapter.viewholder.CommuOrgnzChildViewHolder;
import com.wyu.iwork.adapter.viewholder.CommuOrgnzParentViewHolder;
import com.wyu.iwork.model.OrgnzChild;
import com.wyu.iwork.model.OrgnzParent;
import com.wyu.iwork.test.Test;

/**
 * Created by jhj_Plus on 2016/10/28.
 */
public class OrgnzAdapter
        extends ExpandableAdapter<CommuOrgnzParentViewHolder, CommuOrgnzChildViewHolder>
{
    private static final String TAG = "OrgnzAdapter";

    private Context mContext;

    public OrgnzAdapter(Context context) {
        super(Test.get());
        mContext = context;
    }

    @Override
    public CommuOrgnzParentViewHolder onCreateParentViewHolder(ViewGroup parent, int parentType) {
        return new CommuOrgnzParentViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_orgnz_parent, parent, false));
    }

    @Override
    public CommuOrgnzChildViewHolder onCreateChildViewHolder(ViewGroup child, int childType) {
        return new CommuOrgnzChildViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_orgnz_child, child, false));
    }

    @Override
    public void onBindParentViewHolder(CommuOrgnzParentViewHolder parentViewHolder,
            int parentPosition, int parentAdapterPosition, ParentItem parentItem)
    {
        parentViewHolder.bind((OrgnzParent) parentItem);
    }

    @Override
    public void onBindChildViewHolder(CommuOrgnzChildViewHolder childViewHolder, int parentPosition,
            int childPosition, int parentAdapterPosition, int childAdapterPosition,
            Object childListItem)
    {
        childViewHolder.bind((OrgnzChild) childListItem);
    }


    public RecyclerView.ItemDecoration getItemDecoration() {
        return new BaseItemDecoration();
    }

    public class BaseItemDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                RecyclerView.State state)
        {

        }
    }

}
