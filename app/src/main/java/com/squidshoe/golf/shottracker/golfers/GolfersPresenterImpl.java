package com.squidshoe.golf.shottracker.golfers;

/**
 * Created by kkovach on 1/18/16.
 */
public class GolfersPresenterImpl implements GolfersPresenter {

    GolfersView mCourseLocationsView;

    public GolfersPresenterImpl(GolfersView courseLocationsView) {

        mCourseLocationsView = courseLocationsView;
    }
}
