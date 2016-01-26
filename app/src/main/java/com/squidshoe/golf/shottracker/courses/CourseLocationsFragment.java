package com.squidshoe.golf.shottracker.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squidshoe.golf.shottracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kkovach on 1/17/16.
 */
public class CourseLocationsFragment extends Fragment implements CourseLocationsView {

    @Bind(R.id.courseContactList)
    RecyclerView mCourseContactList;

    private CourseLocationsPresenter mCourseLocationsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courselocation_list, container, false);

        ButterKnife.bind(this, view);

        mCourseLocationsPresenter = new CourseLocationsPresenterImpl(this);

        mCourseContactList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCourseContactList.setAdapter(new CourseLocationsAdapter(null));

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
