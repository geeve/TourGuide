package com.example.android.tourguide;

/**
 * Created by Administrator on 2017/5/23 0023.
 * com.example.android.tourguide,TourGuide
 */

public class City {

    private String mCityName;

    private int mCityPicResourseId;

    public City(String cityName, int cityPicResourseId){

        this.mCityName = cityName;
        this.mCityPicResourseId = cityPicResourseId;

    }

    public String getmCityName(){
        return mCityName;
    }

    public int getmCityPicResourseId(){
        return mCityPicResourseId;
    }

}
