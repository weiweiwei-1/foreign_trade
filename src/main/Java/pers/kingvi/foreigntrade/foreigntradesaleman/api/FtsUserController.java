package pers.kingvi.foreigntrade.foreigntradesaleman.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.common.IdWorker;
import pers.kingvi.foreigntrade.filter.CustomizedToken;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.util.fts.error.FtsVoErrorUtils;
import pers.kingvi.foreigntrade.vo.AuthResult;
import pers.kingvi.foreigntrade.vo.error.LoginError;
import pers.kingvi.foreigntrade.vo.error.fts.FtsVoError;
import pers.kingvi.foreigntrade.vo.fts.ForeignTradeSalemanInfoVo;
import pers.kingvi.foreigntrade.vo.fts.FtsMessageVo;
import pers.kingvi.foreigntrade.vo.fts.FtsUpdateVo;

import java.io.File;
import java.sql.SQLException;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/fts/user")
public class FtsUserController {

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    private UserService userService;

    /**
     *
     * @param email: 前端传入的邮箱
     * @param password：前端传入的密码
     * @param code：前端传入的验证码
     * @return 返回result结果
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestParam("account") String email, @RequestParam("password") String password, @RequestParam("code") String code) {
        String emailError = null;
        String passwordError = null;
        if (StringUtils.isBlank(email)) {
            emailError = ResultInfo.NULL_EMAIL;
        } else {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = ResultInfo.EMAIL_FORMAT;
            }
        }
        if (StringUtils.isBlank(password)) {
            passwordError = ResultInfo.NULL_PASSWORD;
        } else if (password.trim().length() < 6 || password.trim().length() > 15) {
            passwordError = ResultInfo.PASSWORD_LENGTH;
        }
        if (emailError != null || passwordError != null) {
            return new Result<>().error(new LoginError(emailError, passwordError, null));
        } else {
            //格式校验通过的条件下，才查询数据库判断邮箱是否注册，否则先返回错误信息
            User user = userService.selectByUserAccount(email);
            if (user != null) {
                emailError = ResultInfo.EMAIL_EXIST;
                return new Result<>().error(new LoginError(emailError, null, null));
            }
            try {
                //雪花算法生成唯一自增id
                IdWorker idWorker = new IdWorker(1, 1, 1);
                ForeignTradeSaleman fts = new ForeignTradeSaleman();
                Long id = idWorker.nextId();
                fts.setId(id);
                fts.setAccount(email);
                fts.setPassword(password);
                fts.setCompany(" ");
                fts.setCity(" ");
                fts.setName("邂逅");
                fts.setPhoto("default.jpg");
                foreignTradeSalemanService.insertSelective(fts);
            } catch (DataAccessException e) {
                SQLException exception = (SQLException) e.getCause();
                int statusCode = exception.getErrorCode();
                String msg = ResultInfo.DBS_ERROR + statusCode;
                return new Result(ResultCode.FAIL, msg);
            }
            CustomizedToken token = new CustomizedToken(email, password, "fts");
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (Exception e) {
                return new Result(ResultCode.FAIL, "注册成功，登录失败，请点击登录按钮重新登录：" + e.toString());
            }
            //将登录用户信息的密码置为空,防止误操作返回账号密码信息等给前端
            FtsUtils.getUserVo().setPassword("");
            AuthResult authResult = new AuthResult(1000, "fts", FtsUtils.getUserVo().getName(), "login");
            return new Result<AuthResult>().success(authResult);
        }
    }

    /**
     *
     * @param email:前端传入的邮箱
     * @param password：前端传入的密码
     * @return 返回result结果
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
        String emailError = null;
        String passwordError = null;
        if (StringUtils.isBlank(email)) {
            emailError = ResultInfo.NULL_EMAIL;
        } else {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = ResultInfo.EMAIL_FORMAT;
            }
        }
        if (StringUtils.isBlank(password)) {
            passwordError = ResultInfo.NULL_PASSWORD;
        } else if (password.trim().length() < 6 || password.trim().length() > 15) {
            passwordError = ResultInfo.PASSWORD_LENGTH;
        }
        //email或者password格式校验错误则返回错误信息，不执行登录操作
        if (emailError != null || passwordError != null) {
            return new Result<>().error(new LoginError(emailError, passwordError, null));
        } else {
            //格式校验通过，进行登录操作
            CustomizedToken token = new CustomizedToken(email, password, "fts");
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                return new Result<>().error(new LoginError(ResultInfo.EMAIL_NOT_EXIST, null));
            } catch (IncorrectCredentialsException ice) {
                return new Result<>().error(new LoginError(null, ResultInfo.PASSWORD_ERROR));
            }
            System.out.println("登录用户角色为：" + subject.getPrincipal());
            Session session = subject.getSession();
            FtsUtils.getUserVo().setPassword("");
            session.setAttribute("id", FtsUtils.getUserVo().getId());
            AuthResult authResult = new AuthResult(1000, "fts", FtsUtils.getUserVo().getName(), "login");
            return new Result<AuthResult>().success(authResult);
        }
    }

    /**
     * @return 返回外贸用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/user-info")
    public Result getUserInfo() {
        ForeignTradeSaleman fts = FtsUtils.getUserVo();
        if (fts != null) {
            ForeignTradeSalemanInfoVo foreignTradeSalemanInfoVo = new ForeignTradeSalemanInfoVo(
                    fts.getPhoto(),
                    fts.getAccount(),
                    fts.getSendProductCount(),
                    fts.getName(),
                    fts.getAge(),
                    fts.getSex(),
                    fts.getCity(),
                    fts.getCompany(),
                    fts.getStoreLink(),
                    fts.getWorkingTime(),
                    fts.getIndustry(),
                    fts.getMainProduct(),
                    fts.getWeChat(),
                    fts.getPhone(),
                    fts.getEmail()
            );
            return new Result<ForeignTradeSalemanInfoVo>().success(foreignTradeSalemanInfoVo);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method={RequestMethod.POST})
    public Result editUserInfo(
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "sex", required = false) String sex,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "storeLink", required = false) String storeLink,
            @RequestParam(value = "workingTime", required = false) String workingTime,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "mainProduct", required = false) String mainProduct,
            @RequestParam(value = "weChat", required = false) String weChat,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "email", required = false) String email) {
        String photoError = null;
        String nameError = null;
        String ageError = null;
        String sexError = null;
        String cityError = null;
        String companyError = null;
        String storeLinkError = null;
        String workingTimeError = null;
        String industryError = null;
        String mainProductError = null;
        String weChatError = null;
        String phoneError = null;
        String emailError = null;
        String newPhotoName = null;
        //名字长度校验
        if (StringUtils.isBlank(name)) {
            nameError = FtsVoErrorUtils.NAME_NULL;
        } else if (!StringUtils.isBlank(name)) {
            if (name.trim().length() > 10 || name.trim().length() < 2) {
                nameError = FtsVoErrorUtils.NAME_ERROR;
            }
        }
        //年龄校验
        if (!StringUtils.isBlank(age)) {
            System.out.println("age" + age);
            System.out.println(age.length());
            System.out.println(StringUtils.isBlank(null));
            try {
                Integer.parseInt(age);
            } catch (NumberFormatException e) {
                ageError = FtsVoErrorUtils.AGE_ERROR;
            }
            if (ageError == null) {
                int parseIntRes = Integer.parseInt(age);
                if (parseIntRes < 2 || parseIntRes > 90) {
                    ageError = FtsVoErrorUtils.AGE_ERROR;
                }
            }
        }
        //性别校验
        if (!StringUtils.isBlank(sex)) {
            if (!"男".equals(sex.trim()) && !"女".equals(sex.trim())) {
                sexError = FtsVoErrorUtils.SEX_ERROR;
            }
        }
        //城市格式校验
        if (StringUtils.isBlank(city)) {
            cityError = FtsVoErrorUtils.CITY_NULL;
        } else if (!StringUtils.isBlank(city)) {
            if (city.trim().length() < 2 || city.trim().length() > 10) {
                cityError = FtsVoErrorUtils.CITY_ERROR;
            }
        }
        //公司格式校验
        if (StringUtils.isBlank(company)) {
            companyError = FtsVoErrorUtils.COMPANY_NULL;
        } else if (!StringUtils.isBlank(company)) {
            if (company.trim().length() < 2 || company.trim().length() > 15) {
                companyError = FtsVoErrorUtils.COMPANY_ERROR;
            }
        }
        //店铺链接格式校验
        if (!StringUtils.isBlank(storeLink)) {
            if (storeLink.trim().length() > 130) {
                storeLinkError = FtsVoErrorUtils.STORE_LINK_ERROR;
            }
        }
        //工作年限校验
        if (!StringUtils.isBlank(workingTime)) {
            System.out.println(StringUtils.isBlank(workingTime));
            try {
                Integer.parseInt(workingTime);
            } catch (NumberFormatException e) {
                workingTimeError = FtsVoErrorUtils.WORKING_TIME_ERROR;
            }
            if (workingTimeError == null) {
                int parseIntRes = Integer.parseInt(workingTime);
                if (parseIntRes < 2 || parseIntRes > 80) {
                    workingTimeError = FtsVoErrorUtils.WORKING_TIME_ERROR;
                }
            }
        }
        //行业校验
        if (!StringUtils.isBlank(industry)) {
            if (industry.trim().length() > 10) {
                industryError = FtsVoErrorUtils.INDUSTRY_ERROR;
            }
        }
        //主要产品格式校验
        if (!StringUtils.isBlank(mainProduct)) {
            if (mainProduct.trim().length() > 60) {
                mainProductError = FtsVoErrorUtils.MAIN_PRODUCT_ERROR;
            }
        }
        //微信格式校验
        if (!StringUtils.isBlank(weChat)) {
            if (weChat.trim().length() < 6 || weChat.trim().length() > 20) {
                weChatError = FtsVoErrorUtils.WECHAT_ERROR;
            }
        }
        //手机号格式校验
        if (!StringUtils.isBlank(phone)) {
            if (!Pattern.matches("^1[3-9]\\d{9}$", phone.trim())) {
                phoneError = FtsVoErrorUtils.PHONE_ERROR;
            }
        }
        //邮箱格式校验
        if (!StringUtils.isBlank(email)) {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = FtsVoErrorUtils.EMAIL_ERROR;
            }
        }
        //上传照片大小校验
        if (photo != null) {
            if (photo.getSize() > 4194304) {
                photoError = FtsVoErrorUtils.PHOTO_ERROR;
            }
        }
        //格式校验不通过，直接返回
        if (photoError != null
                || nameError != null
                || ageError != null
                || sexError != null
                || cityError != null
                || companyError != null
                || storeLinkError != null
                || workingTimeError != null
                || industryError != null
                || mainProductError != null
                || weChatError != null
                || phoneError != null
                || emailError != null) {
            FtsVoError ftsVoError = new FtsVoError(photoError, nameError, ageError, sexError, cityError, companyError, storeLinkError, workingTimeError, industryError, mainProductError, weChatError, phoneError, emailError);
            return new Result<FtsVoError>().error(ftsVoError);
        }
        //格式校验通过， 对文件进行操作
        if (photo != null) {
            String originalFileName = photo.getOriginalFilename();
            if (originalFileName != null && originalFileName.length() > 0) {
                String savePath = "E:\\IDEA-workspace\\fts-image\\";
                String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(savePath + newFileName);
                try {
                    photo.transferTo(newFile);
                } catch (Exception e) {
                    photoError = ResultInfo.WRITE_PHOTO_ERROR;
                }
                String oldPhoto = FtsUtils.getUserVo().getPhoto();
                if (photoError == null) {
                    newPhotoName = newFileName;
                    //如果是非默认图片default.jpg,则将本地储存的图片删除
                    if (!"default.jpg".equals(oldPhoto)) {
                        File oldFile = new File(savePath + oldPhoto);
                        if (!oldFile.isDirectory() && oldFile.isFile()) {
                            boolean result = oldFile.delete();
                            if (!result) {
                                photoError = ResultInfo.UPDATE_PHOTO_ERROR;
                            }
                        }
                    }
                }
            }
        }
        if (photoError == null) {
            FtsUpdateVo ftsUpdateVo = new FtsUpdateVo(FtsUtils.getUserVo().getId(), newPhotoName != null ? newPhotoName : FtsUtils.getUserVo().getPhoto(), name, !"".equals(age) ? Integer.parseInt(age) : null, sex, city, company, storeLink, !"".equals(workingTime) ? Integer.parseInt(workingTime) : null, industry, mainProduct, weChat, phone, email);
            try {
                foreignTradeSalemanService.updateByPrimaryKey(ftsUpdateVo);
            } catch (DataAccessException e) {
                System.out.println(e.toString());
                return new Result(ResultCode.FAIL, e.toString());
            }
            FtsUtils.getUserVo().setPhoto(!StringUtils.isBlank(newPhotoName) ? newPhotoName : FtsUtils.getUserVo().getPhoto());
            FtsUtils.getUserVo().setName(name);
            FtsUtils.getUserVo().setAge(!StringUtils.isBlank(age) ? Integer.parseInt(age) : null);
            FtsUtils.getUserVo().setSex(sex);
            FtsUtils.getUserVo().setCity(city);
            FtsUtils.getUserVo().setCompany(company);
            FtsUtils.getUserVo().setStoreLink(storeLink);
            FtsUtils.getUserVo().setWorkingTime(!StringUtils.isBlank(workingTime) ? Integer.parseInt(workingTime) : null);
            FtsUtils.getUserVo().setIndustry(industry);
            FtsUtils.getUserVo().setMainProduct(mainProduct);
            FtsUtils.getUserVo().setWeChat(weChat);
            FtsUtils.getUserVo().setPhone(phone);
            FtsUtils.getUserVo().setEmail(email);
            return Result.success;
        } else {
            FtsVoError ftsVoError = new FtsVoError(photoError, nameError, ageError, sexError, cityError, companyError, storeLinkError, workingTimeError, industryError, mainProductError, weChatError, phoneError, emailError);
            return new Result<FtsVoError>().error(ftsVoError);
        }

    }

    /**
     * 退出登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout")
    public Result logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return Result.fail;
        }
        return Result.success;
    }

    @ResponseBody
    @RequestMapping(value = "/info")
    public Result getUserId() {
        try {
            long id = FtsUtils.getUserVo().getId();
            ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(id);
            FtsMessageVo ftsMessageVo = new FtsMessageVo(foreignTradeSaleman.getId(), foreignTradeSaleman.getPhoto(), foreignTradeSaleman.getName());
            return new Result<>().success(ftsMessageVo);
        } catch (Exception e) {
            return Result.fail;
        }
    }

}
