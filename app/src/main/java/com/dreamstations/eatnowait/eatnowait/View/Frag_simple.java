package com.dreamstations.eatnowait.eatnowait.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamstations.eatnowait.eatnowait.R;

/**
 * Created by 7YHong on 2015/9/8.
 */
public class Frag_simple extends Fragment{

    static int layoutID;

    public static Frag_simple newInstance(int mlayoutID){
        layoutID=mlayoutID;
        return new Frag_simple();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(layoutID,container,false);
        v.findViewById(R.id.frag_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Btn Clicked!",Snackbar.LENGTH_SHORT).show();
            }
        });
        return v;
    }


}
