package com.android.rnm.bustime.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.rnm.bustime.databases.TrackerDatabase;
import com.android.rnm.bustime.di.components.MainSubComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {MainSubComponent.class})
public class AppModule {

    @Provides
    public Context providesAppContext(Application application){
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    public SharedPreferences providesSharedPreference(Context appContext){
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    @Singleton
    @Provides
    public TrackerDatabase providesDatabase(Context context){
        return Room.databaseBuilder(context, TrackerDatabase.class, "tracker-db")
                .build();
    }
}
