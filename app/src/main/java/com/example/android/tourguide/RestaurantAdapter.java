package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.manageSpaceActivity;
import static android.R.attr.resource;

/**
 * Created by Administrator on 2017/5/30 0030.
 * com.example.android.tourguide,TourGuide
 */

public class RestaurantAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<Restaurant> mRestaurants = new ArrayList<Restaurant>();

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        super(context,0, restaurants);

        this.mContext = context;
        this.mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView =  convertView;
        if(currentView == null){
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_restaurant_list_item,parent,false);
        }

        ImageView img = (ImageView) currentView.findViewById(R.id.res_img);
        img.setImageResource(mRestaurants.get(position).getmImageResourseId());

        TextView tvName = (TextView) currentView.findViewById(R.id.res_name);
        tvName.setText(mRestaurants.get(position).getmRestaurantName());

        RatingBar rb = (RatingBar) currentView.findViewById(R.id.res_rank);
        rb.setNumStars(5);
        rb.setRating(mRestaurants.get(position).getmRestaurantRank());

        TextView tvKind = (TextView) currentView.findViewById(R.id.rank_kind);
        tvKind.setText(mRestaurants.get(position).getmRestaurantKind());

        TextView tvPrice = (TextView) currentView.findViewById(R.id.res_price);
        tvPrice.setText(mRestaurants.get(position).getmRestaurantPrice());

        return currentView;
    }
}
