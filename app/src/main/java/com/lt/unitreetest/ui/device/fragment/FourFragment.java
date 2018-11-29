package com.lt.unitreetest.ui.device.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lt.unitreetest.MainActivity;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.ConsoleEngineItem;
import com.lt.unitreetest.ui.device.fragment.adapter.ConsoleEngineAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends BaseFragment {

    @BindView(R.id.rv_console_engine)
    RecyclerView recyclerView;

    public FourFragment() {
        // Required empty public constructor
    }

    private ConsoleEngineAdapter adapter;
    private List<ConsoleEngineItem> itemList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        ButterKnife.bind(this,view);

        initView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new ConsoleEngineAdapter(itemList,getActivity());
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    public void initView(){
        ConsoleEngineItem one = new ConsoleEngineItem("1","",1,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem two = new ConsoleEngineItem("2","",2,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem three = new ConsoleEngineItem("3","",3,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem four = new ConsoleEngineItem("4","",4,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem five = new ConsoleEngineItem("5","",1,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem six = new ConsoleEngineItem("6","",2,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem seven = new ConsoleEngineItem("7","",3,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem eight = new ConsoleEngineItem("8","",4,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem nine = new ConsoleEngineItem("9","",1,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem ten = new ConsoleEngineItem("10","",2,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem elven = new ConsoleEngineItem("11","",3,"30℃","30℃","0.00°","10.0°/s");
        ConsoleEngineItem tweent = new ConsoleEngineItem("12","",4,"30℃","30℃","0.00°","10.0°/s");
        itemList.add(one);
        itemList.add(two);
        itemList.add(three);
        itemList.add(four);
        itemList.add(five);
        itemList.add(six);
        itemList.add(seven);
        itemList.add(eight);
        itemList.add(nine);
        itemList.add(ten);
        itemList.add(elven);
        itemList.add(tweent);
    }

}
