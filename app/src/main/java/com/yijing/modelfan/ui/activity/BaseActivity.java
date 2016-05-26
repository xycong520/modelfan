package com.yijing.modelfan.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.yijing.modelfan.R;
import com.yijing.modelfan.utils.VolleySingleton;

/**
 * Created by xycong on 2016/5/18.
 */
public abstract class BaseActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    String TAG = "";
    Toolbar toolbar;
//    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
    }

    //设置Toolbar
    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        if (toolbar != null) {
            //设置toolbar作为actionbar
            setSupportActionBar(toolbar);

            // Set up the action bar.
            final ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.setDisplayHomeAsUpEnabled(true);
            }
        }

    }

    //设置工具栏标题
    protected void setToolbarTitle(String title) {
        // Set up the action bar.
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
//        if (appBarLayout != null) {
//            appBarLayout.addOnOffsetChangedListener(this);
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (appBarLayout != null) {
//            appBarLayout.removeOnOffsetChangedListener(this);
//        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //取消volley 连接
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        if (queue != null) {
            cancelVolleyRequest(queue);
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            setRefreshEnabled(true);
        } else {
            setRefreshEnabled(false);
        }
    }

    //设置是否enable refresh
    protected abstract void setRefreshEnabled(boolean enabled);

    protected abstract void cancelVolleyRequest(RequestQueue queue);
}
