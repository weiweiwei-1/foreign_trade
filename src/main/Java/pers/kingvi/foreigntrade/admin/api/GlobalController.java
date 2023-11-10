package pers.kingvi.foreigntrade.admin.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;

@Controller
@RequestMapping(value = "/vivivi/global")
public class GlobalController {

    @RequestMapping(value = "/chat/status")
    @ResponseBody
    public boolean getChatStatus() {
        return GlobalControlUtils.CHAT_STATUS;
    }

    @RequestMapping(value = "/chat/open")
    @ResponseBody
    public boolean openChatStatus() {
        GlobalControlUtils.setChatStatus(true);
        return GlobalControlUtils.CHAT_STATUS;
    }

    @RequestMapping(value = "/chat/close")
    @ResponseBody
    public boolean closeChatStatus() {
        GlobalControlUtils.setChatStatus(false);
        return GlobalControlUtils.CHAT_STATUS;
    }


    @RequestMapping(value = "/login/status")
    @ResponseBody
    public boolean getLoginStatus() {
        return GlobalControlUtils.LOGIN_STATUS;
    }

    @RequestMapping(value = "/login/open")
    @ResponseBody
    public boolean openLoginStatus() {
        GlobalControlUtils.setLoginStatus(true);
        return GlobalControlUtils.LOGIN_STATUS;
    }

    @RequestMapping(value = "/login/close")
    @ResponseBody
    public boolean closeLoginStatus() {
        GlobalControlUtils.setLoginStatus(false);
        return GlobalControlUtils.LOGIN_STATUS;
    }

    @RequestMapping(value = "/register/status")
    @ResponseBody
    public boolean getRegisterStatus() {
        return GlobalControlUtils.REGISTER_STATUS;
    }

    @RequestMapping(value = "/register/open")
    @ResponseBody
    public boolean openRegisterStatus() {
        GlobalControlUtils.setRegisterStatus(true);
        return GlobalControlUtils.REGISTER_STATUS;
    }

    @RequestMapping(value = "/register/close")
    @ResponseBody
    public boolean closeRegisterStatus() {
        GlobalControlUtils.setRegisterStatus(false);
        return GlobalControlUtils.REGISTER_STATUS;
    }

    @RequestMapping(value = "/market/status")
    @ResponseBody
    public boolean getMarketStatus() {
        return GlobalControlUtils.MARKET_STATUS;
    }

    @RequestMapping(value = "/market/open")
    @ResponseBody
    public boolean openMarketStatus() {
        GlobalControlUtils.setMarketStatus(true);
        return GlobalControlUtils.MARKET_STATUS;
    }

    @RequestMapping(value = "/market/close")
    @ResponseBody
    public boolean closeMarketStatus() {
        GlobalControlUtils.setMarketStatus(false);
        return GlobalControlUtils.MARKET_STATUS;
    }

    @RequestMapping(value = "/activity/status")
    @ResponseBody
    public boolean getActivityStatus() {
        return GlobalControlUtils.ACTIVITY_STATUS;
    }

    @RequestMapping(value = "/activity/open")
    @ResponseBody
    public boolean openActivityStatus() {
        GlobalControlUtils.setActivityStatus(true);
        return GlobalControlUtils.ACTIVITY_STATUS;
    }

    @RequestMapping(value = "/activity/close")
    @ResponseBody
    public boolean closeActivityStatus() {
        GlobalControlUtils.setActivityStatus(false);
        return GlobalControlUtils.ACTIVITY_STATUS;
    }

    @RequestMapping(value = "/quote/status")
    @ResponseBody
    public boolean getQuoteStatus() {
        return GlobalControlUtils.QUOTE_STATUS;
    }

    @RequestMapping(value = "/quote/open")
    @ResponseBody
    public boolean openQuoteStatus() {
        GlobalControlUtils.setQuoteStatus(true);
        return GlobalControlUtils.QUOTE_STATUS;
    }

    @RequestMapping(value = "/quote/close")
    @ResponseBody
    public boolean closeQuoteStatus() {
        GlobalControlUtils.setQuoteStatus(false);
        return GlobalControlUtils.QUOTE_STATUS;
    }
}
