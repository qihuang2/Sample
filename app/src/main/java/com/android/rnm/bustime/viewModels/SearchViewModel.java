package com.android.rnm.bustime.viewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.rnm.bustime.R;
import com.android.rnm.bustime.enums.ScreenState;
import com.android.rnm.bustime.models.Bus;
import com.android.rnm.bustime.models.BusList;
import com.android.rnm.bustime.models.Stop;
import com.android.rnm.bustime.models.StopList;
import com.android.rnm.bustime.listItems.search.BusSearchResultListItem;
import com.android.rnm.bustime.listItems.search.StopSearchResultListItem;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.StopRepository;
import com.android.rnm.bustime.utils.rv.BaseListItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

public class SearchViewModel extends ViewModel{

    private static final int SEARCH_DELAY = 1000;

    private BusRepository mBusRepository;
    private StopRepository mStopRepository;

    private ObservableField<ScreenState> mScreenState;
    private ObservableField<List<BaseListItem>> mListItems;

    private Disposable mCurrentSearch;
    private String mCurrentSearchString;

    public SearchViewModel(BusRepository repository, StopRepository stopRepository){
        this.mBusRepository = repository;
        this.mStopRepository = stopRepository;
        this.mScreenState = new ObservableField<>(ScreenState.IDLE);
        this.mListItems = new ObservableField<>(Collections.<BaseListItem>emptyList());
    }

    public ObservableField<ScreenState> getScreenState() {
        return mScreenState;
    }

    public ObservableField<List<BaseListItem>> getListItems() {
        return mListItems;
    }

    public void search(Context context, String search){
        if (search.isEmpty() || search.equals(mCurrentSearchString)) return;
        mCurrentSearchString = search;

        if (mCurrentSearch != null) mCurrentSearch.dispose();
        mScreenState.set(ScreenState.LOADING);

        final WeakReference<Context> weakReference = new WeakReference<>(context);

        mCurrentSearch = Observable.zip(mBusRepository.getBuses(search).toObservable(),
                mStopRepository.getStops(search).toObservable(),
                new BiFunction<BusList, StopList, List<BaseListItem>>() {
                    @Override
                    public List<BaseListItem> apply(BusList busList, StopList stopList){
                        List<BaseListItem> searchResultListItems = new ArrayList<>();
                        convertBusList(searchResultListItems, busList);
                        convertStopList(searchResultListItems, stopList);

                        return searchResultListItems;
                    }
                }).delay(SEARCH_DELAY, TimeUnit.MILLISECONDS)
                .subscribeOn(io())
                .observeOn(mainThread())
                .singleOrError()
                .subscribe(new Consumer<List<BaseListItem>>() {
                    @Override
                    public void accept(List<BaseListItem> baseListItems) {
                        mListItems.set(baseListItems);
                        mScreenState.set(baseListItems.isEmpty() ? ScreenState.EMPTY : ScreenState.IDLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        throwable.printStackTrace();
                        mScreenState.set(ScreenState.ERROR);
                        mCurrentSearchString = "";

                        if (weakReference.get() != null)
                            Toast.makeText(weakReference.get(), R.string.error_retrieving_search_result,
                                    Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mCurrentSearch != null) mCurrentSearch.dispose();
    }

    List<BaseListItem> convertBusList(List<BaseListItem> result, BusList busList){
        if (busList.getItems() == null) return Collections.emptyList();

        for (Bus bus : busList.getItems()) result.add(new BusSearchResultListItem(bus));
        return result;
    }

    List<BaseListItem> convertStopList(List<BaseListItem> result, StopList stopList){
        if (stopList == null) return Collections.emptyList();

        for (Stop stop : stopList.getItems()) result.add(new StopSearchResultListItem(stop));
        return result;
    }

    public void onTextChanged(View view, CharSequence charSequence) {
        search(view.getContext(), charSequence.toString());
    }

    public void onSearchBarActionClicked(View view, EditText searchBar, ScreenState screenState){
        if (screenState == ScreenState.ERROR){
            search(view.getContext(), searchBar.getText().toString());
        }else if (screenState == ScreenState.IDLE && searchBar.getText().length() != 0){
            searchBar.setText("");
            mScreenState.notifyChange();
        }
    }

    @BindingAdapter(value = {"searchBar","imageState"})
    public static void bindSearchBarAction(ImageView imageView, EditText editText, ScreenState screenState){
        if (screenState == ScreenState.ERROR) {
            imageView.setImageResource(R.drawable.ic_refresh_black_24dp);
        }else if (screenState == ScreenState.IDLE && editText.getText().length() != 0 ){
            imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        }else {
            imageView.setImageResource(0);
        }
    }
}
