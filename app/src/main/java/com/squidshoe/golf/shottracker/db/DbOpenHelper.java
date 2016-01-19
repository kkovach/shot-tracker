package com.squidshoe.golf.shottracker.db;

/**
 * Created by kkovach on 7/15/15.
 */

import com.squidshoe.golf.shottracker.model.MobileCourse;
import com.squidshoe.golf.shottracker.model.MobileCourseLocation;
import com.squidshoe.golf.shottracker.model.MobileHole;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class DbOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String CREATE_COURSE_LOCATION_TABLE = "" + "CREATE TABLE " + MobileCourseLocation.TABLE + "(" + MobileCourseLocation.ID
            + " INTEGER NOT NULL PRIMARY KEY," + MobileCourseLocation.NAME + " TEXT NOT NULL," + MobileCourseLocation.ADDRESS + " TEXT NOT NULL,"
            + MobileCourseLocation.CITY + " TEXT NOT NULL," + MobileCourseLocation.STATE + " TEXT NOT NULL," + MobileCourseLocation.ZIP + " TEXT NOT NULL,"
            + MobileCourseLocation.URL + " TEXT," + MobileCourseLocation.EMAIL + " TEXT," + MobileCourseLocation.PHONE + " TEXT" + ")";

    private static final String CREATE_COURSE_TABLE = "" + "CREATE TABLE " + MobileCourse.TABLE + "(" + MobileCourse.ID + " INTEGER NOT NULL PRIMARY KEY,"
            + MobileCourse.COURSE_LOCATION_ID + " INTEGER NOT NULL REFERENCES " + MobileCourseLocation.TABLE + "(" + MobileCourseLocation.ID + "),"
            + MobileCourse.NAME + " TEXT NOT NULL," + MobileCourse.HOLES + " INTEGER NOT NULL," + MobileCourse.SLOPE + " INTEGER NOT NULL,"
            + MobileCourse.RATING + " REAL NOT NULL" + ")";

    private static final String CREATE_HOLE_TABLE = "" + "CREATE TABLE " + MobileHole.TABLE + "(" + MobileHole.ID + " INTEGER NOT NULL PRIMARY KEY,"
            + MobileHole.COURSE_ID + " INTEGER NOT NULL REFERENCES " + MobileCourse.TABLE + "(" + MobileCourse.ID + ")," + MobileHole.NAME + " TEXT,"
            + MobileHole.NUMBER + " INTEGER NOT NULL" + MobileHole.YARDAGE + " INTEGER NOT NULL" + MobileHole.PAR + " INTEGER NOT NULL" + MobileHole.HANDICAP
            + " INTEGER NOT NULL" + MobileHole.TEE_COLOR + " TEXT NOT NULL" + ")";

    private static final String CREATE_HOLE_COURSE_ID_INDEX = "CREATE INDEX holeCourseId ON " + MobileHole.TABLE + " (" + MobileHole.COURSE_ID + ")";

    private static final String CREATE_COURSE_LOCAION_ID_INDEX = "CREATE INDEX courseLocationId ON " + MobileCourse.TABLE + " ("
            + MobileCourse.COURSE_LOCATION_ID + ")";

    public DbOpenHelper(Context context) {

        super(context, "todo.db", null /* factory */, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_COURSE_LOCATION_TABLE);
        db.execSQL(CREATE_COURSE_TABLE);
        db.execSQL(CREATE_HOLE_TABLE);
        db.execSQL(CREATE_HOLE_COURSE_ID_INDEX);
        db.execSQL(CREATE_COURSE_LOCAION_ID_INDEX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
