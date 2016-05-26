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

public class ModelkuFragment extends Fragment {

    View view;
    List<BeanModelFun> funs = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_modelku, container, false);
//        init();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvModelfun);
        BeanModelFun f = new BeanModelFun();
        f.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_AD);
        funs.add(f);
        BeanModelFun f2 = new BeanModelFun();
        f2.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_KU_GRIDVIEW);
        f2.setTextValue("平面模特");
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        BeanModelFun f3 = new BeanModelFun();
        f3.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_KU_TEXTTITLE);
        f3.setTextValue("精品推荐");
        funs.add(f3);
        BeanModelFun f4 = new BeanModelFun();
        f4.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_KU_RECOMNEND);
        f4.setTextValue("王晓彤");
        funs.add(f4);
        funs.add(f4);
        f3.setTextValue("新秀模特");
        funs.add(f3);
        BeanModelFun f5 = new BeanModelFun();
        f5.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_KU_MODEL);
        f5.setTextValue("啊五");
        funs.add(f5);
        funs.add(f5);
        funs.add(f5);
        funs.add(f5);
        funs.add(f5);
        funs.add(f5);
        final ModelKuAdapter adapter = new ModelKuAdapter(funs, this);
        //布局为GridView
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);

        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
