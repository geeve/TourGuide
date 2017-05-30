package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/29 0029.
 * com.example.android.tourguide,TourGuide
 */

public class ActivitesAdapter extends ArrayAdapter {

    private Context mContext;

    private ArrayList<CityActivities> mActivities = new ArrayList<CityActivities>();

    public ActivitesAdapter(Context context,ArrayList<CityActivities> cityActivities){
        super(context,0,cityActivities);

        this.mActivities = cityActivities;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if(currentView == null){
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_activities_list_item,parent,false);
        }

        ImageView img = (ImageView) currentView.findViewById(R.id.activities_item_img);
        TextView tvTitle = (TextView) currentView.findViewById(R.id.activites_item_title);
        TextView tvTime = (TextView)currentView.findViewById(R.id.activites_item_time);
        TextView tvAddress = (TextView) currentView.findViewById(R.id.activites_item_address);
        TextView tvPrice = (TextView) currentView.findViewById(R.id.activites_item_price);

        img.setImageResource(mActivities.get(position).getmActivitiesImgResourseId());
        tvAddress.setText(mActivities.get(position).getmActivityAddress());
        tvPrice.setText(mActivities.get(position).getmActivityPrice());
        tvTime.setText(mActivities.get(position).getmActivityTime());
        tvTitle.setText(mActivities.get(position).getmActivityName());

        return currentView;
    }
}
