package com.lt.unitreetest.ui.device.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.model.ConsoleBatteryItem;
import com.lt.unitreetest.ui.device.fragment.adapter.ConsoleBatteryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment {

    @BindView(R.id.rv_battery_list)
    RecyclerView recyclerView;


    private List<ConsoleBatteryItem> itemList = new ArrayList<>();
    private ConsoleBatteryAdapter adapter;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this,view);

        initView();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new ConsoleBatteryAdapter(itemList,getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    public void initView(){
        for (int i =0;i<13;i++){
            ConsoleBatteryItem one = new ConsoleBatteryItem((float)2.5);
            itemList.add(one);
        }
        ConsoleBatteryItem two = new ConsoleBatteryItem((float)3.7);
        itemList.add(two);
    }

}
