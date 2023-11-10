package pers.kingvi.foreigntrade.freightagency.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendService;
import pers.kingvi.foreigntrade.freightagency.service.FaMessageService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.fa.FaFriendInfoDetailVo;
import pers.kingvi.foreigntrade.vo.fa.FaMessageVo;
import pers.kingvi.foreigntrade.vo.fts.FtsMessageVo;

import java.util.List;

@Controller
@RequestMapping(value = "/fa/message")
public class FaMessageController {
    @Autowired
    private FaMessageService faMessageService;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    private FaFriendService faFriendService;

    /**
     * 通过productInformation的id获取对方ftsId，进而获取messageList
     *
     * @param pid
     * @return 消息列表
     */
    @RequestMapping(value = "/list/pid/get", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFtsIdByPid(@RequestParam("productId") Integer pid) {
        Long userId = FaUtils.getUserVo().getId();
        try {
            List<Message> messageList = faMessageService.getMessageListByProuductId(pid, userId);
            return new Result<>().success(messageList);
        } catch (Exception e) {
            return Result.fail;
        }
    }


    /**
     * 通过senderId获取message列表
     *
     * @param senderId
     * @return 消息列表
     */
    @RequestMapping(value = "/list/sender/get", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFaMessageListBySenderId(@RequestParam("senderId") Long senderId) {
        Long receiverId = FaUtils.getUserVo().getId();
        try {
            List<Message> messageList = faMessageService.getMessageListBySenderId(senderId, receiverId);
            return new Result<>().success(messageList);
        } catch (Exception e) {
            return Result.fail;
        }

    }

    /**
     * 获取消息对象主要个人信息，照片，id，名称
     *
     * @param productId
     * @return ftsInfo
     */
    @RequestMapping(value = "/fts/info/pid", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFtsMessageInfoByPid(@RequestParam("productId") Integer productId) {
        Long faId = FaUtils.getUserVo().getId();
        ForeignTradeSaleman foreignTradeSaleman = faMessageService.getFtsInfoByProductId(productId);
        return getResult(faId, foreignTradeSaleman);
    }

    /**
     * 通过对方id获取消息列表
     *
     * @param senderId
     * @return 通过对方id查询的消息列表
     */
    @RequestMapping(value = "/fts/info/sid", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFtsMessageInfoBySenderId(@RequestParam("senderId") Long senderId) {
        Long faId = FaUtils.getUserVo().getId();
        ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(senderId);
        return getResult(faId, foreignTradeSaleman);
    }

    private Result getResult(Long faId, ForeignTradeSaleman foreignTradeSaleman) {
        if (foreignTradeSaleman != null) {
            FtsMessageVo ftsMessageVo;
            Friend friend = new Friend(faId, foreignTradeSaleman.getId());
            friend = faFriendService.selectFriend(friend);
            if (friend == null) {
                ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getName());
            } else {
                ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), friend.getFtsMark());
            }
            return new Result<>().success(ftsMessageVo);
        }
        return Result.fail;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getMsgListVo() {
        Long receiverId = FaUtils.getUserVo().getId();
        try {
            List<ReadAndUnReadMessageVo> readAndUnReadMessageVoList = faMessageService.getMessageList(receiverId);
            return new Result<>().success(readAndUnReadMessageVoList);
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
    }



    @RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int getUnReadMsgCount() {
        FreightAgency freightAgency;
        try {
            freightAgency = FaUtils.getUserVo();
        } catch (Exception e) {
            return 0;
        }
        if (freightAgency == null) {
            return 0;
        }
        try {
            return faMessageService.getUnReadMsgCount(freightAgency.getId());
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/content", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getMessageContent(Long senderId) {
        Long userId = FaUtils.getUserVo().getId();
        try {
            List<Message> messageList = faMessageService.getMessageListBySenderId(senderId, userId);
            return new Result<>().success(messageList);
        } catch (Exception e) {
            return new Result<>().fail(e.toString());
        }
    }

    @RequestMapping(value = "/fts/info", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFtsInfoById(Long senderId) {
        try {
            ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(senderId);
            Long faId = FaUtils.getUserVo().getId();
            Friend friend = new Friend(foreignTradeSaleman.getId(), faId);
            friend = faFriendService.selectFriend(friend);
            FtsMessageVo ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getName());
            if (friend != null) {
                ftsMessageVo.setName(friend.getFtsMark());
            }
            return new Result<>().success(ftsMessageVo);
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
    }

    @RequestMapping(value = "/read", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result readMessage(Long senderId) {
        Long faId = FaUtils.getUserVo().getId();
        Message message = new Message(senderId, faId);
        try {
            faMessageService.readAllMessages(message);
            if (WebSocketUtils.hasConnection(senderId)) {
//                发给发送消息的人
                message.setMessageType("readMessage");
                message.setStatus("1");
                WebSocketUtils.get(senderId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
            }
            if (WebSocketUtils.hasConnection(faId)) {
//                发给自己
                message.setMessageType("hasRead");
                message.setSenderId(senderId);
                WebSocketUtils.get(faId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
            }
            return Result.success;
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
    }

}
