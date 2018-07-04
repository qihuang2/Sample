package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

import java.util.List;

public class Stop {

    @Json(name = "direction")
    String direction;

    @Json(name = "coordinates")
    Coordinate coordinates;

    @Json(name = "buses")
    List<String> buses;

    @Json(name = "id")
    String id;

    @Json(name = "name")
    String name;

    @Json(name = "stopId")
    String stopId;

    public String getDirection() {
        return direction;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public List<String> getBuses() {
        return buses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStopId() {
        return stopId;
    }
}
