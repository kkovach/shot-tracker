package com.squidshoe.golf.shottracker.courses;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squidshoe.golf.model.Clubhouse;
import com.squidshoe.golf.shottracker.R;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

/**
 * Created by kkovach on 1/18/16.
 */
public class ClubhousesAdapter extends RecyclerView.Adapter<ClubhouseViewHolder> implements Action1<List<Clubhouse>> {

    private static final String TAG = "ClubhousesAdapter";

    ArrayList<Clubhouse> mClubhouseList;

    public ClubhousesAdapter(ArrayList<Clubhouse> clubhouseList) {

        mClubhouseList = new ArrayList<>();
        if (clubhouseList != null)
            mClubhouseList.addAll(clubhouseList);
    }

    @Override
    public ClubhouseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_location_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return new ClubhouseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClubhouseViewHolder holder, int position) {

        Clubhouse clubhouse = mClubhouseList.get(position);
        holder.mCourseName.setText(clubhouse.name);
        holder.mCourseAddress.setText(clubhouse.address);
        holder.mCourseCity.setText(clubhouse.city);
        holder.mCourseState.setText(clubhouse.state);
        holder.mCourseZip.setText(clubhouse.zip);
    }

    @Override
    public int getItemCount() {

        return mClubhouseList.size();
    }

    @Override
    public void call(List<Clubhouse> clubhouses) {

        mClubhouseList = (ArrayList<Clubhouse>) clubhouses;
        notifyDataSetChanged();
    }
}
