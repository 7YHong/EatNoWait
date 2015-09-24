package com.dreamstations.eatnowait.eatnowait.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dreamstations.eatnowait.eatnowait.Adapter.Home_TitleVPAdapter;
import com.dreamstations.eatnowait.eatnowait.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/9/23.
 */
public class Frag_Home extends Fragment implements ViewPager.OnPageChangeListener{

    ViewPager titlevp;
    LinearLayout points;
    LinearLayout eaterys;

    //开发时用
    List<ImageView> titlepics;
    List<ImageView> listpics;
    int[] listpicsid={R.drawable.home_tingxiang,R.drawable.home_ganyi};

    private void initTempPics(){
        titlepics =new ArrayList<>();
        for (int i=0;i<3;i++){
            ImageView iv=new ImageView(getContext());
            iv.setImageResource(R.drawable.home_titlepic1);
            iv.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            iv.setAdjustViewBounds(true);
            titlepics.add(iv);
        }

        listpics=new ArrayList<>();
        for (int i=0;i<listpicsid.length;i++){
            ImageView iv=new ImageView(getContext());
            iv.setImageResource(listpicsid[i]);
            iv.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            iv.setAdjustViewBounds(true);
            listpics.add(iv);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTempPics();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_home,container,false);
        titlevp = (ViewPager) v.findViewById(R.id.home_titlevp);
        points= (LinearLayout) v.findViewById(R.id.home_vp_points);
        eaterys= (LinearLayout) v.findViewById(R.id.home_eaterys);
        PagerAdapter vpAdapter=new Home_TitleVPAdapter(titlepics,getContext());
        titlevp.setAdapter(vpAdapter);
        titlevp.addOnPageChangeListener(this);



        //由于VP的刷新问题尚未解决，因此这个方法是不完善的
        setTitlepics(titlepics);
        //开发时用
        setListpics(listpics);


        return v;
    }

    /**
     *  由Presenter调用，为该View设置列表内容
     * @param listpics
     */
    public void setListpics(List<ImageView> listpics) {
        eaterys.removeAllViews();
        for (int i=0;i<listpics.size();i++){
            eaterys.addView(listpics.get(i));
        }
    }

    /**
     * 由Presenter调用，设置titlevp内容
     * @param titlepics
     *  由于VP的刷新问题尚未解决，因此这个方法是不完善的
     */
    public void setTitlepics(List<ImageView> titlepics) {
        points.removeAllViews();
        for (int i=0;i<titlepics.size();i++){
            ImageView iv=new ImageView(getContext());
            iv.setImageResource(R.drawable.home_titledots);
            points.addView(iv);
        }
        points.getChildAt(0).setSelected(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<points.getChildCount();i++)
            if (i==position) points.getChildAt(i).setSelected(true);
            else points.getChildAt(i).setSelected(false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
