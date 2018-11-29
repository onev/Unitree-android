package com.lt.unitreetest.common;

/**
 * Created by zhaowenlong on 2018/7/16.
 */
public class CommonItem {
    String itemTitle;
    String itemData;
    int itemIamge;
    Boolean checked ;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public CommonItem() {
    }

    public CommonItem(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public CommonItem(int itemIamge) {
        this.itemIamge = itemIamge;
    }

    public CommonItem(String itemTitle, String itemData) {
        this.itemTitle = itemTitle;
        this.itemData = itemData;
    }

    public CommonItem(String itemTitle, Boolean checked) {
        this.itemTitle = itemTitle;
        this.checked = checked;
    }

    public CommonItem(String itemTitle, String itemData, int itemIamge) {
        this.itemTitle = itemTitle;
        this.itemData = itemData;
        this.itemIamge = itemIamge;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemData() {
        return itemData;
    }

    public void setItemData(String itemData) {
        this.itemData = itemData;
    }

    public int getItemIamge() {
        return itemIamge;
    }

    public void setItemIamge(int itemIamge) {
        this.itemIamge = itemIamge;
    }
}
