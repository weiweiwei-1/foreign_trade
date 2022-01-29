package pers.kingvi.foreigntrade.util;

public final class ResultCode {
    static final int SUCCESS = 1;                  //请求成功，参数非法，读或者写数据库被系统拒绝
    static final int ERROR = 0;                    //请求成功，参数合法，读或者写数据库成功数据库
    static final int FAIL = -1;                    //系统内部错误
    static final int NULL_EMAIL = 100;             //邮箱不能为空
    static final int EMAIL_FORMAT = 101;           //邮箱格式错误
    static final int EMAIL_INVALID = 21;           //邮箱不存在
    static final int PASSWORD_LENGTH = 102;        //密码长度为6-15位
    static final int CONFIRM_PASSWORD = 103;       //前后密码不一致
    static final int CONFIRM_CODE_FORMAT = 104;    //验证码格式错误
    static final int CONFIRM_CODE_ERROR = 105;     //验证码错误
}
