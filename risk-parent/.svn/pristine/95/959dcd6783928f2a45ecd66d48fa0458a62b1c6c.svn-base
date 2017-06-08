package cn.sunfit.risk.buz.server.activiti.assign.calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeAssign;
import cn.sunfit.risk.buz.server.activiti.assign.AssignRuleCalculator;
import cn.sunfit.risk.buz.server.dao.corp.CorpRoleDAO;

/**
 * 
 * @Title: UserRoleCalculator.java
 * @Package cn.sunfit.risk.buz.server.activiti.assign.calculator
 * @Description: 功能角色用户计算规则
 * @author XFL
 * @date 2017年1月4日 下午6:07:03
 * @version V1.0
 */
@Service("userRoleCalculator")
public class UserRoleCalculator extends AssignRuleCalculator {

    @Autowired
    private CorpRoleDAO corpRoleDAO;

    @Override
    public Set<String> cal(BPMetaNodeAssign assgin, String bpId, String domain, String corpId) {
        // 根据配置的ID，查询有该角色的所有用户
        List<String> list = corpRoleDAO.selectHasRole(assgin.getRelateId());
        return new HashSet<String>(list);
    }

}
