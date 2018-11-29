package com.lt.unitreesdk.model;

public class Navegation extends BaseHeader {
    /*
     * 1: GPS
     * 2: 北斗
     * 4：伽利略
     * 8：GLONASS
     */
    public int GNSS;                                  //
    public int status;                                // 定位状态
    public int satellite_num;                         // 卫星数
    public int longitude;
    public int latitude;
    public int antenna_altitude;                      // 天线仰角
    public int speed;                                 // 地速 knots
    public int yaw;                                   // 航向 x10

    public Navegation analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        GNSS = data[4];
        status = data[5];
        satellite_num = data[6];
        longitude = (int) ((data[8] & 0xFF)
                | ((data[9] & 0xFF) << 8)
                | ((data[10] & 0xFF) << 16)
                | ((data[11] & 0xFF) << 24));
        latitude = (int) ((data[12] & 0xFF)
                | ((data[13] & 0xFF) << 8)
                | ((data[14] & 0xFF) << 16)
                | ((data[15] & 0xFF) << 24));
        antenna_altitude = (int) ((data[16] & 0xFF)
                | ((data[17] & 0xFF) << 8)
                | ((data[18] & 0xFF) << 16)
                | ((data[19] & 0xFF) << 24));
        speed = (int) ((data[20] & 0xFF)
                | ((data[21] & 0xFF) << 8));
        yaw = (int) ((data[22] & 0xFF)
                | ((data[23] & 0xFF) << 8));
        return this;
    }
}
