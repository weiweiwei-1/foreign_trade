package pers.kingvi.foreigntrade.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.admin.service.ProductInformationVerifyService;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;

import java.util.List;

@Controller
@RequestMapping(value = "/vivivi/product")
public class ProductInformationVerifyController {
    @Autowired
    private ProductInformationVerifyService productInformationVerifyService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Result getProductVerifyList() {
        try {
            List<ProductInformationVerify> list = productInformationVerifyService.selectAllProductList();
            return new Result<>().success(list);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new Result().fail("后台查询失败！");
        }


    }

    @RequestMapping(value = "/permit")
    @ResponseBody
    public Result permitProduct(Integer id) {
        try {
            int res = productInformationVerifyService.permitProduct(id);
            if (res == 0) {
                return new Result(ResultCode.ERROR, "没有相关产品信息，检查输入id是否存在");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new Result<>().fail("后台出错，请查看log");
        }
        return Result.success;
    }

    @RequestMapping(value = "/reject")
    @ResponseBody
    public Result rejectProduct(Integer id) {
        try {
            int res = productInformationVerifyService.rejectProduct(id);
            if (res == 0) {
                return new Result(ResultCode.ERROR, "操作失败，没有该产品信息，检查输入数据是否合法");
            }
        } catch (Exception e) {
            return new Result<>().fail("后台出错，请查看log");
        }
        return Result.success;
    }
}
