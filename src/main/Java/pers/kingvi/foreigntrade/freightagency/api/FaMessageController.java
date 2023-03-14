package pers.kingvi.foreigntrade.freightagency.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendService;
import pers.kingvi.foreigntrade.freightagency.service.FaMessageService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
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
        ForeignTradeSaleman foreignTradeSaleman = faMessageService.getFtsInfoByProductId(productId);
        if (foreignTradeSaleman != null) {
            FtsMessageVo ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getName());
            return new Result<>().success(ftsMessageVo);
        }
        return Result.fail;
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
        ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(senderId);
        if (foreignTradeSaleman != null) {
            FtsMessageVo ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getName());
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
            if (readAndUnReadMessageVoList == null) {
                return Result.fail;
            }
            return new Result<>().success(readAndUnReadMessageVoList);
        } catch (Exception e) {
            return Result.fail;
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
        Long ftsId = FaUtils.getUserVo().getId();
        Message message = new Message(senderId, ftsId);
        try {
            faMessageService.readAllMessages(message);
            return Result.success;
        } catch (Exception e) {
            return Result.fail;
        }
    }

}
