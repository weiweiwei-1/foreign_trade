package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.util.PageSet;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.vo.error.PageError;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "/fa/product")
public class FaProductController {

    @Autowired
    private ProductInformationService productInformationService;

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public Result getProductList(@RequestParam("currentPage") Integer currentPage) {
        if (!GlobalControlUtils.isMarketStatus()) {
            PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>("market", false);
            return new Result<>().success(pageBeanVo);
        }
        Subject subject = SecurityUtils.getSubject();
        //页面错误信息
        PageError pageError;
        //初始化pageBeanVo
        PageBeanVo<ProductInformation> pageBeanVo;
        Session session = subject.getSession();
        //如果未授权，则返回系统默认页面
        if (!subject.isAuthenticated()) {
            try {
                pageBeanVo = productInformationService.selectByCityRecommend(null, currentPage, PageSet.PRODUCT_PAGE_SIZE_20);
            } catch (DataAccessException e) {
                SQLException exception = (SQLException) e.getCause();
                int statusCode = exception.getErrorCode();
                String msg = ResultInfo.DBS_ERROR + statusCode;
                return new Result(ResultCode.FAIL, msg);
            }
            //如果已经登录授权，通过地址查询, 由subject角色判断身份
        } else {
            try {
                if (subject.hasRole("fa")) {
                    FreightAgency freightAgency = (FreightAgency)subject.getPrincipal();
                    pageBeanVo = productInformationService.selectByCityRecommend(freightAgency.getCity(), currentPage, PageSet.PRODUCT_PAGE_SIZE_20);
                } else {
                    pageBeanVo = productInformationService.selectByCityRecommend(null, currentPage, PageSet.PRODUCT_PAGE_SIZE_20);
                }
            } catch (DataAccessException e) {
                SQLException exception = (SQLException) e.getCause();
                int statusCode = exception.getErrorCode();
                String msg = ResultInfo.DBS_ERROR + statusCode;
                return new Result(ResultCode.FAIL, msg);
            }
        }
        return new Result<PageBeanVo>().success(pageBeanVo);
    }

    @ResponseBody
    @RequestMapping(value = "/list/condition", method = {RequestMethod.GET})
    public Result getProductList(Integer curPage, String searchContent) {
        if (!GlobalControlUtils.isMarketStatus()) {
            PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>("market", false);
            return new Result<>().success(pageBeanVo);
        }
        if (curPage < 1) {
            return new Result(0, "页数非法,请重新输入~");
        }
        try {
            PageBeanVo<ProductInformation> pageBeanVo = productInformationService.selectByFullIndex(searchContent, curPage, PageSet.PRODUCT_PAGE_SIZE_20);
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
