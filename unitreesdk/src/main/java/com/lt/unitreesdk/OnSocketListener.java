package com.lt.unitreesdk;

public interface OnSocketListener {
    void conn();

    void colse();

    void send();

    void recData(String data);
}