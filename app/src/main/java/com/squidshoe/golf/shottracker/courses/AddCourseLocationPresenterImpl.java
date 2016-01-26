package com.squidshoe.golf.shottracker.courses;

import android.view.View;

import com.squidshoe.golf.model.CourseLocation;

/**
 * Created by kkovach on 1/18/16.
 */
public class AddCourseLocationPresenterImpl implements AddCourseLocationPresenter {

    AddCourseLocationView mAddCourseLocationView;

    public AddCourseLocationPresenterImpl(AddCourseLocationView addCourseLocationView) {

        mAddCourseLocationView = addCourseLocationView;
    }

    @Override
    public void add(CourseLocation courseLocation) {

    }

    @Override
    public void onClick(View v) {


    }
}
