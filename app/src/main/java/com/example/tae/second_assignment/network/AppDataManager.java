package com.example.tae.second_assignment.network;


import com.example.tae.second_assignment.network.model.Music_Model;

import io.reactivex.Observable;

/**
 * Created by TAE on 29/09/2017.
 */

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;
    public AppDataManager(){this.apiHelper=new AppApiHelper();}
    @Override
    public Observable<Music_Model> useCaseRockList() {
        return apiHelper.useCaseRockList();
    }

    @Override
    public Observable<Music_Model> useCaseClassicList() {
        return apiHelper.useCaseClassicList();
    }

    @Override
    public Observable<Music_Model> useCasePopList() {
        return apiHelper.useCasePopList();
    }

}
