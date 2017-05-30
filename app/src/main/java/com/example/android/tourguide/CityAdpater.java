package com.example.android.tourguide;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/23 0023.
 * com.example.android.tourguide,TourGuide
 */

public class CityAdpater extends BaseAdapter {

    private Context mContext;

    private ArrayList<City> mCities = new ArrayList<City>();

    public CityAdpater(Context context, ArrayList<City> cities) {
        super();

        this.mContext = context;
        this.mCities = cities;
    }

    @Override
    public int getCount() {
        return mCities.size();
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View currentView = view;
        if(currentView == null){
            currentView = LayoutInflater.from(this.mContext).inflate(R.layout.city_grid_item,viewGroup,false);
        }

        City currentCity = mCities.get(i);

        ImageView imgView = (ImageView) currentView.findViewById(R.id.city_grid_item_img);
        imgView.setImageResource(currentCity.getmCityPicResourseId());

        TextView textView = (TextView) currentView.findViewById(R.id.city_grid_item_text);
        textView.setText(currentCity.getmCityName());

        return currentView;
    }
}
