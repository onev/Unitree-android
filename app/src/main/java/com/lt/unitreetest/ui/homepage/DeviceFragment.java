package com.lt.unitreetest.ui.homepage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.ui.device.FirmwareUpdateActivity;
import com.lt.unitreetest.ui.device.GuideActivity;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceFragment extends BaseFragment {

    @BindView(R.id.tv_logo)
    TextView logo;
    @BindView(R.id.iv_device)
    ImageView device;
    @BindView(R.id.mv_update)
    MarqueeView update;

    private String updateInfo = "有最新的Laikago固件可供更新 立即更新!";
    private List<String> updateList = new ArrayList<>();

    public DeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_device, container, false);
        ButterKnife.bind(this,view);

        updateList.add(updateInfo);
        updateList.add(updateInfo);
        update.startWithList(updateList);

        logo.setText(getString(R.string.logo));
//        Glide.with(getActivity()).load(R.mipmap.device).into(device);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),GuideActivity.class);
                startActivity(intent);
            }
        });
        update.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Intent intent = new Intent(getActivity(),FirmwareUpdateActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
