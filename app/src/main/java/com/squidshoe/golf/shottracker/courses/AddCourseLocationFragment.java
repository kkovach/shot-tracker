package com.squidshoe.golf.shottracker.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.squidshoe.golf.shottracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kkovach on 1/17/16.
 */
public class AddCourseLocationFragment extends Fragment implements AddCourseLocationView {

    private static final String TAG = "AddCourseLocationFrag";

    @Bind(R.id.courseName)
    EditText mCourseName;
    @Bind(R.id.courseAddress)
    EditText mCourseAdress;
    @Bind(R.id.courseCity)
    EditText mCourseCity;
    @Bind(R.id.courseState)
    EditText mCouseState;
    @Bind(R.id.courseZip)
    EditText mCourseZip;
    @Bind(R.id.addCourse)
    AppCompatButton mAddCourseButton;

    private AddCourseLocationPresenter addCourseLocationPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_courselocation, container, false);

        ButterKnife.bind(this, view);

        addCourseLocationPresenter = new AddCourseLocationPresenterImpl(this);

        mAddCourseButton.setOnClickListener(addCourseLocationPresenter);

        return view;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void updateCourses() {

    }

    @Override
    public void navigateToCourse() {

    }
}
