package com.dreamstations.eatnowait.eatnowait.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamstations.eatnowait.eatnowait.Model.Product;
import com.dreamstations.eatnowait.eatnowait.R;

import java.util.List;

/**
 * Created by 7YHong on 2015/9/26.
 */
public class Recommond_ListAdapter extends BaseAdapter {
    Context context;
    List<Product> products;

    View.OnClickListener onOrderClickListener=null;

    //缓存的基本单位
    class ViewHolder{
        TextView title,subtitle,detail;
        Button order;
        public void setData(Product p){
            title.setText(p.getTitle());
            subtitle.setText(p.getSubtitle());
            detail.setText(p.getDetail());
        }
        public void setOnOrderClickListener(View.OnClickListener listener){
            order.setOnClickListener(listener);
        }
    }

    //外部接口，用于给按钮设置回调
    public void setOnOrderClickListener(View.OnClickListener listener){
        this.onOrderClickListener=listener;
    }

    public Recommond_ListAdapter(Context context,List<Product> products) {
        this.context=context;
        this.products=products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.recommond_card,parent,false);
            holder=new ViewHolder();
            holder.title= (TextView) convertView.findViewById(R.id.recommond_card_title);
            holder.subtitle= (TextView) convertView.findViewById(R.id.recommond_card_subtitle);
            holder.detail= (TextView) convertView.findViewById(R.id.recommond_card_detail);
            holder.order= (Button) convertView.findViewById(R.id.recommond_card_order);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }
        //上面所做的只是将holder用起来
        holder.setData(products.get(position));
        if (onOrderClickListener!=null) holder.setOnOrderClickListener(onOrderClickListener);
        return convertView;
    }
}
