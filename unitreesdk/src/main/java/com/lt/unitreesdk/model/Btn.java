package com.lt.unitreesdk.model;

import java.util.Arrays;

public class Btn extends BaseHeader {
    public int[] val;

    public Btn analyzeData(int[] data) {
        head = new int[]{data[0], data[1]};
        fn = data[2];
        len = data[3];
        val = Arrays.copyOfRange(data, 4, 12);
        return this;
    }
}
