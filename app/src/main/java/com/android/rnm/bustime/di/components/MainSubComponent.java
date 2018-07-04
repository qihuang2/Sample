package com.android.rnm.bustime.di.components;

import com.android.rnm.bustime.ui.MainActivity;
import com.android.rnm.bustime.di.modules.MainModule;
import com.android.rnm.bustime.di.scopes.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = {MainModule.class})
public interface MainSubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }
}
