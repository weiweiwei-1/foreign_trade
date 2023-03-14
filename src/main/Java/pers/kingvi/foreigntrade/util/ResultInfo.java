package pers.kingvi.foreigntrade.util;

import org.apache.commons.lang3.StringUtils;

public final class ResultInfo {
    public static final String DBS_ERROR = "数据库操作错误, 错误码：";
    public static final String NULL_EMAIL = "邮箱不能为空";
    public static final String ACCOUNT_OR_PWD_ERROR = "用户名或密码错误";
    public static final String EMAIL_FORMAT = "邮箱格式错误";
    public static final String EMAIL_EXIST = "邮箱已被注册";
    public static final String EMAIL_NOT_EXIST = "邮箱不存在";
    public static final String NULL_PASSWORD = "密码不能为空";
    public static final String PASSWORD_LENGTH = "密码长度为6-15位";
    public static final String PASSWORD_ERROR = "密码错误";
    public static final String NULL_CODE = "验证码不能为空";
    public static final String CONFIRM_CODE_ERROR = "验证码错误";
    public static final String PAGE_COUNT_ERROR = "页面数错误";
    public static final String PAGE_COUNT_TOO_LONG = "页面数超过指定长度";
    public static final String PAGE_COUNT_TOO_SHORT = "页面数不能小于1";
    public static final String SEARCH_NULL = "搜索条件不能为空";
    public static final String SEARCH_TOO_LONG = "搜索字段超过指定长度8";
    public static final String AUTH_SUCCESS = "登录且认证成功";
    public static final String AUTH_FAIL = "未登录或登录过期,请重新登录！";
    public static final String AUTH_NOT_MATCH = "已登录但角色不匹配";
    public static final String AUTH_FOR_FTS = "请登录外贸账号";
    public static final String AUTH_FOR_FA = "请登录货代账号";
    public static final String WRITE_PHOTO_ERROR = "照片保存错误";
    public static final String UPDATE_PHOTO_ERROR = "更新照片错误";


}
