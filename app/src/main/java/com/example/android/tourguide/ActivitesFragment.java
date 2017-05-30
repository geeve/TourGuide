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

//第二个Fragment
public class ActivitesFragment extends Fragment {

    private String mCityName;

    private ArrayList<CityActivities> mCityActivities = new ArrayList<CityActivities>();

    public static ActivitesFragment newInstance(String cityName){
        Bundle args = new Bundle();

        args.putString("cityName",cityName);

        ActivitesFragment activitesFragment = new ActivitesFragment();
        activitesFragment.setArguments(args);

        return activitesFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCityName = getArguments().getString("cityName");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities,container,false);

        mCityActivities.clear();

        creatActivities(mCityName);

        ActivitesAdapter activitesAdapter = new ActivitesAdapter(container.getContext(),mCityActivities);

        ListView listView = (ListView) view.findViewById(R.id.activities_list_view);
        listView.setAdapter(activitesAdapter);

        return view;
    }

    private void creatActivities(String cityName){
        if(cityName.equals("武汉")){
            creatActivityInstanceWuHan();
        }else if(cityName.equals("杭州")){
            creatActivityInstanceHangZhou();
        }else if(cityName.equals("西安")){
            creatActivityInstanceXiAn();
        }else if(cityName.equals("北京")){
            creatActivityInstanceBejing();
        }

        Log.v("HistoricalFragment",mCityName);

    }

    private void creatActivityInstanceWuHan(){
        mCityActivities.add(new CityActivities(R.drawable.wuhan_dxsxqj,getString(R.string.dxsxqj_name),getString(R.string.dxsxqj_time),getString(R.string.dxsxqj_address),getString(R.string.dxsxqj_price)));
        mCityActivities.add(new CityActivities(R.drawable.wuhan_nvpu,getString(R.string.nvpu_name),getString(R.string.nvpu_time),getString(R.string.nvpu_address),getString(R.string.nvpu_price)));
        mCityActivities.add(new CityActivities(R.drawable.wuhan_wugongsan,getString(R.string.wugongshan_name),getString(R.string.wugongshan_time),getString(R.string.wugongshan_address),getString(R.string.wugongshan_price)));
    }

    private void creatActivityInstanceHangZhou(){
        mCityActivities.add(new CityActivities(R.drawable.hangzhou_chahuazhan,getString(R.string.chahuazhan_name),getString(R.string.chahuazan_teim),getString(R.string.chahuazhan_address),getString(R.string.chahuazhan_price)));
        mCityActivities.add(new CityActivities(R.drawable.hangzhou_xihyyj,getString(R.string.xihyyj_name),getString(R.string.xihyyj_tiem),getString(R.string.xihyyj_address),getString(R.string.xihyyj_price)));
        mCityActivities.add(new CityActivities(R.drawable.hangzhou_qdh,getString(R.string.qdh_name),getString(R.string.qdh_time),getString(R.string.qdh_address),getString(R.string.qdh_price)));
    }

    private void creatActivityInstanceXiAn(){
        mCityActivities.add(new CityActivities(R.drawable.xian_gfxx,getString(R.string.gfxx_name),getString(R.string.gfxx_time),getString(R.string.gfxx_address),getString(R.string.gfxx_price)));
        mCityActivities.add(new CityActivities(R.drawable.xian_jszx,getString(R.string.jszx_name),getString(R.string.jszx_time),getString(R.string.jszx_address),getString(R.string.jszx_price)));
        mCityActivities.add(new CityActivities(R.drawable.xian_zsjsll,getString(R.string.zsjsll_name),getString(R.string.zsjsll_time),getString(R.string.zsjsll_address),getString(R.string.zsjsll_price)));
    }

    private void creatActivityInstanceBejing(){
        mCityActivities.add(new CityActivities(R.drawable.beijing_zgdd,getString(R.string.zgdd_name),getString(R.string.zgdd_time),getString(R.string.zgdd_address),getString(R.string.zgdd_price)));
        mCityActivities.add(new CityActivities(R.drawable.bejing_ppsjlyg,getString(R.string.ppsjlyg_name),getString(R.string.pxsj_tiem),getString(R.string.pxsj_address),getString(R.string.pxsj_price)));
        mCityActivities.add(new CityActivities(R.drawable.bejing_tgkw,getString(R.string.tgkw_name),getString(R.string.tgkw_time),getString(R.string.tgkw_address),getString(R.string.tgkw_price)));
    }
}
