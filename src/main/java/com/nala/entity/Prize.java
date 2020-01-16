package com.nala.entity;

import java.io.Serializable;

/**
 * @author oyj
 * @date 2020-01-16 13:22
 * @description
 */
public class Prize implements Serializable {
    private static final long serialVersionUID = -6165773980111683397L;

    private Integer prizeId;

    //活动id
    private String activityNum;

    //奖品名称
    private String prizeName;

    //等级
    private Integer level;

    //奖品数量
    private Integer count;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
