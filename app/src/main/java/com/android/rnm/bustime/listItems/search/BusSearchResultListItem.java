package com.android.rnm.bustime.listItems.search;

import android.view.View;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.enums.ObjectType;
import com.android.rnm.bustime.models.Bus;
import com.android.rnm.bustime.ui.MainActivity;
import com.android.rnm.bustime.ui.fragments.BusUpdateFragment;

public class BusSearchResultListItem extends SearchResultListItem {

    private Bus mBus;

    public BusSearchResultListItem(Bus bus){
        this.mBus = bus;
    }

    @Override
    public String getId() {
        return mBus.getId();
    }

    @Override
    public int getType() {
        return ObjectType.TYPE_BUS;
    }

    @Override
    public String getName() {
        return mBus.getShortName();
    }

    @Override
    public int getImageRes() {
        return R.drawable.ic_directions_bus_black_24dp;
    }

    @Override
    public void onClick(View v) {
        MainActivity appCompatActivity = (MainActivity) v.getContext();
        appCompatActivity.popBackStack();
        appCompatActivity.addToBackStack(BusUpdateFragment.newInstance(mBus.getId()), BusUpdateFragment.class.getSimpleName());
    }

}
