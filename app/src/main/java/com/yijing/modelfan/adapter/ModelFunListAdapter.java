package com.yijing.modelfan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yijing.modelfan.R;

/**
 * Created by xycong on 2016/5/28.
 */
public class ModelFunListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new FunListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funlist,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FunListViewHolder)holder).itemView.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    class FunListViewHolder extends RecyclerView.ViewHolder{

        public FunListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
