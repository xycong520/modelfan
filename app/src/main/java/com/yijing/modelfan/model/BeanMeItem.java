package com.yijing.modelfan.model;

/**
 * Created by xycong on 2016/6/5.
 */
public class BeanMeItem {
    int iconID;
    String name;
    String value;

    public BeanMeItem(int iconID, String name, String value) {
        this.iconID = iconID;
        this.name = name;
        this.value = value;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
