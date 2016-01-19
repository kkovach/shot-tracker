package com.squidshoe.golf.shottracker.model;

import com.squidshoe.golf.model.CourseLocation;

import android.content.ContentValues;

/**
 * Created by kkovach on 7/15/15.
 */
public class MobileCourseLocation extends CourseLocation {


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
