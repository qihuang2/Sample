package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

import java.util.List;

public class Route {

    @Json(name = "stops")
    List<Stop> stops;

    @Json(name = "destination")
    String destination;

    @Json(name = "direction")
    int direction;

    @Json(name = "polylines")
    List<Polyline> polylines;

    public List<Stop> getStops() {
        return stops;
    }

    public String getDestination() {
        return destination;
    }

    public int getDirection() {
        return direction;
    }

    public List<Polyline> getPolylines() {
        return polylines;
    }
}
