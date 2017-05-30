package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25 0025.
 * com.example.android.tourguide,TourGuide
 */

public class RestaurantFragment extends Fragment{

    private String mCityName;

    private ArrayList<Restaurant> mRestaurants = new ArrayList<Restaurant>();

    public static RestaurantFragment newInstance(String cityName){
        Bundle args = new Bundle();

        args.putString("cityName",cityName);

        RestaurantFragment restaurantFragment = new RestaurantFragment();

        restaurantFragment.setArguments(args);

        return restaurantFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCityName = getArguments().getString("cityName");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant,container,false);

        mRestaurants.clear();

        creatRestaurants(mCityName);

        ListView listView = (ListView) view.findViewById(R.id.lv_restaurant);

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(container.getContext(),mRestaurants);

        listView.setAdapter(restaurantAdapter);

        return view;
    }

    private void creatRestaurants(String cityName){
        if(cityName.equals("武汉")){
            creatRestaurantsInstanceWuHan();
        }else if(cityName.equals("杭州")){
            creatRestaurantsInstanceHangZhou();
        }else if(cityName.equals("西安")){
            creatRestaurantsInstanceXiAn();
        }else if(cityName.equals("北京")){
            creatRestaurantsInstanceBejing();
        }

        Log.v("HistoricalFragment",mCityName);
    }

    private void creatRestaurantsInstanceWuHan(){
        mRestaurants.add(new Restaurant(R.drawable.wh_clj,getString(R.string.wh_clj),4,getString(R.string.tsxc),getString(R.string.clj_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.wh_hbx,getString(R.string.wh_hbx),5,getString(R.string.tsxc),getString(R.string.hbx_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.wh_zhy,getString(R.string.wh_zhy),5,getString(R.string.tsxc),getString(R.string.zhy_rjxf)));
    }

    private void creatRestaurantsInstanceHangZhou(){
        mRestaurants.add(new Restaurant(R.drawable.hz_kyg,getString(R.string.hz_kyg),5,getString(R.string.kcxc),getString(R.string.kyg_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.hz_zwg,getString(R.string.hz_zwg),4,getString(R.string.ddts),getString(R.string.zwg_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.hz_xnh,getString(R.string.hz_xnh),5,getString(R.string.ddts),getString(R.string.xnh_rjxf)));
    }

    private void creatRestaurantsInstanceXiAn(){
        mRestaurants.add(new Restaurant(R.drawable.xan_tsx,getString(R.string.xan_tsx),4,getString(R.string.tsxc),getString(R.string.tsx_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.xian_zca,getString(R.string.xan_zca),4.6f,getString(R.string.ddts),getString(R.string.zca_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.xan_wjlp,getString(R.string.xan_wjlp),5,getString(R.string.ddts),getString(R.string.wjlp_rjxf)));
    }

    private void creatRestaurantsInstanceBejing(){
        mRestaurants.add(new Restaurant(R.drawable.bj_qjd,getString(R.string.bj_qjd),5,getString(R.string.zcg),getString(R.string.qjd_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.bj_yjcg,getString(R.string.bj_yjcg),4,getString(R.string.zcg),getString(R.string.yjcg_rjxf)));
        mRestaurants.add(new Restaurant(R.drawable.bj_hgs,getString(R.string.bj_hgs),5,getString(R.string.tsxc),getString(R.string.hgs_rjxf)));
    }
}
