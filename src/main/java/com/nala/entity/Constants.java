package com.nala.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oyj
 * @date 2020-01-16 13:39
 * @description
 */
public class Constants  {
    //活动列表
    public static final Map<String,Activity> ACTIVITY_MAP = new HashMap<>();

    //活动奖品表  活动唯一值-奖品集合
    public static final Map<String,List<Prize>> ACTIVITY_PRIZE_MAP = new HashMap<>();

    //用户表 手机号-用户信息
    public static final Map<String,User> USER_MAP = new HashMap<>();

    //中奖记录表以及判断用户是否参加过活动
    public static final Map<String, List<WinnerRecord>> ACTIVITYNUM_USER_MAP = new HashMap<>();
}
