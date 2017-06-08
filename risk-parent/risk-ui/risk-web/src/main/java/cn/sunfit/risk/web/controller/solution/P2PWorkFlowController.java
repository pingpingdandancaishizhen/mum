package cn.sunfit.risk.web.controller.solution;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.service.p2p.activiti.SolutionService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormRelateReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignAddReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignDeleteReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaReq;
import cn.sunfit.risk.web.controller.BaseController;


/**
 * 
 * @Title: WorkFlowController.java
 * @Package cn.sunfit.risk.web.controller.solution
 * @Description: p2p审批公司的流程管理
 * @author kevinhan
 * @date 2016年12月29日 下午5:23:13
 * @version V1.0
 */
@Controller
@RequestMapping("/solution/p2pworkflow")
public class P2PWorkFlowController extends BaseController {
    @Autowired
    private SolutionService solutionService;
    @Autowired
    private P2PProductService productService;

    /**
     * 
     * @Title: addNodeAssign
     * @Description: 添加节点的指派规则
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2017年1月3日 
     * @throws
     */
    @RequestMapping(value = "/addNodeAssign", method = RequestMethod.POST)
    @ResponseBody
    public Resp addNodeAssign(@Valid BpMetaNodeAssignAddReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        req.setUserId(getCurrentUser().getId());
        solutionService.nodeAssign(req);
        return new Resp();
    }

    @RequestMapping(value = "/deleteNodeAssign", method = RequestMethod.POST)
    @ResponseBody
    public Resp deleteNodeAssign(@Valid BpMetaNodeAssignDeleteReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        solutionService.nodeAssignDelete(req);
        return new Resp();
    }

    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
    @ResponseBody
    public Resp deploy(@Valid BpMetaReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        solutionService.deploy(req);
        return r;
    }

    /**
     * 
     * @Title: getFormByBpDefId
     * @Description: 根据流程定义查询流程下所有表单
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/getFormByBpDefId", method = RequestMethod.POST)
    @ResponseBody
    public Resp getFormByBpDefId(BpMetaFormDefQuery req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        List<BpMetaFormDefVO> rs = solutionService.queryBpMetaFormByDefId(req);
        return new Resp(rs);
    }

    /**
     * @Title: loadAssignManager
     * @Description: 加载流程节点分配指派的页面
     * @param @param bpDefId
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/loadAssignManager", method = RequestMethod.GET)
    public String loadAssignManager(@RequestParam(required = true) String bpDefId, ModelMap map) {
        map.put("bpDefId", bpDefId);
        return "/solution/workflow/loadAssignManager";
    }

    /**
     * @Title: loadNodeFormManager
     * @Description: 加载流程节点表单对应页面
     * @param @param bpDefId
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/loadNodeFormManager", method = RequestMethod.GET)
    public String loadNodeFormManager(@RequestParam(required = true) String bpDefId, ModelMap map) {
        map.put("bpDefId", bpDefId);
        return "/solution/workflow/loadNodeFormManager";
    }

    /**
     * 
     * @Title: loadWorkFlowManager
     * @Description: 加载管理公司流程列表页
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/loadWorkFlowManager", method = RequestMethod.GET)
    public String loadWorkFlowManager(ModelMap map) {
        return "/solution/workflow/p2pLoadWorkFlowManager";
    }

    /**
     @RequestMapping(value = "/queryNodeAssignList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryNodeAssignList(BpMetaFormRelateReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        solutionService.nodeRelateForm(req);
        return new Resp();
    }* 
     * @Title: relateForm
     * @Description: 关联表单
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/queryNodeAssignList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryNodeAssignList(@Valid BpMetaNodeAssignQueryReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        RespPage<List<BPMetaNodeAssign>> rs = solutionService.queryNodeAssignList(req);
        return new Resp(rs);
    }

    /**
     * @Title: queryNodeList4Assain
     * @Description: 查询能审核分配的表单节点
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/queryNodeList4Assain", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryNodeList4Assain(@Valid BpMetaNodeQueryReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        RespPage<List<BpMetaNodeVO>> re = solutionService.queryNodeListTask(req);
        r.setData(re);
        return r;
    }

    /**
     * 
     * @Title: queryNodeList4Form
     * @Description: 查询能分配表单的节点
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/queryNodeList4Form", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryNodeList4Form(@Valid BpMetaNodeQueryReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        RespPage<List<BpMetaNodeVO>> re = solutionService.queryNodeListTaskAndStart(req);
        r.setData(re);
        return r;
    }

    /**
     * @Title: queryWorkFlowList
     * @Description: 查询公司流程列表
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月29日 
     * @throws
     */
    @RequestMapping(value = "/queryWorkFlowList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryWorkFlowList(BpMetaQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<BpMetaCorpProductVO>> r = solutionService.queryBPMetaCorpProduct(req);
        return new Resp(r);
    }

    /**
     * 
     * @Title: relateForm
     * @Description: 关联表单
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月30日 
     * @throws
     */
    @RequestMapping(value = "/relateForm", method = RequestMethod.POST)
    @ResponseBody
    public Resp relateForm(@Valid BpMetaFormRelateReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        solutionService.nodeRelateForm(req);
        return new Resp();
    }

}
