package cn.sunfit.risk.web.controller.system;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpRole;
import cn.sunfit.risk.buz.api.service.corp.CorpRoleService;
import cn.sunfit.risk.buz.api.service.system.SystemMenuService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.RoleQueryReq;
import cn.sunfit.risk.buz.api.vo.system.SystemMenuFunc;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/role")
public class RoleController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private CorpRoleService corpRoleService;
    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 
     * @Title: addRole
     * @Description: 添加角色
     * @param @param role
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp addRole(@Valid CorpRoleAddReq role, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        role.setMenuIds(Arrays.asList(role.getMenuStr().split(",")));
        role.setFuncIds(Arrays.asList(role.getFuncStr().split(",")));
        role.setCorpId(getCurrentUser().getCorpId());
        corpRoleService.saveRole(role);
        return new Resp();
    }

    /**
     * 
     * @Title: changeStatus
     * @Description: 修改角色状态
     * @param @param roleId
     * @param @param status
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    @ResponseBody
    public Resp changeStatus(@RequestParam(required = true) String roleId, @RequestParam(required = true) String status) {
        corpRoleService.updateStatus(getCurrentUser().getCorpId(), roleId, status);
        return new Resp();
    }

    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp deleteRole(@RequestParam(required = true) String roleId) {
        corpRoleService.updateStatus(getCurrentUser().getCorpId(), roleId, "2");
        return new Resp();
    }

    /**
     * @Title: loadRoleList
     * @Description: 角色管理跳转
     * @param @return   
     * @return String 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/loadRoleManager", method = RequestMethod.GET)
    public String loadRoleManager() {
        return "/system/role/loadRoleManager";
    }

    @RequestMapping(value = "/modifyRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp modifyRole(@Valid CorpRoleAddReq role, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        if (StringUtils.isBlank(role.getId())) {
            return new Resp(DATA_VALIDATION_ERROR, "参数错误");
        }
        role.setCorpId(getCurrentUser().getCorpId());
        role.setMenuIds(Arrays.asList(role.getMenuStr().split(",")));
        role.setFuncIds(Arrays.asList(role.getFuncStr().split(",")));
        corpRoleService.saveRole(role);
        return new Resp();
    }

    /**
     * 
     * @Title: loadAddRole
     * @Description: 角色新增页面
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/queryAllFuncMenu", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryAllFuncMenu() {
        // 获取所有的菜单和功能
        List<SystemMenuFunc> lst = systemMenuService.queryAllCorpFuncMenu(getCurrentUser().getCorpId());
        return new Resp(lst);
    }

    /**
     * @Title: queryAllRole
     * @Description: 查询公司所有权限
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/queryAllRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryAllRole() {
        List<CorpRole> list = corpRoleService.queryAllRole(getCurrentUser().getCorpId());
        return new Resp(list);
    }

    /**
     * 
     * @Title: queryFuncMenuByRole
     * @Description: 查询指定角色下的菜单和功能
     * @param @param roleId
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/queryFuncMenuByRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryFuncMenuByRole(@RequestParam(required = true) String roleId) {
        List<SystemMenuFunc> list = systemMenuService.queryRoleCorpFuncMenu(getCurrentUser().getCorpId(), roleId);
        return new Resp(list);
    }

    /**
     * 
     * @Title: loadModifyRole
     * @Description: 角色修改页面
     * @param @param roleId
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/queryModifyRole", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryModifyRole(@RequestParam(required = true) String roleId) {
        CorpRole role = corpRoleService.queryRoleById(roleId);
        return new Resp(role);
    }

    /**
     * 
     * @Title: queryRoleList
     * @Description: 角色列表
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/queryRoleList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryRoleList(RoleQueryReq req) {
        req.setCorpId(getCurrentUser().getCorpId());
        RespPage<List<CorpRoleDTO>> r = corpRoleService.queryRoleList(req);
        return new Resp(r);
    }
}
