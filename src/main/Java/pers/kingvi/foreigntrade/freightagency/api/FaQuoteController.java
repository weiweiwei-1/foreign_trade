package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.freightagency.service.QuoteRecordService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.vo.error.fa.QuoteRecordError;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteProductVo;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteRecordVo;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteVo;
import pers.kingvi.foreigntrade.vo.fts.QuoteFtsInfoVo;

import java.util.List;

@Controller
@RequestMapping(value = "/fa/quote")
public class FaQuoteController {
    @Autowired
    private QuoteRecordService quoteRecordService;

    @Autowired
    private ProductInformationService productInformationService;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private FriendApplyService friendApplyService;

    @RequestMapping(value = "/send")
    @ResponseBody
    public Result sendQuote(@RequestParam(value = "productId") String productId,
                            @RequestParam(value = "shippingWay") String shippingWay,
                            @RequestParam(value = "price") String price,
                            @RequestParam(value = "arrangeTime") String arrangeTime,
                            @RequestParam(value = "deliverTime") String deliverTime,
                            @RequestParam(value = "reMark") String reMark) {
        String productIdError = null;
        String shippingWayError = null;
        String priceError = null;
        String arrangeTimeError = null;
        String deliverTimeError = null;
        String reMarkError = null;
        if (!NumberUtils.isDigits(productId) || Integer.valueOf(productId) <= 0) {
            productIdError = "1";
        }
        if (!shippingWay.equals("海运") && !shippingWay.equals("空运") && !shippingWay.equals("陆运")) {
            shippingWayError = "1";
        }
        if (!NumberUtils.isDigits(price) || Integer.valueOf(price) < 0) {
            priceError = "1";
        }
        if (!NumberUtils.isDigits(arrangeTime) || 15 < Integer.valueOf(arrangeTime) || Integer.valueOf(arrangeTime) < 0) {
            arrangeTimeError = "1";
        }
        if (!NumberUtils.isDigits(arrangeTime) || 30 < Integer.valueOf(arrangeTime) || Integer.valueOf(arrangeTime) < 0) {
            deliverTimeError = "1";
        }
        if (reMark.trim().length() > 80) {
            reMarkError = "1";
        }
        if (productIdError != null || shippingWayError != null || priceError != null || arrangeTimeError != null || deliverTimeError != null || reMarkError != null) {
            QuoteRecordError quoteRecordError = new QuoteRecordError(productIdError, shippingWayError, priceError, arrangeTimeError, deliverTimeError, reMarkError);
            return new Result<QuoteRecordError>().error(quoteRecordError);
        }
        try {
            Long faId = FaUtils.getUserVo().getId();
            System.out.println(FaUtils.getUserVo());
            QuoteRecord quoteRecord = new QuoteRecord(Integer.valueOf(productId), faId, shippingWay.trim(), Integer.valueOf(price), arrangeTime, deliverTime, reMark.trim());
            int quoteResult = quoteRecordService.insertSelective(quoteRecord, faId);
            switch (quoteResult) {
                case -3: return new Result<>().fail("当天报价次数已用完");
                case -2: return new Result<>().fail("重复报价");
                case -1: return new Result<>().fail("产品不存在");
                case 0: return new Result<>().fail("产品已报完");
                default: return Result.success;
            }
        } catch (DataAccessException e) {
            System.out.println(e.toString());
            return new Result<>().fail("报价中被别人抢先一步啦！");
        }
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Result getQuoteVo() {
        Long faId = FaUtils.getUserVo().getId();
        try {
            List<FaQuoteRecordVo> faQuoteRecordVoList = quoteRecordService.selectByFaId(faId);
            return new Result<>().success(faQuoteRecordVoList);
        } catch (Exception e) {
            return new Result<>().fail("dataBase query fail");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = {RequestMethod.GET})
    public Result getQuoteDetail(Integer productId) {
        Long faId = FaUtils.getUserVo().getId();
        QuoteRecord quoteRecord = new QuoteRecord(productId, faId);
        ProductInformation productInformation = productInformationService.selectByQuoteRecord(quoteRecord);
        if (productInformation == null) {
            return new Result<>().fail("没有该条记录");
        }
        FaQuoteProductVo faQuoteProductVo = new FaQuoteProductVo(
                productInformation.getPhoto(), productInformation.getProductName(), productInformation.getOrigin(), productInformation.getDestinationCountry(), productInformation.getDestination(),
                productInformation.getWeight(), productInformation.getVolumn(), productInformation.getCharger(), productInformation.getCertificate(), productInformation.getRealOrder(),
                productInformation.getSendTime(), productInformation.getQuoteCount(), productInformation.getRemark()
        );
        return new Result<>().success(faQuoteProductVo);
    }

    @RequestMapping(value = "/sent", method = {RequestMethod.GET})
    @ResponseBody
    public Result getSendedQuote(Integer productId) {
        Long faId = FaUtils.getUserVo().getId();
        QuoteRecord quoteRecord = new QuoteRecord(productId, faId);
        try {
            QuoteRecord quoteRecordRes = quoteRecordService.selectByProductIdAndFaId(quoteRecord);
            FaQuoteVo faQuoteVo = new FaQuoteVo(quoteRecordRes.getShippingWay(), quoteRecordRes.getPrice(), quoteRecordRes.getArrangeTime(), quoteRecordRes.getDeliverTime(), quoteRecordRes
                    .getSendTime());
            return new Result<>().success(faQuoteVo);
        } catch (Exception e) {
            return new Result<>().fail("后台出错，查看日志！");
        }

    }

    @RequestMapping(value = "/fts/info", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFtsInfo(Integer productId) {
        ProductInformation productInformation = productInformationService.selectByPrimaryKey(productId);
        if (productInformation != null) {
            ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(productInformation.getFtsId());
            QuoteFtsInfoVo quoteFtsInfoVo = new QuoteFtsInfoVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getName(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getCity(), foreignTradeSaleman.getCompany(), foreignTradeSaleman.getStoreLink(), foreignTradeSaleman.getIndustry(), foreignTradeSaleman.getMainProduct());
            return new Result<>().success(quoteFtsInfoVo);
        }
        return new Result<>().fail("没有相关信息");
    }


    @RequestMapping(value = "/fts/status/friend", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFriendStatus(Long ftsId) {
        Long faId = FaUtils.getUserVo().getId();
        Friend friend = new Friend(faId, ftsId);
        Friend friendRes = friendService.selectFriend(friend);
        FriendApply friendApply = new FriendApply(friend.getFtsId(), friend.getFaId());
        friendApply = friendApplyService.selectFriendApply(friendApply);
        if (friendRes != null || friendApply != null) {
            return new Result<>().success(1);
        } else {
            return new Result<>().success(0);
        }
    }


}
