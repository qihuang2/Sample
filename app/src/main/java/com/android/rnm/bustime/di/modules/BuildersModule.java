package com.android.rnm.bustime.di.modules;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.rnm.bustime.di.components.BusUpdateSubComponent;
import com.android.rnm.bustime.di.components.FavoritesSubComponent;
import com.android.rnm.bustime.di.components.SearchSubComponent;
import com.android.rnm.bustime.ui.MainActivity;
import com.android.rnm.bustime.di.components.MainSubComponent;
import com.android.rnm.bustime.ui.fragments.BusUpdateFragment;
import com.android.rnm.bustime.ui.fragments.FavoritesFragment;
import com.android.rnm.bustime.ui.fragments.SearchFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainSubComponent.Builder builder);


    @Binds
    @IntoMap
    @FragmentKey(FavoritesFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindsFavoritesFragmentInjectorFactory(FavoritesSubComponent.Builder builder);


    @Binds
    @IntoMap
    @FragmentKey(SearchFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindsSearchFragmentInjectorFactory(SearchSubComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(BusUpdateFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindsBusUpdateFragmentInjectorFactory(BusUpdateSubComponent.Builder builder);
}
