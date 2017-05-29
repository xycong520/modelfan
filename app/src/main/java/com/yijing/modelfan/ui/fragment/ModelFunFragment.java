package com.yijing.modelfan.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yijing.modelfan.R;
import com.yijing.modelfan.adapter.ModelKuAdapter;
import com.yijing.modelfan.model.BeanModelFun;

import java.util.ArrayList;
import java.util.List;

public class ModelFunFragment extends Fragment {
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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvModelfun);
        BeanModelFun f = new BeanModelFun();
        f.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_AD);
        funs.add(f);
        for (int i = 0; i < itemID.length; i++) {
            BeanModelFun fun = new BeanModelFun();
            fun.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_GRIDVIEW);
            fun.setImgID(itemID[i]);
            fun.setTextValue(itemName[i]);
            funs.add(fun);
        }
        BeanModelFun f3 = new BeanModelFun();
        f3.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_AD_SMALL);
        funs.add(f3);
        for (int i = 0; i < itemID2.length; i++) {
            BeanModelFun fun = new BeanModelFun();
            fun.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_GRIDVIEW);
            fun.setImgID(itemID2[i]);
            fun.setTextValue(itemName2[i]);
            funs.add(fun);
        }
        final ModelKuAdapter adapter = new ModelKuAdapter(funs, this);
        //布局为GridView
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);

        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
