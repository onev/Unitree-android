package com.lt.unitreetest.model;

/**
 * 作者：zhaowenlong on 2018/11/6 17:01
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class ConsoleEngineItem {
    private String engineNumber;
    private String engineStatus;
    private int statusIcon;
    private String engineTemperature1;
    private String engineTemperature2;
    private String jointAngle;
    private String jointSpeed;

    public ConsoleEngineItem() {
    }

    public ConsoleEngineItem(String engineNumber, String engineStatus, int statusIcon, String engineTemperature1, String engineTemperature2, String jointAngle, String jointSpeed) {
        this.engineNumber = engineNumber;
        this.engineStatus = engineStatus;
        this.statusIcon = statusIcon;
        this.engineTemperature1 = engineTemperature1;
        this.engineTemperature2 = engineTemperature2;
        this.jointAngle = jointAngle;
        this.jointSpeed = jointSpeed;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

    public int getStatusIcon() {
        return statusIcon;
    }

    public void setStatusIcon(int statusIcon) {
        this.statusIcon = statusIcon;
    }

    public String getEngineTemperature1() {
        return engineTemperature1;
    }

    public void setEngineTemperature1(String engineTemperature1) {
        this.engineTemperature1 = engineTemperature1;
    }

    public String getEngineTemperature2() {
        return engineTemperature2;
    }

    public void setEngineTemperature2(String engineTemperature2) {
        this.engineTemperature2 = engineTemperature2;
    }

    public String getJointAngle() {
        return jointAngle;
    }

    public void setJointAngle(String jointAngle) {
        this.jointAngle = jointAngle;
    }

    public String getJointSpeed() {
        return jointSpeed;
    }

    public void setJointSpeed(String jointSpeed) {
        this.jointSpeed = jointSpeed;
    }
}
