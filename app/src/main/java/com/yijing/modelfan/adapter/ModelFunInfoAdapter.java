package com.yijing.modelfan.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yijing.modelfan.R;

/**
 * Created by xycong on 2016/5/28.
 */
public class ModelFunInfoAdapter extends RecyclerView.Adapter {
    public static final int FUNINFO = 1;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FunListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_funinfo, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    switch (getItemViewType(position)) {
                        case FUNINFO:
                            return 6;
                        default:
                            return 6;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class FunListViewHolder extends RecyclerView.ViewHolder {

        public FunListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
