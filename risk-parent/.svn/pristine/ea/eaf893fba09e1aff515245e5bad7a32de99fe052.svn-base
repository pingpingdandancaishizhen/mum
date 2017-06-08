package cn.sunfit.risk.buz.server.service.corp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptListVO;
import cn.sunfit.risk.buz.api.constants.system.DeptStatusType;
import cn.sunfit.risk.buz.api.constants.system.UserStatusType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptNodeDTO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDeptDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;

@Service("risk.corpDeptService")
public class CorpDeptServiceImpl implements CorpDeptService {

    @Autowired
    CorpDeptDAO corpDeptDAO;

    @Autowired
    CorpUserDAO corpUserDAO;

    @Override
    public void addDept(CorpDept dept) {
        dept.setId(IdUtil.geneId());
        dept.setCreateTime(new Date());
        if (dept.getLevel() == 1) {
            dept.setParentCode("1");
        }
        dept.setStatus(DeptStatusType.Active.getStatus());
        dept.setDeptCode(createDeptCode(dept.getCorpId(), dept.getLevel()));

        checkParentCode(dept);
        corpDeptDAO.insert(dept);

    }

    @Override
    public void changeDeptStatus(String id, DeptStatusType type) {
        switch (type) {
            case Active:
                this.enableDept(id, type);
                break;
            case Suspended:
                this.disableDept(id, type);
                break;
            case delete:
                this.deleteDept(id, type);
                break;
        }
    }

    /**
     * 检查部门下是否存在活动部门或活动用户
     * @Title: checkIfEditable
     * @Description: TODO
     * @param @param deptId
     * @param @param type   
     * @return void 
     * @author RJS 2016年12月22日 
     * @throws
     */
    private void checkIfEditable(String deptId, DeptStatusType type) {
        CorpDept curDept = corpDeptDAO.selectByPrimaryKey(deptId);
        CorpDept queryNode = new CorpDept();
        queryNode.setCorpId(curDept.getCorpId());
        queryNode.setParentCode(curDept.getDeptCode());
        List<CorpDept> childDeptList = null;
        int userCount = 0;

        if (type == DeptStatusType.Suspended) {
            childDeptList = corpDeptDAO.selectCorpDept(queryNode, new String[] { DeptStatusType.Active.getStatus() });
            if (childDeptList != null && childDeptList.size() > 0) {
                throw new ServiceException("该部门下存在启用部门,无法" + type.getLabel());
            }
            userCount = corpUserDAO.countUserByDeptIdAndStatus(deptId,
                    new String[] { UserStatusType.Active.getStatus() });
            if (userCount > 0) {
                throw new ServiceException("该部门下存在活动用户,无法" + type.getLabel());
            }
        }

        if (type == DeptStatusType.delete) {
            childDeptList = corpDeptDAO.selectCorpDept(queryNode, new String[] { DeptStatusType.Active.getStatus(),
                    DeptStatusType.Suspended.getStatus() });
            if (childDeptList != null && childDeptList.size() > 0) {
                throw new ServiceException("该部门下存在未删除部门,无法" + type.getLabel());
            }
            userCount = corpUserDAO.countUserByDeptIdAndStatus(deptId, new String[] {
                    UserStatusType.Active.getStatus(), UserStatusType.Suspended.getStatus() });
            if (userCount > 0) {
                throw new ServiceException("该部门下存在未删除用户,无法" + type.getLabel());
            }
        }

    }

    /**
     * 检查部门的
     * @Title: checkParentCode
     * @Description: TODO
     * @param @param dept
     * @param @param type   
     * @return void 
     * @author RJS 2016年12月22日 
     * @throws
     */
    private void checkParentCode(CorpDept dept) {
        CorpDept queryNode = new CorpDept();
        queryNode.setCorpId(dept.getCorpId());
        queryNode.setDeptCode(dept.getParentCode());
        List<CorpDept> childDeptList = corpDeptDAO.selectCorpDept(queryNode,
                new String[] { DeptStatusType.Active.getStatus(), DeptStatusType.Suspended.getStatus() });
        if (childDeptList != null && childDeptList.size() == 1) {
            // 如果父级部门存在
            if (childDeptList.get(0).getLevel() >= dept.getLevel()) {
                // 如果当前修改级别大于父级部门级别
                throw new ServiceException("父级部门选择错误");
            }
            // CorpDept oldDept = corpDeptDAO.selectByPrimaryKey(dept.getId());
            List<CorpDeptNodeDTO> subDeptList = corpDeptDAO.selectCorpDeptSub(dept.getCorpId(), dept.getDeptCode());
            for (CorpDeptNodeDTO corpDept : subDeptList) {
                if (corpDept.getLevel() <= dept.getLevel()) {
                    throw new ServiceException("存在下级部门级别小于等于当前编辑级别");
                }
            }
        } else {
            // 如果父级部门不存在
            throw new ServiceException("父级部门选择错误");
        }
    }

    private String createDeptCode(String corpId, Integer level) {
        if (level == 1) {
            // 如果是一级节点 编码为公司
            return "0001";
        } else {
            int deptCount = corpDeptDAO.selectDeptCountByCorpId(corpId);
            return StringUtils.leftPad((deptCount + 1) + "", 4, "0");
        }
    }

    public void deleteDept(String id, DeptStatusType type) {
        checkIfEditable(id, type);
        corpDeptDAO.updateStatusById(id, DeptStatusType.delete.getStatus());
    }

    public void disableDept(String id, DeptStatusType type) {
        checkIfEditable(id, type);
        corpDeptDAO.updateStatusById(id, DeptStatusType.Suspended.getStatus());
    }

    public void enableDept(String id, DeptStatusType type) {
        corpDeptDAO.updateStatusById(id, DeptStatusType.Active.getStatus());
    }

    private void getAllDeptIdLvUp(List<String> corpIds, String parentCode) {
        List<CorpDept> deptList = corpDeptDAO.getDeptsByParent(parentCode);
        if (deptList != null && deptList.size() > 0) {
            for (CorpDept cd : deptList) {
                corpIds.add(cd.getId());
                getAllDeptIdLvUp(corpIds, cd.getDeptCode());
            }
        }
    }

    @Override
    public List<String> getAllDeptIds(String deptId) {
        List<String> result = new ArrayList<String>();
        CorpDept cd = corpDeptDAO.selectByPrimaryKey(deptId);
        if (cd != null) {
            result.add(cd.getId());
            getAllDeptIdLvUp(result, cd.getDeptCode());
        }
        return result;
    }

    @Override
    public CorpDeptNodeDTO queryAllAvailableDept(String corpId) {
        return recursiveAvailableTree(corpId, "0001");
    }

    @Override
    public CorpDeptNodeDTO queryAllDept(String corpId) {
        return recursiveTree(corpId, "0001");
    }

    @Override
    public List<CorpDept> queryByDeptType(String corpId, String type) {
        List<CorpDept> list = corpDeptDAO.selectByDeptType(corpId, type);
        return list;
    }

    @Override
    public List<CorpDeptListVO> queryCoopDetps(String corpId) {
        return corpDeptDAO.queryCoopDetps(corpId);
    }

    @Override
    public List<CorpDept> queryCorpDeptList(String corpId) {
        return corpDeptDAO.queryCorpDeptList(corpId);
    }

    @Override
    public List<CorpDept> queryDeptByDataRole(String corpId, String roleId) {
        return corpDeptDAO.queryDeptByDataRole(corpId, roleId);
    }

    private CorpDeptNodeDTO recursiveAvailableTree(String corpId, String deptCode) {
        CorpDeptNodeDTO rootNode = corpDeptDAO.selectAvailableCorpDeptRoot(corpId, deptCode);
        List<CorpDeptNodeDTO> childTreeNodes = corpDeptDAO.selectAvailableCorpDeptSub(corpId, deptCode);
        // 遍历子节点
        for (CorpDeptNodeDTO child : childTreeNodes) {
            CorpDeptNodeDTO sub = recursiveAvailableTree(corpId, child.getDeptCode()); // 递归
            rootNode.getNodes().add(sub);
        }
        return rootNode;
    }

    private CorpDeptNodeDTO recursiveTree(String corpId, String deptCode) {
        CorpDeptNodeDTO rootNode = corpDeptDAO.selectCorpDeptRoot(corpId, deptCode);
        List<CorpDeptNodeDTO> childTreeNodes = corpDeptDAO.selectCorpDeptSub(corpId, deptCode);
        // 遍历子节点
        for (CorpDeptNodeDTO child : childTreeNodes) {
            CorpDeptNodeDTO sub = recursiveTree(corpId, child.getDeptCode()); // 递归
            rootNode.getNodes().add(sub);
        }
        return rootNode;
    }

    @Override
    public List<CorpDept> selectAddableCorpDept(String corpId, Integer level) {
        CorpDept queryNode = new CorpDept();
        queryNode.setCorpId(corpId);
        queryNode.setLevel(level);
        return corpDeptDAO.selectAddableCorpDept(queryNode, new String[] { DeptStatusType.Active.getStatus() });
    }

    @Override
    public List<CorpDept> selectAvailableCorpDept(String corpId) {
        return corpDeptDAO.selectAvailableCorpDept(corpId);
    }

    @Override
    public void updateDept(CorpDept dept) {
        CorpDept oldDept = corpDeptDAO.selectByPrimaryKey(dept.getId());
        if (oldDept.getLevel() == 1) {
            if (dept.getLevel() != 1) {
                throw new ServiceException("一级部门无法修改级别！");
            } else {
                dept.setParentCode("1");
            }
        } else {
            checkParentCode(dept);
        }
        corpDeptDAO.updateByPrimaryKey(dept);
    }

	@Override
	public List<CorpDept> selectAvailableCorpDeptByType(String corpId, Integer deptType) {		
		return corpDeptDAO.selectAvailableCorpDeptByType(corpId, deptType);
	}
}
