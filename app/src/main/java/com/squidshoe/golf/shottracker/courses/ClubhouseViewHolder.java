package com.squidshoe.golf.shottracker.courses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squidshoe.golf.shottracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kkovach on 1/18/16.
 */
public class ClubhouseViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.courseName)
    TextView mCourseName;
    @Bind(R.id.courseAddress)
    TextView mCourseAddress;
    @Bind(R.id.courseCity)
    TextView mCourseCity;
    @Bind(R.id.courseState)
    TextView mCourseState;
    @Bind(R.id.courseZip)
    TextView mCourseZip;

    public ClubhouseViewHolder(View v) {

        super(v);
        ButterKnife.bind(this, v);
    }
}
