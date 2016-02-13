package io.caster.daggerscopes.screens.settings;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {
    // All settings screen dependencies go here

    @Provides
    public SettingsService provideSettingsService() {
        return new SettingsServiceImpl();
    }
}
