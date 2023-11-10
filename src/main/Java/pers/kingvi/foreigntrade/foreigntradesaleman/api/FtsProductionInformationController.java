package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.admin.service.ProductInformationVerifyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.freightagency.service.QuoteRecordService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.FileSet;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fa.error.FaVoErrorUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.util.fts.error.PdVerVoErrUtils;
import pers.kingvi.foreigntrade.vo.error.fts.ProductInfoVerVoError;
import pers.kingvi.foreigntrade.vo.fa.QuoteFaInfoVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteProductVo;
import pers.kingvi.foreigntrade.vo.fts.ProductInfoVo;
import pers.kingvi.foreigntrade.vo.fts.ProductListInfoVo;
import pers.kingvi.foreigntrade.vo.fts.ProductQuoteVo;
import pers.kingvi.foreigntrade.vo.fts.QuoteRecordVo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/fts/product")
public class FtsProductionInformationController {

    @Autowired
    private ProductInformationService productInformationService;

    @Autowired
    private ProductInformationVerifyService productInformationVerifyService;

    @Autowired
    private QuoteRecordService quoteRecordService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private FriendApplyService friendApplyService;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @RequestMapping(value = "/send", method = {RequestMethod.POST})
    @ResponseBody
    public Result sendProduct(@RequestParam(value = "photo", required = true) MultipartFile photo,
                              @RequestParam(value = "productName", required = true) String productName,
                              @RequestParam(value = "origin", required = true) String origin,
                              @RequestParam(value = "destinationCountry", required = true) String destinationCountry,
                              @RequestParam(value = "postcode", required = true) String postcode,
                              @RequestParam(value = "weight", required = true) String weight,
                              @RequestParam(value = "volumn", required = true) String volumn,
                              @RequestParam(value = "timeRequirement", required = true) String timeRequirement,
                              @RequestParam(value = "realOrder", required = true) String realOrder,
                              @RequestParam(value = "charger", required = true) String charger,
                              @RequestParam(value = "certificate", required = true) String certificate,
                              @RequestParam(value = "destination", required = true) String destination,
                              @RequestParam(value = "remark", required = true) String remark) {
        Long ftsId = FtsUtils.getUserVo().getId();
        String photoErr = null;
        String productNameErr = null;
        String originErr = null;
        String destinationCountryErr = null;
        String postcodeErr = null;
        String weightErr = null;
        String volumnErr = null;
        String timeRequirementErr = null;
        String realOrderErr = null;
        String chargerErr = null;
        String certificateErr = null;
        String destinationErr = null;
        String remarkErr = null;
        String newPhotoName = null;
        //产品名校验
        if (StringUtils.isBlank(productName)) {
            productNameErr = PdVerVoErrUtils.PRODUCT_NAME_NULL;
        } else if (productName.trim().length() > 10) {
            productNameErr = PdVerVoErrUtils.PRODUCT_NAME_ERROR;
        }
        //发货地校验
        if (StringUtils.isBlank(origin)) {
            originErr = PdVerVoErrUtils.ORIGIN_NULL;
        } else if (origin.trim().length() < 2 || origin.trim().length() > 10) {
            originErr = PdVerVoErrUtils.ORIGIN_ERROR;
        }
        //目的国校验
        if (StringUtils.isBlank(destinationCountry)) {
            destinationCountryErr = PdVerVoErrUtils.DESTINATION_COUNTRY_NULL;
        } else if (destinationCountry.trim().length() < 2 || destinationCountry.trim().length() > 13) {
            destinationCountryErr = PdVerVoErrUtils.DESTINATION_COUNTRY_ERROR;
        }
        //邮编校验
        if (!StringUtils.isBlank(postcode) && (postcode.trim().length() < 3 || postcode.trim().length() > 10)) {
            postcodeErr = PdVerVoErrUtils.POSTCODE_ERROR;
        }
        //重量校验
        if (StringUtils.isBlank(weight)) {
            weightErr = PdVerVoErrUtils.WEIGHT_NULL;
        } else {
            try {
                Integer.parseInt(weight);
            } catch (NumberFormatException e) {
                weightErr = PdVerVoErrUtils.WEIGHT_FORMAT;
            }
            if (weightErr == null) {
                int parseIntRes = Integer.parseInt(weight);
                if (parseIntRes < 1 || parseIntRes > 9999999) {
                    weightErr = PdVerVoErrUtils.WEIGHT_ERROR;
                }
            }
        }
        //材积校验
        if (!StringUtils.isBlank(volumn) && (volumn.trim().length()) > 20) {
            volumnErr = PdVerVoErrUtils.VOLUMN_ERROR;
        }
        //需求时间校验
        if (!StringUtils.isBlank(timeRequirement) && (timeRequirement.trim().length()) > 10) {
            timeRequirementErr = PdVerVoErrUtils.TIME_REQUIREMENT_ERROR;
        }
        //实单校验
        if (StringUtils.isBlank(realOrder)) {
            realOrderErr = PdVerVoErrUtils.REAL_ORDER_NULL;
        } else if (!"1".equals(realOrder) && !"0".equals(realOrder)) {
            realOrderErr = PdVerVoErrUtils.REAL_ORDER_ERROR;
        }
        //带电校验
        if (StringUtils.isBlank(charger)) {
            chargerErr = PdVerVoErrUtils.CHARGER_NULL;
        } else if (!"1".equals(charger) && !"0".equals(charger)) {
            chargerErr = PdVerVoErrUtils.CHARGER_ERROR;
        }
        //证书校验
        if (StringUtils.isBlank(certificate)) {
            certificateErr = PdVerVoErrUtils.CERTIFICATE_NULL;
        } else if (!"1".equals(certificate) && !"0".equals(certificate)) {
            certificateErr = PdVerVoErrUtils.CERTIFICATE_ERROR;
        }
        //详细地址校验
        if (StringUtils.isBlank(destination)) {
            destinationErr = PdVerVoErrUtils.DESTINATION_NULL;
        } else if (destination.trim().length() < 2 || destination.trim().length() > 100) {
            destinationErr = PdVerVoErrUtils.DESTINATION_ERROR;
        }
        //备注校验
        if (!StringUtils.isBlank(remark) && (remark.trim().length()) > 80) {
            remarkErr = PdVerVoErrUtils.REMARK_ERROR;
        }
        if (photo != null) {
            if (photo.getSize() > 5 * 1024 * 1024) {
                photoErr = FaVoErrorUtils.PHOTO_ERROR;
            }
        }
        if (photoErr != null
                || productNameErr != null
                || originErr != null
                || destinationCountryErr != null
                || postcodeErr != null
                || weightErr != null
                || volumnErr != null
                || timeRequirementErr != null
                || realOrderErr != null
                || chargerErr != null
                || certificateErr != null
                || destinationErr != null
                || remarkErr != null) {
            ProductInfoVerVoError productInfoVerVoError = new ProductInfoVerVoError(photoErr, productNameErr, originErr, destinationCountryErr, postcodeErr, weightErr, volumnErr, timeRequirementErr, realOrderErr, chargerErr, certificateErr, destinationErr, remarkErr);
            return new Result<ProductInfoVerVoError>().error(productInfoVerVoError);
        }
        //格式校验通过，对文件进行操作
        if (photo != null) {
            String originFileName = photo.getOriginalFilename();
            if (originFileName != null && originFileName.length() > 0) {
                String savePath = FileSet.PRODUCT_VERIFY_IMAGE_PATH;
                String newFileName = UUID.randomUUID() + originFileName.substring(originFileName.lastIndexOf("."));
                File newFile = new File(savePath + newFileName);
                try {
                    photo.transferTo(newFile);
                } catch (Exception e) {
                    photoErr = ResultInfo.WRITE_PHOTO_ERROR;
                }
                if (photoErr == null) {
                    newPhotoName = newFileName;
                }
            }
        }
        //图片写入未出现异常，才执行数据插入操作
        if (photoErr == null) {
            ProductInformationVerify productInformationVerify = new ProductInformationVerify(ftsId, FtsUtils.getUserVo().getName(), newPhotoName, productName, origin, destinationCountry, postcode, Double.parseDouble(weight), volumn, timeRequirement, realOrder, charger, certificate, destination, remark);
            try {
                productInformationVerifyService.insertSelective(productInformationVerify);
                return new Result(ResultCode.SUCCESS, "发送成功，等待管理员审核通过后可接收报价");
            } catch (DataAccessException e) {
                System.out.println(e.toString());
                return new Result(ResultCode.FAIL, e.toString());
            }
        } else {
            return new Result(ResultCode.FAIL, photoErr);
        }
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getProductionInformationList() {
        Long ftsId = FtsUtils.getUserVo().getId();
        List<ProductInformation> list = productInformationService.selectByFtsId(ftsId);
        List<ProductListInfoVo> productListInfoVoList = new ArrayList<>();
        for (ProductInformation productInfo : list) {
            ProductListInfoVo productListInfoVo = new ProductListInfoVo(productInfo.getId(), productInfo.getProductName(), productInfo.getPhoto(), productInfo.getSendTime(), productInfo.getQuoteCount(), null);
            productListInfoVoList.add(productListInfoVo);
        }
        return new Result<>().success(productListInfoVoList);
    }

    @RequestMapping(value = "/quote/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getQuoteListByPid(Integer productId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        ProductInformation productInformation = productInformationService.selectByIdAndFtsId(productId, ftsId);
        if (productInformation != null) {
            try {
                List<QuoteRecord> quoteRecordList = quoteRecordService.selectByProductId(productId);
                List<QuoteRecordVo> quoteRecordVoList = new ArrayList<>();
                for (QuoteRecord quoteRecord : quoteRecordList) {
                    quoteRecordVoList.add(new QuoteRecordVo(quoteRecord.getId(), quoteRecord.getShippingWay(), quoteRecord.getPrice(), quoteRecord.getArrangeTime(), quoteRecord.getDeliverTime(), quoteRecord.getFaId()));
                }
                return new Result<>().success(quoteRecordVoList);
            } catch (Exception e) {
                return new Result<>().fail("后台出错");
            }
        } else {
            return new Result<>().fail("产品不存在！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = {RequestMethod.GET})
    public Result productDetail(Integer productId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        ProductInformation productInfo = productInformationService.selectByIdAndFtsId(productId, ftsId);
        if (productInfo == null) {
            return new Result<>().fail("没有该条记录");
        }
        ProductInfoVo productInfoVo = new ProductInfoVo(
                productInfo.getPhoto(), productInfo.getProductName(), productInfo.getOrigin(), productInfo.getDestinationCountry(), productInfo.getDestination(),
                productInfo.getWeight(), productInfo.getVolumn(), productInfo.getCharger(), productInfo.getCertificate(), productInfo.getRealOrder(),
                productInfo.getSendTime(), productInfo.getQuoteCount(), productInfo.getRemark()
        );
        return new Result<>().success(productInfoVo);
    }

    @ResponseBody
    @RequestMapping(value = "/quote", method = {RequestMethod.GET})
    public Result getProductQuote(Integer productId, Long faId) {
        QuoteRecord quoteRecord = new QuoteRecord(productId, faId);
        quoteRecord = quoteRecordService.selectByProductIdAndFaId(quoteRecord);
        if (quoteRecord == null) {
            return new Result<>().fail("输入参数不合法，请检查参数！");
        }
        ProductQuoteVo productQuoteVo = new ProductQuoteVo(quoteRecord.getShippingWay(), quoteRecord.getPrice(), quoteRecord.getArrangeTime(), quoteRecord.getDeliverTime(), quoteRecord.getSendTime());
        return new Result<>().success(productQuoteVo);
    }

    @ResponseBody
    @RequestMapping(value = "/fa/info", method = {RequestMethod.GET})
    public Result getFaInfo(Long faId) {
        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
        if (freightAgency != null) {
            QuoteFaInfoVo quoteFaInfoVo = new QuoteFaInfoVo(freightAgency.getId(),
                    freightAgency.getName(),
                    freightAgency.getPhoto(),
                    freightAgency.getCity(),
                    freightAgency.getCompany(),
                    freightAgency.getCompanyLink(),
                    freightAgency.getMainBussinessScope()
            );
            return new Result<>().success(quoteFaInfoVo);
        }
        return new Result<>().fail("输入参数错误，请重新输入");
    }
/*
    @RequestMapping(value = "/fa/status/friend", method = {RequestMethod.GET})
    @ResponseBody
    public Result getFriendStatus(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        Friend friend = new Friend(ftsId, faId);
        Friend friendRes = friendService.selectFriend(friend);
        FriendApply friendApply = new FriendApply(friend.getFtsId(), friend.getFaId());
        friendApply = friendApplyService.selectFriendApply(friendApply);
        if (friendRes != null || friendApply != null) {
            return new Result<>().success(1);
        } else {
            return new Result<>().success(0);
        }
    }*/

    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    @ResponseBody
    public int getQuoteCount() {
        ForeignTradeSaleman foreignTradeSaleman;
        try {
            foreignTradeSaleman = FtsUtils.getUserVo();
        } catch (Exception e) {
//           此时为fts登录状态，返回-2
            return -2;
        }
        if (foreignTradeSaleman == null) {
//            未登录状态
            return -2;
        }
        try {
            foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(foreignTradeSaleman.getId());
            return foreignTradeSaleman.getSendProductCount();
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/list/faid")
    @ResponseBody
    public Result getQuoteProductListByFaId(Long faId) {
        Long ftsId = FtsUtils.getUserVo().getId();
        try {
            List<QuoteProductVo> quoteProductVoList = quoteRecordService.selectQuoteListByFtsId(faId, ftsId);
            return new Result<>().success(quoteProductVoList);
        } catch (Exception e) {
            return new Result<>().fail("dataBase query fail");
        }
    }
}
