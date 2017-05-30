package com.example.android.tourguide;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Administrator on 2017/5/25 0025.
 * com.example.android.tourguide,TourGuide
 */

public class AttractionAdapter extends ArrayAdapter {

    private Context mContext ;
    private ArrayList<Attraction> mAttractions = new ArrayList<Attraction>();

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions) {
        super(context,0,attractions);

        this.mAttractions = attractions;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView = convertView;

        if(currentView == null){
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_historical_attractions_list_item,parent,false);
        }

        ImageView img = (ImageView) currentView.findViewById(R.id.iv_attraction_img);
        TextView name = (TextView) currentView.findViewById(R.id.tv_attraction_name);
        TextView detail = (TextView) currentView.findViewById(R.id.tv_attraction_detail);

        img.setImageResource(mAttractions.get(position).getmImgResourseId());
        name.setText(mAttractions.get(position).getmName());
        detail.setText(mAttractions.get(position).getmDetail());

        return currentView;
    }
}
