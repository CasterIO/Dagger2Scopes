package io.caster.daggerscopes;

import android.app.Application;

import io.caster.daggerscopes.screens.profile.ProfileComponent;
import io.caster.daggerscopes.screens.profile.ProfileModule;
import io.caster.daggerscopes.screens.settings.SettingsComponent;
import io.caster.daggerscopes.screens.settings.SettingsModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DemoApplication extends Application {

    private AppComponent appComponent;
    private ProfileComponent profileComponent;
    private SettingsComponent settingsComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Set up the data store
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);

        appComponent = createAppComponent();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ProfileComponent createProfileComponent() {
        profileComponent = appComponent.plus(new ProfileModule());
        return profileComponent;
    }

    public void releaseProfileComponent() {
        profileComponent = null;
    }

    public SettingsComponent createSettingsComponent() {
        settingsComponent = appComponent.plus(new SettingsModule());
        return settingsComponent;
    }

    public void releaseSettingsComponent() {
        settingsComponent = null;
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .androidModule(new AndroidModule(this))
                .appModule(new AppModule())
                .build();
    }


}
