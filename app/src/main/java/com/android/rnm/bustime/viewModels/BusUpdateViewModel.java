package com.android.rnm.bustime.viewModels;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;

import com.android.rnm.bustime.enums.ScreenState;
import com.android.rnm.bustime.listItems.busUpdate.BusUpdateListItem;
import com.android.rnm.bustime.models.BusExtendedInfo;
import com.android.rnm.bustime.models.BusUpdate;
import com.android.rnm.bustime.models.Stop;
import com.android.rnm.bustime.repositories.BusRepository;
import com.android.rnm.bustime.repositories.BusUpdateRepository;
import com.android.rnm.bustime.utils.rv.BaseListItem;
import com.android.rnm.bustime.utils.rv.SimpleBindingAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

public class BusUpdateViewModel extends ViewModel{

    private BusRepository mBusRepository;
    private BusUpdateRepository mBusUpdateRepository;
    private String busId;

    private ObservableField<List<BaseListItem>> mStandardDirectionListItems;
    private ObservableField<List<BaseListItem>> mAlternativeDirectionListItems;

    private BusExtendedInfo mBusExtendedInfo;

    private Disposable mInitCall;

    private ObservableField<ScreenState> mScreenState;

    private ObservableBoolean mShowAlternativeRoute;

    public BusUpdateViewModel(BusRepository busRepository, BusUpdateRepository busUpdateRepository,
                              String busId){
        this.mBusRepository = busRepository;
        this.mBusUpdateRepository = busUpdateRepository;
        this.busId = busId;

        this.mStandardDirectionListItems = new ObservableField<>(Collections.<BaseListItem>emptyList());
        this.mAlternativeDirectionListItems = new ObservableField<>(Collections.<BaseListItem>emptyList());
        this.mScreenState = new ObservableField<>(ScreenState.IDLE);
        this.mShowAlternativeRoute = new ObservableBoolean(false);
    }

    public void init(){
        mScreenState.set(ScreenState.LOADING);
        mInitCall = Observable.zip(mBusRepository.getExtendedBusInfo(busId).toObservable(),
                mBusUpdateRepository.getBusUpdate(busId).toObservable(),
                new BiFunction<BusExtendedInfo, List<BusUpdate>, List<BaseListItem>[]>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List<BaseListItem>[] apply(BusExtendedInfo busExtendedInfo, List<BusUpdate> busUpdates){
                        mBusExtendedInfo = busExtendedInfo;

                        Map<String, BusUpdate> updateMap = createUpdateMap(busUpdates);
                        return (List<BaseListItem>[]) new List[]{
                                convertToListItems(busExtendedInfo.getStandardDirection().getStops(), updateMap),
                                convertToListItems(busExtendedInfo.getAlternateDirection().getStops(), updateMap)
                        };
                    }
                }).subscribeOn(io())
                .observeOn(mainThread())
                .singleOrError()
                .subscribe(new Consumer<List<BaseListItem>[]>() {
                    @Override
                    public void accept(List<BaseListItem>[] lists) {
                        mStandardDirectionListItems.set(lists[0]);
                        mAlternativeDirectionListItems.set(lists[1]);
                        mScreenState.set(ScreenState.IDLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mScreenState.set(ScreenState.ERROR);
                        throwable.printStackTrace();
                    }
                });
    }

    public ObservableBoolean getShowAlternativeRoute() {
        return mShowAlternativeRoute;
    }

    public ObservableField<List<BaseListItem>> getStandardDirectionListItems() {
        return mStandardDirectionListItems;
    }

    public ObservableField<List<BaseListItem>> getAlternativeDirectionListItems() {
        return mAlternativeDirectionListItems;
    }

    public ObservableField<ScreenState> getScreenState() {
        return mScreenState;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        if (mInitCall != null) {
            mInitCall.dispose();
            mInitCall = null;
        }
    }

    protected List<BaseListItem> convertToListItems(List<Stop> stops, Map<String, BusUpdate> updateMap){
        List<BaseListItem> listItems = new ArrayList<>();
        for (Stop stop : stops){
            listItems.add(new BusUpdateListItem(stop, updateMap.get(stop.getId())));
        }

        return listItems;
    }

    protected Map<String, BusUpdate> createUpdateMap(List<BusUpdate> busUpdates){
        Map<String, BusUpdate> updateMap = new HashMap<>();

        for (BusUpdate update : busUpdates){
            // don't override repeats. only show first
            if (!updateMap.containsKey(update.getStopId())) updateMap.put(update.getStopId(), update);
        }

        return updateMap;
    }

    @BindingAdapter({"showAlternativeList","standardDirection", "alternativeDirection"})
    public static void bindBusUpdateRecycler(RecyclerView recyclerView,
                                             boolean showAlternativeList,
                                             List<BaseListItem> standardDirection,
                                             List<BaseListItem> alternativeList){
        if (recyclerView.getAdapter() == null){
            recyclerView.setAdapter(new SimpleBindingAdapter());
        }

        SimpleBindingAdapter adapter = (SimpleBindingAdapter) recyclerView.getAdapter();
        adapter.setItemList(showAlternativeList ? alternativeList : standardDirection);
        adapter.notifyDataSetChanged();
    }

}
