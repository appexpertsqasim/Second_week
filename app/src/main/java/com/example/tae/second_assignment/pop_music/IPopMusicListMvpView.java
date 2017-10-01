package com.example.tae.second_assignment.pop_music;


import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.ui.base.MvpView;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IPopMusicListMvpView extends MvpView {
    void onFetchDataCompleted(Music_Model rockMusic_model);
}
