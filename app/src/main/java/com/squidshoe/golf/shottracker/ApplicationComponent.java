package com.squidshoe.golf.shottracker;

import com.squidshoe.golf.shottracker.courses.AddClubhouseInteractor;
import com.squidshoe.golf.shottracker.db.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kkovach on 7/15/15.
 */
@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(ShotTrackerApplication app);
    void inject(MainActivity activity);
    void inject(AddClubhouseInteractor persistenceEngine);
}
