package cn.sunfit.risk.web.controller.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.constants.UserStatusType;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserModifyReq;
import cn.sunfit.risk.buz.api.vo.corp.ResetPasswordReq;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserQuery;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserResp;
import cn.sunfit.risk.buz.api.vo.corp.UpdatePasswordReq;
import cn.sunfit.risk.buz.api.vo.corp.UpdateUserInfoReq;
import cn.sunfit.risk.buz.api.vo.corp.UserQueryReq;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.HideInfoUtils;

@Controller
@RequestMapping(value = "/system/user")
public class UserController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CorpUserService corpUserService;

    /**
     * 
     * @Title: addCorpUser
     * @Description: 后台添加用户
     * @param @param corpUserDTO
     * @param @param roleId
     * @param @return   
     * @return String 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Resp addCorpUser(@Valid CorpUserAddReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO dto = req.toCorpUserDTO();
        dto.setRoleIds(Arrays.asList(req.getRoleId().split(",")));
        dto.setDataRoleIds(Arrays.asList(req.getDataRoleId().split(",")));
        dto.setCorpId(getCurrentUser().getCorpId());
        corpUserService.addCorpUser(dto);
        return new Resp();
    }

    /**
     * 
     * @Title: changePassowrd
     * @Description: 前台用户修改密码
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/changePassowrd", method = RequestMethod.POST)
    @ResponseBody
    public Resp changePassowrd(@Valid UpdatePasswordReq req, BindingResult result) {
        final Resp response = buildValidationFaildResponse(result);
        if (response.getStatus() == DATA_VALIDATION_ERROR) {
            return response;
        }
        req.setCorpId(getCurrentUser().getCorpId());
        req.setId(getCurrentUser().getId());
        corpUserService.updatePassword(req);
        return response;
    }

    /**
     * 
     * @Title: changeStatus
     * @Description: 修改账户状态，删除账户
     * @param @param id
     * @param @param status
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    @ResponseBody
    public Resp changeStatus(@RequestParam(required = true) String id, @RequestParam(required = true) String status) {
        CorpUserDTO user = new CorpUserDTO();
        user.setId(id);
        user.setStatus(status);
        user.setCorpId(getCurrentUser().getCorpId());
        corpUserService.updateUserStatus(user);
        return new Resp();
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    @ResponseBody
    public Resp changeUser(@Valid UpdateUserInfoReq req, BindingResult result) {
        final Resp response = buildValidationFaildResponse(result);
        if (response.getStatus() == DATA_VALIDATION_ERROR) {
            return response;
        }
        req.setId(getCurrentUser().getId());
        corpUserService.updateCorpUser(req);
        return new Resp();
    }

    /**
     * 
     * @Title: checkAccountExist
     * @Description: 查询用户账户是否存在
     * @param @param account
     * @param @param id
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月9日 
     * @throws
     */
    @RequestMapping(value = "/checkAccountExist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkAccountExist(@RequestParam(required = true) String account, String id) {
        CorpUserDTO dto = new CorpUserDTO();
        dto.setCorpId(getCurrentUser().getCorpId());
        dto.setUserAccount(account);
        dto.setId(id);
        boolean check = corpUserService.checkAcountNotExist(dto);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("valid", check);
        return map;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public Resp deleteUser(@RequestParam(required = true) String id) {
        CorpUserDTO user = new CorpUserDTO();
        user.setId(id);
        user.setStatus(UserStatusType.delete.getStatus());
        user.setCorpId(getCurrentUser().getCorpId());
        corpUserService.updateUserStatus(user);
        return new Resp();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Resp getUserById() {
        CorpUserDTO user = new CorpUserDTO();
        user.setCorpId(getCurrentUser().getCorpId());
        user.setId(getCurrentUser().getId());
        CorpUserDTO r = corpUserService.queryCorpUserByIdOrCode(user);
        r.setPassword(null);
        r.setSalt(null);
        return new Resp(r);
    }

    /**
     * 
     * @Title: getUserById
     * @Description: 通过ID查询用户信息
     * @param @param userId
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    @ResponseBody
    public Resp getUserById(@RequestParam(required = true) String userId) {
        CorpUserDTO user = new CorpUserDTO();
        user.setCorpId(getCurrentUser().getCorpId());
        user.setId(userId);
        CorpUserDTO r = corpUserService.queryCorpUserByIdOrCode(user);
        r.setPassword(null);
        r.setSalt(null);
        return new Resp(r);
    }

    /**
     * 
     * @Title: loadUserMananger
     * @Description: 加载用户管理初始页
     * @param @return   
     * @return String 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/loadUserManager", method = RequestMethod.GET)
    public String loadUserMananger() {
        return "/system/user/loadUserManager";
    }

    /**
     * 
     * @Title: modifyCorpUser
     * @Description: 后台修改用户
     * @param @param corpUserDTO
     * @param @param roleId
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    @ResponseBody
    public Resp modifyCorpUser(@Valid CorpUserModifyReq req, BindingResult result) {
        final Resp response = buildValidationFaildResponse(result);
        if (response.getStatus() == DATA_VALIDATION_ERROR) {
            return response;
        }
        CorpUserDTO corpUserDTO = req.toCorpUserDTO();
        corpUserDTO.setRoleIds(Arrays.asList(req.getRoleId().split(",")));
        corpUserDTO.setDataRoleIds(Arrays.asList(req.getDataRoleId().split(",")));
        corpUserDTO.setCorpId(getCurrentUser().getCorpId());
        corpUserService.updateCorpUser(corpUserDTO);
        return new Resp();
    }

    /**
     * 
     * @Title: queryUserList
     * @Description: 查询用户列表
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author RJS 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryUserList(UserQueryReq req, BindingResult result) {
        // final Resp response = buildValidationFaildResponse(result);
        // if (response.getStatus() != Resp.STATUS_SUCCESS) {
        // return response;
        // }
        Resp response = new Resp();
        req.setCorpId(getCurrentUser().getCorpId());
        RespPage<List<CorpUserDTO>> r = corpUserService.queryUserList(req);
        for (CorpUserDTO user : r.getData()) {
            user.setTelephone(HideInfoUtils.hidePhoneNo(user.getTelephone()));
            user.setIdcard(HideInfoUtils.hideIdentificationCard(user.getIdcard()));
        }
        response.setData(r);
        return response;
    }

    /**
     * 
     * @Title: resetPassword
     * @Description: 后台重置密码
     * @param @param password
     * @param @param id
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Resp resetPassword(@Valid ResetPasswordReq req, BindingResult result) {
        final Resp response = buildValidationFaildResponse(result);
        if (response.getStatus() == DATA_VALIDATION_ERROR) {
            return response;
        }
        UpdatePasswordReq re = new UpdatePasswordReq();
        re.setCorpId(getCurrentUser().getCorpId());
        re.setPassword(req.getPassword());
        re.setId(req.getId());
        corpUserService.updatePassword(re);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/sameDeptBPList", method = RequestMethod.POST)
    public Resp sameDeptBPList(@Valid SameDeptUserQuery req, BindingResult result) {
        final Resp response = buildValidationFaildResponse(result);
        if (response.getStatus() == DATA_VALIDATION_ERROR) {
            return response;
        }
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCorpId(user.getCorpId());
        List<SameDeptUserResp> info = corpUserService.querySameDeptUser(req);
        return new Resp(info);
    }
}
