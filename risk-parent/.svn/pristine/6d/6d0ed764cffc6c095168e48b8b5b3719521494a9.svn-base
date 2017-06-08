package cn.sunfit.risk.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunfit.risk.buz.api.service.OSSService;
import cn.sunfit.risk.web.utils.ImgCompressUtil;
import cn.sunfit.risk.web.utils.UrlUtil;

/**
 * 百度富文本编辑器图片上传
 * @author RJS
 *
 */
@Controller
public class UmeditorFileUpController {

    protected static final Logger logger = LoggerFactory.getLogger(UmeditorFileUpController.class);

    @Autowired
    private OSSService ossService;

    @ResponseBody
    @RequestMapping(value = "umeditor-dev/umeditorFileUp")
    public String umeditorFileUp(HttpServletRequest request, @RequestParam("upfile") MultipartFile upfile) {

        Long size = upfile.getSize();

        String result = "";
        String coverUrl = "";
        String fname = "";
        String oname = "";

        if (size > 5 * 1024 * 1024) {

            result = "{\"name\":\"" + fname + "\", \"originalName\": \"" + oname + "\", \"size\": " + upfile.getSize()
                    + ", \"state\": \"上传图片大小超过5M，请重新上传！\", \"type\": \"" + upfile.getContentType() + "\", \"url\": \""
                    + coverUrl + "\"}";
            return result;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String suffix = upfile.getOriginalFilename().toString()
                .substring(upfile.getOriginalFilename().toString().lastIndexOf("."));
        String key = UrlUtil.getUrl("umeditor", dateFormat.format(new Date()), suffix);

        try {
            String src = request.getSession().getServletContext().getRealPath("/")
                    + upfile.getOriginalFilename().toString();
            byte[] fileByte = ImgCompressUtil.getFileFromMultipartFile(upfile, src, 0, 0, 0.8f);
            if (null == fileByte)
                fileByte = upfile.getBytes();
            ossService.uploadFile(key, fileByte);
        } catch (IOException e) {
            logger.error("file getBytes exception," + e.getMessage());
            throw new RuntimeException("file getBytes exception," + e.getMessage());
        }
        coverUrl = ossService.buildUrl(key);
        fname = upfile.getName();
        oname = upfile.getOriginalFilename();
        result = "{\"name\":\"" + fname + "\", \"originalName\": \"" + oname + "\", \"size\": " + upfile.getSize()
                + ", \"state\": \"SUCCESS\", \"type\": \"" + upfile.getContentType() + "\", \"url\": \"" + coverUrl
                + "\"}";
        return result;
    }
}
