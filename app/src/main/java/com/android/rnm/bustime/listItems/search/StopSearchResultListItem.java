package com.android.rnm.bustime.listItems.search;

import android.view.View;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.enums.ObjectType;
import com.android.rnm.bustime.models.Stop;

public class StopSearchResultListItem extends SearchResultListItem {

    private Stop mStop;

    public StopSearchResultListItem(Stop stop){
        this.mStop = stop;
    }

    @Override
    public String getId() {
        return mStop.getId();
    }

    @Override
    public int getType() {
        return ObjectType.TYPE_STOP;
    }

    @Override
    public String getName() {
        return mStop.getName();
    }

    @Override
    public int getImageRes() {
        return R.drawable.ic_location_on_black_24dp;
    }

    @Override
    public void onClick(View v) {

    }
}
