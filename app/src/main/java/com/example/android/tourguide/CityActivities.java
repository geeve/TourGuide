package com.example.android.tourguide;

/**
 * Created by Administrator on 2017/5/29 0029.
 * com.example.android.tourguide,TourGuide
 */

public class CityActivities {
    private int mActivitiesImgResourseId;
    private String mActivityName;
    private String mActivityTime;
    private String mActivityAddress;
    private String mActivityPrice;

    public CityActivities(int mActivitiesImgResourseId, String mActivityName, String mActivityTime, String mActivityAddress, String mActivityPrice) {
        this.mActivitiesImgResourseId = mActivitiesImgResourseId;
        this.mActivityName = mActivityName;
        this.mActivityTime = mActivityTime;
        this.mActivityAddress = mActivityAddress;
        this.mActivityPrice = mActivityPrice;
    }

    public int getmActivitiesImgResourseId() {
        return mActivitiesImgResourseId;
    }

    public String getmActivityName() {
        return mActivityName;
    }

    public String getmActivityTime() {
        return mActivityTime;
    }

    public String getmActivityAddress() {
        return mActivityAddress;
    }

    public String getmActivityPrice() {
        return mActivityPrice;
    }
}
