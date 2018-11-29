package com.lt.unitreesdk.model;

import java.util.Arrays;

public class Motor extends BaseHeader {
    public int[] mode_status;                      // 模式/状态
    public int[][] T = new int[12][2];                              // 温度 ℃ T[12][2]
    public int[] joint_angle;                      // 关节角度 °
    public int[] joint_angle_velocity;             // 关节角速度 °/s

    public int temp=16;


    public Motor analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        mode_status = Arrays.copyOfRange(data, 4, 16);
        for (int i =0;i<12;i++){
            for (int j = 0;j<2;j++){
                T[i][j] = (int) ((data[temp] & 0xFF) | ((data[temp+1] & 0xFF) << 8));
                temp +=2;
            }
        }
        joint_angle = new int[]{
                (int) ((data[64] & 0xFF) | ((data[65] & 0xFF) << 8)),
                (int) ((data[66] & 0xFF) | ((data[67] & 0xFF) << 8)),
                (int) ((data[68] & 0xFF) | ((data[69] & 0xFF) << 8)),
                (int) ((data[70] & 0xFF) | ((data[71] & 0xFF) << 8)),
                (int) ((data[72] & 0xFF) | ((data[73] & 0xFF) << 8)),
                (int) ((data[74] & 0xFF) | ((data[75] & 0xFF) << 8)),
                (int) ((data[76] & 0xFF) | ((data[77] & 0xFF) << 8)),
                (int) ((data[78] & 0xFF) | ((data[79] & 0xFF) << 8)),
                (int) ((data[80] & 0xFF) | ((data[81] & 0xFF) << 8)),
                (int) ((data[82] & 0xFF) | ((data[83] & 0xFF) << 8)),
                (int) ((data[84] & 0xFF) | ((data[85] & 0xFF) << 8)),
                (int) ((data[86] & 0xFF) | ((data[87] & 0xFF) << 8))
        };
        joint_angle_velocity = new int[]{
                (int) ((data[88] & 0xFF) | ((data[89] & 0xFF) << 8)),
                (int) ((data[90] & 0xFF) | ((data[91] & 0xFF) << 8)),
                (int) ((data[92] & 0xFF) | ((data[93] & 0xFF) << 8)),
                (int) ((data[94] & 0xFF) | ((data[95] & 0xFF) << 8)),
                (int) ((data[96] & 0xFF) | ((data[97] & 0xFF) << 8)),
                (int) ((data[98] & 0xFF) | ((data[99] & 0xFF) << 8)),
                (int) ((data[100] & 0xFF) | ((data[101] & 0xFF) << 8)),
                (int) ((data[102] & 0xFF) | ((data[103] & 0xFF) << 8)),
                (int) ((data[104] & 0xFF) | ((data[105] & 0xFF) << 8)),
                (int) ((data[106] & 0xFF) | ((data[107] & 0xFF) << 8)),
                (int) ((data[108] & 0xFF) | ((data[109] & 0xFF) << 8)),
                (int) ((data[110] & 0xFF) | ((data[111] & 0xFF) << 8))
        };

        return this;
    }
}
