package com.yijing.modelfan.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.android.volley.RequestQueue;
import com.yijing.modelfan.R;
import com.yijing.modelfan.ui.fragment.ModelFunFragment;
import com.yijing.modelfan.ui.fragment.ModelkuFragment;
import com.yijing.modelfan.widget.WechatRadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xycong on 2016/5/18.
 */
public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private WechatRadioGroup gradualRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setToolbarTitle("模特饭");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gradualRadioGroup = (WechatRadioGroup) findViewById(R.id.radiogroup);
        List<Fragment> list = new ArrayList<>();
//        list.add(new ADViewFragment());

        ModelFunFragment fragmentModelFun = new ModelFunFragment();
        ModelkuFragment fragmentModelku = new ModelkuFragment();
        list.add(fragmentModelFun);
        list.add(fragmentModelku);

        viewPager.setAdapter(new DemoPagerAdapter(getSupportFragmentManager(), list));
        gradualRadioGroup.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setToolbarTitle("模特饭");
                        break;
                    case 1:
                        setToolbarTitle("模特库");
                        break;
                    case 2:
                        setToolbarTitle("发现");
                        break;
                    case 3:
                        setToolbarTitle("我的");
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_more, menu);
        return super.onCreateOptionsMenu(menu);
    }

    class DemoPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mData;

        public DemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public DemoPagerAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            mData = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }

    @Override
    protected void setRefreshEnabled(boolean enabled) {

    }

    @Override
    protected void cancelVolleyRequest(RequestQueue queue) {
        queue.cancelAll(TAG);
    }
}
