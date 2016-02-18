package com.squidshoe.golf.shottracker.courses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.squareup.sqlbrite.BriteDatabase;
import com.squidshoe.golf.model.Clubhouse;
import com.squidshoe.golf.shottracker.ShotTrackerApplication;
import com.squidshoe.golf.shottracker.model.MobileClubhouse;

import javax.inject.Inject;

/**
 * Created by kkovach on 1/28/16.
 */
public class AddClubhouseInteractor {

    private static final String TAG = "AddClubhouseInteractor";

    @Inject
    BriteDatabase db;

    public AddClubhouseInteractor(Context context) {

        ShotTrackerApplication.getComponent().inject(this);
    }

    public long put(Clubhouse clubhouse) {

        Log.i(TAG, "Adding Clubhouse: " + clubhouse);

        long insertedRow = db.insert(MobileClubhouse.TABLE, build(clubhouse), SQLiteDatabase.CONFLICT_FAIL);

        Log.i(TAG, "Inserted " + insertedRow);

        return insertedRow;
    }

    private ContentValues build(Clubhouse clubhouse) {

        return new MobileClubhouse.Builder().name(clubhouse.name).address(clubhouse.address).city(clubhouse.city).state(clubhouse.state).zip(clubhouse.zip).build();
    }
}
