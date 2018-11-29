package com.lt.unitreesdk.model;

public class Status extends BaseHeader {
    public int pitch;                                  // x100
    public int roll;                                   // x100
    public int yaw;                                    // x100
    public int high;                                   // 高 cm
    public int[] speed;                               // X和Y方向速度 cm/s 2位
    public struct left_front;
    public struct left_rear;
    public struct right_front;
    public struct right_rear;
    public int total_time;                            // 总开机时间
    public int total_time_today;                      // 今天/一天开机总时间
    public int time;                                  // 此次开机时间
    public class struct {
        public int status;                             // 脚部传感器状态
        public int force;                              // 力度 N
    }

    public Status analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        pitch = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8));
        roll = (int) ((data[6] & 0xFF)
                | ((data[7] & 0xFF) << 8));
        yaw = (int) ((data[8] & 0xFF)
                | ((data[9] & 0xFF) << 8));
        high = data[10];
        speed = new int[]{(int) ((data[12] & 0xFF)
                | ((data[13] & 0xFF) << 8)), (int) ((data[14] & 0xFF)
                | ((data[15] & 0xFF) << 8))};

        struct left_front = new struct();
        struct left_rear = new struct();
        struct right_front = new struct();
        struct right_rear = new struct();

        left_front.status = data[16];
        left_rear.status = data[20];
        right_front.status = data[24];
        right_rear.status = data[28];

        left_front.force = (int) ((data[17] & 0xFF)
                | ((data[18] & 0xFF) << 8));
        left_rear.force = (int) ((data[21] & 0xFF)
                | ((data[22] & 0xFF) << 8));
        right_front.force = (int) ((data[25] & 0xFF)
                | ((data[26] & 0xFF) << 8));
        right_rear.force = (int) ((data[29] & 0xFF)
                | ((data[30] & 0xFF) << 8));

        this.left_front = left_front;
        this.left_rear = left_rear;
        this.right_front = right_front;
        this.right_rear = right_rear;

        total_time = (int) ((data[32] & 0xFF)
                | ((data[33] & 0xFF) << 8)
                | ((data[34] & 0xFF) << 16)
                | ((data[35] & 0xFF) << 24));
        total_time_today = (int) ((data[36] & 0xFF)
                | ((data[37] & 0xFF) << 8)
                | ((data[38] & 0xFF) << 16)
                | ((data[39] & 0xFF) << 24));
        time = (int) ((data[40] & 0xFF)
                | ((data[41] & 0xFF) << 8)
                | ((data[42] & 0xFF) << 16)
                | ((data[43] & 0xFF) << 24));

        return this;
    }
}
