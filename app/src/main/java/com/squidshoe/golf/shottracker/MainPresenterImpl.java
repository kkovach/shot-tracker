package com.squidshoe.golf.shottracker;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.squidshoe.golf.shottracker.courses.AddClubhouseFragment;
import com.squidshoe.golf.shottracker.courses.ClubhousesFragment;
import com.squidshoe.golf.shottracker.golfers.GolfersFragment;

/**
 * Created by kkovach on 1/17/16.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {

        mMainView = mainView;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment;
        String title;

        switch (item.getItemId()) {

            case R.id.navCourses:
                fragment = new ClubhousesFragment();
                title = "Courses";
                break;
            case R.id.navGolfers:
                fragment = new GolfersFragment();
                title = "Golfers";
                break;
            default:
                throw new IllegalStateException("Unknown navigation item: " + item.getTitle());
        }

        mMainView.showFragment(fragment);
        mMainView.setTitle(title);

        mMainView.closeNavigationDrawer();

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        Fragment fragment;
        String title;

        // Handle item selection
        switch (item.getItemId()) {

            case R.id.addCourseLocation:
                fragment = new AddClubhouseFragment();
                mMainView.showFragment(fragment);
                title = "Add Course Contact";
                mMainView.setTitle(title);
                return true;
            default:
                return false;
        }
    }
}
