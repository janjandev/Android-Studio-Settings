package com.wyu.iwork.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by jhj_Plus on 2016/10/26.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder
{
    private static final String TAG = "BaseViewHolder";

    private SparseArray<View> mCachedViews = new SparseArray<>();

    public BaseViewHolder(View itemView) {
        super(itemView);
        init();
    }

    private void init() {
        ViewEventImpl viewEvent=new ViewEventImpl();
        itemView.setOnClickListener(viewEvent);
        int[] viewIds=getRegisterViewClickIds();
        if (viewIds == null || viewIds.length == 0) return;
        for (int id : viewIds) {
             View v=getView(id);
            if (v != null) v.setOnClickListener(viewEvent);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int id) {
        View v = mCachedViews.get(id);
        if (v == null) {
            v = itemView.findViewById(id);
            mCachedViews.put(id, v);
        }
        return (T) v;
    }

    protected int[] getRegisterViewClickIds() {return null;}

    protected void onClick(BaseViewHolder vh, View v, int position) {}

    private class ViewEventImpl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            BaseViewHolder.this.onClick(BaseViewHolder.this, v, getAdapterPosition());
        }
    }

}
