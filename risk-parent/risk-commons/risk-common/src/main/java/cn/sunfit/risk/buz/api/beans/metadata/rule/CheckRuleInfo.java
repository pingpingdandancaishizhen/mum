/*******************************************************************************
 * @Title: CheckRuleInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.rule;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**   
 * @Title: CheckRuleInfo.java
 * @Description: 检查规则
 * @author zouxuejun
 * @date 2016年12月28日 下午2:00:05
 * @version V1.0   
 */
public class CheckRuleInfo implements Serializable {

    private static final long serialVersionUID = 5825832374891329783L;

    /**
     * 参考 BPMetaConsts.RuleType 
     */
    private String ruleType;

    /**
     * 级别 字段Field,  流程BP
     */
    private String ruleLevel = "field";

    private String message;

    private String fieldKey;

    private String fieldName;

    private String parent;

    private List<ConditionInfo> condition;

    private Map<String, String> detail;

    public List<ConditionInfo> getCondition() {
        return condition;
    }

    public Map<String, String> getDetail() {
        return detail;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    public String getParent() {
        return parent;
    }

    public String getRuleLevel() {
        return ruleLevel;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setCondition(List<ConditionInfo> condition) {
        this.condition = condition;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setRuleLevel(String ruleLevel) {
        this.ruleLevel = ruleLevel;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }
}
