package com.example.android.tourguide;

/**
 * Created by Administrator on 2017/5/25 0025.
 * com.example.android.tourguide,TourGuide
 */

/***
 * 历史景点信息类
 */
public class Attraction {
    private String mName;
    private String mDetail;
    private int mImgResourseId;
    private String mTelNum;
    private String mOpenTime;
    private String mAddress;
    private String mTips;

    public Attraction(String name, String detail, int imgResourseId, String mTelNum, String mOpenTime, String mAddress, String mTips){

        this.mName = name;
        this.mDetail = detail;
        this.mImgResourseId = imgResourseId;
        this.mTelNum = mTelNum;

        this.mOpenTime = mOpenTime;
        this.mAddress = mAddress;
        this.mTips = mTips;
    }

    public int getmImgResourseId() {
        return mImgResourseId;
    }

    public String getmDetail() {
        return mDetail;
    }

    public String getmName() {
        return mName;
    }

    public String getmTelNum() {
        return mTelNum;
    }

    public String getmOpenTime() {
        return mOpenTime;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmTips() {
        return mTips;
    }
}
