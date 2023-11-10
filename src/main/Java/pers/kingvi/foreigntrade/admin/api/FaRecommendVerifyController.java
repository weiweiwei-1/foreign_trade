package pers.kingvi.foreigntrade.admin.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.admin.service.FreightAgencyRecommendVerifyService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.po.subPo.SubFreightAgenceRecommendVerify;
import pers.kingvi.foreigntrade.util.Result;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/vivivi/fa-recommend")
public class FaRecommendVerifyController {

    @Autowired
    private FreightAgencyRecommendVerifyService freightAgencyRecommendVerifyService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Result getFaRecommendList() {
        try {
            List<SubFreightAgenceRecommendVerify> lists = new ArrayList<>();
            List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyLists = freightAgencyRecommendVerifyService.selectAll();
            for (FreightAgencyRecommendVerify freightAgencyRecommendVerifyList : freightAgencyRecommendVerifyLists) {
                SubFreightAgenceRecommendVerify subFreightAgenceRecommendVerify = new SubFreightAgenceRecommendVerify();
                BeanUtils.copyProperties(freightAgencyRecommendVerifyList, subFreightAgenceRecommendVerify);
                FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(freightAgencyRecommendVerifyList.getFaId());
                subFreightAgenceRecommendVerify.setAccount(freightAgency.getAccount());
                lists.add(subFreightAgenceRecommendVerify);
            }
            return new Result<>().success(lists);
        } catch (Exception e) {
            return Result.fail;
        }
    }

    @RequestMapping(value = "permit")
    @ResponseBody
    public Result permitFaRecommend(Integer id, Long faId) {
        int res = freightAgencyRecommendVerifyService.permitFaRecommend(id, faId);
        if (res == 1) {
            return Result.success;
        }
        return Result.fail;
    }

    @RequestMapping(value = "reject")
    @ResponseBody
    public Result rejectFaRecommend(Integer id) {
        try {
            int res = freightAgencyRecommendVerifyService.rejectRecommend(id);
            if (res == 1) {
                return Result.success;
            }
            return Result.fail;
        } catch (Exception e) {
            return Result.fail;
        }
    }
}
