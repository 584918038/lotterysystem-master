package com.nala.entity;

import java.io.Serializable;

/**
 * @author oyj
 * @date 2020-01-16 13:19
 * @description
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = -8212724193128488935L;

    //活动id
    private String activityNum;

    //活动名称
    private String activityName;

    //创建人
    private String createdUserId;

    public String getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }
}
