package com.wyu.iwork.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wyu.iwork.adapter.viewholder.BaseViewHolder;
import com.wyu.iwork.interfaces.Adapter;

import java.util.ArrayList;
import java.util.List;

import static com.wyu.iwork.R.dimen.item_offset_8dp;

/**
 * Created by jhj_Plus on 2016/10/24.
 */
public abstract class BaseAdapter<VH extends BaseViewHolder, D> extends RecyclerView.Adapter<VH>
        implements Adapter<D>
{
    private static final String TAG = "BaseAdapter";
    protected Context context;
    List<D> mItems;

    public BaseAdapter(Context context) {
        this(context, null);
    }

    public BaseAdapter(Context context, List<D> items) {
        this.context = context;
        mItems = items == null ? new ArrayList<D>() : items;
    }

    public abstract VH getViewHolder(ViewGroup parent, int viewType);

    public abstract void bindData(VH vh, D data);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        boolean hasData = position < mItems.size();
        bindData(holder, hasData ? mItems.get(position) : null);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public RecyclerView.ItemDecoration getItemDecoration() {
        return new BaseItemDecoration();
    }

    protected void getItemOffsets(Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state)
    {
        outRect.set(0, context.getResources().getDimensionPixelSize(item_offset_8dp), 0, 0);
    }

    public class BaseItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                RecyclerView.State state)
        {
            BaseAdapter.this.getItemOffsets(outRect, view, parent, state);
        }
    }

    @Override
    public D getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public void addItem(D item, boolean reverse) {
        addItem(reverse ? 0 : mItems.size(), item);
    }

    @Override
    public void addItem(int position, D item) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public void addItems(List<D> items, boolean reverse) {
        addItems(reverse ? 0 : mItems.size(), items);
    }

    @Override
    public void addItems(int position, List<D> items) {
        mItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    @Override
    public D removeItem(int position) {
        D removedItem = mItems.remove(position);
        notifyItemRemoved(position);
        return removedItem;
    }

    @Override
    public void removeItem(D item) {
        final int removedPos = mItems.indexOf(item);
        mItems.remove(item);
        notifyItemRemoved(removedPos);
    }

    @Override
    public void removeItems(List<D> items) {
        final int removedPosStart = mItems.indexOf(items.get(0));
        mItems.removeAll(items);
        notifyItemRangeRemoved(removedPosStart, items.size());
    }

    @Override
    public void setItem(int position, D newItem) {
        mItems.set(position, newItem);
        notifyItemChanged(position);
    }
}
