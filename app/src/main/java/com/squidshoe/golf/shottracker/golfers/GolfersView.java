package com.squidshoe.golf.shottracker.golfers;

/**
 * Created by kkovach on 1/17/16.
 */
public interface GolfersView {

    public void showProgress(boolean show);

    public void updateCourses();

    public void navigateToCourse();
}
