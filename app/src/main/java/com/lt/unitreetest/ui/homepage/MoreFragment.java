package com.lt.unitreetest.ui.homepage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lt.unitreetest.MainActivity;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.PersonalMenuItem;
import com.lt.unitreetest.ui.homepage.adapter.MoreAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends BaseFragment {

    @BindView(R.id.tv_logo)
    TextView logo;
    @BindView(R.id.rv_more_menu)
    RecyclerView recyclerView;

    private List<PersonalMenuItem> itemList =new ArrayList<>();
    private MoreAdapter adapter;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this,view);

        logo.setText(getActivity().getString(R.string.more));
        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        adapter = new MoreAdapter(itemList,getActivity());
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

    public void initData(){
        PersonalMenuItem first = new PersonalMenuItem(R.drawable.ic_machine,getString(R.string.machine));
        PersonalMenuItem second = new PersonalMenuItem(R.drawable.ic_communication,getString(R.string.communication));
        PersonalMenuItem third = new PersonalMenuItem(R.drawable.ic_battery,getString(R.string.battery));
        PersonalMenuItem fouth = new PersonalMenuItem(R.drawable.engine_black,getString(R.string.engine));
        PersonalMenuItem fifth = new PersonalMenuItem(R.drawable.ic_cruise,getString(R.string.cruise));
        itemList.add(first);
        itemList.add(second);
        itemList.add(third);
        itemList.add(fouth);
        itemList.add(fifth);
    }

}
