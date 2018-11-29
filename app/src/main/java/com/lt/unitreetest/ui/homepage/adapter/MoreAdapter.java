package com.lt.unitreetest.ui.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.PersonalMenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zhaowenlong on 2018/10/18 09:32
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
    private List<PersonalMenuItem> mItemList;
    private Context mContext;

    public MoreAdapter(List<PersonalMenuItem> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_more_menu,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        PersonalMenuItem item = mItemList.get(position);
        holder.itemImg.setImageResource(item.getItemImg());
        holder.itemTitle.setText(item.getItemTitle());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_menu_img)
        ImageView itemImg;
        @BindView(R.id.tv_menu_title)
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
