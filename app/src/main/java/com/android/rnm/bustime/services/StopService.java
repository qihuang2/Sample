package com.android.rnm.bustime.services;

import com.android.rnm.bustime.models.StopList;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StopService {

    @GET("stops/")
    Single<StopList> getStops();

    @GET("stops/")
    Single<StopList> getStops(@Query("searchByName") String name);

}
