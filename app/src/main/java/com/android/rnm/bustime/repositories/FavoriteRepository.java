package com.android.rnm.bustime.repositories;

import com.android.rnm.bustime.dao.FavoriteDao;
import com.android.rnm.bustime.models.Favorite;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;

public class FavoriteRepository {

    private FavoriteDao mFavoriteDao;


    public FavoriteRepository(FavoriteDao favoriteDao){
        this.mFavoriteDao = favoriteDao;

    }


    public Single<List<Favorite>> getAll(){
        return mFavoriteDao.getAll();
    }

    public Single<Long> insert(final Favorite favorite){
        return Single.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mFavoriteDao.insert(favorite);
            }
        });
    }


    public Single<Integer> delete(final Favorite favorite){
        return Single.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return mFavoriteDao.delete(favorite);
            }
        });
    }
}

