package com.bw.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.recyclerview.fragment.DepartmentsFragment;
import com.bw.recyclerview.fragment.NetworkedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class DepartmentsActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TextView tv_newworked;
    private TextView tv_departments;
    private List<Fragment> list;
    private FragmentManager fm;
    private LinearLayout ll_departments;
    private LinearLayout ll_newworked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        findID();
        initData();
    }

        public  void initData(){
            fm=getSupportFragmentManager();
            list=new ArrayList<Fragment>();
            DepartmentsFragment departmentsfragment=new DepartmentsFragment();
            NetworkedFragment networkedfragment=new NetworkedFragment();
            list.add(departmentsfragment);
            list.add(networkedfragment);
            viewPager.setAdapter(new FragmentPagerAdapter(fm) {
                @Override
                public Fragment getItem(int position) {
                    return list.get(position);
                }

                @Override
                public int getCount() {
                    return list.size();
                }
            });
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            tv_departments.setTextColor(Color.BLUE);
                            ll_departments.setBackgroundColor(Color.BLUE);
                            tv_newworked.setTextColor(Color.BLACK);
                            ll_newworked.setBackgroundColor(Color.BLACK);
                            break;
                        case 1:
                            tv_departments.setTextColor(Color.BLACK);
                            ll_departments.setBackgroundColor(Color.BLACK);
                            tv_newworked.setTextColor(Color.BLUE);
                            ll_newworked.setBackgroundColor(Color.BLUE);
                            break;

                        default: break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    private void findID() {
        viewPager=(ViewPager)findViewById(R.id.pager);
        ll_departments=(LinearLayout)findViewById(R.id.ll_departments);
        ll_newworked=(LinearLayout)findViewById(R.id.ll_newworked);
        tv_departments=(TextView)findViewById(R.id.tv_departments);
        tv_newworked=(TextView)findViewById(R.id.tv_newworked);
        tv_newworked.setOnClickListener(this);
        tv_departments.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.tv_departments:
                viewPager.setCurrentItem(0);
                break;
            case  R.id.tv_newworked:
                viewPager.setCurrentItem(1);
                break;
            default: break;
        }
    }
}
