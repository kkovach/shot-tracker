package com.squidshoe.golf.shottracker.model;

import com.squidshoe.golf.model.Hole;

import android.content.ContentValues;

/**
 * Created by kkovach on 7/15/15.
 */
public class MobileHole extends Hole {

    public static final class Builder {

        private final ContentValues values = new ContentValues();

        public Builder id(long id) {

            values.put(ID, id);
            return this;
        }

        public Builder courseId(long id) {

            values.put(COURSE_ID, id);
            return this;
        }

        public Builder name(String name) {

            values.put(NAME, name);
            return this;
        }

        public Builder number(Integer number) {

            values.put(NUMBER, number);
            return this;
        }

        public Builder handicap(Integer handicap) {

            values.put(HANDICAP, handicap);
            return this;
        }

        public Builder yardage(Integer yardage) {

            values.put(YARDAGE, yardage);
            return this;
        }

        public Builder par(Integer par) {

            values.put(PAR, par);
            return this;
        }

        public Builder teeColor(String teeColor) {

            values.put(TEE_COLOR, teeColor);
            return this;
        }

        public ContentValues build() {

            return values; // TODO defensive copy?
        }
    }
}
