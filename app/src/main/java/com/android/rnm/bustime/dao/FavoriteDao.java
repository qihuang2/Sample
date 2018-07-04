package com.android.rnm.bustime.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.android.rnm.bustime.models.Favorite;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    Single<List<Favorite>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Favorite favorite);

    @Delete
    int delete(Favorite favorite);
}
