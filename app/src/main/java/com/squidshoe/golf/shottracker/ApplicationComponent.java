package com.squidshoe.golf.shottracker;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kkovach on 7/15/15.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(ShotTrackerApplication app);
    void inject(MainActivity activity);
}
