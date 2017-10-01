package com.example.tae.second_assignment.network.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.tae.second_assignment.network.model.API_Constants;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TheAppExperts on 27/09/2017.
 */

    public class ConnectionService {

    static Retrofit retrofit;
    private static reqInterface varReqInter;
    Context app;
    Toast toast;

        public static reqInterface getConnectionService(){

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(reqInterface.class);
        }
    public void reactiveNetwork(){
        ReactiveNetwork.observeNetworkConnectivity(app)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Connectivity>() {
                    @Override public void accept(final Connectivity connectivity) {
                        toast.makeText(app, connectivity.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Connection", connectivity.toString());

                    }
                });

    }


}
