package com.android.rnm.bustime.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.TransitViewModelFactory;
import com.android.rnm.bustime.databinding.FragmentBusUpdateBinding;
import com.android.rnm.bustime.viewModels.BusUpdateViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class BusUpdateFragment extends Fragment{

    public static final String ARG_BUS_ID = "bus_update_bus_id";

    @Inject
    protected TransitViewModelFactory<BusUpdateViewModel> mTransitViewModelFactory;

    private BusUpdateViewModel mBusUpdateViewModel;

    private FragmentBusUpdateBinding mFragmentBusUpdateBinding;


    public static BusUpdateFragment newInstance(String busId){
        BusUpdateFragment fragment = new BusUpdateFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_BUS_ID, busId);
        fragment.setArguments(bundle);
        return fragment;
    }

    public String retrieveBusId(){
        return getArguments().getString(BusUpdateFragment.ARG_BUS_ID);
    }


    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBusUpdateViewModel = ViewModelProviders.of(this, mTransitViewModelFactory).get(BusUpdateViewModel.class);
        mFragmentBusUpdateBinding.setViewModel(mBusUpdateViewModel);
        mBusUpdateViewModel.init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFragmentBusUpdateBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bus_update, container, false);
        return mFragmentBusUpdateBinding.getRoot();
    }
}
