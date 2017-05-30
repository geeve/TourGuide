package com.example.android.tourguide;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AttractionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);


        Bundle extras = getIntent().getExtras();

        if(extras == null){
            return;
        }


        String cityName = extras.getString("cityName");
        String attractionName = extras.getString("attractionName");
        //String attractionDetail = extras.getString("attractionDetail");
        int attractionImg = extras.getInt("attractionImg");
        String attractionTel = extras.getString("attractionTel");
        String attractionOpentTime = extras.getString("attractionOpenTime");
        String attractionAddress = extras.getString("attractionAddress");
        String attractionTips = extras.getString("attractionTips");

        ImageView iv = (ImageView) findViewById(R.id.attraction_img);
        iv.setImageResource(attractionImg);

        TextView tvCityName = (TextView) findViewById(R.id.city_name);
        tvCityName.setText(cityName);

        TextView tvAttractionName = (TextView) findViewById(R.id.attraction_name);
        tvAttractionName.setText(attractionName);

        TextView tvAttractionTel = (TextView) findViewById(R.id.attraction_tel);
        tvAttractionTel.setText(attractionTel);

        TextView tvAttractionAddress = (TextView) findViewById(R.id.attraction_address);
        tvAttractionAddress.setText(attractionAddress);

        TextView tvOpenTime = (TextView) findViewById(R.id.open_time);
        tvOpenTime.setText(attractionOpentTime);

        TextView tvAttractionTips = (TextView) findViewById(R.id.attraction_tips);
        tvAttractionTips.setText(attractionTips);

    }
}
