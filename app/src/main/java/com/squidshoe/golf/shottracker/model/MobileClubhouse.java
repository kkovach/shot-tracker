package com.squidshoe.golf.shottracker.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.squidshoe.golf.model.Clubhouse;
import com.squidshoe.golf.shottracker.db.Db;

import rx.functions.Func1;

/**
 * Created by kkovach on 7/15/15.
 */
public class MobileClubhouse extends Clubhouse {

    private static final String TAG = "MobileClubhouse";

    public static final String TABLE = "clubhouse";
    public static final String QUERY = "SELECT " + NAME + ", " + ADDRESS + ", " + CITY + ", " + STATE + ", " + ZIP + " FROM " + TABLE;

    public static final Func1<Cursor, Clubhouse> MAPPER = new Func1<Cursor, Clubhouse>() {

        @Override
        public Clubhouse call(Cursor cursor) {

            Log.i(TAG, "Got cursor with " + cursor.getCount());

            Clubhouse clubhouse = new Clubhouse();
            clubhouse.name = Db.getString(cursor, NAME);
            clubhouse.address = Db.getString(cursor, ADDRESS);
            clubhouse.city = Db.getString(cursor, CITY);
            clubhouse.state = Db.getString(cursor, STATE);
            clubhouse.zip = Db.getString(cursor, ZIP);

            return clubhouse;
        }
    };

    public static final class Builder {

        private final ContentValues values = new ContentValues();

        public Builder id(long id) {

            values.put(ID, id);
            return this;
        }

        public Builder name(String name) {

            values.put(NAME, name);
            return this;
        }

        public Builder address(String address) {

            values.put(ADDRESS, address);
            return this;
        }

        public Builder city(String city) {

            values.put(CITY, city);
            return this;
        }

        public Builder state(String state) {

            values.put(STATE, state);
            return this;
        }

        public Builder zip(String zip) {

            values.put(ZIP, zip);
            return this;
        }

        public Builder url(String url) {

            values.put(URL, url);
            return this;
        }

        public Builder email(String email) {

            values.put(EMAIL, email);
            return this;
        }

        public Builder phone(String phone) {

            values.put(PHONE, phone);
            return this;
        }

        public ContentValues build() {

            return values; // TODO defensive copy?
        }
    }
}
