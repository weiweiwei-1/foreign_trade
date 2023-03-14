package pers.kingvi.foreigntrade.freightagency.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendApplyService;
import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fa.error.FaFriendApplyErrorUtils;

@Controller
@RequestMapping(value = "/fa/friend")
public class FaFriendController {

    @Autowired
    FaFriendApplyService faFriendApplyService;

    @RequestMapping(value = "/apply/send")
    @ResponseBody
    public Result sendFriendApply(@RequestParam(value = "receiverId") Long receiverId,
                                  @RequestParam(value = "senderName") String senderName) {
        Long senderId = FaUtils.getUserVo().getId();
        FriendApply friendApply = new FriendApply(senderId, receiverId, senderName);
//        try {
            int applyRes = faFriendApplyService.insertSelective(friendApply);
            switch (applyRes) {
                case 0: return new Result(0, FaFriendApplyErrorUtils.RECEIVER_NOT_EXIST);
                case -1: return new Result(0, FaFriendApplyErrorUtils.FRIEND_EXIST);
                case -2: return new Result(0, FaFriendApplyErrorUtils.FRIEND_APPLY_EXIST);
                case -3: return new Result(0, FaFriendApplyErrorUtils.APPLY_TARGET_ERROR);
                default: return Result.success;
            }
        /*} catch (Exception e) {
            System.out.println(e.toString());
            return new Result<>().fail("后台出错，联系管理员！");
        }*/
    }
}
