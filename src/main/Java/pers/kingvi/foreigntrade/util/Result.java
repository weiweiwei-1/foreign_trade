package pers.kingvi.foreigntrade.util;

public class Result<T> {
    //请求结果状态码
    private Integer code;
    //请求结果提示消息
    private String msg;
    //请求成功返回接口数据
    private T data;
    //请求参数错误返回错误详细信息
    private T error;
    public static Result success = new Result(ResultCode.SUCCESS, "success");

    //请求遇到后台异常返回fail信息
    public static Result fail = new Result(ResultCode.FAIL, "fail, 后台出错");

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

    //请求成功返回接口数据
    public Result<T> success(T t) {
        this.code = ResultCode.SUCCESS;
        this.msg = "success";
        this.data = t;
        return this;
    }

    //参数错误返回错误详细提示
    public Result<T> error(T t) {
        this.code = ResultCode.ERROR;
        this.msg = "error";
        this.error = t;
        return this;
    }

    //请求失败携带失败信息，如失败异常原因等
    public Result fail(String msg) {
        this.code = ResultCode.FAIL;
        this.msg = msg;
        return this;
    }

}
