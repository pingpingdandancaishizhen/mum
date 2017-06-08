package cn.sunfit.risk.buz.server.activiti.assign.calculator;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeAssign;
import cn.sunfit.risk.buz.server.activiti.assign.AssignRuleCalculator;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;

/**
 * 
 * @Title: StartUserCalculator.java
 * @Package cn.sunfit.risk.buz.server.activiti.assign.calculator
 * @Description: 发起人分配规则
 * @author XFL
 * @date 2017年1月4日 下午6:08:44
 * @version V1.0
 */
@Service("startUserCalculator")
public class StartUserCalculator extends AssignRuleCalculator {

    @Autowired
    private BPDAO bpDao;

    @Override
    public Set<String> cal(BPMetaNodeAssign assgin, String bpId, String domain, String corpId) {
        // 查询单号的发起人
        BP bp = bpDao.findById(corpId, domain, bpId);
        Set<String> s = new HashSet<String>();
        s.add(bp.getCreateUserId());
        return s;
    }

}
