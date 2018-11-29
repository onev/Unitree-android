package com.lt.unitreesdk.model;

import java.util.Arrays;

public class Battery extends BaseHeader {
    public int num;                                 // 编号 0时表示无电池
    public int on_off;                              // 开关机
    public int[] cell_vol;                          // 单体电压 mV
    public int SOC;                                 // SOC 0-100%
    public int current;                             // mA
    public int[] BQ_NTC;                            // ℃
    public int[] MCU_NTC;                           // ℃
    public int circle;                              // 循环数
    public int bq_status;                           // bq769x0状态
    public int year;                                // 出厂年份
    public int month;                               // 月份
    public int day;                                 // 日期

    public Battery analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        num = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8));
        on_off = data[6];
        cell_vol = new int[]{
                (int) ((data[8] & 0xFF) | ((data[9] & 0xFF) << 8)),
                (int) ((data[10] & 0xFF) | ((data[11] & 0xFF) << 8)),
                (int) ((data[12] & 0xFF) | ((data[13] & 0xFF) << 8)),
                (int) ((data[14] & 0xFF) | ((data[15] & 0xFF) << 8)),
                (int) ((data[16] & 0xFF) | ((data[17] & 0xFF) << 8)),
                (int) ((data[18] & 0xFF) | ((data[19] & 0xFF) << 8)),
                (int) ((data[20] & 0xFF) | ((data[21] & 0xFF) << 8)),
                (int) ((data[22] & 0xFF) | ((data[23] & 0xFF) << 8)),
                (int) ((data[24] & 0xFF) | ((data[25] & 0xFF) << 8)),
                (int) ((data[26] & 0xFF) | ((data[27] & 0xFF) << 8)),
                (int) ((data[28] & 0xFF) | ((data[29] & 0xFF) << 8)),
                (int) ((data[30] & 0xFF) | ((data[31] & 0xFF) << 8)),
                (int) ((data[32] & 0xFF) | ((data[33] & 0xFF) << 8)),
                (int) ((data[34] & 0xFF) | ((data[35] & 0xFF) << 8)),
                (int) ((data[36] & 0xFF) | ((data[37] & 0xFF) << 8))
        };

        SOC = data[38];
        current = (int) ((data[40] & 0xFF)
                | ((data[41] & 0xFF) << 8)
                | ((data[42] & 0xFF) << 16)
                | ((data[43] & 0xFF) << 24));

        BQ_NTC = new int[]{
                (int) ((data[44] & 0xFF) | ((data[45] & 0xFF) << 8)),
                (int) ((data[46] & 0xFF) | ((data[47] & 0xFF) << 8)),
                (int) ((data[48] & 0xFF) | ((data[49] & 0xFF) << 8)),
        };
        MCU_NTC = new int[]{
                (int) ((data[50] & 0xFF) | ((data[51] & 0xFF) << 8)),
                (int) ((data[52] & 0xFF) | ((data[53] & 0xFF) << 8)),
        };

        circle = (int) ((data[54] & 0xFF) | ((data[55] & 0xFF) << 8));
        bq_status = data[56];
        year = data[57];
        month = data[58];
        day = data[59];

        return this;
    }
}
