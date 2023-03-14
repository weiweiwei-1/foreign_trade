package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.bo.fts.FtsMsgListBo;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsMessageService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.util.Result;
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
            if (readAndUnReadMessageVoList == null) {
                return Result.fail;
            }
            return new Result<>().success(readAndUnReadMessageVoList);
        } catch (Exception e) {
            return Result.fail;
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
