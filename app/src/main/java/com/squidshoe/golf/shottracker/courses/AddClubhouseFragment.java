package com.squidshoe.golf.shottracker.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.squidshoe.golf.model.Clubhouse;
import com.squidshoe.golf.shottracker.MainView;
import com.squidshoe.golf.shottracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kkovach on 1/17/16.
 */
public class AddClubhouseFragment extends Fragment implements AddClubhouseView {

    private static final String TAG = "AddClubhouseFragment";

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

    Clubhouse mClubhouse;

    private AddClubhousePresenter mAddClubhousePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_clubhouse, container, false);

        ButterKnife.bind(this, view);

        mAddClubhousePresenter = new AddClubhousePresenter(getActivity(), (MainView) getActivity(), this);

        RxTextView.textChanges(mCourseName).subscribe(mAddClubhousePresenter.actionSetCourseName);
        RxTextView.textChanges(mCourseAdress).subscribe(mAddClubhousePresenter.actionSetCourseAddess);
        RxTextView.textChanges(mCourseCity).subscribe(mAddClubhousePresenter.actionSetCourseCity);
        RxTextView.textChanges(mCouseState).subscribe(mAddClubhousePresenter.actionSetCourseState);
        RxTextView.textChanges(mCourseZip).subscribe(mAddClubhousePresenter.actionSetCourseZip);
        RxView.clicks(mAddCourseButton).subscribe(mAddClubhousePresenter.actionAddCourse);

        return view;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void updateClubhouse() {

    }

    @Override
    public void navigateToClubhouse() {

    }
}
