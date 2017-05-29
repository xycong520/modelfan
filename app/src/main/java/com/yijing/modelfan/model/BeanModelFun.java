package com.yijing.modelfan.model;

/**
 * Created by xycong on 2016/5/19.
 */
public class BeanModelFun {

    int itemViewType;
    int id;
    String imageUrl;
    int imgID;
    String textValue;

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getImgID() {

        return imgID;
    }

    public int getItemViewType() {
        return itemViewType;
    }

    public void setItemViewType(int itemViewType) {
        this.itemViewType = itemViewType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }
}
