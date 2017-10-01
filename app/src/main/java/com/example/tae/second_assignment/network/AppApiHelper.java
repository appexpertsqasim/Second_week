package com.example.tae.second_assignment.network;


import android.util.Log;

import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.network.service.ConnectionService;
import com.example.tae.second_assignment.network.service.reqInterface;

import io.reactivex.Observable;

/**
 * Created by TAE on 29/09/2017.
 */

public class AppApiHelper implements ApiHelper {
    private reqInterface reqInterface;

    public AppApiHelper(){
        this.reqInterface= ConnectionService.getConnectionService();
    }

    @Override
    public Observable<Music_Model> useCaseRockList() {
        Log.i("~~~~~~~~~~~~~~~~~~~~~", "API CALLED");
        return reqInterface.getRockMusicList();

    }

    @Override
    public Observable<Music_Model> useCaseClassicList() {
        return reqInterface.getClassicMusicList();
    }

    @Override
    public Observable<Music_Model> useCasePopList() {
        return reqInterface.getPopMusicList();
    }
}
