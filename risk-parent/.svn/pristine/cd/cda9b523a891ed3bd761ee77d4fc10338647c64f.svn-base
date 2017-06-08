package cn.sunfit.risk.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeDeptRel;
import cn.sunfit.risk.buz.api.constants.DeptStatusType;
import cn.sunfit.risk.buz.api.constants.ResponseStatus;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.solution.SolutionService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptModifyReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptNodeDTO;
import cn.sunfit.risk.buz.api.vo.solution.BPMetaProductNodeVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/dept")
public class DeptController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private CorpDeptService corpDeptService;

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private ProductService productService;

    /**
     * 
     * @Title: addDept
     * @Description: 添加部门
     * @param @param dept
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public Resp addDept(CorpDeptAddReq dept) {
        dept.setDomain(getCurrentUser().getDomain());
        dept.setCorpId(getCurrentUser().getCorpId());
        dept.setUserId(getCurrentUser().getId());
        corpDeptService.addDept(dept);
        return new Resp();
    }

    /**
     * 
     * @Title: changeDeptStatus
     * @Description: 修改部门状态
     * @param @param id ,status
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/changeDeptStatus", method = RequestMethod.POST)
    public Resp disableDept(String id, String status) {
        if (!DeptStatusType.validateStatus(status)) {
            return Resp.buildErrorResponse(ResponseStatus.FAILED);
        }
        DeptStatusType type = DeptStatusType.getDeptStatusByStatus(status);
        corpDeptService.changeDeptStatus(id, type);
        return new Resp();
    }

    /**
     * 
     * @Title: loadDeptManager
     * @Description: 加载组织机构管理初始页
     * @param @return   
     * @return String 
     * @author XJ 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/loadDeptManager", method = RequestMethod.GET)
    public String loadDeptManager() {
        return "/system/dept/loadDeptManager";
    }

    @ResponseBody
    @RequestMapping(value = "/loadNodeSelect", method = RequestMethod.GET)
    public Resp loadNodeSelect() {
        List<BPMetaProductNodeVO> result = new ArrayList<BPMetaProductNodeVO>();
        BpMetaQueryReq mq = new BpMetaQueryReq();
        mq.setDomain(getCurrentUser().getDomain());
        List<BpMetaCorpProductVO> list = solutionService.queryAllBPMetaCorpProduct(mq);
        for (BpMetaCorpProductVO product : list) {
            BPMetaProductNodeVO pn = new BPMetaProductNodeVO();
            pn = pn.convert(product);
            BpMetaNodeQueryReq nq = new BpMetaNodeQueryReq();
            nq.setDomain(getCurrentUser().getDomain());
            nq.setBpDefId(product.getBpDefId());
            pn.setBpMetaNodes(solutionService.queryAllNodeListTask(nq));
            result.add(pn);
        }
        return new Resp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllAddableParentDept", method = RequestMethod.POST)
    public Resp queryAllAddableParentDept(Integer level) {
        List<CorpDept> list = corpDeptService.selectAddableCorpDept(getCurrentUser().getCorpId(), level);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllAvailableDept", method = RequestMethod.GET)
    public Resp queryAllAvailableDept() {
        CorpDeptNodeDTO tree = corpDeptService.queryAllAvailableDept(getCurrentUser().getCorpId());
        return new Resp(tree);
    }

    /**
     * 
     * @Title: queryAllDept
     * @Description: 查询所有部门
     * @param @param dept
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllDept", method = RequestMethod.GET)
    public Resp queryAllDept() {
        CorpDeptNodeDTO tree = corpDeptService.queryAllDept(getCurrentUser().getCorpId());
        return new Resp(tree);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCorpDeptList", method = RequestMethod.GET)
    public Resp queryCorpDeptList() {
        List<CorpDept> list = corpDeptService.queryCorpDeptList(getCurrentUser().getCorpId());
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDeptMetaNode", method = RequestMethod.GET)
    public Resp queryDeptMetaNode(String deptId) {
        List<BPMetaNodeDeptRel> list = corpDeptService.queryDeptMeteNodes(getCurrentUser().getDomain(), deptId);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public Resp updateDept(CorpDeptModifyReq dept) {
        dept.setCorpId(getCurrentUser().getCorpId());
        dept.setDomain(getCurrentUser().getDomain());
        dept.setCorpId(getCurrentUser().getCorpId());
        dept.setUserId(getCurrentUser().getId());
        corpDeptService.updateDept(dept);
        return new Resp();
    }

}
