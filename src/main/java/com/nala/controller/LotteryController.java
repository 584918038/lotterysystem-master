package com.nala.controller;

import com.nala.entity.Constants;
import com.nala.entity.Result;
import com.nala.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oyj
 * @date 2020-01-16 14:03
 * @description
 */
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @RequestMapping("/login")
    public Result<Void> login(User user){
        String phoneNumber = user.getPhoneNumber();
        User userByPhone = Constants.USER_MAP.get(phoneNumber);
        if (null != userByPhone && user.getCarNumber().equals(userByPhone.getCarNumber()) && user.getPhoneNumber().equals(userByPhone.getPhoneNumber())){
                return new Result().defaultSuccess();
        }
        return null;
    }

    @GetMapping("/xx")
    public Result participate() {
        System.out.println("hello world00");
        return null;
    }
}
