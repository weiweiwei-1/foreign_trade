package pers.kingvi.foreigntrade.freightagency.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.admin.service.MessageService;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.freightagency.service.QuoteRecordService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVoImpl;
import pers.kingvi.foreigntrade.vo.error.fa.QuoteRecordError;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteProductVo;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteRecordVo;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteProductVo;
import pers.kingvi.foreigntrade.vo.fts.QuoteFtsInfoVo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private MessageService messageService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @RequestMapping(value = "/send")
    @ResponseBody
    public Result sendQuote(@RequestParam(value = "productId") String productId,
                            @RequestParam(value = "shippingWay") String shippingWay,
                            @RequestParam(value = "price") String price,
                            @RequestParam(value = "arrangeTime") String arrangeTime,
                            @RequestParam(value = "deliverTime") String deliverTime,
                            @RequestParam(value = "reMark") String reMark) throws IOException {
        if (!GlobalControlUtils.isQuoteStatus()) {
            return new Result(-2, "报价功能已关闭，请联系管理员开启");
        }
        String productIdError = null;
        String shippingWayError = null;
        String priceError = null;
        String arrangeTimeError = null;
        String deliverTimeError = null;
        String reMarkError = null;
        if (!NumberUtils.isDigits(productId) || Integer.parseInt(productId) <= 0) {
            productIdError = "1";
        }
        if (!shippingWay.equals("海运") && !shippingWay.equals("空运") && !shippingWay.equals("陆运")) {
            shippingWayError = "1";
        }
        if (!NumberUtils.isDigits(price) || Integer.parseInt(price) < 0) {
            priceError = "1";
        }
        if (!NumberUtils.isDigits(arrangeTime) || 15 < Integer.parseInt(arrangeTime) || Integer.parseInt(arrangeTime) < 0) {
            arrangeTimeError = "1";
        }
        if (!NumberUtils.isDigits(arrangeTime) || 30 < Integer.parseInt(arrangeTime) || Integer.parseInt(arrangeTime) < 0) {
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
            QuoteRecord quoteRecord = new QuoteRecord(Integer.valueOf(productId), faId, shippingWay.trim(), Integer.valueOf(price), arrangeTime, deliverTime, reMark.trim());
            int quoteResult = quoteRecordService.insertSelective(quoteRecord, faId);
            switch (quoteResult) {
                case -3: return new Result<>().fail("当天报价次数已用完");
                case -2: return new Result<>().fail("重复报价");
                case -1: return new Result<>().fail("产品不存在");
                case 0: return new Result<>().fail("产品已报完");
                default:
                    ProductInformation productInformation = productInformationService.selectByPrimaryKey(Integer.valueOf(productId));
                    Long ftsId = productInformation.getFtsId();
                    String productName = productInformation.getProductName();
                    String msgContent = "我刚给您的货物：" + productName + "，进行了运费报价，请点击左上角的三个点或左侧的产品列表查看详情吧";
                    Message message = new Message(faId, ftsId, msgContent);
                    message.setMessageType("addFriend");
                    Date date = new Date();//获取当前的日期
                    String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//设置日期格式
                    message.setSendTime(nowTime);
                    message.setStatus("0");
                    messageService.insertFaMessage(message);
                    if (WebSocketUtils.hasConnection(ftsId)) {
                        ReadAndUnReadMessageVoImpl readAndUnReadMessageVo = new ReadAndUnReadMessageVoImpl();
                        readAndUnReadMessageVo.setMessageType ("addFriend");
                        readAndUnReadMessageVo.setFriendId(faId);
                        readAndUnReadMessageVo.setFriendMark(FaUtils.getUserVo().getName());
                        readAndUnReadMessageVo.setFriendPhoto(FaUtils.getUserVo().getPhoto());
                        readAndUnReadMessageVo.setUnReadMessageCount(1);
                        readAndUnReadMessageVo.setContent(message.getContent());
                        readAndUnReadMessageVo.setSendTime(nowTime);
                        WebSocketUtils.get(ftsId).sendMessage(new TextMessage(JSONObject.toJSONString(readAndUnReadMessageVo)));
                    }
                    return Result.success;
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
            if (faQuoteRecordVoList != null) {
                return new Result<>().success(faQuoteRecordVoList);
            } else {
                return new Result<>().success(new FaQuoteRecordVo());
            }
        } catch (Exception e) {
//            System.out.println("出现的错误是：" + e.toString());
            return new Result<>().fail("dataBase query fail");
        }
    }

    @RequestMapping(value = "/list/ftsid")
    @ResponseBody
    public Result getQuoteProductListByFtsId(Long ftsId) {
        Long faId = FaUtils.getUserVo().getId();
        try {
            List<QuoteProductVo> quoteProductVoList = quoteRecordService.selectQuoteListByFtsId(faId, ftsId);
            return new Result<>().success(quoteProductVoList);
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
    public Result getSendQuote(Integer productId) {
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

    @RequestMapping(value = "/fts/info/pid", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFtsInfoByPid(Integer productId) {
        ProductInformation productInformation = productInformationService.selectByPrimaryKey(productId);
        if (productInformation != null) {
            ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(productInformation.getFtsId());
            QuoteFtsInfoVo quoteFtsInfoVo = new QuoteFtsInfoVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getName(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getCity(), foreignTradeSaleman.getCompany(), foreignTradeSaleman.getStoreLink(), foreignTradeSaleman.getIndustry(), foreignTradeSaleman.getMainProduct());
            return new Result<>().success(quoteFtsInfoVo);
        }
        return new Result<>().fail("请输入正确信息");
    }

    @RequestMapping(value = "/fts/info", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFtsInfoByFtsId(Long ftsId) {
        ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(ftsId);
        if (foreignTradeSaleman != null) {
            QuoteFtsInfoVo quoteFtsInfoVo = new QuoteFtsInfoVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getName(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getCity(), foreignTradeSaleman.getCompany(), foreignTradeSaleman.getStoreLink(), foreignTradeSaleman.getIndustry(), foreignTradeSaleman.getMainProduct());
            return new Result<>().success(quoteFtsInfoVo);
        }
        return new Result<>().fail("请输入正确信息");
    }

    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    @ResponseBody
    public int getQuoteCount() {
        FreightAgency freightAgency;
        try {
            freightAgency = FaUtils.getUserVo();
        } catch (Exception e) {
//           此时为fts登录状态，返回-2
            return -2;
        }
        if (freightAgency == null) {
//            未登录状态
            return -2;
        }
        try {
            freightAgency = freightAgencyService.selectByPrimaryKey(freightAgency.getId());
            return freightAgency.getSendQuoteCount();
        } catch (Exception e) {
            return -1;
        }
    }

}
