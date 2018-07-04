package com.android.rnm.bustime.di.components;

import com.android.rnm.bustime.di.modules.FavoritesModule;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.ui.fragments.FavoritesFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerFragment
@Subcomponent(modules = {FavoritesModule.class})
public interface FavoritesSubComponent extends AndroidInjector<FavoritesFragment>{


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FavoritesFragment>{

    }
}
