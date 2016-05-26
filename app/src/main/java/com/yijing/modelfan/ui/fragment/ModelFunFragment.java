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
        f2.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_GRIDVIEW);
        f2.setTextValue("模特");
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        BeanModelFun f3 = new BeanModelFun();
        f3.setItemViewType(ModelKuAdapter.ITEM_VIEW_TYPE_AD_SMALL);
        ADViewFragment fragment = new ADViewFragment();
        funs.add(f3);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        funs.add(f2);
        final ModelKuAdapter adapter = new ModelKuAdapter(funs, this);
        //布局为GridView
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);

        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
