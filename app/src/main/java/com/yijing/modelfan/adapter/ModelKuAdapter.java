package com.yijing.modelfan.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yijing.modelfan.Constant;
import com.yijing.modelfan.R;
import com.yijing.modelfan.model.BeanModelFun;
import com.yijing.modelfan.ui.fragment.ADViewFragment;

import java.util.List;

/**
 * Created by xycong on 2016/5/19.
 */
public class ModelKuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_VIEW_TYPE_AD = 1;
    public static final int ITEM_VIEW_TYPE_GRIDVIEW = 2;
    public static final int ITEM_VIEW_TYPE_AD_SMALL = 3;

    public static final int ITEM_VIEW_TYPE_KU_GRIDVIEW = 4;
    public static final int ITEM_VIEW_TYPE_KU_RECOMNEND = 5;
    public static final int ITEM_VIEW_TYPE_KU_MODEL = 6;
    public static final int ITEM_VIEW_TYPE_KU_TEXTTITLE = 7;

    List<BeanModelFun> mData;
    Fragment mFragment;


    public ModelKuAdapter(List<BeanModelFun> data, Fragment mFragment) {
        mData = data;
        this.mFragment = mFragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case ITEM_VIEW_TYPE_AD:
                return new HeadADViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adview_head, parent, false));
            case ITEM_VIEW_TYPE_GRIDVIEW:
                return new GridViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_graidview, parent, false));
            case ITEM_VIEW_TYPE_AD_SMALL:
                return new SmallADViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adview_small, parent, false));
            case ITEM_VIEW_TYPE_KU_GRIDVIEW:
                return new KuTypeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ku_type, parent, false));
            case ITEM_VIEW_TYPE_KU_RECOMNEND:
                return new KuRecommendViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ku_recommend,parent, false));
            case ITEM_VIEW_TYPE_KU_MODEL:
                return new KuModelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ku_model, parent, false));
            case ITEM_VIEW_TYPE_KU_TEXTTITLE:
                return new KuTextTitleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ku_texttitle, parent, false));
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof GridViewHolder) {
            ((GridViewHolder) holder).getTextView().setText(mData.get(position).getTextValue());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constant.showToast(mFragment.getActivity(),""+position);
                }
            });
        } else if (holder instanceof SmallADViewHolder) {
            ADViewFragment fragment = new ADViewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ADViewFragment.LOAD_TYPE, ADViewFragment.FUN_SMALL_AD);
            fragment.setArguments(bundle);
            mFragment.getChildFragmentManager().beginTransaction().add(R.id.fragmentSmallAD, fragment).commit();
        } else if (holder instanceof HeadADViewHolder) {
            mFragment.getChildFragmentManager().beginTransaction().add(R.id.fragmentHeadAD, new ADViewFragment()).commit();
        }else if(holder instanceof KuTypeViewHolder){
            ((KuTypeViewHolder) holder).getTvTypeName().setText(mData.get(position).getTextValue());
        }else if (holder instanceof KuModelViewHolder){
            ((KuModelViewHolder) holder).getIvPhoto().setImageResource(R.mipmap.ad_ku2);
            ((KuModelViewHolder) holder).getTvTypeName().setText(mData.get(position).getTextValue());
        }else if (holder instanceof KuRecommendViewHolder){
            ((KuRecommendViewHolder) holder).getTvTypeName().setText(mData.get(position).getTextValue());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemViewType();
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
                        case ITEM_VIEW_TYPE_AD:
                            return 4;
                        case ITEM_VIEW_TYPE_AD_SMALL:
                            return 4;
                        case ITEM_VIEW_TYPE_GRIDVIEW:
                            return 1;
                        case ITEM_VIEW_TYPE_KU_GRIDVIEW:
                            return 2;
                        case ITEM_VIEW_TYPE_KU_RECOMNEND:
                            return 2;
                        case ITEM_VIEW_TYPE_KU_MODEL:
                            return 1;
                        case ITEM_VIEW_TYPE_KU_TEXTTITLE:
                            return 4;
                        default:
                            return -1;
                    }
                }
            });
        }
    }

    class SmallADViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;

        public SmallADViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.fragmentHeadAD);
        }

        public LinearLayout getLayout() {
            return layout;
        }
    }
    class KuTypeViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPhoto;
        TextView tvTypeName;

        public KuTypeViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivIcon);
            tvTypeName = (TextView) itemView.findViewById(R.id.tvText);
        }

        public ImageView getIvPhoto() {
            return ivPhoto;
        }

        public TextView getTvTypeName() {
            return tvTypeName;
        }
    }
    class KuModelViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPhoto;
        TextView tvTypeName;

        public KuModelViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivIcon);
            tvTypeName = (TextView) itemView.findViewById(R.id.tvText);
        }

        public ImageView getIvPhoto() {
            return ivPhoto;
        }

        public TextView getTvTypeName() {
            return tvTypeName;
        }
    }
    class KuRecommendViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPhoto;
        TextView tvTypeName;

        public KuRecommendViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivIcon);
            tvTypeName = (TextView) itemView.findViewById(R.id.tvText);
        }

        public ImageView getIvPhoto() {
            return ivPhoto;
        }

        public TextView getTvTypeName() {
            return tvTypeName;
        }
    }
    class KuTextTitleViewHolder extends RecyclerView.ViewHolder {

        TextView tvMore;
        TextView tvName;

        public KuTextTitleViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvTitleName);
            tvMore = (TextView) itemView.findViewById(R.id.tvMore);
        }

        public TextView getTvMore() {
            return tvMore;
        }

        public TextView getTvName() {
            return tvName;
        }
    }

    class HeadADViewHolder extends RecyclerView.ViewHolder {
//        ViewPager mViewPage;

        public HeadADViewHolder(View itemView) {
            super(itemView);
//            mViewPage = (ViewPager) itemView.findViewById(R.id.viewpager);
        }

//        public ViewPager getmViewPage() {
//            return mViewPage;
//        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public GridViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvText);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
