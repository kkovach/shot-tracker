package com.squidshoe.golf.model;

/**
 * Created by kkovach on 7/15/15.
 */
public class Course {

    public static final String TABLE = "course";

    public static final String ID = "_id";
    public static final String COURSE_LOCATION_ID = "courseLocationId";
    public static final String NAME = "name";
    public static final String HOLES = "holes";
    public static final String RATING = "rating";
    public static final String SLOPE = "slope";

    public Long id;
    public Long courseLocationId;
    public String name;
    public Integer holes;
    public Float rating;
    public Integer slope;

}
