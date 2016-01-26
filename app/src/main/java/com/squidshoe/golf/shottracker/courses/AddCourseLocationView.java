package com.squidshoe.golf.shottracker.courses;

/**
 * Created by kkovach on 1/17/16.
 */
public interface AddCourseLocationView {

    public void showProgress(boolean show);

    public void updateCourses();

    public void navigateToCourse();
}
