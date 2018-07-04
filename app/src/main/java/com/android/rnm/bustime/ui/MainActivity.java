package com.android.rnm.bustime.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.ui.fragments.FavoritesFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction()
                .add(R.id.content, new FavoritesFragment())
                .commit();
    }

    public void addToBackStack(Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    public void popBackStack(){
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingAndroidInjector;
    }
}
