package com.dreamstations.eatnowait.eatnowait.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 7YHong on 2015/9/8.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments;
    Context c;

    String[] actions = new String[] { "Bookmark", "Subscribe", "Share" };

    public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return actions[position];
    }

}
