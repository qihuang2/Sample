package com.android.rnm.bustime.di.components;

import com.android.rnm.bustime.di.modules.BusUpdateModule;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.ui.fragments.BusUpdateFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerFragment
@Subcomponent(modules = {BusUpdateModule.class})
public interface BusUpdateSubComponent extends AndroidInjector<BusUpdateFragment>{


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BusUpdateFragment>{

    }

}
