package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

import java.util.List;

public class BusList {

    @Json(name = "items")
    List<Bus> items;

    @Json(name = "total")
    int total;

    @Json(name = "skip")
    int skip;


    @Json(name = "limit")
    int limit;

    public List<Bus> getItems() {
        return items;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }
}
