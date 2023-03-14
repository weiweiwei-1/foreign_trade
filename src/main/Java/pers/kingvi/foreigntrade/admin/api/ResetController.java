package pers.kingvi.foreigntrade.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.util.Result;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/vivivi/reset")
public class ResetController {

    @Autowired
    ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    FreightAgencyService freightAgencyService;

    /**
     *
     * @return 重置结果
     */
    @ResponseBody
    @RequestMapping(value = "/count/product")
    public Result resetSendProductCount() {
        try {
            foreignTradeSalemanService.resetSendProductCount(30);
        } catch (Exception e) {
            return new Result<>().fail("后台出错，请查看log解决");
        }
        return Result.success;
    }


    /**
     *
     * @return 重置结果
     */
    @ResponseBody
    @RequestMapping(value = "/count/quote")
    public Result resetQuoteCount() {
        try {
            freightAgencyService.resetAllSendQuoteCount(30);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new Result<>().fail("后台出错，请查看log解决");
        }
        return Result.success;
    }
}
