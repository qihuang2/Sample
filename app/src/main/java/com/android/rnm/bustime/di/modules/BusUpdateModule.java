package com.android.rnm.bustime.di.modules;


import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.BusUpdateRepository;
import com.android.rnm.bustime.ui.fragments.BusUpdateFragment;
import com.android.rnm.bustime.viewModels.BusUpdateViewModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class BusUpdateModule {

    @PerFragment
    @Provides
    @Named("busId")
    public String providesBusId(BusUpdateFragment fragment){
        return fragment.retrieveBusId();
    }

    @PerFragment
    @Provides
    public BusUpdateViewModel providesBusUpdate(BusRepository busRepository, BusUpdateRepository busUpdateRepository,
                                                @Named("busId") String busId){
        return new BusUpdateViewModel(busRepository, busUpdateRepository, busId);
    }

}
