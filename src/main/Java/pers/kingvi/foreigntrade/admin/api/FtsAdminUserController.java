package pers.kingvi.foreigntrade.admin.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.util.Result;

@RequestMapping(value = "/vivivi/fts-user")
@Controller
public class FtsAdminUserController {

    @Autowired
    ForeignTradeSalemanService foreignTradeSalemanService;

    @ResponseBody
    @RequestMapping(value = "/all", method={RequestMethod.GET})
    public Result getAllFtsUser() {
        try {
            return new Result<>().success(foreignTradeSalemanService.selectAll());
        } catch (Exception e) {
            return new Result(-1, "查询失败");
        }

    }
}
