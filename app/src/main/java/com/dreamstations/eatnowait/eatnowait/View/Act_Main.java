package com.dreamstations.eatnowait.eatnowait.View;

import android.app.ActionBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.dreamstations.eatnowait.eatnowait.Adapter.Main_PagerAdapter;
import com.dreamstations.eatnowait.eatnowait.R;

import java.util.ArrayList;
import java.util.List;

public class Act_Main extends AppCompatActivity {

    Toolbar mToolbar;
    Spinner mSpinner;
    ArrayAdapter<String> spinnerAdapter;
    ViewPager mViewPager;
    LinearLayout bottombar;

    //临时变量
    String[] actions = new String[] { "Bookmark", "Subscribe", "Share" };
    List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        //从Home开始，添加Fragment
        fragments.add(new Frag_Home());
        fragments.add(new Frag_Queue());
        fragments.add(new Frag_Recommond());
        fragments.add(new Frag_My());

//        //这里生成相同的Fragment玩
//        for (int i = 0; i < 1; i++)
//            fragments.add(Frag_simple.newInstance(R.layout.simple_frag_onebtn));

        initViews();

        setTitleData(actions);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        bottombar = (LinearLayout) findViewById(R.id.bottomtab);
        /**
         * Toolbar部分的设置
         */
        //要添加到Toolbar上的Spinner
        mSpinner =new Spinner(getApplicationContext());
        spinnerAdapter = new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(R.layout.simple_title_spinner);
        mSpinner.setAdapter(spinnerAdapter);
        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, parent.getItemAtPosition(position).toString(), Snackbar.LENGTH_LONG)
                        .setAction("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //默认点击了之后就隐藏了，因此不用dismiss
                            }
                        }).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mToolbar.setTitle("");
        mToolbar.addView(mSpinner, ActionBar.LayoutParams.MATCH_PARENT);
        //添加ToolBar
        setSupportActionBar(mToolbar);
        //ToolBar到现在设置完成


        //设置PagerView
        PagerAdapter pagerAdapter=new Main_PagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                syncBottomStatus(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        findViewById(R.id.bottomtab_1).setSelected(true);

    }

    private void syncBottomStatus(int position) {
        for (int i=0;i<bottombar.getChildCount();i++){
            if(i==position) {
                bottombar.getChildAt(i).setSelected(true);
            }else bottombar.getChildAt(i).setSelected(false);

        }
    }

    public void onBottomIconClick(View v){

        switch (v.getId()){
            case R.id.bottomtab_1:mViewPager.setCurrentItem(0);
                break;
            case R.id.bottomtab_2:mViewPager.setCurrentItem(1);
                break;
            case R.id.bottomtab_3:mViewPager.setCurrentItem(2);
                break;
            case R.id.bottomtab_4:mViewPager.setCurrentItem(3);
                break;
        }
    }

    public void setTitleData(String[] actions){
        spinnerAdapter.clear();
        spinnerAdapter.addAll(actions);
    }

}
