package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeUserRel;
import cn.sunfit.risk.buz.api.constants.UserCodeType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserQuery;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserResp;
import cn.sunfit.risk.buz.api.vo.corp.UpdatePasswordReq;
import cn.sunfit.risk.buz.api.vo.corp.UpdateUserInfoReq;
import cn.sunfit.risk.buz.api.vo.corp.UserQueryReq;

public interface CorpUserService {

    void addCorpUser(CorpUserDTO corpUserDTO);

    /**
     * 
     * @Title: checkAcountNotExist
     * @Description: 查询账户名是否存在
     * @param @param dto
     * @param @return   
     * @return boolean 
     * @author XFL 2016年12月9日 
     * @throws
     */
    boolean checkAcountNotExist(CorpUserDTO dto);

    /**
     * 
     * @Title: checkUserSmsCode
     * @Description: 查询登录短信校验码是否正确
     * @param @param userId
     * @param @param smsCode
     * @param @param type
     * @param @return   
     * @return boolean 
     * @author XFL 2016年12月7日 
     * @throws
     */
    boolean checkUserSmsCode(String userId, String smsCode, UserCodeType type);

    CorpUserDTO queryById(String corpId, String userId);

    /**
     * @Title: queryCorpUserByIdOrCode
     * @Description: 查询用户
     * @param @param corpUserDTO
     * @param @return   
     * @return CorpUserDTO 
     * @author XFL 2016年12月7日 
     * @throws
     */
    CorpUserDTO queryCorpUserByIdOrCode(CorpUserDTO corpUserDTO) throws ServiceException;

    /**
     * 查询借款单业务员的同级业务员
     * @Title: querySameDeptUser
     * @Description: TODO
     * @param @param req
     * @param @return   
     * @return List<SameDeptUserResp> 
     * @author XFL 2017年2月7日 
     * @throws
     */
    List<SameDeptUserResp> querySameDeptUser(SameDeptUserQuery req);

    RespPage<List<CorpUserDTO>> queryUserList(UserQueryReq req);

    /**
     * @Title: queryUserListByDeptId
     * @Description: 通过分公司ID搜索下面的业务员
     * @param @param deptId
     * @param @return   
     * @return List<CorpUserDTO>
     * @author zhaoziyu 2017年5月5日 
     * @throws
     */
    List<CorpUserDTO> queryUserListByDeptId(String deptId);

    List<BPMetaNodeUserRel> queryUserMeteNodes(String domain, String userId);

    void updateCorpUser(CorpUserDTO corpUserDTO);

    void updateCorpUser(UpdateUserInfoReq req);

    void updatePassword(UpdatePasswordReq req);

    void updateUserStatus(CorpUserDTO user);
}
