package com.squidshoe.golf.shottracker.golfers;

import android.support.v7.widget.RecyclerView;
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
public class GolfersAdapter extends RecyclerView.Adapter<GolferViewHolder> implements Action1<List<Clubhouse>> {

    ArrayList<Clubhouse> mClubhouseList;

    public GolfersAdapter(ArrayList<Clubhouse> clubhouseList) {

        mClubhouseList = new ArrayList<>();
        if (clubhouseList != null)
            mClubhouseList.addAll(clubhouseList);
    }

    @Override
    public GolferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_location_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return new GolferViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GolferViewHolder holder, int position) {

        Clubhouse clubhouse = mClubhouseList.get(position);
        holder.mCourseName.setText(clubhouse.name);
        holder.mCourseAddress.setText(clubhouse.address);
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
