package pers.kingvi.foreigntrade.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.util.Result;


@RequestMapping(value = "/vivivi/fa-user")
@Controller
public class FaAdminUserController {

    @Autowired
    private FreightAgencyService freightAgencyService;

    @ResponseBody
    @RequestMapping(value = "/all", method={RequestMethod.GET})
    public Result getAllFaUser() {
        try {
            return new Result<>().success(freightAgencyService.selectAll());
        } catch (Exception e) {
            return new Result(-1, "查询失败");
        }

    }
}
