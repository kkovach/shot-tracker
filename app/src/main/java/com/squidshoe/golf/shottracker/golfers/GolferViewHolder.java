package com.squidshoe.golf.shottracker.golfers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squidshoe.golf.shottracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kkovach on 1/18/16.
 */
public class GolferViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.courseName)
    TextView mCourseName;
    @Bind(R.id.courseAddress)
    TextView mCourseAddress;

    public GolferViewHolder(View v) {

        super(v);
        ButterKnife.bind(this, v);
    }
}
