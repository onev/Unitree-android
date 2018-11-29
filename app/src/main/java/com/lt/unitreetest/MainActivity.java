package com.lt.unitreetest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.lt.unitreesdk.DigitalTrans;
import com.lt.unitreesdk.OnFuncListener;
import com.lt.unitreesdk.OnSocketListener;
import com.lt.unitreesdk.UnitreeSDK;
import com.lt.unitreesdk.model.Battery;
import com.lt.unitreesdk.model.Btn;
import com.lt.unitreesdk.model.Cruise;
import com.lt.unitreesdk.model.Heartbeat;
import com.lt.unitreesdk.model.IAP;
import com.lt.unitreesdk.model.Motor;
import com.lt.unitreesdk.model.Navegation;
import com.lt.unitreesdk.model.Rocker;
import com.lt.unitreesdk.model.Status;
import com.lt.unitreesdk.model.Vertion;
import com.lt.unitreesdk.model.Waypoint;
import com.lt.unitreesdk.model.WiFi;
import com.lt.unitreetest.model.TabEntity;
import com.lt.unitreetest.ui.device.ConsoleActivity;
import com.lt.unitreetest.ui.device.fragment.FourFragment;
import com.lt.unitreetest.ui.device.fragment.OneFragment;
import com.lt.unitreetest.ui.device.fragment.ThreeFragment;
import com.lt.unitreetest.ui.device.fragment.TwoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements OnSocketListener, OnFuncListener {

    @BindView(R.id.iv_console_more_read)
    ImageView moreRead;
    @BindView(R.id.tv_console_battery)
    TextView soc;
    @BindView(R.id.tv_console_logo)
    TextView logo;

    /*接收发送定义的常量*/
    private String mIp = "192.168.1.1";
    private int mPort = 8899;
    private static UnitreeSDK unitreeSDK;
    private Boolean tag;

    private Unbinder unbinder;

    /*****************************/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tag =true;
        startConn(tag);


        moreRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConsoleActivity.class);
                startActivity(intent);
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void startConn(Boolean tag){
        if (tag) {
            /***************连接*****************/
            unitreeSDK = new UnitreeSDK(mIp, mPort);
            Log.i("zhao", "onClick: "+"点击连接");
            unitreeSDK.setOnSocketListener(MainActivity.this);
            unitreeSDK.setOnFuncListener(MainActivity.this);
            unitreeSDK.Conn();
            /**********************************/
        } else {
            if (unitreeSDK != null)
                unitreeSDK.Colse();
        }
    }

    // SDK返回方法 UnitreeSDK.OnSocketListener
    @Override
    public void conn() {
        tag = false;
    }

    @Override
    public void colse() {
        tag = true;
       // Toast.makeText(this,"未连接上机器人WiFi",Toast.LENGTH_SHORT).show();
        unitreeSDK = null;
    }

    @Override
    public void send() {

    }

    @Override
    public void recData(String data) {
    }

    // OnFuncListener

    @Override
    public void heartBeat(Heartbeat heartbeat) {

    }

    @Override
    public void vertion(Vertion vertion) {
//        Log.i("UnitreesVersion", "protocol: "+vertion.hardware[0]);
//        Log.i("UnitreesVersion", "protocol: "+vertion.hardware[1]);
//        Log.i("UnitreesVersion", "protocol: "+vertion.software[0]);
//        Log.i("UnitreesVersion", "protocol: "+vertion.software[1]);
//        Log.i("UnitreesVersion", "protocol: "+vertion.protocol);
        Log.i("UnitreesVersion", "protocol: "+vertion.len);
    }

    @Override
    public void status(Status status) {
        Log.i("UnitreesStatus", "high: "+status.high);
        Log.i("UnitreesStatus", "yaw: "+status.yaw);
        Log.i("UnitreesStatus", "len: "+status.len);
    }

    @Override
    public void wifi(WiFi wifi) {
        Log.i("UnitreesWiFi", "status: "+wifi.status);
    }

    @Override
    public void battery(Battery battery) {
        Log.i("UnitreesBattery", "circle: "+battery.circle);
        Log.i("UnitreesBattery", "SOC: "+battery.SOC);
        Log.i("UnitreesBattery", "len: "+battery.len);
    }

    @Override
    public void rocker(Rocker rocker) {

    }

    @Override
    public void motor(Motor motor) {
        Log.i("UnitreesMotorAngle0", "angle0: "+motor.joint_angle[0]);
        Log.i("UnitreesMotorAngle1", "angle1: "+motor.joint_angle[1]);
        Log.i("UnitreesMotorStatus0", "status0: "+motor.mode_status[0]);
    }

    @Override
    public void btn(Btn btn) {
        Log.i("UnitreesBtn", "val0: "+btn.val[0]);
    }

    @Override
    public void cruise(Cruise cruise) {
        Log.i("UnitreesCruisel", "length: "+cruise.length);
        Log.i("UnitreesCruise", "turns: "+cruise.turns);
    }

    @Override
    public void navegation(Navegation navegation) {
        Log.i("UnitreesNav", "antenna_altitude: "+navegation.antenna_altitude);
        Log.i("UnitreesNav", "latitude: "+navegation.latitude);
    }

    @Override
    public void waypoint(Waypoint waypoint) {
        Log.i("UnitreesWayPoint", "x: "+waypoint.x);
        Log.i("UnitreesWayPoint", "y: "+waypoint.y);
        Log.i("UnitreesWayPoint", "heading: "+waypoint.heading);
    }

    @Override
    public void iap(IAP iap) {
        Log.i("UnitreesIAP", "num: "+iap.num);
        Log.i("UnitreesIAP", "signal: "+iap.signal);
        Log.i("UnitreesIAP", "status: "+iap.status);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
}







