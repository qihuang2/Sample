package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

public class Coordinate {

    @Json(name = "long")
    public final double longitude;

    @Json(name = "lat")
    public final double latitude;

    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
