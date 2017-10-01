package com.example.tae.second_assignment.pop_music;


import com.example.tae.second_assignment.ui.base.MvpPresenter;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IPopMusicListMvpPresenter<V extends IPopMusicListMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
}
