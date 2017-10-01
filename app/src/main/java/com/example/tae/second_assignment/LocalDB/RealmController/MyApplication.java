package com.example.tae.second_assignment.LocalDB.RealmController;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;



public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration= new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

