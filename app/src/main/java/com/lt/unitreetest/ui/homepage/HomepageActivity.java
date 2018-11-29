package com.lt.unitreetest.ui.homepage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.model.TabEntity;
import com.lt.unitreetest.ui.homepage.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomepageActivity extends AppCompatActivity {

    @BindView(R.id.vp_homepage)
    ViewPager mViewPager;
    @BindView(R.id.tl_homepage)
    CommonTabLayout mTab;


    private Unbinder unbinder;
    private ViewPageAdapter viewPagerAadpter;
    private List<BaseFragment> fragmentList;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private DeviceFragment firstFragment;
    private MoreFragment secondFragment;
    private PersonalFragment thirdFragment;
    private final int REQUEST_CODED = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        unbinder = ButterKnife.bind(this);
        requestPermission();
        initView();
    }

    private void initView() {

        if (null == fragmentList) {
            fragmentList = new ArrayList<BaseFragment>();
        }

        if (null == firstFragment) {
            firstFragment = new DeviceFragment();
            fragmentList.add(firstFragment);
        }

        if (null == secondFragment) {
            secondFragment = new MoreFragment();
            fragmentList.add(secondFragment);
        }

        if (null == thirdFragment) {
            thirdFragment = new PersonalFragment();
            fragmentList.add(thirdFragment);
        }


        mTabEntities.add(new TabEntity(getString(R.string.device),R.drawable.ic_device_selected,R.drawable.ic_device));
        mTabEntities.add(new TabEntity(getString(R.string.more),R.drawable.ic_more_selected,R.drawable.ic_more));
        mTabEntities.add(new TabEntity(getString(R.string.personal),R.drawable.ic_personal_selected,R.drawable.ic_personal));

        viewPagerAadpter = new ViewPageAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(viewPagerAadpter);
        mTab.setTabData(mTabEntities);

        mViewPager.setOffscreenPageLimit(3);

        //为tab页的点击添加监听事件
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        //为viewPager的滑动添加监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void requestPermission() {
        List<String> permissions = new ArrayList<String>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
            }

            if (!(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                }
            }
            if (!(checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    permissions.add(Manifest.permission.INTERNET);
                }
            }
            if (!(checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    permissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
                }
            }
            if (!(checkSelfPermission(Manifest.permission.CHANGE_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    permissions.add(Manifest.permission.CHANGE_NETWORK_STATE);
                }
            }
            if (permissions.size() > 0) {
                String[] pers = permissions.toArray(new String[permissions.size()]);
                requestPermissions(pers, REQUEST_CODED);
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
}
