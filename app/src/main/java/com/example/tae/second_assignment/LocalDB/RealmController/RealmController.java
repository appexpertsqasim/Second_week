package com.example.tae.second_assignment.LocalDB.RealmController;

import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.network.model.Result;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmController {
    Realm realm;

    public RealmController(Realm realm) {
        this.realm = realm;
    }

    public void saveResult(final Result result) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(result);
            }
        });
    }
    public ArrayList<Result> getResult(){
        ArrayList<Result>resultArraylist=new ArrayList<>();
        RealmResults<Result> realmResults=realm.where(Result.class).findAll();
        for (Result musicModel : realmResults){
            resultArraylist.add(musicModel);
        }
        return resultArraylist;
    }
    public void saveMusicList(final Result result) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(result);
            }
        });
    }
    public ArrayList<Music_Model> getMusic(){
        ArrayList<Music_Model>musicModelArraylist=new ArrayList<>();
        RealmResults<Music_Model> realmResults=realm.where(Music_Model.class).findAll();
        for (Music_Model musicModel : realmResults){
            musicModelArraylist.add(musicModel);
        }
        return musicModelArraylist;
    }
}
