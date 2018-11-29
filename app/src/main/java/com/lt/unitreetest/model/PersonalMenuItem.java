package com.lt.unitreetest.model;

/**
 * Created by zhaowenlong on 2018/7/21.
 */
public class PersonalMenuItem {
    int itemImg;
    String itemTitle;

    public PersonalMenuItem() {
    }

    public PersonalMenuItem(int itemImg, String itemTitle) {
        this.itemImg = itemImg;
        this.itemTitle = itemTitle;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
