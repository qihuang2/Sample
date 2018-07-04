package com.android.rnm.bustime.listItems.search;

import android.support.annotation.DrawableRes;
import android.view.View;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.utils.rv.BaseListItem;

public abstract class SearchResultListItem extends BaseListItem {

    public abstract String getId();
    public abstract int getType();
    public abstract String getName();
    @DrawableRes public abstract int getImageRes();
    public abstract void onClick(View v);

    @Override
    public int getLayout(){
        return R.layout.viewholder_search_item;
    }

}
