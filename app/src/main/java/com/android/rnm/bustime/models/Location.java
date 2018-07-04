package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

public class Location {

    @Json(name = "longitude")
    double longitude;

    @Json(name = "latitude")
    double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
