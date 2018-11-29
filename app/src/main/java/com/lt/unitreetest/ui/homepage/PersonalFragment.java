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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.PersonalMenuItem;
import com.lt.unitreetest.ui.homepage.adapter.MoreAdapter;
import com.lt.unitreetest.ui.personal.ForumActivity;
import com.lt.unitreetest.ui.personal.ModifyInformationActivity;
import com.lt.unitreetest.ui.personal.MyRecordActivity;
import com.lt.unitreetest.ui.personal.PasswordManagementActivity;
import com.lt.unitreetest.ui.personal.TechSupportActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseFragment {

    @BindView(R.id.iv_my_background)
    ImageView background;
    @BindView(R.id.rv_personal_menu)
    RecyclerView recyclerView;
    @BindView(R.id.iv_personal_setup)
    ImageView setup;

    private List<PersonalMenuItem> itemList =new ArrayList<>();
    private MoreAdapter adapter;

    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this,view);

        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        adapter = new MoreAdapter(itemList,getActivity());
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(),PasswordManagementActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),MyRecordActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(),TechSupportActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(),ForumActivity.class);
                        startActivity(intent3);
                        break;
                        default:break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ModifyInformationActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    public void initData(){
        PersonalMenuItem first = new PersonalMenuItem(R.drawable.ic_password,getString(R.string.password_management));
        PersonalMenuItem second = new PersonalMenuItem(R.drawable.ic_record,getString(R.string.my_record));
        PersonalMenuItem third = new PersonalMenuItem(R.drawable.ic_technical_support,getString(R.string.technical_support));
        PersonalMenuItem fouth = new PersonalMenuItem(R.drawable.ic_forum,getString(R.string.forum));
        itemList.add(first);
        itemList.add(second);
        itemList.add(third);
        itemList.add(fouth);
    }


}
