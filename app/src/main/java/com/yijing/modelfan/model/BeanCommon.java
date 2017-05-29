package com.yijing.modelfan.model;

/**
 * Created by xycong on 2016/6/5.
 */
public class BeanCommon<T> {
    int layoutID;
    T object;
    int space;

    public BeanCommon(int layoutID) {
        this.layoutID = layoutID;
    }
    public BeanCommon(int layoutID, T object) {
        this.layoutID = layoutID;
        this.object = object;
    }
    public BeanCommon(int layoutID, T object,int space) {
        this.layoutID = layoutID;
        this.object = object;
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
