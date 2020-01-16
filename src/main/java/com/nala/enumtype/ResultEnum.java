package com.nala.enumtype;


import com.nala.entity.Result;

/**
 * @author ：mengwl
 * @date ：Created in 2019-05-27 16:51
 * @description：通用返回结果类
 * @modified By：
 * @version: 1.0$
 */
public enum ResultEnum {
    /**
     *
     */
    SUCCESS("成功", "1000"),
    FAIL("失败", "1001"),
    SERVER_ERROR("server error","1001"),

    /***************通用返回码****************/
    //10 开头

    PARAM_ERROR("请求参数异常", "10001"),

    OPERATION_BUSY_ERROR("当前操作繁忙, 请稍后再试", "10010"),

    ROLE_UPDATE_ERROR("角色更新失败", "10002"),

    COMPANYNAME_IS_NULL("组织名为空", "10003"),

    COMPANYCODE_IS_REPEAT("组织编码重复", "10004"),

    COMPANYCONTACT_IS_NULL("组织联系人为空", "10005"),

    COMPANY_ADD_ERROR("组织添加失败", "10006"),

    COMPANY_UPDATE_ERROR("组织更新失败", "10007"),

    COMPANY_INFO_EXIST("组织关系已存在","10008"),

    STOCK_MANAGE_IS_NULL("库位信息不存在","10009"),

    SESSIONKEY_IS_EXPIRED("sessionKey过期，无法解密","10010"),

    ENCRYPTLIST_IS_NULL("需要加密的集合不能为空", "10011"),

    DECRYPTLIST_IS_NULL("需要解密的集合不能为空", "10012"),

    DATA_ENCRYPT_ERROR("数据加密失败，返回空值","10013"),
    DATA_DECRYPT_ERROR("数据解密失败，返回空值","10014"),

    REDLOCK_FAILD("分布式锁获取失败,请重试","10015"),

    GET_CITY_MENU_FAIL_ERROR("获取省市区列表失败","10015"),

    GET_PROVINCE_LIST_FAIL_ERROR("获取一级地址省份列表失败","10016"),
    GET_CITY_LIST_FAIL_ERROR("获取二级地址城市列表失败","10017"),

    /***************登录模块返回码****************/
    //11 开头
    USER_LOGIN_SUCCESS("登录成功", "11000"),

    LOGIN_ERROR_PASSWORD("用户密码错误", "11001"),

    LOGIN_ERROR_EMAIL("用户名错误", "11002"),

    USER_IS_LOCKED("登录失败，该用户已被冻结", "11003"),

    USER_IS_UNLOGIN("用户未登录", "11004"),

    USER_LOGOUT_SUCCESS("用户退出成功", "11005"),

    USER_IS_UNAUTHORIZED("用户无权限", "11006"),

    USER_IS_UNKNOWNSESSION("用户登录已过期,需重新登录", "11007"),

    EMAIL_SEND_ERROR("邮件发送错误","11008"),

    CODE_IS_ERROR("验证码错误","11009"),

    EMAIL_NOT_EXIST("邮箱不存在","11010"),

    CHANGEPWD_BYCODE_ERROR("邮件验证码修改密码错误","11011"),

    CHANGEPWD_IS_ERROR("直接修改密码错误","11012"),

    USER_LOGIN_UNKNOWNERROR("登录未知错误", "11013"),

    USER_UNASSIGNED_COMPANY("账号没有分配组织，无法登录","11014"),

    USER_LOGIN_EXPIRED("账号没有分配组织，无法登录","11015"),

    USER_IN_INVALID("账号已被停用","11016"),

    /*************** 营销模块模块返回码 ****************/
    TRADE_PROMO_AMOUNT_SECTION_ERROR("金额必须大于上一个区间最大值或小于下一个区间最小值","33015"),
    TRADE_PROMO_CACHE_UPDATE_LOSS_PARAM_ERROR("更新营销活动 缺少必要参数","33016"),
    TRADE_PROMO_GIFT_QTY_NOT_ENOUGTH_ERROR("赠品库存不足","33017"),
    TRADE_PROMO_OVER_FIVE_SECTION_ERROR("满金额就送营销活动 最多允许 5个金额区间范围","33018"),
    TRADE_PROMO_PRICE_SECTION_ERROR("满金额就送营销活动 新价格区间最小值 必须大于 上个区间最大值","33019"),
    TRADE_PROMO_NOT_FOUND_ERROR("查不到该营销活动详情","33022"),
    PRODUCT_NOT_FOUND_ERROR("查不到该商品信息","33020"),
    TRADE_PROMO_PDT_REPEAT_ERROR("买送SKU活动已存在该商品列表相关的SKU，请避免重复赠送","33021"),
    TRADE_PROMO_TIME_ERROR("活动开始时间必须小于结束时间, 并且时间不可以过期","33024"),
    TRADE_PROMO_SKU_CODE_REPEAT_ERROR("请避免添加重复SKU编码","33027"),
    TRADE_PROMO_SKU_REPEAT_ERROR("本次绑定买就送活动的主产品SKU:xxx已经绑定过了，请您检查！如需要买就送多个子产品请使用组合产品赠产品","33025"),
    TRADE_PROMO_LESS_ONE_ERROR("满送营销活动 删除赠品 至少要保留一个","33023"),
    TRADE_PROMO_QTY_NONE_ERROR("库存为0, 无法提交","33026"),
    TRADE_PROMO_SAME_NAME_ERROR("营销活动名称有重复, 请避免名称重复","33033"),
    TRADE_PROMO_ORDER_CACHE_ERROR("营销活动解析缓存异常","33027"),
    TRADE_PROMO_REPEAT_PRODUCT_ERROR("营销活动商品 不可重复","33028"),
    TRADE_PROMO_ANALY_PARAM_LESS_ERROR("解析参数不全","33029"),
    /*************** 库存异常返回码 ****************/

    TOKEN_ERPIRE_ERROR("1688该店铺的token失效, 请重新登录","60001"),
    XXL_JOB_GROUP_ID_NULL_ERROR("找不到定时调度group_id 缺失 导致无法启动定时任务","60002"),
    XXL_JOB_START_ERROR("启动调度任务Job失败","60003"),
    XXL_JOB_ADD_ERROR("添加调度任务Job失败","60004"),
    XXL_JOB_SCHEDULE_ERROR("安排调度任务失败","60010"),

    TASK_PULL_EMPTY_MEMBER_SHOP_ORDER_ERROR("添加拉取订单任务必填组织和店铺","60005"),
    TASK_PULL_PARAM_ORDER_ERROR("拉去订单调度任务安排失败, 缺少必要参数","60006"),
    TASK_PULL_ORDER_COMPANY_DB_EMPTY_ERROR("拉去订单调度任务 查找不到组织下的DB","60007"),
    TASK_PULL_ORDER_WMS_ERROR("WMS暂无订单拉取服务","60008"),
    TASK_EMPTY_CRON_ERROR("时间表达式必填","60009"),
    TRADE_VOID_EID_ERROR("无效的订单号","33055"),
    NOT_FOUND_USER_ERROR_BY_NAME("查不到该用户名账户","33056"),
    NOT_FOUND_AFTSVR_RECORD_ERROR("该笔售后登记查不到或已完结","33057"),
    OVERFLOW_STOCK_NUM_ERROR("该笔退件入库失败, 添加的数量超出可入库数量","33058"),
    NOT_FOUND_CAUSE_ID_ERROR("查找不到该问题类型","33059"),
    NOT_FOUND_TRADE_ID_ERROR("找不到该订单号","33060"),
    DELETE_CASE_TYPE_ERROR("该问题类型下存在问题原因，不允许删除","33061"),
    TRADE_AFTSVR_BOUNCE_EXIST_ERROR("该订单已进行过退件登记","33062"),
    TRADE_STATUS_LEFT_ERROR("该订单未出库，不允许操作","33063"),
    TRADE_AFTSVR_RECORD_EXIST_ERROR("该订单已进行过售后登记","33064"),

    /*************** 库存调整异常返回码 ****************/
    FILE_HAS_ALREADY_BEEN_IMPORTED("请勿重复导入相同内容","33065"),
    IMPORT_FAIL("导入失败,sku和分区的组合不能相同,请检查","33066"),
    APPROVE_ERROR("调整单必须是未审核的","33067"),
    NUMBER_ERROR("数量不是+,-或=, 无法通过审核","33068"),
    RECORD_NOT_EXIST("找不到调整单,请检查参数是否正确","33069"),

    /*************** B2B称重异常返回码 ****************/
    TRADE_NOT_EXIST("订单不存在，请检查单号","33070"),
    TRADE_STATUS_IS_NOT_PICK("该订单不是待称重未拦截的状态","33071"),
    PACKAGE_NUMBER_OVER_TWENTY("包裹数量不能超过20个","33072"),
    PACKAGE_NUM_MUST_OVER_ZERO("请输入大于0的数字","33073"),
    /*************** 库存异常返回码 ****************/

    SPLIT_SKU_NUM_LESS_ONE("不能勾选所有订单明细进行拆分","60031"),

    TRADE_IS_PULLED_ERROR("订单已存在,无需重新拉取","60050"),
    TRADE_IS_PULLED_IS_NULL("未获取到订单,请检查单号是否正确","60051"),

    /*************** 库存锁定异常返回码 ****************/
    STOCK_LOCK_AUDIT_EMPTY_PARAMS("请选择审核的记录","44100"),
    STOCK_LOCK_INFO_NOT_EXIST("库存锁定记录不存在","44101"),
    STOCK_LOCK_NOT_UNLOCKED("不是待锁定状态,无法审核","44102"),
    STOCK_LOCK_APPROVE_ERROR("仓库sku可下载库存不足,审核失败","44103"),
    UNLOCKNUM_GREATER_THAN_LOCKNUM("解锁数量不能大于可解锁数量","44104"),
    TURN_TO_UNLOCK_ERROR("不是已锁定状态或部分解锁状态,解锁失败","44105"),
    STATUS_UNALLOWED_CANCEL("不是待锁定状态,无法取消","44106");

    private String name;
    private String value;

    ResultEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getName(String value) {
        for (ResultEnum c : ResultEnum.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static Result error(ResultEnum resultEnum, Result result) {
        result.setSuccess(false);
        result.setCode(resultEnum.getValue());
        result.setMessage(resultEnum.getName());
        return result;
    }

}