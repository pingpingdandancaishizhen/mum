package cn.sunfit.risk.web.controller.flow;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunfit.risk.buz.api.beans.templates.MetaCategoryTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFieldsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFormsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaNodesTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaOperationsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaTemplates;
import cn.sunfit.risk.buz.api.service.activiti.TemplatesService;
import cn.sunfit.risk.buz.api.vo.ReqBase;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.CategoryQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FieldsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FormsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.NodeQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.OperationsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.UploadBpmnReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/flow")
public class FlowController extends BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    @Autowired
    private TemplatesService templatesService;

    @RequestMapping(value = "/flow/copy", method = RequestMethod.POST)
    @ResponseBody
    public Resp copy(String bpDefId) {
        templatesService.copy(bpDefId, getCurrentUser().getCorpId(), getCurrentUser().getDomain());
        return new Resp();
    }

    /**
     * 
     * @Title: loadFlowManager
     * @Description: 流程定义
     * @param @return   
     * @return String 
     * @author XFL 2016年12月26日 
     * @throws
     */
    @RequestMapping(value = "/flow/loadFlowManager", method = RequestMethod.GET)
    public String loadFlowManager() {
        return "/flow/flow/loadFlowManager";
    }

    /**
     * 
     * @Title: loadFlowManager
     * @Description: 流程表单
     * @param @return   
     * @return String 
     * @author XFL 2016年12月26日 
     * @throws
     */
    @RequestMapping(value = "/forms/loadFormsManager", method = RequestMethod.GET)
    public String loadFormsManager(String bpDefId, ModelMap map) {
        map.addAttribute("bpDefId", bpDefId);
        return "/flow/flow/loadFormsManager";
    }

    /**
     * 
     * @Title: loadFlowManager
     * @Description: 流程节点
     * @param @return   
     * @return String 
     * @author XFL 2016年12月26日 
     * @throws
     */
    @RequestMapping(value = "/nodes/loadNodeManager", method = RequestMethod.GET)
    public String loadNodeManager(String bpDefId, ModelMap map) {
        map.addAttribute("bpDefId", bpDefId);
        return "/flow/flow/loadNodeManager";
    }

    @RequestMapping(value = "/forms/queryMetaCategoryTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaCategoryTemplates(CategoryQueryReq req) {
        RespPage<List<MetaCategoryTemplates>> r = templatesService.queryMetaCategoryTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaCategoryTemplatesAll", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaCategoryTemplatesAll(CategoryQueryReq req) {
        List<MetaCategoryTemplates> r = templatesService.queryMetaCategoryTemplatesAll(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaFieldsTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaFieldsTemplates(FieldsQueryReq req) {
        RespPage<List<MetaFieldsTemplates>> r = templatesService.queryMetaFieldsTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaFormsTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaFormsTemplates(FormsQueryReq req) {
        RespPage<List<MetaFormsTemplates>> r = templatesService.queryMetaFormsTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaFormsTemplatesAll", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaFormsTemplatesAll(FormsQueryReq req) {
        List<MetaFormsTemplates> r = templatesService.queryMetaFormsTemplatesAll(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/nodes/queryMetaNodesTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaNodesTemplates(NodeQueryReq req) {
        RespPage<List<MetaNodesTemplates>> r = templatesService.queryMetaNodesTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaOperationsTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaOperationsTemplates(OperationsQueryReq req) {
        RespPage<List<MetaOperationsTemplates>> r = templatesService.queryMetaOperationsTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/forms/queryMetaOperationsTemplatesAll", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaOperationsTemplatesAll(OperationsQueryReq req) {
        List<MetaOperationsTemplates> r = templatesService.queryMetaOperationsTemplatesAll(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/flow/queryMetaTemplates", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryMetaTemplates(ReqBase req) {
        RespPage<List<MetaTemplates>> r = templatesService.queryMetaTemplates(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/node/relateForm", method = RequestMethod.POST)
    @ResponseBody
    public Resp relateForm(MetaNodesTemplates req) {
        templatesService.updateNodeFormKey(req);
        return new Resp();
    }

    @RequestMapping(value = "/node/relateOperation", method = RequestMethod.POST)
    @ResponseBody
    public Resp relateOperation(String nodeKey, String operationIds, String bpDefId) {
        templatesService.updateNodeOperation(Arrays.asList(operationIds.split(",")), bpDefId, nodeKey);
        return new Resp();
    }

    @RequestMapping(value = "/forms/saveFields", method = RequestMethod.POST)
    @ResponseBody
    public Resp save(MetaFieldsTemplates f) {
        templatesService.addMetaFieldsTemplates(f);
        return new Resp();
    }

    @RequestMapping(value = "/flow/save", method = RequestMethod.POST)
    @ResponseBody
    public Resp save(MultipartFile file, UploadBpmnReq req) {
        try {
            req.setUserId(getCurrentUser().getId());
            req.setBpmnxml(new String(file.getBytes(), "UTF-8"));
            templatesService.save(req);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Resp();
    }

    @RequestMapping(value = "/forms/saveCategory", method = RequestMethod.POST)
    @ResponseBody
    public Resp saveCategory(MetaCategoryTemplates t) {
        templatesService.addMetaCategoryTemplates(t);
        return new Resp();
    }

    @RequestMapping(value = "/forms/saveForms", method = RequestMethod.POST)
    @ResponseBody
    public Resp saveForms(MetaFormsTemplates f) {
        templatesService.addMetaFormsTemplates(f);
        return new Resp();
    }

    @RequestMapping(value = "/forms/saveOperations", method = RequestMethod.POST)
    @ResponseBody
    public Resp saveOperations(MetaOperationsTemplates f) {
        templatesService.addMetaOperationsTemplates(f);
        return new Resp();
    }
}
