package com.android.rnm.bustime.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.android.rnm.bustime.utils.rv.BaseListItem;
import com.android.rnm.bustime.utils.rv.SimpleBindingAdapter;

import java.util.List;

public final class BindingAdapters {

    private BindingAdapters(){

    }

    @BindingAdapter({"list"})
    public static void bindSearchList(RecyclerView recyclerView, List<BaseListItem> listItems){
        if (recyclerView.getAdapter() == null){
            recyclerView.setAdapter(new SimpleBindingAdapter());
        }

        SimpleBindingAdapter simpleBindingAdapter = (SimpleBindingAdapter) recyclerView.getAdapter();
        simpleBindingAdapter.setItemList(listItems);
        simpleBindingAdapter.notifyDataSetChanged();
    }
}
