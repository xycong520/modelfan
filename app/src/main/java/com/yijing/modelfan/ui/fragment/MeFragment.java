package com.yijing.modelfan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijing.modelfan.R;
import com.yijing.modelfan.adapter.CommonRecyclerViewAdapter;
import com.yijing.modelfan.adapter.CommonViewHolder;
import com.yijing.modelfan.model.BeanCommon;
import com.yijing.modelfan.model.BeanCommonViewType;
import com.yijing.modelfan.model.BeanMeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xycong on 2016/5/28.
 */
public class MeFragment extends Fragment {
    View thisView;
    RecyclerView mRecyclerView;
    List<BeanCommonViewType> commonList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (thisView == null) {
            thisView = inflater.inflate(R.layout.fragment_me,null);
            init();
        }
        ViewGroup parent = (ViewGroup) thisView.getParent();
        if (parent != null) {
            parent.removeView(thisView);
        }
        return thisView;
    }

    private void init() {
        initData();


        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.rvMe);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new CommonRecyclerViewAdapter(commonList) {
            @Override
            public void convert(CommonViewHolder holder, int position) {
                switch (getItemViewType(position)) {
                    case R.layout.layout_me_userifon:
                        TextView tvName = holder.getView(R.id.tvName);
                        tvName.setText("萧萧");
                        break;
                    case R.layout.layout_me_news:
                        break;
                    case R.layout.layout_me_item:
                        ImageView ivIcon = holder.getView(R.id.ivIcon);
                        TextView tvN = holder.getView(R.id.tvName);
                        TextView tvValue = holder.getView(R.id.tvValue);
                        if (position>2 && position<=6){
                            ivIcon.setImageResource(icon[0][position-3]);
                            tvN.setText(menuNameValue[0][position-3][0]);
                            tvValue.setText(menuNameValue[0][position-3][1]);
                        }else if (position>7 && position<=11){
                            ivIcon.setImageResource(icon[1][position-8]);
                            tvN.setText(menuNameValue[1][position-8][0]);
                            tvValue.setText(menuNameValue[1][position-8][1]);
                        }else if(position >12 && position< 18){
                            ivIcon.setImageResource(icon[2][position-13]);
                            tvN.setText(menuNameValue[2][position-13][0]);
                            tvValue.setText(menuNameValue[2][position-13][1]);
                        }
                        break;
                    case R.layout.layout_div:
                        break;
                }
            }
        });
    }


    private int icon[][] = {
            {R.mipmap.icon_qianbao, R.mipmap.icon_yinhangka, R.mipmap.icon_chongzhi, R.mipmap.icon_xiaofei},
            {R.mipmap.icon_tonggao, R.mipmap.icon_fujin, R.mipmap.icon_gongzuoguanli, R.mipmap.icon_fujingongzuo},
            {R.mipmap.icon_wodeziliao,R.mipmap.icon_wodedongtai,R.mipmap.icon_tongxunlu,R.mipmap.icon_wodexiangce,R.mipmap.icon_wodexinyuan}
    };

    String[][][] menuNameValue = {
            {
                    {"钱包", "余额0.00"}, {"银行卡", "收款的银行卡"}, {"充值", "立即转入"}, {"消费", "好东西 获优惠"}},
            {
                    {"通告管理", "发布的工作"}, {"附近模特", "附近模特资源"}, {"工作管理", "应聘的工作"}, {"附近工作", "附近工作资源"}},
            {
                    {"我的资料", "基础资料+实名"}, {"我的动态", "说说近来情况"}, {"通讯录", "好友粉丝+关注"}, {"我的相册", "上传我的照片"}, {"我的心愿", "汇少成多的爱"}}
    };

    private void initData() {
       /* commonList.add(new BeanCommonViewType(R.layout.layout_me_userifon, null, 2));
        commonList.add(new BeanCommonViewType(R.layout.layout_div, null, 2));
        commonList.add(new BeanCommonViewType(R.layout.layout_me_news, null, 2));
        for (int j = 0; j < icon.length; j++) {
            for (int i = 0; i < icon[j].length; i++) {
                BeanCommon menu = new BeanCommon(R.layout.layout_me_item, new BeanMeItem(icon[j][i], menuNameValue[j][i][0], menuNameValue[j][i][1]), 1);
                commonList.add(menu);
            }
            commonList.add(new BeanCommon(R.layout.layout_div, null, 2));
        }*/
    }
}
