package com.android.rnm.bustime.repositories;

import com.android.rnm.bustime.models.BusUpdate;
import com.android.rnm.bustime.services.BusUpdateService;

import java.util.List;

import io.reactivex.Single;

public class BusUpdateRepository {

    private BusUpdateService mBusUpdateService;

    public BusUpdateRepository(BusUpdateService service){
        this.mBusUpdateService = service;
    }

    public Single<List<BusUpdate>> getBusUpdate(String busId){
        return mBusUpdateService.getBusUpdate(busId);
    }

}
