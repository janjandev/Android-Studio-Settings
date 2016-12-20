package com.wyu.iwork.model;

import com.jhj.expandablerecyclerview.model.ParentItem;

import java.util.List;

/**
 * Created by jhj_Plus on 2016/10/28.
 */
public class OrgnzParent implements ParentItem<OrgnzChild> {
    private static final String TAG = "OrgnzParent";
    private String name;
    private List<OrgnzChild> childItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildItems(List<OrgnzChild> childItems) {
        this.childItems = childItems;
    }

    @Override
    public List<OrgnzChild> getChildItems() {
        return childItems;
    }

    @Override
    public boolean isExpandable() {
        return true;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
