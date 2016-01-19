package com.squidshoe.golf.shottracker.courses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squidshoe.golf.model.CourseLocation;
import com.squidshoe.golf.shottracker.R;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

/**
 * Created by kkovach on 1/18/16.
 */
public class CourseLocationsAdapter extends RecyclerView.Adapter<CourseLocationViewHolder> implements Action1<List<CourseLocation>> {

    ArrayList<CourseLocation> mCourseLocationList;

    public CourseLocationsAdapter(ArrayList<CourseLocation> courseLocationList) {

        mCourseLocationList = new ArrayList<>();
        if (courseLocationList != null)
            mCourseLocationList.addAll(courseLocationList);
    }

    @Override
    public CourseLocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_location_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return new CourseLocationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CourseLocationViewHolder holder, int position) {

        CourseLocation courseLocation = mCourseLocationList.get(position);
        holder.mCourseName.setText(courseLocation.name);
        holder.mCourseAddress.setText(courseLocation.address);
    }

    @Override
    public int getItemCount() {

        return mCourseLocationList.size();
    }

    @Override
    public void call(List<CourseLocation> courseLocations) {

        mCourseLocationList = (ArrayList<CourseLocation>) courseLocations;
        notifyDataSetChanged();
    }
}
