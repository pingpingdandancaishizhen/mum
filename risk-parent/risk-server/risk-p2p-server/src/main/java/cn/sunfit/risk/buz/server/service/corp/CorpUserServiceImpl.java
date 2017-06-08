package cn.sunfit.risk.buz.server.service.corp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.beans.corp.UserCode;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.RiskSystem;
import cn.sunfit.risk.buz.api.constants.system.DeptStatusType;
import cn.sunfit.risk.buz.api.constants.system.UserCodeType;
import cn.sunfit.risk.buz.api.constants.system.UserStatusType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserQuery;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserResp;
import cn.sunfit.risk.buz.api.vo.corp.UpdatePasswordReq;
import cn.sunfit.risk.buz.api.vo.corp.UpdateUserInfoReq;
import cn.sunfit.risk.buz.api.vo.corp.UserQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDeptDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.corp.UserCodeDAO;
import cn.sunfit.risk.buz.server.util.Digests;
import cn.sunfit.risk.buz.server.util.Encodes;

@Service("risk.corpUserService")
public class CorpUserServiceImpl implements CorpUserService {

    protected static final Logger logger = LoggerFactory.getLogger(CorpUserServiceImpl.class);
    @Autowired
    private UserCodeDAO userCodeDAO;
    @Autowired
    private CorpUserDAO corpUserDAO;
    @Autowired
    private CorpDeptDAO corpDeptDAO;
    @Autowired
    private CorpDAO corpDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCorpUser(CorpUserDTO corpUserDTO) {
        corpUserDTO.setStatus(UserStatusType.Active.getStatus());
        updateNewPassword(corpUserDTO, corpUserDTO.getPassword());
        corpUserDTO.setCreateTime(new Date());
        corpUserDTO.setId(IdUtil.geneId());
        // if ("0".equals(corpUserDTO.getUserLevel()))
        // corpUserService.changeGroupMan(corpUserDTO);
        corpUserDAO.insert(corpUserDTO);
        // 插入角色
        corpUserDAO.insertCorpUserRole(corpUserDTO);
        corpUserDAO.insertCorpUserDataRole(corpUserDTO);
    }

    @Override
    public boolean checkAcountNotExist(CorpUserDTO dto) {
        long count = corpUserDAO.countUserByAccount(dto);
        return count == 0;
    }

    @Override
    public boolean checkUserSmsCode(String userId, String smsCode, UserCodeType type) {

        long count = userCodeDAO.selectSmsCode(new UserCode(userId, smsCode, type.getStatus()));
        return count != 0;
    }

    /**
     * <p>Description:根据id查找用户 </p>
     * @param corpId
     * @param userId
     * @return
     * @see cn.sunfit.risk.buz.api.service.corp.CorpUserService#queryById(java.lang.String, java.lang.String)
     */
    @Override
    public CorpUserDTO queryById(String corpId, String userId) {
        CorpUserDTO dto = new CorpUserDTO();
        dto.setCorpId(corpId);
        dto.setId(userId);
        return this.queryCorpUserByIdOrCode(dto);
    }

    @Override
    public CorpUserDTO queryCorpUserByIdOrCode(CorpUserDTO corpUserDTO) throws ServiceException {
        try {
            CorpUserDTO dto = corpUserDAO.selectCorpUserByIdOrCode(corpUserDTO);
            // 查询角色
            List<String> roles = corpUserDAO.selectCorpUserRoleIds(corpUserDTO);
            dto.setRoleIds(roles);
            List<String> dataRoles = corpUserDAO.selectCorpUserDataRoleIds(corpUserDTO);
            dto.setDataRoleIds(dataRoles);
            Corp corp = corpDAO.selectByPrimaryKey(dto.getCorpId());
            String systems = corp.getSystems();
            if (StringUtils.isBlank(systems)) {
                throw new ServiceException("公司没有系统使用权限");
            }
            String[] syss = systems.split(",");
            dto.setSystems(new ArrayList<RiskSystem>());
            for (String s : syss) {
                dto.getSystems().add(RiskSystem.getSystemByCode(s));
            }
            dto.setSystem(dto.getSystems().get(0));
            return dto;
        } catch (final ServiceException e) {
            throw e;
        } catch (final Exception e) {
            logger.error("queryCorpUserByIdOrCode:" + e);
            throw new ServiceException("用户名或密码错误");
        }
    }

    @Override
    public List<SameDeptUserResp> querySameDeptUser(SameDeptUserQuery req) {
        List<SameDeptUserResp> list = corpUserDAO.selectUserByBpId(req);
        return list;
    }

    @Override
    public RespPage<List<CorpUserDTO>> queryUserList(UserQueryReq req) {
        List<CorpUserDTO> list = corpUserDAO.selectUserList(req, new RowBounds(req.getOffset(), req.getLimit()));
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<CorpUserDTO>>(list, totalCount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCorpUser(CorpUserDTO corpUserDTO) {
        corpUserDTO.setPassword(null);
        // 更新普通信息
        CorpUser old = corpUserDAO.selectByPrimaryKey(corpUserDTO.getId());
        if (!StringUtils.equalsIgnoreCase(old.getCorpId(), corpUserDTO.getCorpId())) {
            throw new ServiceException("无权修改此数据");
        }
        // 赋值
        old.setDeptId(corpUserDTO.getDeptId());
        old.setDesc(corpUserDTO.getDesc());
        old.setEmail(corpUserDTO.getEmail());
        old.setIdcard(corpUserDTO.getIdcard());
        old.setJob(corpUserDTO.getJob());
        old.setLastModTime(new Date());
        old.setTelephone(corpUserDTO.getTelephone());
        old.setUserAccount(corpUserDTO.getUserAccount());
        old.setUserName(corpUserDTO.getUserName());
        corpUserDAO.updateByPrimaryKey(old);
        // 修改完毕后修改权限
        corpUserDAO.deleteUserRole(corpUserDTO);
        corpUserDAO.deleteUserDataRole(corpUserDTO);
        // 插入新的权限
        corpUserDAO.insertCorpUserRole(corpUserDTO);
        corpUserDAO.insertCorpUserDataRole(corpUserDTO);
    }

    @Override
    public void updateCorpUser(UpdateUserInfoReq req) {
        CorpUser old = corpUserDAO.selectByPrimaryKey(req.getId());
        old.setDesc(req.getDesc());
        old.setEmail(req.getEmail());
        old.setIdcard(req.getIdcard());
        old.setJob(req.getJob());
        old.setLastModTime(new Date());
        old.setTelephone(req.getTelephone());
        old.setUserName(req.getUserName());
        corpUserDAO.updateByPrimaryKey(old);
    }

    private void updateNewPassword(CorpUser user, String password) {
        byte[] salt = Digests.generateSalt(32);
        final byte[] hashPassword = Digests.sha1(new String(password).getBytes(), salt,
                GlobalConstants.HASH_INTERATIONS);
        final String newPassword = Encodes.encodeHex(hashPassword).toUpperCase();
        String sSalt = Encodes.encodeHex(salt);
        user.setSalt(sSalt);
        user.setPassword(newPassword);
    }

    @Override
    public void updatePassword(UpdatePasswordReq req) {
        CorpUser old = corpUserDAO.selectByPrimaryKey(req.getId());
        if (!StringUtils.equalsIgnoreCase(old.getCorpId(), old.getCorpId())) {
            throw new ServiceException("无权修改此数据");
        }
        if (StringUtils.isBlank(req.getOldpassword())) {
            // 后台重置
            updateNewPassword(old, req.getPassword());
            corpUserDAO.updateByPrimaryKey(old);
        } else {
            // 判断老密码是否正确
            byte[] salt = Encodes.decodeHex(old.getSalt());
            byte[] hashPassword = Digests.sha1(req.getOldpassword().getBytes(), salt, GlobalConstants.HASH_INTERATIONS);
            String password = Encodes.encodeHex(hashPassword).toUpperCase();
            if (StringUtils.equals(password, old.getPassword())) {
                updateNewPassword(old, req.getPassword());
                corpUserDAO.updateByPrimaryKey(old);
            } else {
                throw new ServiceException("旧密码错误");
            }
        }

    }

    @Override
    public void updateUserStatus(CorpUserDTO corpUserDTO) {
        CorpUser old = corpUserDAO.selectByPrimaryKey(corpUserDTO.getId());
        if (!StringUtils.equalsIgnoreCase(old.getCorpId(), corpUserDTO.getCorpId())) {
            throw new ServiceException("无权修改此数据");
        }
        if (!UserStatusType.validateStatus(corpUserDTO.getStatus())) {
            throw new ServiceException("无权修改此数据");
        }
        CorpUser user = corpUserDAO.selectByPrimaryKey(corpUserDTO.getId());
        CorpDept dept = corpDeptDAO.selectByPrimaryKey(user.getDeptId());
        if (!StringUtils.equalsIgnoreCase(dept.getStatus(), DeptStatusType.Active.getStatus())) {
            throw new ServiceException("所属部门已停用,无权修改");
        }
        old.setStatus(corpUserDTO.getStatus());
        corpUserDAO.updateByPrimaryKey(old);
    }

	@Override
	public List<CorpUserDTO> queryUserListByDeptId(String deptId) {
		return corpUserDAO.selectUserListByDeptId(deptId);		
	}
}
