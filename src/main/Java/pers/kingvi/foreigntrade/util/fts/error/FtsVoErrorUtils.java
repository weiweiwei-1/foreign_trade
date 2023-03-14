package pers.kingvi.foreigntrade.util.fts.error;

public class FtsVoErrorUtils {
    public static final String PHOTO_ERROR = "照片大小不超过5M";
    public static final String NAME_ERROR = "名字长度不超过10";
    public static final String NAME_NULL = "名字不能为空";
    public static final String AGE_ERROR = "年龄为1-90岁";
    public static final String SEX_ERROR = "性别错误";
    public static final String CITY_ERROR = "城市字数2-10个";
    public static final String CITY_NULL = "城市不能为空";
    public static final String COMPANY_ERROR = "公司字数2-15个";
    public static final String COMPANY_NULL = "公司不能为空";
    public static final String STORE_LINK_ERROR = "店铺链接字符小于130个";
    public static final String WORKING_TIME_ERROR = "从业年限为0-80年";
    public static final String INDUSTRY_ERROR = "行业字符1-10个";
    public static final String MAIN_PRODUCT_ERROR = "主要产品字数小于60个";
    public static final String WECHAT_ERROR = "微信号格式错误（6-20位）";
    public static final String PHONE_ERROR = "手机号格式错误";
    public static final String EMAIL_ERROR = "邮箱格式错误（6-30位）";
}
