package com.example.tae.second_assignment.ui.Classic_Music;


import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.ui.base.MvpView;

/**
 * Created by TAE on 29/09/2017.
 */

public interface IClassicMusicMvpView extends MvpView {
    void onFetchDataCompleted(Music_Model Music_model);
}
