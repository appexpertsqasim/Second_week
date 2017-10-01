package com.example.tae.second_assignment.ui.Classic_Music;


import com.example.tae.second_assignment.ui.base.MvpPresenter;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IClassicMusicMvpPresenter<V extends IClassicMusicMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
}
