package com.lt.unitreetest.model;

/**
 * 作者：zhaowenlong on 2018/11/15 10:11
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class ConsoleBatteryItem {
    String itemVoltageValue;
    float itemVoltage;

    public ConsoleBatteryItem() {
    }

    public ConsoleBatteryItem(String itemVoltageValue, float itemVoltage) {
        this.itemVoltageValue = itemVoltageValue;
        this.itemVoltage = itemVoltage;
    }

    public ConsoleBatteryItem(float itemVoltage) {
        this.itemVoltage = itemVoltage;
    }

    public String getItemVoltageValue() {
        return itemVoltageValue;
    }

    public void setItemVoltageValue(String itemVoltageValue) {
        this.itemVoltageValue = itemVoltageValue;
    }

    public float getItemVoltage() {
        return itemVoltage;
    }

    public void setItemVoltage(float itemVoltage) {
        this.itemVoltage = itemVoltage;
    }
}
