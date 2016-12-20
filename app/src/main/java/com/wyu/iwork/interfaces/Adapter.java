package com.wyu.iwork.interfaces;

import java.util.List;

/**
 * Created by jhj_Plus on 2016/10/27.
 */

public interface Adapter<D> {
    D getItem(int position);

    void addItem(D item, boolean reverse);

    void addItem(int position, D item);

    void addItems(List<D> items, boolean reverse);

    void addItems(int position, List<D> items);

    D removeItem(int position);

    void removeItem(D item);

    void removeItems(List<D> items);

    void setItem(int position, D newItem);
}
