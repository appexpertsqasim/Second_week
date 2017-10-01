package com.example.tae.second_assignment.network.service;


import com.example.tae.second_assignment.network.model.Music_Model;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by TheAppExperts on 27/09/2017.
 */

public interface reqInterface {


    @GET("?term=rock&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<Music_Model> getRockMusicList();



    @GET("?term=classic&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<Music_Model> getClassicMusicList();



    @GET("?term=pop&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<Music_Model> getPopMusicList();
}
