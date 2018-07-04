package com.android.rnm.bustime.services;

import com.android.rnm.bustime.models.BusUpdate;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusUpdateService {

    @GET("bus-activity/{id}")
    Single<List<BusUpdate>> getBusUpdate(@Path("id") String busId);

}
