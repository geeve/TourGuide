package com.example.android.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/***
 * 第二个画面的Acitvity，包含历史景点，活动，餐厅三个标签Fragment
 */
public class CityGuideActivity extends AppCompatActivity {

    private SimpleFragmentAdapter mSimpleFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_guide);

        Bundle bundle = getIntent().getExtras();

        if(bundle == null){
            return;
        }

        String cityName = bundle.getString("cityName");

        ///////////////////////////////////////////

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_city);

        mSimpleFragmentAdapter = new SimpleFragmentAdapter(getSupportFragmentManager(),cityName);


        viewPager.setAdapter(mSimpleFragmentAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tb_city);

        tabLayout.setupWithViewPager(viewPager);


    }
}
