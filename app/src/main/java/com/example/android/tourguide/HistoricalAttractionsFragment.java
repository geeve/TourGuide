package com.example.android.tourguide;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//第一个Fragment
public class HistoricalAttractionsFragment extends Fragment {

    private ArrayList<Attraction> mAttractions = new ArrayList<Attraction>();

    private String mCityName;

    private ListView mListView;

    private AttractionAdapter mAttractionAdapter;

    private static final int REQUEST_CODE = 10;

    //利用工厂模式，使用seArguments方法将参数传递到Fragment中来，因为Frament构造方法不推荐带参数。
    public static HistoricalAttractionsFragment newInstance(String cityName){
        Bundle args = new Bundle();

        args.putString("cityName",cityName);

        HistoricalAttractionsFragment historicalAttractionsFragment = new HistoricalAttractionsFragment();
        historicalAttractionsFragment.setArguments(args);

        return historicalAttractionsFragment;
    }

    /***
     * 实例生成后得到传递过来的参数
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCityName = getArguments().getString("cityName");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_historical_attractions,container,false);

        mAttractions.clear();

        //如果景点未添加，则根据城市信息生成实例
        if(mAttractions.size() == 0){

            creatAttraction(mCityName);

            mAttractionAdapter = new AttractionAdapter(container.getContext(),mAttractions);

            mListView = (ListView)view.findViewById(R.id.activity_historical_attractions);

            mListView.setAdapter(mAttractionAdapter);

            //为每项点击增加事件处理程序
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getContext(),AttractionDetailActivity.class);

                    intent.putExtra("cityName",mCityName);
                    intent.putExtra("attractionName",mAttractions.get(i).getmName());
                    //intent.putExtra("attractionDetail",mAttractions.get(i).getmDetail());
                    intent.putExtra("attractionImg",mAttractions.get(i).getmImgResourseId());
                    intent.putExtra("attractionTel",mAttractions.get(i).getmTelNum());
                    intent.putExtra("attractionOpenTime",mAttractions.get(i).getmOpenTime());
                    intent.putExtra("attractionAddress",mAttractions.get(i).getmAddress());
                    intent.putExtra("attractionTips",mAttractions.get(i).getmTips());

                    Log.v("HistoricalOnclick","OnItemClick!");
                    startActivityForResult(intent,REQUEST_CODE);
                }
            });

        }

        return view;
    }

    //根据城市名称参数传递产生相应的对象实例
    private void creatAttraction(String cityName){
        if(cityName.equals("武汉")){
            creatAttractionInstanceWuHan();
        }else if(cityName.equals("杭州")){
            creatAttractionInstanceHangZhou();
        }else if(cityName.equals("西安")){
            creatAttractionInstanceXiAn();
        }else if(cityName.equals("北京")){
            creatAttractionInstanceBejing();
        }

        Log.v("HistoricalFragment",mCityName);
    }

    private void creatAttractionInstanceWuHan(){
        mAttractions.add(new Attraction(getString(R.string.hhl_name),getString(R.string.wuhan_huanghelou_d),R.drawable.wuhan_huanghelou, getString(R.string.hhlou_tel), getString(R.string.hhlou_opentime), getString(R.string.hhlou_address), getString(R.string.hhlou_tip)));
        mAttractions.add(new Attraction(getString(R.string.gys_name),getString(R.string.wuhan_guiyuansi_d),R.drawable.wuhan_guiyuansi, getString(R.string.guiyuansi_tel), getString(R.string.guiyuansi_opentime), getString(R.string.guiyuansi_address), getString(R.string.guiyuansi_tips)));
        mAttractions.add(new Attraction(getString(R.string.whdx_name),getString(R.string.wuhandaxue_detail),R.drawable.wuhan_wuhandaxue, getString(R.string.wuhandaxue_tel), getString(R.string.wuhandaxue_opentime), getString(R.string.wuhandaxue_address), getString(R.string.wuhandaxue_tip)));
        mAttractions.add(new Attraction(getString(R.string.dh_name),getString(R.string.donghu_detail),R.drawable.wuhan_donghu, getString(R.string.donghu_tel), getString(R.string.donghu_opentime), getString(R.string.donghu_address), getString(R.string.donghu_tip)));
    }

    private void creatAttractionInstanceHangZhou(){
        mAttractions.add(new Attraction(getString(R.string.xihu_name),getString(R.string.xh_detail),R.mipmap.hangzhou_xihu, getString(R.string.xih_tel), getString(R.string.xh_time), getString(R.string.xh_address), getString(R.string.xh_tips)));
        mAttractions.add(new Attraction(getString(R.string.lls_name),getString(R.string.lls_detail),R.mipmap.hangzhou_lingyingsi, getString(R.string.lys_tel), getString(R.string.lys_time), getString(R.string.lys_address), getString(R.string.lys_tips)));
        mAttractions.add(new Attraction(getString(R.string.songc),getString(R.string.sc_detail),R.mipmap.hangzhou_songcheng, getString(R.string.sc_tel), getString(R.string.sc_time), getString(R.string.sc_address), getString(R.string.sc_tips)));
        mAttractions.add(new Attraction(getString(R.string.xxsd_name),getString(R.string.xxsd_detail),R.mipmap.hangzhou_xixi, getString(R.string.xx_tel), getString(R.string.xx_time), getString(R.string.xx_address), getString(R.string.xx_tips)));
    }

    private void creatAttractionInstanceXiAn(){
        mAttractions.add(new Attraction(getString(R.string.bmy_name),getString(R.string.bmy_detail),R.mipmap.xian_bingmayong, getString(R.string.bmy_tel), getString(R.string.bmy_time), getString(R.string.bmy_address), getString(R.string.bmy_tip)));
        mAttractions.add(new Attraction(getString(R.string.xagcq_name),getString(R.string.xagcq_detail),R.mipmap.xian_guchegnqiang, getString(R.string.xagcq_tel), getString(R.string.xagcq_time), getString(R.string.xagcq_address), getString(R.string.xagcq_tips)));
        mAttractions.add(new Attraction(getString(R.string.dyt_name),getString(R.string.dyt_detail),R.mipmap.xian_dayanta, getString(R.string.dyt_tel), getString(R.string.dyt_time), getString(R.string.dyt_address), getString(R.string.dyt_tips)));
        mAttractions.add(new Attraction(getString(R.string.hmj_name),getString(R.string.hmj_detail),R.mipmap.xian_huimingjie, getString(R.string.hmj_tel), getString(R.string.hmj_time), getString(R.string.hmj_address), getString(R.string.hmj_tips)));
    }

    private void creatAttractionInstanceBejing(){
        mAttractions.add(new Attraction(getString(R.string.gugong_name),getString(R.string.gg_detail),R.mipmap.bejing_gugong, getString(R.string.gg_tel), getString(R.string.gg_time), getString(R.string.gg_address), getString(R.string.gg_tips)));
        mAttractions.add(new Attraction(getString(R.string.yhy_name),getString(R.string.yhy_detail),R.mipmap.bejing_yiheyuan, getString(R.string.yhy_tel), getString(R.string.yhy_time), getString(R.string.yhy_address), getString(R.string.yhy_tips)));
        mAttractions.add(new Attraction(getString(R.string.tt_name),getString(R.string.tt_detail),R.mipmap.bejing_tiantan, getString(R.string.tt_tel), getString(R.string.tt_time), getString(R.string.tt_address), getString(R.string.tt_tips)));
        mAttractions.add(new Attraction(getString(R.string.ymy_name),getString(R.string.ymy_detail),R.mipmap.beijing_yuanmingyuan, getString(R.string.ymy_tel), getString(R.string.ymy_time), getString(R.string.ymy_address), getString(R.string.ymy_tips)));
    }

}
