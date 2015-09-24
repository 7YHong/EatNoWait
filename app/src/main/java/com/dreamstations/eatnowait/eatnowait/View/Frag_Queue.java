package com.dreamstations.eatnowait.eatnowait.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dreamstations.eatnowait.eatnowait.R;

/**
 * Created by 7YHong on 2015/9/24.
 */
public class Frag_Queue extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView v=new ImageView(getContext());
        v.setImageResource(R.drawable.queue_default);
        v.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        return v;
    }
}
