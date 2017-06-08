package cn.sunfit.risk.credit.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String policy_uuid; // 策略uuid
    private String policy_decision; // 策略结果
    private String policy_mode; // 策略模式
    private String policy_name; // 策略名称
    private int policy_score; // 策略分数
    private String risk_type; // 风险类型

    private List<HitRule> hit_rules = new ArrayList<HitRule>(); // 命中规则列表

    public List<HitRule> getHit_rules() {
        return hit_rules;
    }

    public String getPolicy_decision() {
        return policy_decision;
    }

    public String getPolicy_mode() {
        return policy_mode;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public int getPolicy_score() {
        return policy_score;
    }

    public String getPolicy_uuid() {
        return policy_uuid;
    }

    public String getRisk_type() {
        return risk_type;
    }

    public void setHit_rules(List<HitRule> hit_rules) {
        this.hit_rules = hit_rules;
    }

    public void setPolicy_decision(String policy_decision) {
        this.policy_decision = policy_decision;
    }

    public void setPolicy_mode(String policy_mode) {
        this.policy_mode = policy_mode;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public void setPolicy_score(int policy_score) {
        this.policy_score = policy_score;
    }

    public void setPolicy_uuid(String policy_uuid) {
        this.policy_uuid = policy_uuid;
    }

    public void setRisk_type(String risk_type) {
        this.risk_type = risk_type;
    }

    @Override
    public String toString() {
        return "Policy [policy_uuid=" + policy_uuid + ", policy_decision=" + policy_decision + ", policy_mode="
                + policy_mode + ", policy_name=" + policy_name + ", policy_score=" + policy_score + ", risk_type="
                + risk_type + ", hit_rules=" + hit_rules + "]";
    }

}
