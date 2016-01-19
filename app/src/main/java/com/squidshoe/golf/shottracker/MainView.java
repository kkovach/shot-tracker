package com.squidshoe.golf.shottracker;

import android.support.v4.app.Fragment;

/**
 * Created by kkovach on 1/17/16.
 */
public interface MainView {

    void closeNavigationDrawer();

    void showFragment(Fragment fragment);

    void setTitle(String title);
}
