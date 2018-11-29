package com.lt.unitreesdk.model;

public class Cruise extends BaseHeader {
    public int cruise_enable;                         // 巡航模式使能
    public int attitude_enable;                       // 姿态模式使能
    public int mode;                                  // 0:矩形模式；  1：圆轨迹
    public int direction;                             // 绕行方向 顺时针/逆时针
    public int length;                                // 长度/半径 cm
    public int width;                                 // 宽度 cm
    public int turns;                                 // 绕行圈数

    public Cruise analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        cruise_enable = data[4];
        attitude_enable = data[5];
        mode = data[6];
        direction = data[7];
        length = (int) ((data[8] & 0xFF) | ((data[9] & 0xFF) << 8));
        width = (int) ((data[10] & 0xFF) | ((data[11] & 0xFF) << 8));
        turns = data[12];

        return this;
    }
}
