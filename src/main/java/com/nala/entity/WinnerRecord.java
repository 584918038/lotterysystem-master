package com.nala.entity;

import java.io.Serializable;

/**
 * @author oyj
 * @date 2020-01-16 13:30
 * @description
 */
public class WinnerRecord implements Serializable {
    private static final long serialVersionUID = -2338202049026720269L;

    //用户姓名
    private String userName;

    //手机号
    private String phoneNumber;

    //奖品id 中奖则存在
    private Integer prizeId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }
}
