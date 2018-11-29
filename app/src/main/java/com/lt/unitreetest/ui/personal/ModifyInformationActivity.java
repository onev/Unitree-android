package com.lt.unitreetest.ui.personal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonTitleActivity;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class ModifyInformationActivity extends CommonTitleActivity {

    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.button32)
    RadioButton secret;
    @BindView(R.id.iv_my_portrait)
    ImageView portrait;
    @BindView(R.id.tv_country)
    TextView country;
    @BindView(R.id.btn_save_information)
    Button save;

    private Unbinder unbinder;
    private static int REQUEST_IMAGE = 400;
    private List<HotCity> hotCities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_information);
        getSupportActionBar().hide();
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);
        Glide.with(this).load(R.drawable.portrait).into(portrait);
        secret.setChecked(true);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));


        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiImageSelector.create().count(1).start(ModifyInformationActivity.this, REQUEST_IMAGE);
            }
        });
        country.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CityPicker.getInstance()
                        .setFragmentManager(getSupportFragmentManager())
                        .enableAnimation(true)
                        .setAnimationStyle(R.style.DefaultCityPickerAnimation)
                        .setLocatedCity(null)
                        .setHotCities(hotCities)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                                country.setText(data.getName());
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CityPicker.getInstance().locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                    }
                                }, 3000);
                            }
                        })
                        .show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                // Get the result list of select image paths
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                // do your logic ....
                RequestOptions options = new RequestOptions().placeholder(R.drawable.portrait).error(R.drawable.portrait).centerCrop();
                Glide.with(this).load(path.get(0)).apply(options).into(portrait);
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void beforeFinish(){}

    @Override
    public void setTitle(){titleBar.setText(getString(R.string.modify_information));}
}
