package com.android.rnm.bustime.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.android.rnm.bustime.dao.FavoriteDao;
import com.android.rnm.bustime.models.Favorite;

@Database(entities = {Favorite.class}, version = 1)
public abstract class TrackerDatabase extends RoomDatabase{

    public abstract FavoriteDao favoriteDao();
}
