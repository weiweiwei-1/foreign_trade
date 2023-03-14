package pers.kingvi.foreigntrade.vo;

/*
授权结果，用来对外贸员和货代区分角色
 */
public class AuthResult {
    //代码
    private int code;
    //角色
    private String role;
    //详细信息
    private String name;
    //拦截类型，code为1000(已登录)时区分拦截类型，当拦截类型为intercept时，页面提示登录符合身份的账号，当拦截类型为login时，注册或者登录成功，前端关闭窗口
    private String interceptType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterceptType() {
        return interceptType;
    }

    public void setInterceptType(String interceptType) {
        this.interceptType = interceptType;
    }

    public AuthResult() {

    }

    public AuthResult(int code, String role) {
        this.code = code;
        this.role = role;
    }

    public AuthResult(int code, String role, String name) {
        this.code = code;
        this.role = role;
        this.name = name;
    }

    public AuthResult(int code, String role, String name, String interceptType) {
        this.code = code;
        this.role = role;
        this.name = name;
        this.interceptType = interceptType;
    }
}
