package com.example.tae.second_assignment.ui.rock_music;


import com.example.tae.second_assignment.ui.base.MvpPresenter;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IRockMusicListMvpPresenter<V extends IRockMusicListMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
}
