package com.lt.unitreetest.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lt.unitreetest.R;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaowenlong on 2018/7/16.
 */
public class CommonListAdapter extends RecyclerView.Adapter<CommonListAdapter.ViewHolder> {
    private List<CommonItem> mItemList;
    private Context mContext;

    public CommonListAdapter(List<CommonItem> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_common_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CommonItem item = mItemList.get(position);
        holder.itemTitle.setText(item.getItemTitle());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_common_item_title)
        TextView itemTitle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null)
                        itemClickListener.onItemClick(view, getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount(){
        return mItemList.size();
    }
}
