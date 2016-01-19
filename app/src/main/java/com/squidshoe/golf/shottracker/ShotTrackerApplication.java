package com.squidshoe.golf.shottracker;

import android.app.Application;

/**
 * Created by kkovach on 7/15/15.
 */
public class ShotTrackerApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        mComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {

        return mComponent;
    }
}
