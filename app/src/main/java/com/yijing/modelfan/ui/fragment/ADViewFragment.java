package com.yijing.modelfan.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yijing.modelfan.Constant;
import com.yijing.modelfan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xycong on 2016/5/18.
 */
public class ADViewFragment extends Fragment {

    public static final String LOAD_TYPE ="loadType";
    public static final int FUN_HEAD_AD = 1;
    public static final int FUN_SMALL_AD = 2;
    public static final int KU_HEAD_AD = 3;


    View view;
    List<View> imgs;
    ViewPager mViewPage;

    int type;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            type = getArguments().getInt(LOAD_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.layout_viewpage, null);
        mViewPage = (ViewPager) view.findViewById(R.id.viewpager);
        imgs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//            LayoutInflater.from(getActivity()).inflate(R.layout.item_head_ad,null);
            ImageView imageView= (ImageView) LayoutInflater.from(getActivity()).inflate(R.layout.item_head_ad, null);
           if (type==FUN_HEAD_AD){
               imageView.setImageResource(R.mipmap.ad_fun1);
           }else if(type == FUN_SMALL_AD){
               imageView.setImageResource(R.mipmap.ad_fun2);
           }
            imageView.setTag(""+i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constant.showToast(getActivity(), String.valueOf(v.getTag().toString()));
                }
            });
            imgs.add(imageView);
        }

        mViewPage.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgs.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return  view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView(imgs.get(position));
            }

            @Override
            public View instantiateItem(ViewGroup container, int position) {
                ((ViewPager)container).addView(imgs.get(position % imgs.size()), 0);
                return imgs.get(position % imgs.size());
            }
        });
        return view;
    }
}
