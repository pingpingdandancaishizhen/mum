/*******************************************************************************
 * @Title: ConditionInfo.java
 *
 * @Copyright (c) 2017 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.rule;

import java.io.Serializable;

/**   
 * @Title: ConditionInfo.java
 * @Description: 规则条件
 * @author zouxuejun
 * @date 2017年1月13日 下午4:29:42
 * @version V1.0   
 */
public class ConditionInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String fieldKey;

    /**
     * equal=,great than >, less than <, >=, <=
     * default value is =
     */
    private String operator = "=";

    private String value;

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
