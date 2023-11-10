package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.log.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.config.LoginUtils;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendApplyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.FriendRecommendUtils;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;
import pers.kingvi.foreigntrade.vo.fa.FaFriendRecommendVo;
import pers.kingvi.foreigntrade.vo.fts.FtsFriendInfoDetailVo;
import pers.kingvi.foreigntrade.vo.fts.FtsFriendListVo;
import pers.kingvi.foreigntrade.vo.fts.FtsFriendRecommendInfoVo;
import pers.kingvi.foreigntrade.vo.fts.FtsFriendRecommendVo;

import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping(value = "/fts/friend")
public class FtsFriendController {

    @Autowired
    private FtsFriendService ftsFriendService;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private FriendApplyService friendApplyService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private FtsFriendApplyService ftsFriendApplyService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/recommend")
    @ResponseBody
    public Result getFriendRecommendList() {
        Subject subject = SecurityUtils.getSubject();

//        保存的faId列表
        List<Long> saveList = new ArrayList<>();

//        保存的ftsId集合
        Set<Long> saveSet;

//        所有的faId列表
        List<Long> faIdAll = freightAgencyService.selectByIdList();
        int defaultPageCount = FriendRecommendUtils.DEFAULT_PAGE_COUNT;
        int onlinePageCount = FriendRecommendUtils.ONLINE_PAGE_COUNT;

        List<Long> faOnlineList = new ArrayList<>();

        for (Map.Entry<Long, String> entry : WebSocketUtils.MATCH_TYPE.entrySet()) {
            if (entry.getValue().equals("fa")) {
                faOnlineList.add(entry.getKey());
            }
        }
//        初始化最大随机计算次数为1000
        int computeTimes = 1000;
//        在线用户数
        int onlineCount = 0;

//        若用户登录，则先选择在线用户，再选择其他用户
        if (subject.isAuthenticated()) {
            if (subject.hasRole("fts")) {
                Long ftsId = FtsUtils.getUserVo().getId();
                List<Friend> friendList = ftsFriendService.selectFriendList(ftsId);
//                用set保存好友的id
                Set<Long> friendSet = new HashSet<>();
//                用list保存好友的id
                List<Long> friendIdList = new ArrayList<>();
                for (Friend friend : friendList) {
                    friendSet.add(friend.getFaId());
                    friendIdList.add(friend.getFaId());
                }
                //                有fts在线用户，则添加到saveList列表中
                if (faOnlineList.size() > 0) {
//                    在线用户剔除掉好友
                    faOnlineList.removeAll(friendIdList);
//                    剔除掉好友后剩余在线用户数小于或等于onlinePageCount，则全部添加到saveList中
                    if (faOnlineList.size() <= onlinePageCount) {
                        saveList.addAll(faOnlineList);
//                        剔除后大于onlinePageCount，随机选择ftsId添加到saveList中
                    } else {
//                        需要剩余添加的数为addCount
                        int addCount = onlinePageCount;
                        saveSet = new HashSet<>(saveList);
                        while (addCount != 0) {
//                            随机选择ftsOnlineList中的addCount个数，最多计算1000次后停止计算
                            int index = (int) (Math.random() * faOnlineList.size());
                            computeTimes--;
                            Long tempId = faOnlineList.get(index);
                            if (!saveSet.contains(tempId) && !friendSet.contains(tempId)) {
                                saveList.add(tempId);
                                saveSet.add(tempId);
                                addCount--;
                            }
                            if (computeTimes == 0) {
                                break;
                            }
                        }
                    }
                }
                onlineCount = saveList.size();
//                在线用户数小于onlinePageCount，且非好友数大于onlinePageCount，则在剩余非在线用户数中随机选择
                if (faIdAll.size() > 0 && saveList.size() < onlinePageCount && faIdAll.size() - friendSet.size() > onlinePageCount) {
                    saveSet = new HashSet<>(saveList);
//                    需添加的非在线用户数
                    int outLineCount = onlinePageCount - onlineCount;
                    computeTimes = 1000;
                    while (outLineCount != 0) {
                        computeTimes--;
                        int index = (int) (Math.random() * faIdAll.size());
                        Long tempId = faIdAll.get(index);
                        if (!saveSet.contains(tempId) && !friendSet.contains(tempId)) {
                            saveList.add(tempId);
                            saveSet.add(tempId);
                            outLineCount--;
                        }
                        if (computeTimes == 0) {
                            break;
                        }
                    }
//                在线用户数小于onlinePageCount，且非好友数小于或等于onlinePageCount，将剩余非在线ftsId全部添加到saveList
                } else if (faIdAll.size() > 0 && saveList.size() < onlinePageCount && faIdAll.size() - friendSet.size() <= onlinePageCount) {
                    saveSet = new HashSet<>(saveList);
                    int outLineCount = onlinePageCount - onlineCount;
                    int addCount = 0;
                    for (Long target : faIdAll) {
                        if (!friendSet.contains(target) && !saveSet.contains(target)) {
                            saveList.add(target);
                            saveSet.add(target);
                            addCount++;
                            if (addCount == outLineCount) {
                                break;
                            }
                        }
                    }
                }
                return getResult(saveList, onlineCount);
            }
        }
//          若用户未登录，则不需要根据好友id进行判断，仍然先显示在线用户
        if (faOnlineList.size() > 0) {
//            在线用户数小于或等于defaultPageCount，则全部添加到saveList中
            if (faOnlineList.size() <= defaultPageCount) {
                saveList.addAll(faOnlineList);
            } else {
                int addCount = defaultPageCount;
                saveSet = new HashSet<>(saveList);
                while (addCount != 0) {
                    int index = (int) (Math.random() * faOnlineList.size());
                    computeTimes--;
                    Long tempId = faOnlineList.get(index);
                    if (!saveSet.contains(tempId)) {
                        saveList.add(tempId);
                        saveSet.add(tempId);
                        addCount--;
                    }
                    if (computeTimes == 0) {
                        break;
                    }
                }
            }
        }
        onlineCount = saveList.size();
//          保存的在线用户数小于defaultPageCount，且ftsIdAll大于defaultPageCount，则从剩余非在线list选择随机数添加
        if (saveList.size() < defaultPageCount && faIdAll.size() > defaultPageCount) {
            Set<Long> set = new HashSet<>(saveList);
            int addCount = defaultPageCount - onlineCount;
            while (addCount != 0) {
                int index = (int) (Math.random() * faIdAll.size());
                Long tempId = faIdAll.get(index);
                computeTimes--;
                if (!set.contains(tempId)) {
                    saveList.add(tempId);
                    set.add(tempId);
                    addCount--;
                }
                if (computeTimes == 0) {
                    break;
                }
            }
//          保存的在线用户数小于defaultPageCount，且ftsIdAll小于或等于defaultPageCount，则从剩余非在线list中全部选择添加
        } else if (saveList.size() < defaultPageCount) {
            saveSet = new HashSet<>(saveList);
            int outLineCount = onlinePageCount - onlineCount;
            int addCount = 0;
            for (Long target : faIdAll) {
                if (!saveSet.contains(target)) {
                    saveList.add(target);
                    saveSet.add(target);
                    addCount++;
                    if (addCount == outLineCount) {
                        break;
                    }
                }
            }
        }
        return getResult(saveList, onlineCount);
    }

    private Result getResult(List<Long> saveList, int onlineCount) {
        if (saveList.size() > 0) {
            List<FreightAgency> foreignTradeSalemanList = freightAgencyService.selectByFaIdList(saveList);
            List<FaFriendRecommendVo> faFriendRecommendVos = new ArrayList<>();
            int count = 1;
            for (FreightAgency freightAgency : foreignTradeSalemanList) {
                if (count <= onlineCount) {
                    faFriendRecommendVos.add(new FaFriendRecommendVo(freightAgency.getId(), freightAgency.getName(), freightAgency.getPhoto(), '1'));
                    count++;
                } else {
                    faFriendRecommendVos.add(new FaFriendRecommendVo(freightAgency.getId(), freightAgency.getName(), freightAgency.getPhoto(), '0'));
                }
            }
            return new Result<>().success(faFriendRecommendVos);
        } else {
            return new Result<>().success(new ArrayList<FaFriendRecommendVo>());
        }
    }

    @RequestMapping(value = "/status", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFriendStatus(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        Friend friend = new Friend(faId, ftsId);
        Friend friendRes = friendService.selectFriend(friend);
        if (friendRes != null) {
            return new Result<>().success(1);
        } else {
            return new Result<>().success(0);
        }
    }

    @RequestMapping(value = "/recommend/condition", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFriendRecommendByCondition(String condition) {
        List<FreightAgency> freightAgencyList = ftsFriendService.selectByCondition(condition);
        List<FtsFriendRecommendVo> ftsFriendRecommendVos = new ArrayList<>();
        for (FreightAgency freightAgency : freightAgencyList) {
            FtsFriendRecommendVo ftsFriendRecommendVo = new FtsFriendRecommendVo(freightAgency.getId(), freightAgency.getName(), freightAgency.getPhoto());
            if (LoginUtils.LOGIN_SESSION.containsKey(freightAgency.getId())) {
                ftsFriendRecommendVo.setOnlineStatus('1');
            } else {
                ftsFriendRecommendVo.setOnlineStatus('0');
            }
            ftsFriendRecommendVos.add(ftsFriendRecommendVo);
        }
        return new Result<>().success(ftsFriendRecommendVos);
    }

    @RequestMapping(value = "/recommend/info", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFaRecommendInfo(Long faId) {
        System.out.println(faId);
        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
        if (freightAgency != null) {
            FtsFriendRecommendInfoVo ftsFriendRecommendInfoVo = new FtsFriendRecommendInfoVo(
                    freightAgency.getId(),
                    freightAgency.getPhoto(),
                    freightAgency.getName(),
                    freightAgency.getCity(),
                    freightAgency.getCompany(),
                    freightAgency.getCompanyLink(),
                    freightAgency.getSex(),
                    freightAgency.getAge(),
                    freightAgency.getWorkingTime(),
                    freightAgency.getMainBussinessScope(),
                    freightAgency.getServiceAdvantage()
            );
            return new Result<>().success(ftsFriendRecommendInfoVo);
        }
        System.out.println(faId);
        return new Result<>().fail("请输入正确参数！");
    }

    @RequestMapping(value = "/apply", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result sendFriendApply(FriendApply friendApply) {
        Long ftsId = FtsUtils.getUserVo().getId();
        friendApply.setSenderId(ftsId);
        try {
            int res = ftsFriendApplyService.insertSelective(friendApply);
            switch (res) {
                case -3:
                    return new Result(res,"账号不存在，请重新输入");
                case -2:
                    return new Result(res, "已发送过申请，勿重复发送");
                case 0:
                    return new Result(res, "已经是好友，不需重复申请");
                case 1:
                    return new Result(res, "已经成为好友啦，点击卡片开始聊天吧~");
                default:
                    if (WebSocketUtils.hasConnection(friendApply.getReceiverId())) {
                        Message message = new Message();
                        message.setMessageType("newFriend");
                        message.setContent(friendApply.getSenderName());
                        WebSocketUtils.getWebsocketSession().get(friendApply.getReceiverId()).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
                    }
                    return new Result(res, "成功发送好友申请，等待通过");
            }
        } catch (Exception e) {
            return new Result<>().fail("后台错误! 联系管理员");
        }
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFriendList() {
        Long ftsId = FtsUtils.getUserVo().getId();
        List<Friend> friendList = ftsFriendService.selectFriendList(ftsId);
//        储存好友的faId列表
        List<Long> faIdList = new ArrayList<>();
        for (Friend friend : friendList) {
            faIdList.add(friend.getFaId());
        }
        List<FtsFriendListVo> ftsFriendListVos = new ArrayList<>();
        if (faIdList.size() != 0) {
            List<FreightAgency> freightAgencyList = freightAgencyService.selectByFaIdList(faIdList);
            for (int i = 0; i < friendList.size(); i++) {
                Long id = friendList.get(i).getFaId();
                String photo = freightAgencyList.get(i).getPhoto();
                String friendMark = friendList.get(i).getFaMark();
                ftsFriendListVos.add(new FtsFriendListVo(
                        id,
                        photo,
                        friendMark
                ));
            }
        }
        return new Result<>().success(ftsFriendListVos);
    }

    @RequestMapping(value = "/apply/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFriendApplyList() {
        Long ftsId = FtsUtils.getUserVo().getId();
        try {
            List<FriendApplyVo> friendApplyVoList = friendApplyService.selectByReceiverId(ftsId);
            return new Result<>().success(friendApplyVoList);
        } catch (Exception e) {
            return new Result<>().fail("后台错误！联系管理员");
        }
    }

    @RequestMapping(value = "/apply/permit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result permitFriendApply(@RequestParam("faId") Long faId, @RequestParam("remark")  String remark) throws IOException {
        if (StringUtils.isBlank(remark) || remark.trim().length() > 10) {
            return new Result<>().fail("好友备注长度必须小于10且不为空！");
        }
        Long ftsId = FtsUtils.getUserVo().getId();
        User user = userService.selectByPrimaryKey(faId);
        if (user != null && user.getUserType().equals("fa")) {
            int res = ftsFriendService.permitFriend(faId, ftsId, remark);
            if (res == -1) {
                return new Result<>().fail("已经是好友关系，勿重复申请！");
            }
            if (res == 0) {
                return new Result<>().fail("数据输入错误，请重新输入！");
            }
            return Result.success;
        } else {
            return new Result<>().fail("账号输入有误");
        }
    }

    @RequestMapping(value = "/apply/reject", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result rejectFriendApply(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        FriendApply friendApply = new FriendApply(faId, ftsId);
        try {
            int res = friendApplyService.deleteFriendApply(friendApply);
            if (res == 0) {
                return new Result<>().fail("数据有误，请重新输入！");
            }
            return Result.success;
        } catch (Exception e) {
            return new Result<>().fail("后台出错，联系管理员！");
        }
    }

    @RequestMapping(value = "/apply/count", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int getNewFriendCount() {
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
            List<FriendApplyVo> friendApplyVoList = friendApplyService.selectByReceiverId(foreignTradeSaleman.getId());
            return friendApplyVoList.size();
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/info/detail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFriendInfoDetail(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        System.out.println("faId为：" + faId);
        User user = userService.selectByPrimaryKey(faId);
        Friend friend = new Friend(faId, ftsId);
        friend = ftsFriendService.selectFriend(friend);
        if (user != null && "fa".equals(user.getUserType())) {
            try {
                FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
                FtsFriendInfoDetailVo ftsFriendInfoDetailVo = new FtsFriendInfoDetailVo(
                        freightAgency.getId(),
                        freightAgency.getPhoto(),
                        freightAgency.getName(),
                        friend != null ? friend.getFaMark() : freightAgency.getName(),
                        freightAgency.getCity(),
                        freightAgency.getCompany(),
                        freightAgency.getCompanyLink(),
                        freightAgency.getSex(),
                        freightAgency.getAge(),
                        freightAgency.getWorkingTime(),
                        freightAgency.getMainBussinessScope(),
                        freightAgency.getServiceAdvantage(),
                        freightAgency.getWeChat(),
                        freightAgency.getPhone(),
                        freightAgency.getEmail()
                );
                return new Result<>().success(ftsFriendInfoDetailVo);
            } catch (Exception e) {
                return new Result<>().fail("后台错误！联系管理员");
            }
        }
        return new Result<>().fail("账号输入错误！");
    }

    @RequestMapping(value = "/remark/save", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getFriendInfoDetail(Long faId, String remark) {
        Long ftsId = FtsUtils.getUserVo().getId();
        User user = userService.selectByPrimaryKey(faId);
        Friend friend = new Friend(faId, ftsId);
        friend = ftsFriendService.selectFriend(friend);
        if (user != null && "fa".equals(user.getUserType()) && friend != null) {
            friend.setFaMark(remark);
            try {
                ftsFriendService.updateFaMark(friend);
                return Result.success;
            } catch (Exception e) {
                return new Result<>().fail("后台错误，联系管理员！");
            }
        } else {
            return new Result(0, "对方已解除好友关系，不能编辑");
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result deleteFriend(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
        Friend friend = new Friend(faId, ftsId);
        friend = ftsFriendService.selectFriend(friend);
        if (freightAgency != null && friend != null) {
            try {
                ftsFriendService.deleteFriend(friend);
                return new Result(ResultCode.SUCCESS, "已解除好友关系");
            } catch (Exception e) {
                return new Result<>().fail("后台错误，联系管理员!");
            }
        } else {
            return new Result(0, "已解除好友关系");
        }
    }
}
