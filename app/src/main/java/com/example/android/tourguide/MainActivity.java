package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //存放第一页面中的城市列表信息
    private ArrayList<City> mCities = new ArrayList<City>();
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        creatCityGrid();

    }

    /***
     * 生成第一页面的GridView
     */
    private void creatCityGrid() {

        mCities.add(new City("武汉", R.drawable.wuhan));
        mCities.add(new City("杭州",R.drawable.hangzhou));
        mCities.add(new City("西安",R.drawable.xian));
        mCities.add(new City("北京",R.drawable.bejing));

        CityAdpater cityAdpater = new CityAdpater(this,mCities);

        GridView gridView = (GridView) findViewById(R.id.activity_main);

        gridView.setAdapter(cityAdpater);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,CityGuideActivity.class);
                //把城市名传到第二个页面
                intent.putExtra("cityName",mCities.get(i).getmCityName());

                startActivityForResult(intent,REQUEST_CODE);

            }
        });
    }


}
