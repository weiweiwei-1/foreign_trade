package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fa.error.FaVoErrorUtils;
import pers.kingvi.foreigntrade.vo.error.fa.FaVoError;
import pers.kingvi.foreigntrade.vo.fa.FaMessageVo;
import pers.kingvi.foreigntrade.vo.fa.FaUpdateVo;

import java.io.File;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/fa/user")
public class FaUserController {

    @Autowired
    private FreightAgencyService freightAgencyService;

    @ResponseBody
    @RequestMapping(value = "/edit", method={RequestMethod.POST})
    public Result editUserInfo(
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "companyLink", required = false) String companyLink,
            @RequestParam(value = "sex", required = false) String sex,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "workingTime", required = false) String workingTime,
            @RequestParam(value = "mainBussinessScope", required = false) String mainBussinessScope,
            @RequestParam(value = "serviceAdvantage", required = false) String serviceAdvantage,
            @RequestParam(value = "weChat", required = false) String weChat,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "email", required = false) String email) {
        String photoError = null;
        String nameError = null;
        String cityError = null;
        String companyError = null;
        String companyLinkError = null;
        String sexError = null;
        String ageError = null;
        String workingTimeError = null;
        String mainBussinessScopeError = null;
        String serviceAdvantageError = null;
        String weChatError = null;
        String phoneError = null;
        String emailError = null;
        String newPhotoName = null;
        //名字长度校验
        if (StringUtils.isBlank(name)) {
            nameError = FaVoErrorUtils.NAME_NULL;
        } else if (!StringUtils.isBlank(name)) {
            if (name.trim().length() > 10 || name.trim().length() < 2) {
                nameError = FaVoErrorUtils.NAME_ERROR;
            }
        }
        //城市格式校验
        if (StringUtils.isBlank(city)) {
            cityError = FaVoErrorUtils.CITY_NULL;
        } else if (!StringUtils.isBlank(city)) {
            if (city.trim().length() < 2 || city.trim().length() > 10) {
                cityError = FaVoErrorUtils.CITY_ERROR;
            }
        }
        //公司格式校验
        if (StringUtils.isBlank(company)) {
            companyError = FaVoErrorUtils.COMPANY_NULL;
        } else if (!StringUtils.isBlank(company)) {
            if (company.trim().length() < 2 || company.trim().length() > 15) {
                companyError = FaVoErrorUtils.COMPANY_ERROR;
            }
        }
        //公司链接格式校验
        if (!StringUtils.isBlank(companyLink)) {
            if (companyLink.trim().length() > 130) {
                companyLinkError = FaVoErrorUtils.COMPANY_LINK_ERROR;
            }
        }
        //性别校验
        if (!StringUtils.isBlank(sex)) {
            if (!"男".equals(sex.trim()) && !"女".equals(sex.trim())) {
                sexError = FaVoErrorUtils.SEX_ERROR;
            }
        }
        //年龄校验
        if (!StringUtils.isBlank(age)) {
            try {
                Integer.parseInt(age);
            } catch (NumberFormatException e) {
                ageError = FaVoErrorUtils.AGE_ERROR;
            }
            if (ageError == null) {
                int parseIntRes = Integer.parseInt(age);
                if (parseIntRes < 2 || parseIntRes > 90) {
                    ageError = FaVoErrorUtils.AGE_ERROR;
                }
            }
        }
        //工作年限校验
        if (!StringUtils.isBlank(workingTime)) {
            System.out.println(StringUtils.isBlank(workingTime));
            try {
                Integer.parseInt(workingTime);
            } catch (NumberFormatException e) {
                workingTimeError = FaVoErrorUtils.WORKING_TIME_ERROR;
            }
            if (workingTimeError == null) {
                int parseIntRes = Integer.parseInt(workingTime);
                if (parseIntRes < 2 || parseIntRes > 80) {
                    workingTimeError = FaVoErrorUtils.WORKING_TIME_ERROR;
                }
            }
        }
        //主营业务校验
        if (!StringUtils.isBlank(mainBussinessScope)) {
            if (mainBussinessScope.trim().length() > 60) {
                mainBussinessScopeError = FaVoErrorUtils.MAIN_BUSINESS_SCOPE_ERROR;
            }
        }
        //服务优势格式校验
        if (!StringUtils.isBlank(serviceAdvantage)) {
            if (serviceAdvantage.trim().length() > 60) {
                serviceAdvantageError = FaVoErrorUtils.SERVICE_ADVANTAGE_ERROR;
            }
        }
        //微信格式校验
        if (!StringUtils.isBlank(weChat)) {
            if (weChat.trim().length() < 6 || weChat.trim().length() > 20) {
                weChatError = FaVoErrorUtils.WECHAT_ERROR;
            }
        }
        //手机号格式校验
        if (!StringUtils.isBlank(phone)) {
            if (!Pattern.matches("^1[3-9]\\d{9}$", phone.trim())) {
                phoneError = FaVoErrorUtils.PHONE_ERROR;
            }
        }
        //邮箱格式校验
        if (!StringUtils.isBlank(email)) {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = FaVoErrorUtils.EMAIL_ERROR;
            }
        }
        //上传照片大小校验
        if (photo != null) {
            if (photo.getSize() > 4194304) {
                photoError = FaVoErrorUtils.PHOTO_ERROR;
            }
        }
        //格式校验不通过，直接返回
        if (photoError != null
                || nameError != null
                || cityError != null
                || companyError != null
                || companyLinkError != null
                || sexError != null
                || ageError != null
                || workingTimeError != null
                || mainBussinessScopeError != null
                || serviceAdvantageError != null
                || weChatError != null
                || phoneError != null
                || emailError != null) {
            FaVoError faVoError = new FaVoError(photoError, nameError, cityError, companyError, companyLinkError, sexError, ageError, workingTimeError, mainBussinessScopeError, serviceAdvantageError, weChatError, phoneError, emailError);
            return new Result<FaVoError>().error(faVoError);
        }
        //格式校验通过， 对文件进行操作
        if (photo != null) {
            String originalFileName = photo.getOriginalFilename();
            if (originalFileName != null && originalFileName.length() > 0) {
                String savePath = "E:\\IDEA-workspace\\fa-image\\";
                String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(savePath + newFileName);
                try {
                    photo.transferTo(newFile);
                } catch (Exception e) {
                    photoError = ResultInfo.WRITE_PHOTO_ERROR;
                }
                String oldPhoto = FaUtils.getUserVo().getPhoto();
                if (photoError == null) {
                    newPhotoName = newFileName;
                    if (!"default.jpg".equals(oldPhoto)) {
                        File oldFile = new File(savePath + oldPhoto);
                        if (oldFile.isFile() && !oldFile.isDirectory()) {
                            oldFile.delete();
                        }
                    }
                }
            }
        }
        if (photoError == null) {
            FaUpdateVo faUpdateVo = new FaUpdateVo(FaUtils.getUserVo().getId(), newPhotoName != null ? newPhotoName : FaUtils.getUserVo().getPhoto(), name, city, company, companyLink, sex, !"".equals(age) ? Integer.parseInt(age) : null, !"".equals(workingTime) ? Integer.parseInt(workingTime) : null, mainBussinessScope, serviceAdvantage, weChat, phone, email);
            try {
                freightAgencyService.updateByPrimaryKey(faUpdateVo);
            } catch (DataAccessException e) {
                return new Result(ResultCode.FAIL, e.toString());
            }
        }
        FaUtils.getUserVo().setPhoto(!StringUtils.isBlank(newPhotoName) ? newPhotoName : FaUtils.getUserVo().getPhoto());
        FaUtils.getUserVo().setName(name);
        FaUtils.getUserVo().setCity(city);
        FaUtils.getUserVo().setCompany(company);
        FaUtils.getUserVo().setCompanyLink(companyLink);
        FaUtils.getUserVo().setSex(sex);
        FaUtils.getUserVo().setAge(!StringUtils.isBlank(age) ? Integer.parseInt(age) : null);
        FaUtils.getUserVo().setWorkingTime(!StringUtils.isBlank(workingTime) ? Integer.parseInt(workingTime) : null);
        FaUtils.getUserVo().setMainBussinessScope(mainBussinessScope);
        FaUtils.getUserVo().setServiceAdvantage(serviceAdvantage);
        FaUtils.getUserVo().setWeChat(weChat);
        FaUtils.getUserVo().setPhone(phone);
        FaUtils.getUserVo().setEmail(email);
        return Result.success;
    }

    @ResponseBody
    @RequestMapping(value = "/info", method={RequestMethod.GET})
    public Result getFaMsgInfo() {
        Long faId = FaUtils.getUserVo().getId();
        try {
            FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
            FaMessageVo faMessageVo = new FaMessageVo(faId, freightAgency.getPhoto(), freightAgency.getName());
            return new Result<>().success(faMessageVo);
        } catch (Exception e) {
            return Result.fail;
        }

    }

}
