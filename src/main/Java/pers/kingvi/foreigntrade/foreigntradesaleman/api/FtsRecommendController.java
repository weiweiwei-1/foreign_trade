package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyRecommendService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.PageSet;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.PageBeanVo;
import pers.kingvi.foreigntrade.vo.error.PageError;

@Controller
@RequestMapping(value = "/fts/recommend/")
public class FtsRecommendController {

    @Autowired
    private FreightAgencyRecommendService freightAgencyRecommendService;

    @Autowired
    private FtsFriendService ftsFriendService;

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public Result getFaRecommendList(@RequestParam("currentPage") Integer currentPage) {
        if (!GlobalControlUtils.isActivityStatus()) {
            PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>("activity", false);
            return new Result<>().success(pageBeanVo);
        }
        Subject subject = SecurityUtils.getSubject();
        //页面错误信息
        PageError pageError;
        //初始化pageBeanVo
        PageBeanVo<FreightAgencyRecommend> pageBeanVo;
        if (!subject.isAuthenticated()) {
            try {
                pageBeanVo = freightAgencyRecommendService.selectByCityRecommend(null, currentPage, PageSet.FA_RECOMMEND_PAGE_SIZE_20);
            } catch (Exception e) {
                return new Result<>().error(e.toString());
            }
        } else {
            try {
                if (subject.hasRole("fts")) {
                    ForeignTradeSaleman foreignTradeSaleman = (ForeignTradeSaleman) subject.getPrincipal();
                    pageBeanVo = freightAgencyRecommendService.selectByCityRecommend(foreignTradeSaleman.getCity(), currentPage, PageSet.FA_RECOMMEND_PAGE_SIZE_20);
                } else {
                    pageBeanVo = freightAgencyRecommendService.selectByCityRecommend(null, currentPage, PageSet.FA_RECOMMEND_PAGE_SIZE_20);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                return new Result<>().fail(e.toString());
            }
        }
        return new Result<PageBeanVo>().success(pageBeanVo);
    }

    @ResponseBody
    @RequestMapping(value = "/friend/status", method = {RequestMethod.GET})
    public Result getFriendStatus(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        Friend friend = new Friend(faId, ftsId);
        friend = ftsFriendService.selectFriend(friend);
        if (friend != null) {
            friend.setFtsMark(null);
            friend.setFtsId(null);
            friend.setFaId(null);
            friend.setId(0);
            friend.setAddTime(null);
        }
        return new Result<>().success(friend);
    }

    @ResponseBody
    @RequestMapping(value = "/list/condition", method = {RequestMethod.GET})
    public Result getFaRecommendListFromCondition(Integer curPage, String searchContent) {
        if (!GlobalControlUtils.isActivityStatus()) {
            PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>("activity", false);
            return new Result<>().success(pageBeanVo);
        }
        if (curPage < 1) {
            return new Result(0, "页数非法,请重新输入~");
        }
        try {
            PageBeanVo<FreightAgencyRecommend> pageBeanVo = freightAgencyRecommendService.selectFullIndex(searchContent, curPage, PageSet.FA_RECOMMEND_PAGE_SIZE_20);
            if (pageBeanVo == null) {
                return new Result(0, "页数非法,请重新输入~");
            }
            return new Result<>().success(pageBeanVo);
        } catch (Exception e) {
            System.out.println("error***********:" + e.toString());
            return new Result<>().fail("后台查询失败，请联系管理员");
        }
    }
}