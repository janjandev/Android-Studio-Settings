package com.wyu.iwork.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jhj.expandablerecyclerview.viewholder.ChildViewHolder;
import com.wyu.iwork.R;
import com.wyu.iwork.model.OrgnzChild;

/**
 * Created by jhj_Plus on 2016/10/28.
 */
public class CommuOrgnzChildViewHolder extends ChildViewHolder<OrgnzChild> {
    private static final String TAG = "CommuOrgnzChildViewHolder";

    public CommuOrgnzChildViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(OrgnzChild data) {
        ((TextView) getView(R.id.name)).setText(data.getName());
        ((ImageView)getView(R.id.head)).setImageResource(data.getHead());
        ((TextView) getView(R.id.tel)).setText(data.getTel());
    }
}
