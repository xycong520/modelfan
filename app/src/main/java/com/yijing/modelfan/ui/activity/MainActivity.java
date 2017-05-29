package com.yijing.modelfan.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.android.volley.RequestQueue;
import com.yijing.modelfan.Constant;
import com.yijing.modelfan.R;
import com.yijing.modelfan.ui.fragment.FindFragment;
import com.yijing.modelfan.ui.fragment.MeFragment;
import com.yijing.modelfan.ui.fragment.ModelFunFragment;
import com.yijing.modelfan.ui.fragment.ModelFunFragment_new;
import com.yijing.modelfan.ui.fragment.ModelkuFragment;
import com.yijing.modelfan.widget.WechatRadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xycong on 2016/5/18.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private WechatRadioGroup gradualRadioGroup;
    int curIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        setToolbarTitle("模特饭");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gradualRadioGroup = (WechatRadioGroup) findViewById(R.id.radiogroup);
        List<Fragment> list = new ArrayList<>();
//        list.add(new ADViewFragment());

        ModelFunFragment_new fragmentModelFun = new ModelFunFragment_new();
        ModelkuFragment fragmentModelku = new ModelkuFragment();
        FindFragment fragmentFind = new FindFragment();
        MeFragment fragmentMe = new MeFragment();
        list.add(fragmentModelFun);
        list.add(fragmentModelku);
//        list.add(fragmentFind);
        list.add(fragmentMe);

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
                        curIndex = 0;
                        setToolbarTitle("模特饭");
                        break;
                    case 1:
                        curIndex = 1;
                        setToolbarTitle("模特库");
                        break;
                 /*   case 2:
                        setToolbarTitle("发现");
                        break;*/
                    case 2:

                        if (Constant.isLogin) {
                            curIndex = 2;
                            setToolbarTitle("我的");
                        } else {

                            viewPager.setCurrentItem(curIndex);
                            gradualRadioGroup.onPageSelected(curIndex);
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("a", state + "");
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

    @OnClick({R.id.wrb_me, R.id.wrb_findMD, R.id.wrb_findTG})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wrb_findMD:
                curIndex = 1;
                viewPager.setCurrentItem(curIndex);
                gradualRadioGroup.onPageSelected(curIndex);
                break;
            case R.id.wrb_findTG:
                curIndex = 0;
                viewPager.setCurrentItem(curIndex);
                gradualRadioGroup.onPageSelected(curIndex);

                break;
            case R.id.wrb_me:
                if (Constant.isLogin) {
                    curIndex = 2;
                    setToolbarTitle("我的");
                    gradualRadioGroup.onPageSelected(curIndex);
                } else {
                    viewPager.setCurrentItem(curIndex);
                    gradualRadioGroup.onPageSelected(curIndex);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
