package cn.sunfit.risk.buz.server.activiti.assign;

import java.util.Set;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.constants.AssignRelateType;

public abstract class AssignRuleCalculator {

    /**
     * 
     * @Title: cal
     * @Description: 根据指派类型获取到相应的user
     * @param @param assgin
     * @param @return   
     * @return List<String> 
     * @author XFL 2017年1月4日 
     * @throws
     */
    public abstract Set<String> cal(BPMetaNodeAssign assgin, String bpId, String domain, String corpId);

    /**
     * 
     * @Title: calCondition
     * @Description: 与或非的计算
     * @param @param newusers
     * @param @param oldusers
     * @param @param relateType
     * @param @return   
     * @return List<String> 
     * @author XFL 2017年1月4日 
     * @throws
     */
    public Set<String> calCondition(Set<String> newusers, Set<String> oldusers, AssignRelateType relateType) {
        switch (relateType) {
            case AND:
                oldusers.retainAll(newusers);
                break;
            case OR:
                oldusers.addAll(newusers);
                break;
            case NOT:
                oldusers.removeAll(newusers);
                break;
            default:
                break;
        }
        return oldusers;
    }

    /**
     * 
     * @Title: cal
     * @Description: 获取计算规则的USERID
     * @param @return   
     * @return List<String> 
     * @author XFL 2017年1月4日 
     * @throws
     */
    public Set<String> getUsers(BPMetaNodeAssign assgin, Set<String> oldusers, String bpId, String domain, String corpId) {
        Set<String> newusers = cal(assgin, bpId, domain, corpId);
        return calCondition(newusers, oldusers, AssignRelateType.getByStatus(assgin.getRelateType()));
    }

}
