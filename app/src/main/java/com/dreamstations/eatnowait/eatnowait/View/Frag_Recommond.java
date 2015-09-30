package com.dreamstations.eatnowait.eatnowait.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamstations.eatnowait.eatnowait.Adapter.Recommond_ListAdapter;
import com.dreamstations.eatnowait.eatnowait.Model.Product;
import com.dreamstations.eatnowait.eatnowait.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/9/26.
 */
public class Frag_Recommond extends Fragment{
    ListView productslist;
    List<Product> products;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //生成一组数据
        products=new ArrayList<>();
        for (int i=0;i<10;i++){
            Product p=new Product();
            p.setTitle("Title:"+String.valueOf(i));
            p.setSubtitle("SubTitle:" + String.valueOf(i));
            p.setDetail("Detail:" + String.valueOf(i));
            products.add(p);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_recommond,container,false);
        productslist = (ListView) v.findViewById(R.id.recommond_productslist);
        Recommond_ListAdapter adapter=new Recommond_ListAdapter(getContext(), products);
        adapter.setOnOrderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.recommond_card_order)
                    Toast.makeText(getContext(),"OrderBtnClicked ",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(),"Something Error!",Toast.LENGTH_SHORT).show();
            }
        });
        productslist.setAdapter(adapter);
        return v;
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        productslist.removeAllViews();
//    }
}
