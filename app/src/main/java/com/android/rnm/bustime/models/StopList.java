package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

import java.util.List;

public class StopList {

    @Json(name = "total")
    int total;

    @Json(name = "items")
    List<Stop> items;

    @Json(name = "skip")
    int skip;

    @Json(name = "limit")
    int limit;


    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public List<Stop> getItems() {
        return items;
    }
}
