package com.android.rnm.bustime.viewModels;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.di.scopes.PerFragment;
import com.android.rnm.bustime.repositories.FavoriteRepository;
import com.android.rnm.bustime.ui.MainActivity;
import com.android.rnm.bustime.ui.fragments.SearchFragment;

import javax.inject.Inject;

public class FavoriteViewModel extends ViewModel {

    private FavoriteRepository mFavoriteRepository;

    public FavoriteViewModel(FavoriteRepository favoriteRepository) {
        this.mFavoriteRepository = favoriteRepository;
    }


    public void onSearchBoxClicked(View view){
        MainActivity activity = (MainActivity) view.getContext();

        activity.addToBackStack(new SearchFragment(), SearchFragment.class.getSimpleName());
    }

}
