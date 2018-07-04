package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

public class Bus {

    @Json(name = "id")
    String id;

    @Json(name = "color")
    String color;

    @Json(name = "description")
    String description;

    @Json(name = "busId")
    String busId;

    @Json(name = "longName")
    String longName;

    @Json(name = "shortName")
    String shortName;

    @Json(name = "textColor")
    String textColor;

    @Json(name = "activeBuses")
    int activeBuses;


    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getBusId() {
        return busId;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getTextColor() {
        return textColor;
    }

    public int getActiveBuses() {
        return activeBuses;
    }
}
