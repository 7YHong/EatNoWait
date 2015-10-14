package com.dreamstations.eatnowait.eatnowait.View;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamstations.eatnowait.eatnowait.R;

/**
 * Created by 7YHong on 2015/10/1.
 */
public class Custom_My_Item extends LinearLayout{
    public Custom_My_Item(Context context) {
        this(context,null);
    }

    public Custom_My_Item(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        initView(context,attrs);
    }

    public Custom_My_Item(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Custom_My_Item(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray t=context.obtainStyledAttributes(attrs, R.styleable.my_item_style);
        String text=t.getString(R.styleable.my_item_style_my_item_text);
        Drawable icon=t.getDrawable(R.styleable.my_item_style_my_item_icon);
        View.inflate(context, R.layout.my_item, this);
        TextView tv= (TextView) findViewById(R.id.my_item_text);
        tv.setText(text);
        ImageView iv= (ImageView) findViewById(R.id.my_item_icon);
        iv.setImageDrawable(icon);

    }
}
