package com.lt.unitreesdk.model;

public class Waypoint extends BaseHeader {
    public int x;                                     //
    public int y;
    public int heading;                               // 航向

    public Waypoint analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        x = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8)
                | ((data[6] & 0xFF) << 16)
                | ((data[7] & 0xFF) << 24));
        y = (int) ((data[8] & 0xFF)
                | ((data[9] & 0xFF) << 8)
                | ((data[10] & 0xFF) << 16)
                | ((data[11] & 0xFF) << 24));
        heading = (int) ((data[12] & 0xFF)
                | ((data[13] & 0xFF) << 8));

        return this;
    }
}
