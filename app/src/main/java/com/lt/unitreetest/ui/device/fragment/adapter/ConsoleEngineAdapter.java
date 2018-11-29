package com.lt.unitreetest.ui.device.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.common.MyApplication;
import com.lt.unitreetest.model.ConsoleEngineItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zhaowenlong on 2018/11/6 17:00
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class ConsoleEngineAdapter extends RecyclerView.Adapter<ConsoleEngineAdapter.ViewHolder> {
    private List<ConsoleEngineItem> mItemList;
    private Context mContext;

    public ConsoleEngineAdapter(List<ConsoleEngineItem> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_console_engine,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        ConsoleEngineItem item = mItemList.get(position);
        holder.engineNumber.setText(item.getEngineNumber());
        switch (item.getStatusIcon()){
            case 1:
                holder.engineStatus.setText("正常运转");
                holder.engineIcon.setImageResource(R.drawable.ic_normal_operations);
                break;
            case 2:
                holder.engineStatus.setText("自检中");
                holder.engineIcon.setImageResource(R.drawable.ic_self_test);
                break;
            case 3:
                holder.engineStatus.setText("电子刹车");
                holder.engineIcon.setImageResource(R.drawable.ic_brakes);
                break;
            case 4:
                holder.engineStatus.setText("故障");
                holder.engineStatus.setTextColor(Color.parseColor("#FF0000"));
                holder.engineIcon.setImageResource(R.drawable.ic_fault);
                break;
                default:
                    break;
        }
        holder.temperature1.setText(item.getEngineTemperature1());
        holder.temperature2.setText(item.getEngineTemperature2());
        holder.jointAngle.setText(item.getJointAngle());
        holder.jointSpeed.setText(item.getJointSpeed());

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_engine_number)
        TextView engineNumber;
        @BindView(R.id.tv_engine_status)
        TextView engineStatus;
        @BindView(R.id.iv_engine_icon)
        ImageView engineIcon;
        @BindView(R.id.tv_engine_temperature1)
        TextView temperature1;
        @BindView(R.id.tv_engine_temperature2)
        TextView temperature2;
        @BindView(R.id.tv_joint_angle)
        TextView jointAngle;
        @BindView(R.id.tv_joint_speed)
        TextView jointSpeed;


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
