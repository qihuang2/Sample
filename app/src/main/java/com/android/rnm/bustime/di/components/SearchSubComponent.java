package com.android.rnm.bustime.di.components;

import com.android.rnm.bustime.di.modules.SearchModule;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.ui.fragments.SearchFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerFragment
@Subcomponent(modules = SearchModule.class)
public interface SearchSubComponent extends AndroidInjector<SearchFragment>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SearchFragment>{

    }
}
