package com.yijing.modelfan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijing.modelfan.R;
import com.yijing.modelfan.adapter.CommonRecyclerViewAdapter;
import com.yijing.modelfan.adapter.CommonViewHolder;
import com.yijing.modelfan.adapter.ModelKuAdapter;
import com.yijing.modelfan.model.BeanCommon;
import com.yijing.modelfan.model.BeanCommonViewType;
import com.yijing.modelfan.model.BeanModelFun;
import com.yijing.modelfan.ui.activity.FunListActivity;

import java.util.ArrayList;
import java.util.List;

public class ModelFunFragment_new extends Fragment {
    View view;
    List<BeanModelFun> funs = new ArrayList<>();
    String[] itemName = {
            "平面通告", "礼仪通告", "展会通告", "摄影通告", "电商通告", "广告通告", "才艺通告", "代言通告", "影视通告", "网红通告", "官方通告", "更多通告"
    };
    int[] itemID = {
            R.mipmap.icon_pingmian, R.mipmap.icon_liyi,
            R.mipmap.icon_zhanhui, R.mipmap.icon_sheying,
            R.mipmap.icon_dianshang, R.mipmap.icon_guanggao,
            R.mipmap.icon_caiyi, R.mipmap.icon_daiyan,
            R.mipmap.icon_yingshi, R.mipmap.icon_wanghong,
            R.mipmap.icon_guanfang, R.mipmap.icon_more
    };
    String[] itemName2 = {
            "化妆师", "造型师", "美容师", "整形师", "摄影师", "设计师", "培训师", "维权师", "主持人", "经纪人", "模院校", "更多服务"
    };
    int[] itemID2 = {
            R.mipmap.icon_huazhuangshi, R.mipmap.icon_zaoxingshi,
            R.mipmap.icon_meirongshi, R.mipmap.icon_zhengxingshi,
            R.mipmap.icon_sheyingshi, R.mipmap.icon_shejishi,
            R.mipmap.icon_peixunshi, R.mipmap.icon_weiquanshi,
            R.mipmap.icon_zhuchiren, R.mipmap.icon_pingmian,
            R.mipmap.icon_moyuanxiao, R.mipmap.icon_more
    };
    List<BeanCommonViewType> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_modelku, container, false);
            init();
        }
        ViewGroup parent = (ViewGroup)view.getParent();
        if(parent != null) {
            parent.removeView(view);
        }
//        init();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void init() {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvModelfun);
        //布局为GridView
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (recyclerView.getAdapter().getItemViewType(position)){
                    case R.layout.layout_adview_head:return 4;
                    case R.layout.item_graidview:return 1;
                    case R.layout.item_tonggao:return 4;
                    case R.layout.item_texttitle:return 4;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        BeanCommonViewType commonAD = new BeanCommonViewType();
        commonAD.setViewType(R.layout.layout_adview_head);
        commonAD.setBeanObj(null);
        data.add(commonAD);
        for (int i=0;i<itemID.length;i++){
            BeanCommonViewType commonItem = new BeanCommonViewType();
            commonItem.setViewType(R.layout.item_graidview);
            BeanModelFun modelFun = new BeanModelFun();
            modelFun.setImgID(itemID[i]);
            modelFun.setTextValue(itemName[i]);
            commonItem.setBeanObj(modelFun);
            data.add(commonItem);
        }
        BeanCommonViewType commonTextTitle = new BeanCommonViewType();
        commonTextTitle.setViewType(R.layout.item_texttitle);
        commonTextTitle.setBeanObj("最新通告");
        data.add(commonTextTitle);
        for (int i= 0;i<3;i++){
            BeanCommonViewType tonggao = new BeanCommonViewType();
            tonggao.setViewType(R.layout.item_tonggao);
            data.add(tonggao);
        }
        recyclerView.setAdapter(new CommonRecyclerViewAdapter(data) {
            @Override
            public void convert(CommonViewHolder holder, int position) {
                switch (getItemViewType(position)){
                    case R.layout.layout_adview_head:
                        getChildFragmentManager().beginTransaction().add(R.id.fragmentHeadAD, new ADViewFragment()).commit();
                        break;
                    case R.layout.item_graidview:
                        BeanModelFun modelFun = (BeanModelFun) data.get(position).getBeanObj();
                        TextView tvName = holder.getView(R.id.tvText);
                        ImageView ivIcon = holder.getView(R.id.ivIcon);
                        tvName.setText(modelFun.getTextValue());
                        ivIcon.setImageResource(modelFun.getImgID());
                        holder.itemView.setOnClickListener(onClickListener);

                        break;
                    case R.layout.item_texttitle:
                        String s = (String) data.get(position).getBeanObj();
                        TextView tvTitle = holder.getView(R.id.tvTitleName);
                        tvTitle.setText(s);
                        break;
                    case R.layout.item_tonggao:
                        break;
                }
            }
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.itemGraidview:
                            Intent intent = new Intent(getActivity(), FunListActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            };
        });
    }
}
