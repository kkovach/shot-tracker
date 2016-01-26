package com.squidshoe.golf.shottracker.courses;

import android.view.View;

import com.squidshoe.golf.model.CourseLocation;

/**
 * Created by kkovach on 1/18/16.
 */
public interface AddCourseLocationPresenter extends View.OnClickListener {

    void add(CourseLocation courseLocation);

    @Override
    void onClick(View v);
}
