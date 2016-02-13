package io.caster.daggerscopes.screens.profile;

import dagger.Module;
import dagger.Provides;
import io.caster.daggerscopes.models.SomeBigObject;

@Module
public class ProfileModule {

    // Profile Screen based dependencies go here

    @Provides
    public SomeBigObject providesSomeBigObject() {
        return new SomeBigObject();
    }
}
