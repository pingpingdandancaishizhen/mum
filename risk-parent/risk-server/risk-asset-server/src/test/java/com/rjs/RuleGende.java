package com.rjs;

import java.util.Map;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.constants.CheckRuleType;

import com.google.common.collect.Maps;

public class RuleGende {
    public static void main(String[] args) {
        SYSREGEXP("loanrebank_account_no", "^\\d{16}|\\d{19}$", "请输入正确银行卡号");
    }

    public static void SYSDECIMAL(String fieldKey, String min, String max, String digits) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage(String.format("请输入在%s到%s之间的%s位小数", min, max, digits));
        a.setRuleType(CheckRuleType.DECIMAL.getStatus());
        Map<String, String> d = Maps.newHashMap();
        d.put("min", min);
        d.put("max", max);
        d.put("digits", digits);
        a.setDetail(d);
        System.out.println(JsonUtils.toJSON(a));
    }

    // type 为 image/jpeg video/mp4
    public static void SYSFILE(String fieldKey, String number, String extension, String maxSize, String type) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage(String.format("请上传%s格式的文件", extension, maxSize));
        a.setRuleType(CheckRuleType.FILE.getStatus());
        Map<String, String> d = Maps.newHashMap();
        d.put("number", number);
        d.put("extension", extension);
        d.put("maxSize", maxSize);
        d.put("type", type);
        a.setDetail(d);
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSIDNUMBER(String fieldKey) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage("请输入正确身份证号码");
        a.setRuleType(CheckRuleType.IDNUMBER.getStatus());
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSLENGTH(String fieldKey, String min, String max) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage(String.format("请输入%s到%s位字符", min, max));
        a.setRuleType(CheckRuleType.LENGTH.getStatus());
        Map<String, String> d = Maps.newHashMap();
        d.put("min", min);
        d.put("max", max);
        a.setDetail(d);
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSNUMBER(String fieldKey, String min, String max) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage(String.format("请输入在%s到%s之间的整数", min, max));
        a.setRuleType(CheckRuleType.NUMBER.getStatus());
        Map<String, String> d = Maps.newHashMap();
        d.put("min", min);
        d.put("max", max);
        a.setDetail(d);
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSPHONE(String fieldKey) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage("请输入正确手机号码");
        a.setRuleType(CheckRuleType.PHONE.getStatus());
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSREGEXP(String fieldKey, String regex, String message) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage(message);
        a.setRuleType(CheckRuleType.REGEXP.getStatus());
        Map<String, String> d = Maps.newHashMap();
        d.put("regexp", regex);
        a.setDetail(d);
        System.out.println(JsonUtils.toJSON(a));
    }

    public static void SYSTELEPHONE(String fieldKey) {
        CheckRuleInfo a = new CheckRuleInfo();
        a.setFieldKey(fieldKey);
        a.setMessage("请输入正确电话号码");
        a.setRuleType(CheckRuleType.TELEPHONE.getStatus());
        System.out.println(JsonUtils.toJSON(a));
    }
}
