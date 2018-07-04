package com.android.rnm.bustime.di.modules;

import com.android.rnm.bustime.di.components.MainSubComponent;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.BusUpdateRepository;
import com.android.rnm.bustime.repositories.StopRepository;
import com.android.rnm.bustime.services.BusService;
import com.android.rnm.bustime.services.BusUpdateService;
import com.android.rnm.bustime.services.StopService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(subcomponents = {MainSubComponent.class})
public class RepositoryModule {

    @Singleton
    @Provides
    public BusRepository providesBusRepository(BusService busService){
        return new BusRepository(busService);
    }

    @Singleton
    @Provides
    public BusService provideBusService(Retrofit retrofit){
        return retrofit.create(BusService.class);
    }


    @Singleton
    @Provides
    public StopService providesStopService(Retrofit retrofit){
        return retrofit.create(StopService.class);
    }

    @Singleton
    @Provides
    public StopRepository providesStopRepository(StopService stopService){
        return new StopRepository(stopService);
    }

    @Singleton
    @Provides
    public BusUpdateService providesBusUpdateService(Retrofit retrofit){
        return retrofit.create(BusUpdateService.class);
    }

    @Singleton
    @Provides
    public BusUpdateRepository providesBusUpdateRepository(BusUpdateService updateService){
        return new BusUpdateRepository(updateService);
    }
}
