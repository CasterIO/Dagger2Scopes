package io.caster.daggerscopes.screens.profile;

import dagger.Subcomponent;

@ProfileScope
@Subcomponent(modules = { ProfileModule.class })
public interface ProfileComponent {
    void inject(ProfileFragment target);
}
