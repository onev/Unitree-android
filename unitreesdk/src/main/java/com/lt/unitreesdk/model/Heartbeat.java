package com.lt.unitreesdk.model;

/**
 * 作者：zhaowenlong on 2018/11/20 15:42
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class Heartbeat extends BaseHeader{

    public int heartbeat; // 心跳包


    public Heartbeat analyzeData(int[] data) {

        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        heartbeat = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8)
                | ((data[6] & 0xFF) << 16)
                | ((data[7] & 0xFF) << 24));
        return this;
    }
}
