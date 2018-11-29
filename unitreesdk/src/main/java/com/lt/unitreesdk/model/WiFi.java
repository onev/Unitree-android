package com.lt.unitreesdk.model;

import java.util.Arrays;

public class WiFi extends BaseHeader {
    public int[] hardware;                            // 硬件版本
    public int[] software;                            // 固件版本
    /*
     * bit0：是否更新WiFi固件
     * bit1：是否重启
     * bit2：是否修改SSID
     * bit3：是否修改key
     */
    public int status;                               //
    public int[] SSID;                               // Byte
    public int[] key;                                // Byte 最小8

    public WiFi analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        hardware = new int[]{data[4], data[5]};
        software = new int[]{data[6], data[7]};
        status = data[8];

        SSID = Arrays.copyOfRange(data, 9, 42);
        key = Arrays.copyOfRange(data, 42, 106);
        return this;
    }
}
