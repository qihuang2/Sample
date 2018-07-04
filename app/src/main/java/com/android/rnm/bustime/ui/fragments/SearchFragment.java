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

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.TransitViewModelFactory;
import com.android.rnm.bustime.databinding.FragmentSearchBinding;
import com.android.rnm.bustime.utils.Utils;
import com.android.rnm.bustime.viewModels.SearchViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SearchFragment extends Fragment {

    @Inject
    protected TransitViewModelFactory<SearchViewModel> mTransitViewModelFactory;

    protected SearchViewModel mSearchViewModel;

    protected FragmentSearchBinding mFragmentSearchBinding;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSearchViewModel = ViewModelProviders.of(this, mTransitViewModelFactory).get(SearchViewModel.class);
        mFragmentSearchBinding.setViewModel(mSearchViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search,
                container, false);
        return mFragmentSearchBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragmentSearchBinding.searchBox.requestFocus();
        Utils.showKeyboard(getContext(), mFragmentSearchBinding.searchBox);
    }

    @Override
    public void onPause() {
        super.onPause();
        Utils.hideKeyboard(getContext(), mFragmentSearchBinding.searchBox);
    }
}
