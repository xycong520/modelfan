package com.yijing.modelfan.model;

import java.io.Serializable;

/**
 * Created by PCPC on 2016/5/24.
 */
public class BeanCommonViewType<T> implements Serializable{
    private int viewType;
    private T beanObj;

    public T getBeanObj() {
        return beanObj;
    }

    public void setBeanObj(T beanObj) {
        this.beanObj = beanObj;
    }

    public int getViewType() {
        return viewType;
    }


    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
