package com.android.rnm.bustime.di.modules;

import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.StopRepository;
import com.android.rnm.bustime.services.BusService;
import com.android.rnm.bustime.services.StopService;
import com.android.rnm.bustime.viewModels.SearchViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class SearchModule {

    @PerFragment
    @Provides
    public SearchViewModel providesSearchViewModel(BusRepository busRepository, StopRepository stopRepository ){
        return new SearchViewModel(busRepository, stopRepository);
    }

}
