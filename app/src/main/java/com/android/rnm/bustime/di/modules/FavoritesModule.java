package com.android.rnm.bustime.di.modules;

import com.android.rnm.bustime.dao.FavoriteDao;
import com.android.rnm.bustime.databases.TrackerDatabase;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.repositories.FavoriteRepository;
import com.android.rnm.bustime.viewModels.FavoriteViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoritesModule {

    @PerFragment
    @Provides
    public FavoriteDao providesFavoriteDao(TrackerDatabase database){
        return database.favoriteDao();
    }

    @PerFragment
    @Provides
    public FavoriteRepository providesFavoriteRepository(FavoriteDao favoriteDao){
        return new FavoriteRepository(favoriteDao);
    }

    @PerFragment
    @Provides
    public FavoriteViewModel providesFavoriteViewModel(FavoriteRepository repository){
        return new FavoriteViewModel(repository);
    }


}
