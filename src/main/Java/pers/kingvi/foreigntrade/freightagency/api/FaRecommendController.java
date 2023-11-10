package pers.kingvi.foreigntrade.freightagency.api;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.kingvi.foreigntrade.admin.service.FreightAgencyRecommendVerifyService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyRecommendService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.util.FileSet;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fa.error.FaRecommendErrorUtils;
import pers.kingvi.foreigntrade.vo.error.fa.RecommendVoError;
import pers.kingvi.foreigntrade.vo.fa.FaRecommendInfoVo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/fa/recommend")
public class FaRecommendController {

    @Autowired
    private FreightAgencyRecommendService freightAgencyRecommendService;

    @Autowired
    private FreightAgencyRecommendVerifyService freightAgencyRecommendVerifyService;

    @RequestMapping(value = "/info")
    @ResponseBody
    public Result getActivityRecommendInfo() {
        Long faId = FaUtils.getUserVo().getId();
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = freightAgencyRecommendVerifyService.selectByFaIdSingle(faId);
        if (freightAgencyRecommendVerify != null) {
            FaRecommendInfoVo faRecommendInfoVo = new FaRecommendInfoVo(freightAgencyRecommendVerify.getActivityPhoto(), freightAgencyRecommendVerify.getKeyWords(), freightAgencyRecommendVerify.getDescription(), "1");
            return new Result<>().success(faRecommendInfoVo);
        } else {
            FreightAgencyRecommend freightAgencyRecommend = freightAgencyRecommendService.selectByFaIdSingle(faId);
            if (freightAgencyRecommend != null) {
                FaRecommendInfoVo faRecommendInfoVo = new FaRecommendInfoVo(freightAgencyRecommend.getActivityPhoto(), freightAgencyRecommend.getKeyWords(), freightAgencyRecommend.getDescription(), "0");
                return new Result<>().success(faRecommendInfoVo);
            }
            return new Result<>().success(new FaRecommendInfoVo());
        }
    }

    @RequestMapping(value = "/send", method={RequestMethod.POST})
    @ResponseBody
    public Result sendRecommendInfo(
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam(value = "keyWords") String keyWords,
            @RequestParam(value = "description") String description) throws Exception {
        Long faId = FaUtils.getUserVo().getId();
        FreightAgency freightAgency = FaUtils.getUserVo();
        String photoError = null;
        String keyWordsError = null;
        String descriptionError = null;
        String newFileName = null;
        boolean errorMark = false;
        if (photo != null) {
            if (photo.getSize() > FileSet.MAX_PHOTO_SIZE) {
                photoError = FaRecommendErrorUtils.PHOTO_SIZE_ERROR;
                errorMark = true;
            }
        }
        if (StringUtils.isBlank(keyWords) || keyWords.trim().length() < 2 || keyWords.trim().length() > 15) {
            keyWordsError = FaRecommendErrorUtils.KEY_WORDS_ERROR;
            errorMark = true;
        }
        if (StringUtils.isBlank(description) || description.trim().length() < 2 || description.trim().length() > 100) {
            descriptionError = FaRecommendErrorUtils.DESCRIPTION_ERROR;
            errorMark = true;
        }
        if (errorMark) {
            return new Result<>().error(new RecommendVoError(photoError, keyWordsError, descriptionError));
        }
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = freightAgencyRecommendVerifyService.selectByFaIdSingle(faId);
        System.setProperty("user.timezone", "Asia/Kolkata");
        // 获得系统时间
        Date date = new Date();
        // 将时间格式转换成符合Timestamp要求的格式
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        // 把时间转换
        Timestamp timestamp = Timestamp.valueOf(nowTime);
        // 根据faId查询的审核表为空
        if (freightAgencyRecommendVerify == null) {
            if (photo != null) {
                String originalFileName = photo.getOriginalFilename();
                if (originalFileName != null && originalFileName.length() > 0) {
                    String savePath = FileSet.RECOMMEND_VERIFY_PATH;
                    newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                    File newFile = new File(savePath + newFileName);
                    try {
                        photo.transferTo(newFile);
                    } catch (Exception e) {
                        photoError = ResultInfo.WRITE_PHOTO_ERROR;
                    }
                }
            } else {
                FreightAgencyRecommend freightAgencyRecommend = freightAgencyRecommendService.selectByFaIdSingle(faId);
//                 若审核通过表为空，则照片不能为空
                if (freightAgencyRecommend == null) {
                    photoError = FaRecommendErrorUtils.PHOTO_NULL_ERROR;
                } else {
//                  照片为空，则将审核通过表磁盘对应照片复制到审核表磁盘中
                    String photoName = freightAgencyRecommend.getActivityPhoto();
                    FileInputStream inputStream = new FileInputStream(FileSet.RECOMMEND_PATH + photoName);
                    FileOutputStream outputStream = new FileOutputStream(FileSet.RECOMMEND_VERIFY_PATH + photoName);
                    byte[] buffer = new byte[1024];
                    int hasRead;
//                  文件写入写出流操作
                    while ((hasRead = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, hasRead);
                    }
                    inputStream.close();
                    outputStream.close();
                    newFileName = photoName;
                }

            }
            if (photoError == null) {
                freightAgencyRecommendVerify = new FreightAgencyRecommendVerify(
                        faId,
                        freightAgency.getName(),
                        freightAgency.getCompany(),
                        freightAgency.getCompanyLink(),
                        freightAgency.getCity(),
                        keyWords.trim(),
                        freightAgency.getMainBussinessScope(),
                        description.trim(),
                        newFileName,
                        freightAgency.getPhone(),
                        freightAgency.getWeChat(),
                        freightAgency.getEmail(),
                        timestamp
                );
                try {
                    freightAgencyRecommendVerifyService.insertSelective(freightAgencyRecommendVerify);
                    return Result.success;
                } catch (Exception e) {
                    return new Result<>().fail("提交错误，请重新提交或联系管理员");
                }
            } else {
                RecommendVoError recommendVoError = new RecommendVoError(photoError, keyWordsError, descriptionError);
                return new Result<>().error(recommendVoError);
            }
        } else {
        //  根据faId查询的审核表不为空
            if (photo != null) {
                String originalFileName = photo.getOriginalFilename();
                if (originalFileName != null && originalFileName.length() > 0) {
                    String savePath = FileSet.RECOMMEND_VERIFY_PATH;
                    newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                    File newFile = new File(savePath + newFileName);
                    try {
                        photo.transferTo(newFile);
                    } catch (Exception e) {
                        photoError = ResultInfo.WRITE_PHOTO_ERROR;
                    }
                    String oldPhoto = freightAgencyRecommendVerify.getActivityPhoto();
                    if (photoError == null) {
                        File oldFile = new File(savePath + oldPhoto);
                        if (oldFile.isFile() && !oldFile.isDirectory()) {
                            oldFile.delete();
                        }
                    } else {
                        RecommendVoError recommendVoError = new RecommendVoError(photoError, keyWordsError, descriptionError);
                        return new Result<>().error(recommendVoError);
                    }
                }

            }
            freightAgencyRecommendVerify = new FreightAgencyRecommendVerify();
            freightAgencyRecommendVerify.setFaId(faId);
            if (newFileName != null) {
                freightAgencyRecommendVerify.setActivityPhoto(newFileName);
            }
            freightAgencyRecommendVerify.setKeyWords(keyWords.trim());
            freightAgencyRecommendVerify.setDescription(description.trim());
            freightAgencyRecommendVerify.setSendTime(timestamp);
            freightAgencyRecommendVerifyService.updateByFaId(freightAgencyRecommendVerify);
            return Result.success;
        }
    }
}