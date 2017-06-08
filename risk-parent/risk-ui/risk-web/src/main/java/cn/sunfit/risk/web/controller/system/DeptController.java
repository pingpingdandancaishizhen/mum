package cn.sunfit.risk.web.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.constants.DeptStatusType;
import cn.sunfit.risk.buz.api.constants.ResponseStatus;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptNodeDTO;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/dept")
public class DeptController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private CorpDeptService corpDeptService;

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
    public Resp addDept(CorpDept dept) {
        dept.setCorpId(getCurrentUser().getCorpId());
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
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public Resp updateDept(CorpDept dept) {
        dept.setCorpId(getCurrentUser().getCorpId());
        corpDeptService.updateDept(dept);
        return new Resp();
    }
}
