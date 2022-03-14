package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.util.ErrorInfo;
import pers.kingvi.foreigntrade.util.PageError;
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
        System.out.println("当前页面为：" + currentPage);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getSession().getId());
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        System.out.println("用户为：" + user);
        //页面错误信息
        PageError pageError;
        //初始化pageBeanVo
        PageBeanVo<ProductInformation> pageBeanVo;
        //如果未授权，则返回系统默认页面
        if (!subject.isAuthenticated()) {
            try {
                pageBeanVo = productInformationService.selectByCityRecommend(null, currentPage, 40);
            } catch (DataAccessException e) {
                SQLException exception = (SQLException) e.getCause();
                int statusCode = exception.getErrorCode();
                String msg = ErrorInfo.DBS_ERROR + statusCode;
                return new Result(ResultCode.FAIL, msg);
            }
            //如果授权，通过地址查询, 通过subject角色判断身份
        } else {
            try {
                if (subject.hasRole("fa")) {
                    FreightAgency freightAgency = (FreightAgency)subject.getPrincipal();
                    pageBeanVo = productInformationService.selectByCityRecommend(freightAgency.getCity(), currentPage, 40);
                } else {
                    pageBeanVo = productInformationService.selectByCityRecommend(null, currentPage, 40);
                }
            } catch (DataAccessException e) {
                SQLException exception = (SQLException) e.getCause();
                int statusCode = exception.getErrorCode();
                String msg = ErrorInfo.DBS_ERROR + statusCode;
                return new Result(ResultCode.FAIL, msg);
            }
        }
        if (pageBeanVo == null) {
            pageError = new PageError(ErrorInfo.PAGE_COUNT_ERROR, null);
            return new Result<PageError>().error(pageError);
        }
        return new Result<PageBeanVo>().success(pageBeanVo);
    }
}
