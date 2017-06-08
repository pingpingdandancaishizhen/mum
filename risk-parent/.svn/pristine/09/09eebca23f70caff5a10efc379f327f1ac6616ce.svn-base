package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.beans.metadata.rule.ConditionInfo;
import cn.sunfit.risk.buz.api.constants.CheckRuleType;

public class CheckRuleTool {

    public static void generDecimalRule(String fieldKey, String digits, String min, String max) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.DECIMAL.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(String.format("仅支持%s-%s的数字", min, max));
        Map<String, String> detail = new HashMap<String, String>();
        detail.put("digits", digits);
        detail.put("min", min);
        detail.put("max", max);
        cri.setDetail(detail);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generEmailRule(String fieldKey) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.EMAIL.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage("请输入正确的邮箱地址");
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generEmptyRule(String fieldKey, String conditionKey, String conditionValue) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.NOT_EMPTY.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage("必填");
        ConditionInfo ci = new ConditionInfo();
        ci.setFieldKey(conditionKey);
        ci.setValue(conditionValue);
        List<ConditionInfo> cList = new ArrayList<ConditionInfo>();
        cList.add(ci);
        cri.setCondition(cList);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generFileRule(String fieldKey, String extension) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.FILE.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(String.format("只能上传后缀为%s的文件", extension));
        Map<String, String> detail = new HashMap<String, String>();
        detail.put("extension", extension);
        cri.setDetail(detail);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generIdNumberRule(String fieldKey) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.IDNUMBER.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage("请输入正确的身份证号");
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generLengthRule(String fieldKey, String length) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.LENGTH.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(String.format("长度不能超过%s", length));
        Map<String, String> detail = new HashMap<String, String>();
        detail.put("length", length);
        cri.setDetail(detail);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generNumberRule(String fieldKey, String min, String max) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.NUMBER.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(String.format("仅支持%s-%s的数字", min, max));
        Map<String, String> detail = new HashMap<String, String>();
        detail.put("min", min);
        detail.put("max", max);
        cri.setDetail(detail);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generPhoneRule(String fieldKey) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.PHONE.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage("请输入正确的手机号");
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generRegexpRule(String fieldKey, String regexp, String message) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.REGEXP.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(message);
        Map<String, String> detail = new HashMap<String, String>();
        detail.put("regexp", regexp);
        cri.setDetail(detail);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void generTelephoneRule(String fieldKey, String message) {
        CheckRuleInfo cri = new CheckRuleInfo();
        cri.setRuleType(CheckRuleType.TELEPHONE.getStatus());
        cri.setFieldKey(fieldKey);
        cri.setMessage(message);
        System.out.println(JsonUtils.toJSON(cri));
    }

    public static void main(String[] args) {
        // generDecimalRule("loan_apply_amount", "2", "0", "9999999999999");
        // generLengthRule("loancheckinfo_person", "40");
        // generFileRule("custearn_security_fund", "jpg");
        // generTelephoneRule("cust_phone", "请输入正确的电话");
        // generRegexpRule("cust_wechat", "^[a-zA-Z][a-zA-Z0-9_]*$", "请输入正确的微信账号");
        // generPhoneRule("cust_mobile");
        // generIdNumberRule("cust_license_num");
        // generEmailRule("cust_email");
        // generNumberRule("cust_qq", "0", "15");
        generEmptyRule("", "", "");
    }
}
