package com.yijing.modelfan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.yijing.modelfan.model.BeanCommonViewType;
import com.yijing.modelfan.Constant;

import java.util.List;


/**
 * Created by PCPC on 2016/5/26.
 */
public abstract class CommonRecyclerViewAdapter extends RecyclerView.Adapter {
    public List<BeanCommonViewType> datas;
    public BeanCommonViewType loadMore, noData;
//    public DisplayImageOptions options = CustomOptions.getOptions2();

    public CommonRecyclerViewAdapter(List<BeanCommonViewType> datas) {
        this.datas = datas;
        loadMore = new BeanCommonViewType();
//        loadMore.setViewType(R.layout.item_loadmore);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder viewHolder = CommonViewHolder.get(parent.getContext(), parent, viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        convert((CommonViewHolder) holder, position);
    }

    public abstract void convert(CommonViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getViewType();
    }

    //第一页数据
    public void initDatas(List<BeanCommonViewType> datas) {
        if (datas == null || datas.size() < 1) {
            this.datas.clear();
            this.datas.add(noData);
        } else if (datas.size() == Constant.pageNum) {
            this.datas = datas;
            loadMore = new BeanCommonViewType();
//            loadMore.setViewType(R.layout.item_loadmore);
            this.datas.add(loadMore);
        } else {
            this.datas = datas;
            loadMore = null;
        }
        notifyDataSetChanged();
    }

    public void addDatas(List<BeanCommonViewType> datas) {
        //如果是加载更多数据插入到loding前面
        if (this.datas.contains(loadMore)) {
            this.datas.addAll(this.datas.lastIndexOf(loadMore), datas);
        } else {
            this.datas.addAll(datas);
        }
        //每页返回10条数据，如果等于10允许加载下一页，添加加载更多item
        if (datas.size() == Constant.pageNum) {
            if (loadMore == null) {
                loadMore = new BeanCommonViewType();
//                loadMore.setViewType(R.layout.item_loadmore);
                this.datas.add(loadMore);
            }
        } else {
            //移除加载更多item
            if (this.datas.contains(loadMore)) {
                this.datas.remove(loadMore);
                loadMore = null;
            }
        }
        notifyDataSetChanged();
    }

    public void setDatas(List<BeanCommonViewType> datas) {
        this.datas = datas;
    }

    public List<BeanCommonViewType> getDatas() {
        return datas;
    }
}
