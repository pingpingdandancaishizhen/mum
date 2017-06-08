/*******************************************************************************
 * @Title: ChcekRuleValidator.java
 *
 * @Copyright (c) 2017 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.server.service.buz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaConsts;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleResult;
import cn.sunfit.risk.buz.api.beans.metadata.rule.ConditionInfo;
import orj.worf.util.JsonUtils;

/**   
 * @Title: ChcekRuleValidator.java
 * @Description: 检查BP
 * @author zouxuejun
 * @date 2017年1月6日 下午4:08:49
 * @version V1.0   
 */
public class CheckRuleValidatorUtils {

    /**
     * @Title: checkBPFrom
     * @Description: 检查表单数据
     * @param @param fieldList
     * @param @param bpMetaForm
     * @param @param operation
     * @param @param properties
     * @param @return   
     * @return CheckRuleResult 
     * @throws
     */
    public static CheckRuleResult checkBPFrom(List<BPMetaField> fieldList, BPMetaForm bpMetaForm,
            BPMetaOperation operation, Map<String, String> properties) {

        List<CheckRuleResult> ruleResults = new ArrayList<CheckRuleResult>();

        for (Entry<String, String> entry : properties.entrySet()) {
            String attrKey = entry.getKey();
            String attrValue = entry.getValue();

            BPMetaField fieldMeta = BPUtils.findField(attrKey, fieldList);
            if (fieldMeta != null) {
                String ruleJson = fieldMeta.getCheckRule();
                if (ruleJson != null && ruleJson.trim().length() > 0) {
                    List<CheckRuleInfo> rules = JsonUtils.parseJSON(ruleJson, List.class, CheckRuleInfo.class);
                    for (CheckRuleInfo ruleInfo : rules) {
                        ruleResults.add(checkAttr(attrValue, ruleInfo));
                    }
                }
            }
        }

        if (bpMetaForm.getCheckRuleList() != null) {
            List<CheckRuleInfo> rules = bpMetaForm.getCheckRuleList();
            for (CheckRuleInfo ruleInfo : rules) {

                boolean match = true;
                if (ruleInfo.getCondition() != null) {
                    for (ConditionInfo condition : ruleInfo.getCondition()) {
                        if (!match(properties, condition)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (!match) {
                    continue;
                }
                if (StringUtils.equals(ruleInfo.getRuleLevel(), BPMetaConsts.RuleLevel.RULE_FOR_FIELD)) {
                    String fieldKey = ruleInfo.getFieldKey();
                    if (fieldKey != null) {
                        ruleResults.add(checkAttr(properties.get(fieldKey), ruleInfo));

                    }
                } else {

                }
            }
        }
        if (operation != null && operation.getPreCondition() != null) {
            List<CheckRuleInfo> rules = JsonUtils.parseJSON(operation.getPreCondition(), List.class,
                    CheckRuleInfo.class);
            for (CheckRuleInfo ruleInfo : rules) {
                // TODO 检查前置条件未实现
            }
        }

        return CheckRuleResult.buildResult(ruleResults);
    }

    // public static boolean checkBP(Map<String, String> properties, CheckRuleInfo checkRule) {
    // if(checkRule)
    // }

    // public static void main(String... args) {
    // Map<String, String> properties = new HashMap<String, String>();
    // properties.put("test", "1");
    //
    // properties.put("test1", "2");
    // System.out.println("out put:" + match(properties, "${test}=1"));
    // }
    //
    // public static boolean match(Map<String, String> properties, String condition) {
    // ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
    // SimpleContext context = new SimpleContext();
    // for (Map.Entry<String, String> entry : properties.entrySet()) {
    // context.setVariable(entry.getKey(),
    // expressionFactory.createValueExpression(entry.getValue(), String.class));
    // }
    //
    // return (Boolean) expressionFactory.createValueExpression(context, condition, Boolean.class).getValue(context);
    //
    // // if (StringUtils.equals(condition.getOperator(), "=")) {
    // // return StringUtils.equals(left, condition.getValue());
    // // } else if (StringUtils.equals(condition.getOperator(), ">")) {
    // // double leftNum = Double.parseDouble(left);
    // // double rightNum = Double.parseDouble(condition.getValue());
    // // return leftNum > rightNum;
    // // } else if (StringUtils.equals(condition.getOperator(), ">=")) {
    // // double leftNum = Double.parseDouble(left);
    // // double rightNum = Double.parseDouble(condition.getValue());
    // // return leftNum >= rightNum;
    // // } else if (StringUtils.equals(condition.getOperator(), "<")) {
    // // double leftNum = Double.parseDouble(left);
    // // double rightNum = Double.parseDouble(condition.getValue());
    // // return leftNum < rightNum;
    // // } else if (StringUtils.equals(condition.getOperator(), "<=")) {
    // // double leftNum = Double.parseDouble(left);
    // // double rightNum = Double.parseDouble(condition.getValue());
    // // return leftNum <= rightNum;
    // // }else{
    // // throws new RuntimeException("unkonow opeator");
    // // }
    // }

    public static boolean match(Map<String, String> properties, ConditionInfo condition) {
        String left = properties.get(condition.getFieldKey());
        if (StringUtils.equals(condition.getOperator(), "=")) {
            return StringUtils.equals(left, condition.getValue());
        } else if (StringUtils.equals(condition.getOperator(), ">")) {
            double leftNum = Double.parseDouble(left);
            double rightNum = Double.parseDouble(condition.getValue());
            return leftNum > rightNum;
        } else if (StringUtils.equals(condition.getOperator(), ">=")) {
            double leftNum = Double.parseDouble(left);
            double rightNum = Double.parseDouble(condition.getValue());
            return leftNum >= rightNum;
        } else if (StringUtils.equals(condition.getOperator(), "<")) {
            double leftNum = Double.parseDouble(left);
            double rightNum = Double.parseDouble(condition.getValue());
            return leftNum < rightNum;
        } else if (StringUtils.equals(condition.getOperator(), "<=")) {
            double leftNum = Double.parseDouble(left);
            double rightNum = Double.parseDouble(condition.getValue());
            return leftNum <= rightNum;
        } else {
            throw new RuntimeException("unkonow opeator");
        }
    }

    public static CheckRuleResult checkAttr(String attrValue, CheckRuleInfo checkRule) {
        switch (checkRule.getRuleType()) {
            case BPMetaConsts.RuleType.REQUIRE: {
                boolean result = StringUtils.isNotBlank(attrValue);
                return CheckRuleResult.buildResult(result, result ? null : checkRule.getMessage());
            }
            case BPMetaConsts.RuleType.LENGTH:
                return checkLength(attrValue, checkRule);

            case BPMetaConsts.RuleType.REGEX:
                return checkRE(attrValue, checkRule);

            case BPMetaConsts.RuleType.RANGE:
                return checkRange(attrValue, checkRule);
            case BPMetaConsts.RuleType.OPTION:
                // TODO not implements
                return CheckRuleResult.buildResult(true, null);
        }

        return CheckRuleResult.buildResult(true, null);

    }

    public static CheckRuleResult checkLength(String attrValue, CheckRuleInfo checkRule) {

        if (checkRule.getDetail().containsKey("max")) {
            int maxLength = Integer.parseInt(checkRule.getDetail().get("max"));

            if (attrValue != null && attrValue.length() > maxLength) {
                return CheckRuleResult.buildResult(false, checkRule.getMessage());
            }
        }
        if (checkRule.getDetail().containsKey("min")) {
            int minLength = Integer.parseInt(checkRule.getDetail().get("min"));
            if (attrValue == null || attrValue.length() < minLength) {
                return CheckRuleResult.buildResult(false, checkRule.getMessage());
            }
        }
        return CheckRuleResult.buildResult(true, null);
    }

    public static CheckRuleResult checkRange(String attrValue, CheckRuleInfo checkRule) {

        if (checkRule.getDetail().containsKey("max")) {
            double doubleValue = Double.parseDouble(attrValue);
            double max = Double.parseDouble(checkRule.getDetail().get("max"));

            if (attrValue != null && doubleValue > max) {
                return CheckRuleResult.buildResult(false, checkRule.getMessage());
            }
        }
        if (checkRule.getDetail().containsKey("min")) {
            double doubleValue = Double.parseDouble(attrValue);
            double min = Double.parseDouble(checkRule.getDetail().get("min"));
            if (attrValue == null || doubleValue < min) {
                return CheckRuleResult.buildResult(false, checkRule.getMessage());
            }
        }
        return CheckRuleResult.buildResult(true, null);
    }

    public static CheckRuleResult checkRE(String attrValue, CheckRuleInfo checkRule) {

        String expression = checkRule.getDetail().get("regex");
        if (expression == null) {
            throw new RuntimeException("invalid check rule, has no expression");

        }
        boolean result = match(expression, attrValue);
        return CheckRuleResult.buildResult(result, result ? null : checkRule.getMessage());

    }

    /**
    * @param regex
    * 正则表达式字符串
    * @param str
    * 要匹配的字符串
    * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
    */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkBPAttr(BPAttr attr, List<CheckRuleInfo> checkRules) {
        return true;
    }
}
