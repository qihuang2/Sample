package com.android.rnm.bustime.di.modules;

import com.android.rnm.bustime.di.components.BusUpdateSubComponent;
import com.android.rnm.bustime.di.components.FavoritesSubComponent;
import com.android.rnm.bustime.di.components.SearchSubComponent;

import dagger.Module;

@Module(subcomponents = {FavoritesSubComponent.class, SearchSubComponent.class, BusUpdateSubComponent.class})
public class MainModule {


}
