package com.nala.entity;

import com.nala.enumtype.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author: heshangqiu
 * Created Date:  2018/3/14
 */
public class Result<T> implements Serializable {

    private final static Logger LOGGER = LoggerFactory.getLogger(Result.class);

    private static final long serialVersionUID = -723554057454058516L;
    /**
     * 返回是否成功
     */
    private boolean success = false;
    /**
     * 返回消息提示
     */
    private String message = ResultEnum.FAIL.getName();

    /**
     * 返回消息编码
     */
    private String code = ResultEnum.FAIL.getValue();
    /**
     * 具体数据对象
     */
    private T model;
    /**
     * 如果是列表,返回总条数
     */
    private int totalRecord;

    private int fail;

    private int succeed;
    /**
     * 创建一个result
     */
    public Result() {
    }

    /**
     * 创建一个result。
     *
     * @param success 是否成功
     */
    public Result(boolean success) {
        this.success = success;
    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public Result(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(T model) {
        this.model = model;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getModel() {
        return model;
    }

    public Result setModel(T model) {
        this.model = model;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setSuccess(boolean success, String resultCode, String resultMsg) {
        this.success = success;
        this.code = resultCode;
        this.message = resultMsg;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public int getSucceed() {
        return succeed;
    }

    public void setSucceed(int succeed) {
        this.succeed = succeed;
    }

    public Result<T> defaultSuccess() {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getValue();
        this.message = ResultEnum.SUCCESS.getName();
        return this;
    }

    public Result<T> defaultSuccess(T t) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getValue();
        this.message = ResultEnum.SUCCESS.getName();
        this.model = t;
        return this;
    }

    public Result<T> defaultSuccess(T t, int totalRecord) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getValue();
        this.message = ResultEnum.SUCCESS.getName();
        this.model = t;
        this.totalRecord = totalRecord;
        return this;
    }

    public Result<T> defaultSuccess(T t, int fail, int succeed) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getValue();
        this.message = ResultEnum.SUCCESS.getName();
        this.setModel(t);
        this.fail = fail;
        this.succeed = succeed;
        return this;
    }

    public Result<T> error(T t, int fail, int succeed) {
        this.success = false;
        this.code = ResultEnum.FAIL.getValue();
        this.message = ResultEnum.FAIL.getName();
        this.setModel(t);
        this.fail = fail;
        this.succeed = succeed;
        return this;
    }


    /**
     * 错误返回
     *
     * @param srcResult
     * @param dstResult
     * @return
     */
    public static Result errorResult(Result srcResult, Result dstResult) {
        dstResult.setSuccess(srcResult.isSuccess());
        dstResult.setCode(srcResult.getCode());
        dstResult.setMessage(srcResult.getMessage());
        return dstResult;
    }

    /**
     * 错误返回
     *
     * @param srcResult
     * @return
     */
    public static Result errorResult(Result srcResult) {
        Result result = new Result();
        result.setSuccess(srcResult.isSuccess());
        result.setCode(srcResult.getCode());
        result.setMessage(srcResult.getMessage());
        return result;
    }


    /**
     * 错误返回
     *
     * @param model
     * @return
     */
    public Result<T> errorResult(T model) {
        this.setSuccess(false);
        this.setModel(model);
        return this;
    }

    public void setErrorResultEnum(ResultEnum resultEnum) {
        this.code = resultEnum.getValue();
        this.message = resultEnum.getName();
        this.success = false;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        return result.defaultSuccess();
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        return result.defaultSuccess(object);
    }

    public static <T> Result<T> success(T object, Integer count) {
        Result<T> result = success(object);
        result.setTotalRecord(count);
        return result;
    }
}