package com.lt.unitreesdk;

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

public interface OnFuncListener {
    // 心跳包1Hz
    void heartBeat(Heartbeat heartbeat);

    // 版本信息
    void vertion(Vertion vertion);

    // 状态
    void status(Status status);

    // WiFi
    void wifi(WiFi wifi);

    // 电池信息
    void battery(Battery battery);

    // 摇杆值
    void rocker(Rocker rocker);

    // 电机相关
    void motor(Motor motor);

    // 按键
    void btn(Btn btn);

    // 巡航
    void cruise(Cruise cruise);

    // 导航
    void navegation(Navegation navegation);

    // 航点
    void waypoint(Waypoint waypoint);

    // IAP
    void iap(IAP iap);
}