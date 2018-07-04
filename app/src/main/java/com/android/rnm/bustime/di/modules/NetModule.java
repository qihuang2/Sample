package com.android.rnm.bustime.di.modules;

import com.android.rnm.bustime.di.components.MainSubComponent;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.StopRepository;
import com.android.rnm.bustime.services.BusService;
import com.android.rnm.bustime.services.StopService;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;

import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(subcomponents = {MainSubComponent.class})
public class NetModule {

    public static final String BASE_URL = "https://api.transittrackr.com";
    public static final String VERSION = "v0";

    public static String getUrl(){
        return BASE_URL +
                "/" +
                VERSION +
                "/";
    }

    @Singleton
    @Provides
    public static Moshi providesMoshi(){
        return new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(Moshi moshi){
        return new Retrofit.Builder()
                .baseUrl(getUrl())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
