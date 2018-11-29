package com.lt.unitreetest.ui.device;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.model.TabEntity;
import com.lt.unitreetest.ui.device.fragment.FiveFragment;
import com.lt.unitreetest.ui.device.fragment.FourFragment;
import com.lt.unitreetest.ui.device.fragment.OneFragment;
import com.lt.unitreetest.ui.device.fragment.ThreeFragment;
import com.lt.unitreetest.ui.device.fragment.TwoFragment;
import com.lt.unitreetest.ui.homepage.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class ConsoleActivity extends AppCompatActivity {

    @BindView(R.id.vp_console)
    ViewPager mViewPager;
    @BindView(R.id.tl_console)
    VerticalTabLayout mTab;
    @BindView(R.id.iv_console_close)
    ImageView close;

    private Unbinder unbinder;
    private ViewPageAdapter viewPagerAadpter;
    private List<BaseFragment> fragmentList;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;
    private  ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console);
        unbinder = ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //窗口对齐屏幕宽度
        Window win = this.getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.RIGHT;//设置对话框置顶显示
        lp.alpha =0.8f;
        win.setAttributes(lp);
        getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initData();
        initView();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData(){
        mTabEntities.add(new TabEntity(getString(R.string.machine),R.drawable.ic_machine_selected,R.drawable.ic_machine));
        mTabEntities.add(new TabEntity(getString(R.string.communication),R.drawable.ic_communication_selected,R.drawable.ic_communication));
        mTabEntities.add(new TabEntity("电池",R.drawable.ic_battery_selected,R.drawable.ic_battery));
        mTabEntities.add(new TabEntity(getString(R.string.engine),R.drawable.engine_selected,R.drawable.engine));
        mTabEntities.add(new TabEntity(getString(R.string.cruise),R.drawable.ic_cruise_selected,R.drawable.ic_cruise));
    }


    private void initView() {

        if (null == fragmentList) {
            fragmentList = new ArrayList<BaseFragment>();
        }

        if (null == oneFragment) {
            oneFragment = new OneFragment();
            fragmentList.add(oneFragment);
        }

        if (null == twoFragment) {
            twoFragment = new TwoFragment();
            fragmentList.add(twoFragment);
        }

        if (null == threeFragment) {
            threeFragment = new ThreeFragment();
            fragmentList.add(threeFragment);
        }

        if (null == fourFragment) {
            fourFragment = new FourFragment();
            fragmentList.add(fourFragment);
        }

        if (null == fiveFragment) {
            fiveFragment = new FiveFragment();
            fragmentList.add(fiveFragment);
        }


        viewPagerAadpter = new ViewPageAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(viewPagerAadpter);

        mTab.setupWithViewPager(mViewPager);
        mTab.setTabAdapter(new TabAdapter() {

            @Override
            public int getCount() {
                return mTabEntities.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return new TabView.TabIcon.Builder()
                        .setIcon(mTabEntities.get(position).getTabSelectedIcon(), mTabEntities.get(position).getTabUnselectedIcon())
                        .setIconGravity(Gravity.START)
                        .setIconMargin(15)
                        .setIconSize(70, 70)
                        .build();
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(mTabEntities.get(position).getTabTitle())
                        .setTextColor(Color.parseColor("#1F9016"), Color.WHITE)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        mViewPager.setOffscreenPageLimit(3);

        //为tab页的点击添加监听事件
        mTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

        //为viewPager的滑动添加监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTab.setTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
}
