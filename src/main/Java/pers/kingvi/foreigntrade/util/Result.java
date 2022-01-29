package pers.kingvi.foreigntrade.util;

public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private T error;
    public static Result success = new Result(ResultCode.SUCCESS, "success");

    public static Result fail = new Result(ResultCode.FAIL, "fail");

    public static Result error_paramerter = new Result(ResultCode.ERROR, "error");

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }

    public Result() {

    }

    public Result(T t) {
        this.code = ResultCode.SUCCESS;
        this.msg = "success";
        this.data = t;
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data, T error) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.error = error;
    }

    public Result success(T t) {
        this.code = ResultCode.SUCCESS;
        this.msg = "success";
        this.data = t;
        return this;
    }

    public Result error(T t) {
        this.code = ResultCode.ERROR;
        this.msg = "error";
        this.error = t;
        return this;
    }

    public Result fail() {
        this.code = ResultCode.FAIL;
        this.msg = "fail";
        return this;
    }
}
