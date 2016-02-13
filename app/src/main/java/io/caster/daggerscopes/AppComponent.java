package io.caster.daggerscopes;

import javax.inject.Singleton;

import dagger.Component;
import io.caster.daggerscopes.screens.profile.ProfileComponent;
import io.caster.daggerscopes.screens.profile.ProfileModule;
import io.caster.daggerscopes.screens.settings.SettingsComponent;
import io.caster.daggerscopes.screens.settings.SettingsModule;

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class})
public interface AppComponent {
    void inject(DemoApplication target);

    ProfileComponent plus(ProfileModule ProfileModule);

    SettingsComponent plus(SettingsModule settingsModule);
}
