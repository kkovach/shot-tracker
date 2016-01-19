package com.squidshoe.golf.shottracker.model;

import com.squidshoe.golf.model.Course;

import android.content.ContentValues;

/**
 * Created by kkovach on 7/15/15.
 */
public class MobileCourse extends Course {

    public static final class Builder {

        private final ContentValues values = new ContentValues();

        public Builder id(long id) {

            values.put(ID, id);
            return this;
        }

        public Builder courseLocationId(long id) {

            values.put(COURSE_LOCATION_ID, id);
            return this;
        }

        public Builder name(String name) {

            values.put(NAME, name);
            return this;
        }

        public Builder holes(Integer holes) {

            values.put(HOLES, holes);
            return this;
        }

        public Builder slope(Integer slope) {

            values.put(SLOPE, slope);
            return this;
        }

        public Builder rating(Float rating) {

            values.put(RATING, rating);
            return this;
        }

        public ContentValues build() {

            return values; // TODO defensive copy?
        }
    }
}
