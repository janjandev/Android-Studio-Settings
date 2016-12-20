package com.wyu.iwork.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyu.iwork.R;
import com.wyu.iwork.adapter.viewholder.AppChoiceViewHolder;
import com.wyu.iwork.model.TestModel;

/**
 * Created by jhj_Plus on 2016/10/26.
 */
public class CommuChatAdapter extends BaseAdapter<AppChoiceViewHolder,TestModel> {
    private static final String TAG = "AppChoiceAdapter";

    public CommuChatAdapter(Context context) {
        super(context);
    }

    @Override
    public AppChoiceViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new AppChoiceViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false));
    }

    @Override
    public void bindData(AppChoiceViewHolder vh, TestModel data) {
        if (vh.getAdapterPosition() == getItemCount() - 1) {
            vh.getView(R.id.divider).setVisibility(View.GONE);
        }
        if (data == null) return;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    protected void getItemOffsets(Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state)
    {
    }

}
