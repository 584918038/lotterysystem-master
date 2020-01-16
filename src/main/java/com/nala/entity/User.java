package com.nala.entity;

import java.io.Serializable;

/**
 * @author oyj
 * @date 2020-01-16 11:16
 * @description
 */
public class User implements Serializable {
    private static final long serialVersionUID = -503988797325055892L;

    private String userName;

    private String carNumber;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
