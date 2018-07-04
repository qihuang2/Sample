package com.android.rnm.bustime.repositories;

import com.android.rnm.bustime.models.StopList;
import com.android.rnm.bustime.services.StopService;

import io.reactivex.Single;

public class StopRepository {

    private StopService mStopService;

    public StopRepository(StopService stopService){
        this.mStopService = stopService;
    }

    public Single<StopList> getStops(){
        return mStopService.getStops();
    }

    public Single<StopList> getStops(String name){
        return mStopService.getStops(name);
    }
}
