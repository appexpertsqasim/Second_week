package com.example.tae.second_assignment.pop_music;


import com.example.tae.second_assignment.network.DataManager;
import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.ui.base.BasePresenter;
import com.example.tae.second_assignment.ui.utils.rx.SchedulerProvider;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 29/09/2017.
 */

public class PopMusicListPresenter<V extends IPopMusicListMvpView> extends BasePresenter<V> implements IPopMusicListMvpPresenter<V> {
    public PopMusicListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable()
                .add(getDataManager().useCasePopList()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                                .subscribe(new Consumer<Music_Model>() {
                                               @Override
                                               public void accept(@NonNull Music_Model rockMusic_model) throws Exception {
                                                   //getMvpView().onFetchDataCompleted(rockMusic_model);
                                               }
                                           },
                                        new Consumer<Throwable>() {
                                            @Override
                                            public void accept(@NonNull Throwable throwable) throws Exception {

                                            }
                                        }));

    }


}
