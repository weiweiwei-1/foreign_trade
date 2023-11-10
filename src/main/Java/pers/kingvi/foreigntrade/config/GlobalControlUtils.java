package pers.kingvi.foreigntrade.config;

public class GlobalControlUtils {
//聊天功能开启关闭状态
    public static boolean CHAT_STATUS = true;
//登录功能开启关闭状态
    public static boolean LOGIN_STATUS = true;
//注册功能开启关闭状态
    public static boolean REGISTER_STATUS = true;
//全部功能开启关闭状态
    public static boolean GLOBAL_FUNCTION_STATUS = true;
//市场模块功能开启关闭状态
    public static boolean MARKET_STATUS = true;
//活动模块功能开启关闭状态
    public static boolean ACTIVITY_STATUS = true;
//报价模块功能开启关闭状态
    public static boolean QUOTE_STATUS = true;
//管理员最大登录次数限制为5次
    public static int ADMIN_MAX_LOGIN_TIMES = 5;
//普通用户最大登录限制次数为10
    public static int NORMAL_LOGIN_TIMES = 10;


    public static boolean isChatStatus() {
        return CHAT_STATUS;
    }

    public static void setChatStatus(boolean chatStatus) {
        CHAT_STATUS = chatStatus;
    }

    public static boolean isQuoteStatus() {
        return QUOTE_STATUS;
    }

    public static void setQuoteStatus(boolean quoteStatus) {
        QUOTE_STATUS = quoteStatus;
    }

    public static boolean isActivityStatus() {
        return ACTIVITY_STATUS;
    }

    public static void setActivityStatus(boolean activityStatus) {
        ACTIVITY_STATUS = activityStatus;
    }

    public static boolean isMarketStatus() {
        return MARKET_STATUS;
    }

    public static void setMarketStatus(boolean marketStatus) {
        MARKET_STATUS = marketStatus;
    }

    public static boolean isLoginStatus() {
        return LOGIN_STATUS;
    }

    public static void setLoginStatus(boolean loginStatus) {
        LOGIN_STATUS = loginStatus;
    }

    public static boolean isRegisterStatus() {
        return REGISTER_STATUS;
    }

    public static void setRegisterStatus(boolean registerStatus) {
        REGISTER_STATUS = registerStatus;
    }

    public static boolean isGlobalFunctionStatus() {
        return GLOBAL_FUNCTION_STATUS;
    }

    public static void setGlobalFunctionStatus(boolean globalFunctionStatus) {
        GLOBAL_FUNCTION_STATUS = globalFunctionStatus;
    }
}
