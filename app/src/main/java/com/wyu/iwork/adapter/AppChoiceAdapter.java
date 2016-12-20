package com.wyu.iwork.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyu.iwork.R;
import com.wyu.iwork.adapter.viewholder.AppChoiceViewHolder;
import com.wyu.iwork.model.TestModel;
import com.wyu.iwork.test.Test;

/**
 * Created by jhj_Plus on 2016/10/26.
 */
public class AppChoiceAdapter extends BaseAdapter<AppChoiceViewHolder,TestModel> {
    private static final String TAG = "AppChoiceAdapter";

    public AppChoiceAdapter(Context context) {
        super(context, Test.getTestData(18));
    }

    @Override
    public AppChoiceViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new AppChoiceViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_app_round_cornor, parent, false));
    }

    @Override
    public void bindData(AppChoiceViewHolder vh, TestModel data) {
        if (data == null) return;
        ((TextView) vh.getView(R.id.name)).setText(data.getName());
    }

    //    @Override
//    public int getItemCount() {
//        return 18;
//    }

    @Override
    protected void getItemOffsets(Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state)
    {
        final int item_offset_2dp = context.getResources().getDimensionPixelSize(
                R.dimen.item_offset_2dp);
        final int item_offset_8dp = context.getResources().getDimensionPixelSize(
                R.dimen.item_offset_8dp);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        final int spanCount = gridLayoutManager.getSpanCount();
        final int childAdapterPos = parent.getChildAdapterPosition(view);
        outRect.set(0, childAdapterPos < spanCount ? item_offset_8dp : 0,
                (childAdapterPos + 1) % spanCount != 0 ? item_offset_2dp : 0,
                getItemCount() - (childAdapterPos + 1) < spanCount ? 0 : item_offset_2dp);
    }


}
