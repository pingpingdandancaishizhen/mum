package cn.sunfit.risk.web.controller.api.jfjd;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFResources;
import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFResourcesService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.OSSUtil;
import cn.sunfit.risk.web.utils.UrlUtil;

/**
 * OSS文件上传接口
 * @Title: FileUploadController.java
 * @Package cn.sunfit.risk.web.controller
 * @Description: TODO
 * @author XJ
 * @date 2017年1月12日 下午5:39:52
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd")
public class JFResourcesController extends BaseController {

    protected class FileUploadResult implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private String originalName;
        private Long size;
        private String type;
        private String url;
        private String resourceId;

        public String getName() {
            return name;
        }

        public String getOriginalName() {
            return originalName;
        }

        public String getResourceId() {
            return resourceId;
        }

        public Long getSize() {
            return size;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    protected static final Logger logger = LoggerFactory.getLogger(JFResourcesController.class);

    @Autowired
    private OSSUtil OSSUtil;

    @Autowired
    private JFResourcesService jFResourcesService;

    @Autowired
    private JFCorpService jFCorpService;

    @ResponseBody
    @RequestMapping(value = "/deleteResources", method = RequestMethod.POST)
    public Resp deleteResourcesById(String resourceId) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        jFResourcesService.deleteResource(resourceId, user.getDomain());
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Resp fileUpload(@RequestParam(required = true) MultipartFile file, String bpId, String category,
            String corpId) {
        if (StringUtils.isBlank(corpId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        String domain = jFCorpService.getDomainByCorpId(corpId);
        if (StringUtils.isBlank(domain)) {
            return Resp.buildErrorResponse("获取公司信息失败");
        }
        FileUploadResult result = new FileUploadResult();
        Long size = file.getSize();
        if (size > 100 * 1024 * 1024) {
            result.setName("");
            result.setOriginalName("");
            result.setSize(size);
            result.setType(file.getContentType());
            result.setUrl("");
            result.setResourceId("");
            return Resp.buildErrorResponse("上传文件大小超过100M，请重新上传！", result);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String suffix = file.getOriginalFilename().toString()
                .substring(file.getOriginalFilename().toString().lastIndexOf("."));
        String key = UrlUtil.getUrl("webuploader", dateFormat.format(new Date()), suffix);
        System.out.println("key---->" + key);
        try {
            OSSUtil.uploadFile(key, file.getBytes());
        } catch (Exception e) {
            logger.error("file getBytes exception," + e.getMessage());
            throw new ServiceException("上传异常");
        }
        String coverUrl = OSSUtil.buildUrl(key);

        Resources resource = new Resources();
        String resourceId = IdUtil.geneId();
        resource.setCorpId(corpId);
        resource.setFileName(file.getOriginalFilename());
        resource.setFileType(file.getContentType());
        resource.setUrl(coverUrl);
        resource.setUploadUserId("");
        resource.setBpId(bpId);
        resource.setCategory(category);
        resource.setResourceId(resourceId);
        resource.setUpdateTime(new Date());
        jFResourcesService.insertResource(resource, domain);

        result.setName(file.getOriginalFilename());
        result.setOriginalName(file.getOriginalFilename());
        result.setSize(file.getSize());
        result.setUrl(coverUrl);
        result.setResourceId(resourceId);
        return new Resp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getResourceById", method = RequestMethod.GET)
    public void getResourceById(String resourceId, String corpId, HttpServletResponse response, String height,
            HttpServletRequest request) throws IOException {
        if (StringUtils.isBlank(corpId)) {
            throw new ServiceException("参数错误");
        }
        String domain = jFCorpService.getDomainByCorpId(corpId);
        if (StringUtils.isBlank(domain)) {
            throw new ServiceException("获取公司信息失败");
        }
        JFResources result = jFResourcesService.queryResourcesById(corpId, resourceId, domain);
        if (result == null) {
            throw new ServiceException("获取资源失败");
        }
        OutputStream out = response.getOutputStream();
        try {
            String userAgent = request.getHeader("User-Agent");
            String fileName;
            // 针对IE或者以IE为内核的浏览器：
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = java.net.URLEncoder.encode(result.getFileName(), "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(result.getFileName().getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setContentType(result.getFileType());
            response.addHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName));
            String key = GlobalConstants.OSS_URL_HEADER + result.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
            if (StringUtils.isNotBlank(height)) {
                out.write(OSSUtil.downloadFileWithQuality(key, height));
            } else {
                out.write(OSSUtil.downloadFile(key));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUrlByResourceId", method = RequestMethod.GET)
    public Resp getUrlByResourceId(HttpServletRequest request, String corpId, String resourceId) {
        if (StringUtils.isBlank(corpId) || StringUtils.isBlank(resourceId)) {
            throw new ServiceException("参数错误");
        }
        String hostAddr = request.getRequestURL().substring(0,
                request.getRequestURL().indexOf(request.getServletPath()));
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("url", hostAddr + "/jfjd/getResourceById?resourceId=" + resourceId + "&corpId=" + corpId);
        return new Resp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getResources", method = RequestMethod.GET)
    public Resp queryResourcesById(String resourceIds) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<JFResources> result = jFResourcesService.queryResourcesByIds(user.getCorpId(),
                Arrays.asList(resourceIds.split(",")), user.getDomain());
        return new Resp(result);
    }

}
