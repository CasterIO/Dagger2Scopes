package io.caster.daggerscopes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    private final Context context;

    public AndroidModule(Application app) {
        this.context = app;
    }

    @Provides
    public Context providesContext() {
        return context;
    }

    @Provides
    public Resources providesResources(Context context) {
        return context.getResources();
    }

    @Provides
    public SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    /**
     * Make it easy to get a system service.
     * @param context The context
     * @param serviceConstant The name of the service. Such as {@code Context.ALARM_SERVICE}
     * @param <T> The type
     * @return An instance of the type.
     */
    @SuppressWarnings("unchecked")
    public <T> T getSystemService(Context context, String serviceConstant) {
        return (T) context.getSystemService(serviceConstant);
    }
}
