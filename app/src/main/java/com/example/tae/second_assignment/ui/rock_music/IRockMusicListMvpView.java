package com.example.tae.second_assignment.ui.rock_music;


import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.ui.base.MvpView;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IRockMusicListMvpView extends MvpView {
    void onFetchDataCompleted(Music_Model rockMusic_model);
}
