package com.lt.unitreesdk.model;

public class IAP extends BaseHeader {
    public int signal;                                // 0xFCFD 开始    0xFBF7 结束
    public int num;                                   // 编号
    /*
     * 0：noting
     * 1：应答主机IAP命令
     * 2：正在IAP
     * 3：IAP成功
     * 4：IAP失败
     * 5：IAP错误
     */
    public int status;

    public IAP analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        signal = (int) ((data[4] & 0xFF)
                | ((data[5] & 0xFF) << 8));
        num = (int) ((data[6] & 0xFF)
                | ((data[7] & 0xFF) << 8));
        status = data[8];
        return this;
    }
}
