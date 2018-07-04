package com.android.rnm.bustime.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.TransitViewModelFactory;
import com.android.rnm.bustime.databinding.FragmentFavoritesBinding;
import com.android.rnm.bustime.utils.Utils;
import com.android.rnm.bustime.viewModels.FavoriteViewModel;


import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class FavoritesFragment extends Fragment {

    @Inject
    protected TransitViewModelFactory<FavoriteViewModel> mTransitViewModelFactory;

    protected FavoriteViewModel mFavoriteViewModel;

    protected FragmentFavoritesBinding mFragmentFavoritesBinding;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFavoriteViewModel = ViewModelProviders.of(this, mTransitViewModelFactory).get(FavoriteViewModel.class);
        mFragmentFavoritesBinding.setViewModel(mFavoriteViewModel);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFragmentFavoritesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites,
                container, false);

        return mFragmentFavoritesBinding.getRoot();

    }
}
