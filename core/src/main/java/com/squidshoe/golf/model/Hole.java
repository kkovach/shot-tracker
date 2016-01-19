package com.squidshoe.golf.model;

/**
 * Created by kkovach on 7/15/15.
 */
public class Hole {

    public static final String TABLE = "hole";

    public static final String ID = "_id";
    public static final String COURSE_ID = "courseId";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    public static final String HANDICAP = "handicap";
    public static final String TEE_COLOR = "teeColor";
    public static final String YARDAGE = "yardage";
    public static final String PAR = "par";

    public Long id;
    public Long courseId;
    public Integer number;
    public String name;
    public Integer handicap;
    public String teeColor;
    public Integer yardage;
    public Integer par;

}
