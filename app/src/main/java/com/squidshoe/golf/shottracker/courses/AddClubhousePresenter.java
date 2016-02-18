package com.squidshoe.golf.shottracker.courses;

import android.content.Context;
import android.util.Log;

import com.squidshoe.golf.model.Clubhouse;
import com.squidshoe.golf.shottracker.MainView;

import rx.functions.Action1;

/**
 * Created by kkovach on 1/18/16.
 */
public class AddClubhousePresenter {

    private static final String TAG = "AddClubhouseImpl";
    private final MainView mMainView;

    AddClubhouseView mAddClubhouseView;
    AddClubhouseInteractor clubhouseInteractor;

    private Clubhouse clubhouse;

    public AddClubhousePresenter(Context context, MainView mainView, AddClubhouseView addClubhouseView) {

        mMainView = mainView;
        mAddClubhouseView = addClubhouseView;
        clubhouseInteractor = new AddClubhouseInteractor(context);
        clubhouse = new Clubhouse();
    }

    public final Action1<CharSequence> actionSetCourseName = new Action1<CharSequence>() {

        @Override
        public void call(CharSequence courseName) {

            clubhouse.name = courseName.toString();
        }
    };

    public final Action1<CharSequence> actionSetCourseAddess = new Action1<CharSequence>() {

        @Override
        public void call(CharSequence courseAddress) {

            Log.i(TAG, "Address is now " + courseAddress);

            clubhouse.address = courseAddress.toString();
        }
    };

    public final Action1<CharSequence> actionSetCourseCity = new Action1<CharSequence>() {

        @Override
        public void call(CharSequence courseCity) {

            clubhouse.city = courseCity.toString();
        }
    };

    public final Action1<CharSequence> actionSetCourseState = new Action1<CharSequence>() {

        @Override
        public void call(CharSequence courseState) {

            clubhouse.state = courseState.toString();
        }
    };

    public final Action1<CharSequence> actionSetCourseZip = new Action1<CharSequence>() {

        @Override
        public void call(CharSequence courseZip) {

            clubhouse.zip = courseZip.toString();
        }
    };

    Action1<Void> actionAddCourse = new Action1<Void>() {

        @Override
        public void call(Void aVoid) {

            clubhouseInteractor.put(clubhouse);
            mMainView.showFragment(new ClubhousesFragment());
            mMainView.setTitle("Courses");
        }
    };
}
