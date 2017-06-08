package cn.sunfit.risk.buz.server.service.corp;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.CorpRole;
import cn.sunfit.risk.buz.api.constants.system.StatusType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpRoleService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.RoleQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CorpRoleDAO;

import com.google.common.base.Preconditions;

@Service("risk.corpRoleService")
public class CorpRoleServiceImpl implements CorpRoleService {

    @Autowired
    private CorpRoleDAO corpRoleDAO;

    @Override
    public List<CorpRole> queryAllRole(String corpId) {
        return corpRoleDAO.selectAllCorpRole(corpId);
    }

    @Override
    public CorpRole queryRoleById(String roleId) {
        return corpRoleDAO.selectByPrimaryKey(roleId);
    }

    @Override
    public RespPage<List<CorpRoleDTO>> queryRoleList(RoleQueryReq req) {
        List<CorpRoleDTO> list = corpRoleDAO.selectCorpRole(req, new RowBounds(req.getOffset(), req.getLimit()));
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<CorpRoleDTO>>(list, totalCount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(CorpRoleAddReq req) {
        Preconditions.checkNotNull(req);
        if (StringUtils.isBlank(req.getId())) {
            CorpRole cr = new CorpRole();
            cr.setCorpId(req.getCorpId());
            cr.setCreateTime(new Date());
            cr.setDesc(req.getDesc());
            cr.setId(IdUtil.geneId());
            cr.setIsAdmin("0");
            cr.setIsCanModify("1");
            cr.setRoleName(req.getRoleName());
            cr.setStatus("0");
            corpRoleDAO.insert(cr);
            // 插入关联
            corpRoleDAO.insertRoleFunc(cr.getId(), req.getFuncIds());
            corpRoleDAO.insertRoleMenu(cr.getId(), req.getMenuIds());
        } else {
            CorpRole cr = corpRoleDAO.selectByPrimaryKey(req.getId());
            if (StringUtils.equals(cr.getIsAdmin(), "1")) {
                throw new ServiceException("管理员权限不能修改");
            }
            if (!StringUtils.equals(cr.getCorpId(), req.getCorpId())) {
                throw new ServiceException("您没有操作该数据的权限");
            }
            cr.setDesc(req.getDesc());
            cr.setRoleName(req.getRoleName());
            corpRoleDAO.updateByPrimaryKey(cr);
            // 修改，删除之前的，插入新的关联
            corpRoleDAO.deleteRoleFunc(cr.getId());
            corpRoleDAO.deleteRoleMenu(cr.getId());
            corpRoleDAO.insertRoleFunc(cr.getId(), req.getFuncIds());
            corpRoleDAO.insertRoleMenu(cr.getId(), req.getMenuIds());
        }
    }

    @Override
    public void updateStatus(String corpId, String roleId, String status) {
        CorpRole cr = corpRoleDAO.selectByPrimaryKey(roleId);
        if (StringUtils.equals(cr.getIsAdmin(), "1")) {
            throw new ServiceException("管理员权限不能修改");
        }
        if (!StringUtils.equals(cr.getCorpId(), corpId) || !StatusType.validateStatus(status)) {
            throw new ServiceException("您没有操作该数据的权限");
        }
        if (StringUtils.equals(status, "1")) {
            // 如果停用 判断是否有用户使用此角色
            long count = corpRoleDAO.countRoleUse(roleId);
            if (count > 0) {
                throw new ServiceException("有" + count + "个用户正在使用该角色，该角色不可停用");
            }
        }
        cr.setStatus(status);
        corpRoleDAO.updateByPrimaryKey(cr);
    }

}
