package com.example.android.tourguide;

/**
 * Created by Administrator on 2017/5/30 0030.
 * com.example.android.tourguide,TourGuide
 */

public class Restaurant {
    private int mImageResourseId;
    private String mRestaurantName;
    private float mRestaurantRank;
    private String mRestaurantKind;
    private String mRestaurantPrice;

    public Restaurant(int mImageResourseId, String mRestaurantName, float mRestaurantRank, String mRestaurantKind, String mRestaurantPrice) {
        this.mImageResourseId = mImageResourseId;
        this.mRestaurantName = mRestaurantName;
        this.mRestaurantRank = mRestaurantRank;
        this.mRestaurantKind = mRestaurantKind;
        this.mRestaurantPrice = mRestaurantPrice;
    }

    public String getmRestaurantPrice() {
        return mRestaurantPrice;
    }

    public String getmRestaurantKind() {
        return mRestaurantKind;
    }

    public float getmRestaurantRank() {
        return mRestaurantRank;
    }

    public String getmRestaurantName() {
        return mRestaurantName;
    }

    public int getmImageResourseId() {
        return mImageResourseId;
    }
}
