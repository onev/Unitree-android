package com.lt.unitreetest.ui.device.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.ConsoleBatteryItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zhaowenlong on 2018/11/15 10:09
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class ConsoleBatteryAdapter extends RecyclerView.Adapter<ConsoleBatteryAdapter.ViewHolder> {
    private List<ConsoleBatteryItem> mItemList;
    private Context mContext;

    public ConsoleBatteryAdapter(List<ConsoleBatteryItem> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_console_battery,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        ConsoleBatteryItem item = mItemList.get(position);
        holder.voltage.setText(item.getItemVoltage()+"V");
        if (item.getItemVoltage()<=2.7){
            holder.voltageValue.setBackgroundColor(Color.parseColor("#d81e06"));
            holder.voltageValue.setWidth(Math.round(TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, item.getItemVoltage()*60,mContext.getResources().getDisplayMetrics())));
        }else {
            holder.voltageValue.setBackgroundColor(Color.parseColor("#1F9016"));
            holder.voltageValue.setWidth(Math.round(TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, item.getItemVoltage()*60,mContext.getResources().getDisplayMetrics())));
        }


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_battery_power)
        TextView voltageValue;
        @BindView(R.id.tv_battery_voltage)
        TextView voltage;



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
