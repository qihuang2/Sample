package com.android.rnm.bustime.repositories;

import com.android.rnm.bustime.models.BusExtendedInfo;
import com.android.rnm.bustime.models.BusList;
import com.android.rnm.bustime.services.BusService;


import io.reactivex.Single;


public class BusRepository {

    private BusService mBusService;

    public BusRepository(BusService busService){
        this.mBusService = busService;
    }

    public Single<BusList> getBuses() {
        return mBusService.getBuses();
    }

    public Single<BusList> getBuses(String name){
        return mBusService.getBuses(name);
    }

    public Single<BusExtendedInfo> getExtendedBusInfo(String busId){
        return mBusService.getBusInfo(busId);
    }


}
