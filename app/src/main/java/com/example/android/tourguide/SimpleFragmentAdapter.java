package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017/5/25 0025.
 * com.example.android.tourguide,TourGuide
 */

public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    private String mTitles[] = new String[]{"历史景点","活动","餐厅"};

    //保存城市名称
    private String mCityName;



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return HistoricalAttractionsFragment.newInstance(mCityName);
            case 1:
                return ActivitesFragment.newInstance(mCityName);
            case 2:
                return RestaurantFragment.newInstance(mCityName);
            default:
                return HistoricalAttractionsFragment.newInstance(mCityName);
        }
    }

    public SimpleFragmentAdapter(FragmentManager fm, String cityName) {
        super(fm);

        this.mCityName = cityName;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
