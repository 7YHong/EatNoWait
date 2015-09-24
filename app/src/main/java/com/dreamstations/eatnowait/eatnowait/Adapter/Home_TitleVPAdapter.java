package com.dreamstations.eatnowait.eatnowait.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/9/24.
 */
public class Home_TitleVPAdapter extends PagerAdapter{
    List<ImageView> views;
    Context context;

    public Home_TitleVPAdapter(List<ImageView> views,Context context) {
        this.views=views;
        this.context=context;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        System.out.println("instantiateItem"+String.valueOf(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
        System.out.println("destoryItem" + String.valueOf(position));
    }

    @Override
    public int getCount() {
        if (views==null) return 0;
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
