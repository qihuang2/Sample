package com.android.rnm.bustime.di.components;

import android.app.Application;

import com.android.rnm.bustime.TrackerApplication;
import com.android.rnm.bustime.di.modules.AppModule;
import com.android.rnm.bustime.di.modules.BuildersModule;
import com.android.rnm.bustime.di.modules.NetModule;
import com.android.rnm.bustime.di.modules.RepositoryModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, BuildersModule.class, AppModule.class, NetModule.class, RepositoryModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(TrackerApplication application);

}
