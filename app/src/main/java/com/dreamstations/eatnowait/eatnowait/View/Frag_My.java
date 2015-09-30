package com.dreamstations.eatnowait.eatnowait.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamstations.eatnowait.eatnowait.R;

/**
 * Created by 7YHong on 2015/9/29.
 */
public class Frag_My extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_my,container,false);


        return  v;
    }
}
