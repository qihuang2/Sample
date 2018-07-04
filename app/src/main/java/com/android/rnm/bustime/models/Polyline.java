package com.android.rnm.bustime.models;

import com.squareup.moshi.Json;

public class Polyline {

    @Json(name = "length")
    int length;

    @Json(name = "levels")
    String levels;

    @Json(name = "points")
    String points;
}
