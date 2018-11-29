package com.lt.unitreesdk.model;

public class Vertion extends BaseHeader {
    public int[] hardware; // 硬件版本
    public int[] software; // 软件/固件版本
    public int software_size; // 固件大小
    public int bootload;  // bootload版本
    public int protocol;  // 通信协议版本
    public int versionsize;

    public Vertion analyzeData(int[] data) {

        versionsize = data.length;
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        hardware = new int[]{data[4], data[5]};
        software = new int[]{data[6], data[7]};
        software_size = (int) ((data[8] & 0xFF)
                | ((data[9] & 0xFF) << 8)
                | ((data[10] & 0xFF) << 16)
                | ((data[11] & 0xFF) << 24));
//        bootload = data[12];
//        protocol = data[13];
        return this;
    }
}
