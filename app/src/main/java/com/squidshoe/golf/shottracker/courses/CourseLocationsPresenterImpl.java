package com.squidshoe.golf.shottracker.courses;

/**
 * Created by kkovach on 1/18/16.
 */
public class CourseLocationsPresenterImpl implements CourseLocationsPresenter {

    CourseLocationsView mCourseLocationsView;

    public CourseLocationsPresenterImpl(CourseLocationsView courseLocationsView) {

        mCourseLocationsView = courseLocationsView;
    }
}
