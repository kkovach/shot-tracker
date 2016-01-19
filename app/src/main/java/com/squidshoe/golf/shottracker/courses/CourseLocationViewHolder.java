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
public class CourseLocationViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.courseName)
    TextView mCourseName;
    @Bind(R.id.courseAddress)
    TextView mCourseAddress;

    public CourseLocationViewHolder(View v) {

        super(v);
        ButterKnife.bind(this, v);
    }
}
