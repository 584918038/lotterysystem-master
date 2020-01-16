package com.nala.entity;

import java.io.Serializable;

/**
 * @author oyj
 * @date 2020-01-16 13:28
 * @description 用户参加活动表
 */
public class Acceding implements Serializable {
    private static final long serialVersionUID = -6759445402060132133L;

    //活动唯一值
    private String activityNum;

    //工号
    private String carNumber;

    public String getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
