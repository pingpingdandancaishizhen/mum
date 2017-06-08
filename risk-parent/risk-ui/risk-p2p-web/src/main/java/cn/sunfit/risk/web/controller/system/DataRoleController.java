package cn.sunfit.risk.web.controller.system;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDataRole;
import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.service.corp.CorpDataRoleService;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.DataRoleQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/dataRole")
public class DataRoleController extends BaseController {

    @Autowired
    CorpDataRoleService corpDataRoleService;

    @Autowired
    CorpDeptService corpDeptService;

    /**
     * @Title: loadDataRoleManager
     * @Description: 数据角色管理跳转
     * @param @return   
     * @return String 
     * @author XJ 2017年1月4日 
     * @throws
     */
    @RequestMapping(value = "/loadDataRoleManager", method = RequestMethod.GET)
    public String loadDataRoleManager() {
        return "/system/dataRole/loadDataRoleManager";
    }

    /**
     * @Title: queryDataRoleList
     * @Description: 查询公司所有数据权限
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月4日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryDataRoleList", method = RequestMethod.POST)
    public Resp queryDataRoleList(DataRoleQueryReq req) {
        req.setCorpId(getCurrentUser().getCorpId());
        RespPage<List<CorpDataRoleDTO>> list = corpDataRoleService.queryDataRoleList(req);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/addDataRole", method = RequestMethod.POST)
    public Resp addDataRole(@Valid CorpDataRoleAddReq role, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        role.setDeptIds(Arrays.asList(role.getDeptStr().split(",")));
        role.setCorpId(getCurrentUser().getCorpId());
        corpDataRoleService.saveDataRole(role);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/modifyDataRole", method = RequestMethod.POST)
    public Resp modifyDataRole(@Valid CorpDataRoleAddReq role, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        if (StringUtils.isBlank(role.getId())) {
            return new Resp(DATA_VALIDATION_ERROR, "参数错误");
        }
        role.setDeptIds(Arrays.asList(role.getDeptStr().split(",")));
        role.setCorpId(getCurrentUser().getCorpId());
        corpDataRoleService.saveDataRole(role);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/queryModifyDataRole", method = RequestMethod.POST)
    public Resp queryModifyDataRole(String roleId) {
        CorpDataRole role = corpDataRoleService.queryDataRoleById(roleId);
        return new Resp(role);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDeptByDataRole", method = RequestMethod.POST)
    public Resp queryDeptByDataRole(String roleId) {
        List<CorpDept> list = corpDeptService.queryDeptByDataRole(getCurrentUser().getCorpId(), roleId);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public Resp changeStatus(@RequestParam(required = true) String roleId, @RequestParam(required = true) String status) {
        corpDataRoleService.updateStatus(getCurrentUser().getCorpId(), roleId, status);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public Resp deleteRole(@RequestParam(required = true) String roleId) {
        corpDataRoleService.updateStatus(getCurrentUser().getCorpId(), roleId, "2");
        return new Resp();
    }

    /**
     * 
     * @Title: queryAllDataRole
     * @Description: TODO
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月14日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllDataRole", method = RequestMethod.POST)
    public Resp queryAllDataRole() {
        List<CorpDataRoleDTO> list = corpDataRoleService.queryAllDataRole(getCurrentUser().getCorpId());
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/getPermissionByBpId", method = RequestMethod.GET)
    public Resp getPermissionByBpId(String bpId, String corpId) {
        List<String> list = corpDataRoleService.getPermissionByBpId(bpId, corpId);
        return new Resp(list);
    }

}
