package io.caster.daggerscopes;

import dagger.Component;

@Component(modules = { AppModule.class, AndroidModule.class })
public interface AppComponent {
    void inject(DemoApplication target);
}
