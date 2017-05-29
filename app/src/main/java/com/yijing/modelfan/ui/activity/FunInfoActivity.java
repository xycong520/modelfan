package com.yijing.modelfan.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.yijing.modelfan.R;
import com.yijing.modelfan.adapter.ModelFunInfoAdapter;

/**
 * Created by xycong on 2016/5/28.
 */
public class FunInfoActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    ModelFunInfoAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funinfo);
        init();
        setupToolbar();
        setToolbarTitle("通告详情");
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rvModelfun);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,6);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter = new ModelFunInfoAdapter());
    }

    @Override
    protected void setRefreshEnabled(boolean enabled) {

    }

    @Override
    protected void cancelVolleyRequest(RequestQueue queue) {

    }
}
