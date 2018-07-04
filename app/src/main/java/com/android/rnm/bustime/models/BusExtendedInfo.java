package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

public class BusExtendedInfo {

    @Json(name = "agencyId")
    String agencyId;

    @Json(name ="color")
    String color;

    @Json(name = "destinations")
    String[] destination;

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

    @Json(name = "type")
    int type;

    @Json(name = "url")
    String url;

    @Json(name = "standardDirection")
    Route standardDirection;

    @Json(name = "alternateDirection")
    Route alternateDirection;

    @Json(name = "id")
    String id;

    public String getAgencyId() {
        return agencyId;
    }

    public String getColor() {
        return color;
    }

    public String[] getDestination() {
        return destination;
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

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public Route getStandardDirection() {
        return standardDirection;
    }

    public Route getAlternateDirection() {
        return alternateDirection;
    }

    public String getId() {
        return id;
    }
}
