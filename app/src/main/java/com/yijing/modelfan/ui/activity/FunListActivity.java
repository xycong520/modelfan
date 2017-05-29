package com.yijing.modelfan.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.RequestQueue;
import com.yijing.modelfan.R;
import com.yijing.modelfan.adapter.ModelFunListAdapter;

/**
 * Created by xycong on 2016/5/28.
 */
public class FunListActivity extends BaseActivity {

    RecyclerView recyclerView;
    ModelFunListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funlist);
        inti();
        setupToolbar();
        setToolbarTitle("通告列表");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void inti() {
        recyclerView = (RecyclerView) findViewById(R.id.rvModelfun);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new ModelFunListAdapter());
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunListActivity.this,FunInfoActivity.class));
            }
        });
    }

    @Override
    protected void setRefreshEnabled(boolean enabled) {

    }

    @Override
    protected void cancelVolleyRequest(RequestQueue queue) {

    }
}
