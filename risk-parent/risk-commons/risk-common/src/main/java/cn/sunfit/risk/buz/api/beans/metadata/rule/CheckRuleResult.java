/*******************************************************************************
 * @Title: CheckRuleResult.java
 *
 * @Copyright (c) 2017 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.rule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: CheckRuleResult.java
 * @Description: 检查规则结果
 * @author zouxuejun
 * @date 2017年1月16日 上午10:35:10
 * @version V1.0   
 */
public class CheckRuleResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean passed;

    private String[] messages;

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public static CheckRuleResult buildResult(boolean passed, String... messages) {
        CheckRuleResult result = new CheckRuleResult();
        result.passed = passed;
        result.messages = messages;
        return result;
    }

    public static CheckRuleResult buildResult(List<CheckRuleResult> results) {
        CheckRuleResult result = new CheckRuleResult();
        boolean passedResult = true;
        List<String> msgList = new ArrayList<String>();

        for (CheckRuleResult re : results) {
            if (!re.isPassed()) {
                passedResult = false;
                for (String msg : re.getMessages()) {
                    msgList.add(msg);
                }
            }
        }

        result.passed = passedResult;
        if (!passedResult) {
            result.messages = msgList.toArray(new String[msgList.size()]);
        }
        return result;
    }
}
