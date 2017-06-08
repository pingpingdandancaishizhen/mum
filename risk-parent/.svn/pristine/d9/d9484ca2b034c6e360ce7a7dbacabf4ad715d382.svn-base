package cn.sunfit.risk.buz.server.service.corp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.beans.corp.CorpDataRole;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptContractVO;
import cn.sunfit.risk.buz.api.constants.StatusType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpDataRoleService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.DataRoleQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDataRoleDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDeptDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;

import com.google.common.base.Preconditions;

@Service("risk.corpDataRoleService")
public class CorpDataRoleServiceImpl implements CorpDataRoleService {

    @Autowired
    CorpDataRoleDAO corpDataRoleDAO;

    @Autowired
    private CorpUserDAO corpUserDAO;
    @Autowired
    private CorpDAO corpDAO;
    @Autowired
    private CorpDeptDAO corpDeptDAO;

    @Override
    public List<String> getPermissionByBpId(String bpId, String corpId) {
        List<String> result = new ArrayList<String>();
        // 获得公司信息
        Corp c = corpDAO.selectByPrimaryKey(corpId);
        // 获得流程信息
        CorpDeptContractVO vo = corpDeptDAO.getDeptNameByBp(bpId, c.getDomain());
        // 创建者部门Id
        result = corpDataRoleDAO.selectBpPermission(vo.getDeptId());
        return result;
    }

    @Override
    public List<CorpDataRoleDTO> queryAllDataRole(String corpId) {
        return corpDataRoleDAO.selectAllDataRole(corpId);
    }

    @Override
    public CorpDataRole queryDataRoleById(String roleId) {
        return corpDataRoleDAO.selectByPrimaryKey(roleId);
    }

    @Override
    public RespPage<List<CorpDataRoleDTO>> queryDataRoleList(DataRoleQueryReq req) {
        List<CorpDataRoleDTO> list = corpDataRoleDAO.selectCorpDataRole(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<CorpDataRoleDTO>>(list, totalCount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDataRole(CorpDataRoleAddReq req) {
        Preconditions.checkNotNull(req);
        if (StringUtils.isBlank(req.getId())) {
            CorpDataRole cr = new CorpDataRole();
            cr.setId(IdUtil.geneId());
            cr.setCorpId(req.getCorpId());
            cr.setCreateTime(new Date());
            cr.setDesc(req.getDesc());
            cr.setRoleName(req.getRoleName());
            cr.setStatus("0");
            cr.setSelfOnly(req.getSelfOnly());
            cr.setDeptOnly(req.getDeptOnly());
            corpDataRoleDAO.insert(cr);
            // 插入关联
            corpDataRoleDAO.insertDataRoleDept(cr.getId(), req.getDeptIds());
        } else {
            CorpDataRole cr = corpDataRoleDAO.selectByPrimaryKey(req.getId());
            if (!StringUtils.equals(cr.getCorpId(), req.getCorpId())) {
                throw new ServiceException("您没有操作该数据的权限");
            }
            cr.setDesc(req.getDesc());
            cr.setRoleName(req.getRoleName());
            cr.setSelfOnly(req.getSelfOnly());
            cr.setDeptOnly(req.getDeptOnly());
            corpDataRoleDAO.updateByPrimaryKey(cr);
            // 修改，删除之前的，插入新的关联
            corpDataRoleDAO.deleteDataRoleDept(cr.getId());
            corpDataRoleDAO.insertDataRoleDept(cr.getId(), req.getDeptIds());
        }
    }

    @Override
    public void updateStatus(String corpId, String roleId, String status) {
        CorpDataRole cr = corpDataRoleDAO.selectByPrimaryKey(roleId);
        if (!StringUtils.equals(cr.getCorpId(), corpId) || !StatusType.validateStatus(status)) {
            throw new ServiceException("您没有操作该数据的权限");
        }
        if (StringUtils.equals(status, "1")) {
            // 如果停用 判断是否有用户使用此角色
            long count = corpDataRoleDAO.countDataRoleUse(roleId);
            if (count > 0) {
                throw new ServiceException("有" + count + "个用户正在使用该角色，该角色不可停用");
            }
        }
        cr.setStatus(status);
        corpDataRoleDAO.updateByPrimaryKey(cr);
    }
}
