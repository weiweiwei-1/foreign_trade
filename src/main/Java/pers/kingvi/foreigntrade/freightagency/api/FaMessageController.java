package pers.kingvi.foreigntrade.freightagency.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.vo.MessageVo;

@Controller
@RequestMapping(value = "famessage")
public class FaMessageController {

    @RequestMapping(value = "/message-list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public MessageVo getFaMessageList() {
        return new MessageVo();
    }
}
