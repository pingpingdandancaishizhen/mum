package cn.sunfit.risk.buz.server.service.p2p.activiti.assign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNodeAssign;

/**
 * 
 * @Title: AssignRuleFactory.java
 * @Package cn.sunfit.risk.buz.server.activiti.assign
 * @Description: 指派分配的工厂
 * @author XFL
 * @date 2017年1月4日 下午2:44:51
 * @version V1.0
 */
public class AssignRuleFactory {

    private Map<String, AssignRuleCalculator> calcus = new HashMap<String, AssignRuleCalculator>();

    /**
     * 
     * @Title: calUser
     * @Description: 计算用户
     * @param @param assigns
     * @param @param bpId
     * @param @param domain
     * @param @param corpId
     * @param @return   
     * @return Set<String> 
     * @author XFL 2017年1月4日 
     * @throws
     */
    public Set<String> calUser(List<BPMetaNodeAssign> assigns, String bpId, String domain, String corpId) {
        Set<String> oldusers = new HashSet<String>();
        for (BPMetaNodeAssign assign : assigns) {
            String assignType = assign.getAssignType();
            AssignRuleCalculator calcu = calcus.get(assignType);
            oldusers = calcu.getUsers(assign, oldusers, bpId, domain, corpId);
        }
        return oldusers;
    }

    public Map<String, AssignRuleCalculator> getCalcus() {
        return calcus;
    }

    public void setCalcus(Map<String, AssignRuleCalculator> calcus) {
        this.calcus = calcus;
    }

}
