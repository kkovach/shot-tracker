package com.squidshoe.golf.shottracker.db;

import android.database.Cursor;

/**
 * Created by kkovach on 1/28/16.
 */
public final class Db {

    private static final String TAG = "Db";

    public static final int BOOLEAN_FALSE = 0;
    public static final int BOOLEAN_TRUE = 1;

    public static String getString(Cursor cursor, String columnName) {

        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }

    public static boolean getBoolean(Cursor cursor, String columnName) {

        return getInt(cursor, columnName) == BOOLEAN_TRUE;
    }

    public static long getLong(Cursor cursor, String columnName) {

        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }

    public static int getInt(Cursor cursor, String columnName) {

        return cursor.getInt(cursor.getColumnIndexOrThrow(columnName));
    }
}