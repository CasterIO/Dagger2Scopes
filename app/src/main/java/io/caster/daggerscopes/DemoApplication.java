package io.caster.daggerscopes;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Set up the data store
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
