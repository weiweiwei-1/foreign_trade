package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.bo.fts.FtsMsgListBo;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsMessageService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.fa.FaMessageVo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/fts/message")
public class FtsMessageController {

    @Autowired
    private FtsMessageService ftsMessageService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private FtsFriendService ftsFriendService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Result getMsgListVo() {
        Long receiverId = FtsUtils.getUserVo().getId();
        try {
            List<ReadAndUnReadMessageVo> readAndUnReadMessageVoList = ftsMessageService.getMessageList(receiverId);
            return new Result<>().success(readAndUnReadMessageVoList);
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
    }

    @RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int getUnReadMsgCount() {
        ForeignTradeSaleman foreignTradeSaleman;
        try {
            foreignTradeSaleman = FtsUtils.getUserVo();
        } catch (Exception e) {
            return 0;
        }
        if (foreignTradeSaleman == null) {
            return 0;
        }
        try {
            return ftsMessageService.getUnReadMsgCount(foreignTradeSaleman.getId());
        } catch (Exception e) {
            System.out.println(e.toString());
            return -1;
        }
    }

    @RequestMapping(value = "/content")
    @ResponseBody
    public Result getMessageContent(Long senderId) {
        Long userId = FtsUtils.getUserVo().getId();
        Message message = new Message(senderId, userId);
        List<Message> messageList = ftsMessageService.selectMessageContent(message);
        return new Result<>().success(messageList);
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public Result readMessage(Long senderId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        Message message = new Message(senderId, ftsId);
        try {
            ftsMessageService.readAllMessages(message);
            if (WebSocketUtils.hasConnection(senderId)) {
                message.setMessageType("readMessage");
                message.setStatus("1");
                WebSocketUtils.get(senderId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
            }
            if (WebSocketUtils.hasConnection(ftsId)) {
//                发给自己
                message.setMessageType("hasRead");
                message.setSenderId(senderId);
                WebSocketUtils.get(ftsId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
            }
            return Result.success;
        } catch (Exception e) {
            return Result.fail;
        }
    }


    @RequestMapping(value = "/fa/info")
    @ResponseBody
    public Result getFaInfoById(Long senderId) {
        try {
            FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(senderId);
            Long ftsId = FtsUtils.getUserVo().getId();
            Friend friend = new Friend(freightAgency.getId(), ftsId);
            friend = ftsFriendService.selectFriend(friend);
            FaMessageVo faMessageVo = new FaMessageVo(freightAgency.getId(), freightAgency.getPhoto(), freightAgency.getName());
            if (friend != null) {
                faMessageVo.setName(friend.getFaMark());
            }
            return new Result<>().success(faMessageVo);
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
    }
}
