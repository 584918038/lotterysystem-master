package com.nala.controller;

import com.nala.entity.Constants;
import com.nala.entity.Result;
import com.nala.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author oyj
 * @date 2020-01-16 14:03
 * @description
 */
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @PostMapping("/login")
    public Result<Void> login(User user, HttpServletRequest request) {
        Result result = new Result();
        String phoneNumber = user.getPhoneNumber();
        User userByPhone = Constants.USER_MAP.get(phoneNumber);
        if (null != userByPhone && userByPhone.getUserName().equals(user.getUserName()) && userByPhone.getCarNumber().equals(user.getCarNumber())) {
            HttpSession session = request.getSession();
            session.setAttribute("phoneNumber",phoneNumber);
            return result.defaultSuccess();
        } else {
            result.setSuccess(false,"10001","账户信息错误");
            return result;
        }
    }

    @GetMapping("/xx")
    public Result participate() {
        System.out.println("hello world00");
        return null;
    }
}
