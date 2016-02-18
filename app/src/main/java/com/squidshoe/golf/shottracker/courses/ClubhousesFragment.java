package com.squidshoe.golf.shottracker.courses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import com.squidshoe.golf.shottracker.R;
import com.squidshoe.golf.shottracker.SimpleDividerItemDecoration;
import com.squidshoe.golf.shottracker.db.DbOpenHelper;
import com.squidshoe.golf.shottracker.model.MobileClubhouse;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kkovach on 1/17/16.
 */
public class ClubhousesFragment extends Fragment implements ClubhousesView {

    private static final String TAG = "ClubhousesFragment";

    @Bind(R.id.courseContactList)
    RecyclerView mCourseContactList;

    private DbOpenHelper helper;
    private SqlBrite sqlBrite;
    private BriteDatabase db;

    private ClubhousesAdapter courseLocationsAdapter;
    private Subscription subscription;

    private ClubhousesPresenter mCourseLocationsPresenter;

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        helper = DbOpenHelper.getInstance(context);
        sqlBrite = SqlBrite.create();
        db = sqlBrite.wrapDatabaseHelper(helper);

        Log.d(TAG, "Attaching clubhouse list. Creating adapter...");
        courseLocationsAdapter = new ClubhousesAdapter(null);
    }

    @Override
    public void onResume() {

        super.onResume();

        Log.i(TAG, "Creating query...");
        subscription = db.createQuery(MobileClubhouse.TABLE, MobileClubhouse.QUERY)
                .mapToList(MobileClubhouse.MAPPER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(courseLocationsAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clubhouse_list, container, false);

        ButterKnife.bind(this, view);

        mCourseLocationsPresenter = new ClubhousesPresenterImpl(this);

        mCourseContactList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCourseContactList.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        mCourseContactList.setAdapter(courseLocationsAdapter);

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
