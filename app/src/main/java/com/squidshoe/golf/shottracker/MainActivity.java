package com.squidshoe.golf.shottracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squidshoe.golf.shottracker.courses.ClubhousesFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    @Inject
    SharedPreferences mSharedPrefs;

    @Bind(R.id.toolbar)
    Toolbar mToolBar;
    @Bind(R.id.main_drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.main_navigation)
    NavigationView drawer;
    @Bind(R.id.main_content)
    ViewGroup content;

    private MainPresenter mMainPresenter;
    private Fragment mCurrentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mMainPresenter = new MainPresenterImpl(this);

        ((ShotTrackerApplication) getApplication()).getComponent().inject(this);

        setSupportActionBar(mToolBar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        drawer.setNavigationItemSelectedListener(mMainPresenter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return mMainPresenter.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (mCurrentFragment != null) {

            Log.d(TAG, "Fragment class is " + mCurrentFragment.getClass().getSimpleName());

            if (mCurrentFragment instanceof ClubhousesFragment)
                getMenuInflater().inflate(R.menu.course_location, menu);
        }

        return true;
    }

    @Override
    public void closeNavigationDrawer() {

        mDrawerLayout.closeDrawers();
    }

    @Override
    public void showFragment(Fragment fragment) {

        if(mCurrentFragment != null)
        Log.d(TAG, "Replacing fragment " + mCurrentFragment.getClass().getSimpleName() + " with " + fragment.getClass().getSimpleName());
        else
            Log.d(TAG, "Adding fragment " + fragment.getClass().getSimpleName());

        mCurrentFragment = fragment;

        invalidateOptionsMenu();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, mCurrentFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setTitle(String title) {

        getSupportActionBar().setTitle(title);
    }
}
