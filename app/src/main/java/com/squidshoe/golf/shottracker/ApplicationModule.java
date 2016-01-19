package com.squidshoe.golf.shottracker;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kkovach on 7/15/15.
 */
@Module
public class ApplicationModule {

    private Application mApp;

    public ApplicationModule(Application app) {

        mApp = app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {

        return PreferenceManager.getDefaultSharedPreferences(mApp);
    }
}
