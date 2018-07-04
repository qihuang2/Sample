package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

import java.util.Date;

public class BusUpdate {

    @Json(name = "location")
    Location location;

    @Json(name = "stopId")
    String stopId;

    @Json(name = "description")
    String description;

    @Json(name = "eta")
    Date eta;

    @Json(name = "etd")
    Date etd;

    @Json(name = "distanceFromStop")
    int distanceFromStop;

    @Json(name = "stopsAway")
    int stopsAway;


    public Location getLocation() {
        return location;
    }

    public String getStopId() {
        return stopId;
    }

    public String getDescription() {
        return description;
    }

    public Date getEta() {
        return eta;
    }

    public Date getEtd() {
        return etd;
    }

    public int getDistanceFromStop() {
        return distanceFromStop;
    }

    public int getStopsAway() {
        return stopsAway;
    }
}
