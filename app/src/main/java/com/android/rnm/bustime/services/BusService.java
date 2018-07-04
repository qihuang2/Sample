package com.android.rnm.bustime.services;

import com.android.rnm.bustime.models.BusList;
import com.android.rnm.bustime.models.BusExtendedInfo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BusService {

    @GET("buses/")
    Single<BusList> getBuses();

    @GET("buses/")
    Single<BusList> getBuses(@Query("searchByShortName") String shortName);

    @GET("buses/{id}")
    Single<BusExtendedInfo> getBusInfo(@Path("id") String busId);
}
