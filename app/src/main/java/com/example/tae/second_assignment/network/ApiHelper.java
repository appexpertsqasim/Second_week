package com.example.tae.second_assignment.network;


import com.example.tae.second_assignment.network.model.Music_Model;

import io.reactivex.Observable;

/**
 * Created by TAE on 29/09/2017.
 */

public interface ApiHelper {
Observable<Music_Model> useCaseRockList();
    Observable<Music_Model> useCaseClassicList();
    Observable<Music_Model> useCasePopList();
}
