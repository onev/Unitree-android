package com.lt.unitreesdk.model;

public class Rocker extends BaseHeader {
    public int left_x;                                // 左摇杆左右方向
    public int left_y;                                // 左摇杆上下方向
    public int right_x;                               // 右摇杆左右方向
    public int right_y;                               // 右摇杆上下方向

    public Rocker analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        left_x = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8));
        left_y = (int) ((data[6] & 0xFF)
                | ((data[7] & 0xFF) << 8));
        right_x = (int) ((data[8] & 0xFF)
                | ((data[9] & 0xFF) << 8));
        right_y = (int) ((data[10] & 0xFF)
                | ((data[11] & 0xFF) << 8));

        return this;
    }
}
