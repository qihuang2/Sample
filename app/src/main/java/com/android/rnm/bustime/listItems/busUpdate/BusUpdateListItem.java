package com.android.rnm.bustime.listItems.busUpdate;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.models.BusUpdate;
import com.android.rnm.bustime.models.Stop;
import com.android.rnm.bustime.utils.rv.BaseListItem;

public class BusUpdateListItem extends BaseListItem {

    private Stop mStop;
    private BusUpdate mBusUpdate;

    public BusUpdateListItem(Stop stop, BusUpdate busUpdate) {
        mStop = stop;
        mBusUpdate = busUpdate;
    }

    public BusUpdate getBusUpdate() {
        return mBusUpdate;
    }

    public Stop getStop() {
        return mStop;
    }

    @Override
    public int getLayout() {
        return R.layout.viewholder_bus_update_item;
    }
}
