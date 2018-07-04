package com.android.rnm.bustime.models;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;


@Entity(primaryKeys = {"id", "type"})
public class Favorite {

    @NonNull
    String id;

    int type;

    String description;

    public Favorite(@NonNull String id, int type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
