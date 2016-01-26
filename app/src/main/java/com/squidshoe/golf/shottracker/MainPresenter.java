package com.squidshoe.golf.shottracker;

import android.support.design.widget.NavigationView;
import android.view.MenuItem;

/**
 * Created by kkovach on 1/17/16.
 */
public interface MainPresenter extends NavigationView.OnNavigationItemSelectedListener {

    boolean onOptionsItemSelected(MenuItem item);
}
