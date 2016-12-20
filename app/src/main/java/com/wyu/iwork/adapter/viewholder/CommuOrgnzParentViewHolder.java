package com.wyu.iwork.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.jhj.expandablerecyclerview.viewholder.ParentViewHolder;
import com.wyu.iwork.R;
import com.wyu.iwork.model.OrgnzParent;

/**
 * Created by jhj_Plus on 2016/10/28.
 */
public class CommuOrgnzParentViewHolder extends ParentViewHolder<OrgnzParent> {
    private static final String TAG = "CommuOrgnzParentViewHolder";

    public CommuOrgnzParentViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(OrgnzParent data) {
        ((TextView) getView(R.id.name)).setText(data.getName());
        getView(R.id.indicator).setRotation(isExpanded() ? 180 : 0);
        getView(R.id.divider).setVisibility(isExpanded() ? View.GONE : View.VISIBLE);
    }
}
