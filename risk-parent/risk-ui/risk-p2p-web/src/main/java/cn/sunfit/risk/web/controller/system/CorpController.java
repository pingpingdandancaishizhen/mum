package cn.sunfit.risk.web.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpUpdateReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpVO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.OSSUtil;
import cn.sunfit.risk.web.utils.UrlUtil;

@Controller
@RequestMapping(value = "/system/corp")
public class CorpController extends BaseController {
    @Autowired
    private CorpService corpService;
    @Autowired
    private OSSUtil OSSUtil;

    /**
     * @Title: loadCorpManager
     * @Description:  跳转企业资料页面
     * @param @param request
     * @param @return   
     * @return String 
     * @author XFL 2017年2月15日 
     * @throws
     */
    @RequestMapping(value = "/loadCorpManager", method = RequestMethod.GET)
    public String loadCorpManager(ModelMap model) {
        CorpVO vo = corpService.queryCorpInfo(getCurrentUser().getCorpId());
        model.put("vo", vo);
        return "/system/corp/loadCorpManager";
    }

    /**
     * 
     * @Title: updateCorp
     * @Description: 修改客户信息
     * @param @param request
     * @param @param model
     * @param @return   
     * @return Resp 
     * @author XFL 2017年2月15日 
     * @throws
     */
    @RequestMapping(value = "/updateCorp", method = RequestMethod.POST)
    @ResponseBody
    public Resp updateCorp(@Valid CorpUpdateReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setId(getCurrentUser().getCorpId());
        corpService.updateCorpInfo(req);
        return r;
    }

    @RequestMapping(value = "/uploadCorpLogo", method = RequestMethod.POST)
    @ResponseBody
    public Resp uploadCorpLogo(@RequestParam(required = true) MultipartFile file) {
        Long size = file.getSize();
        if (size > 5 * 1024 * 1024) {
            return Resp.buildErrorResponse("上传文件大小超过1M，请重新上传！", "");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String suffix = file.getOriginalFilename().toString()
                .substring(file.getOriginalFilename().toString().lastIndexOf("."));
        String key = UrlUtil.getLOGOUrl("webuploader", dateFormat.format(new Date()), suffix);
        System.out.println("key---->" + key);
        try {
            OSSUtil.uploadFile(key, file.getBytes());
        } catch (Exception e) {
            logger.error("file getBytes exception," + e.getMessage());
            throw new ServiceException("上传异常");
        }
        String coverUrl = OSSUtil.buildUrl(key);
        return new Resp(coverUrl);
    }
}
