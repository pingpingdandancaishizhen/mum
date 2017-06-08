package com.rjs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;

public class GenerFieldRule {
    public static void main(String[] args) throws IOException {
        String field = FileUtils.readFileToString(new File("C:\\Users\\RJS\\Desktop\\bp_meta_fields_templates.json"));
        Map fields = JsonUtils.parseJSON(field, Map.class);
        List<Map> ff = (List<Map>) fields.get("RECORDS");
        Map<String, List<CheckRuleInfo>> map = new LinkedHashMap<String, List<CheckRuleInfo>>();
        for (Map f : ff) {
            map.put((String) f.get("field_key"), new ArrayList<CheckRuleInfo>());
        }
        System.out.println(JsonUtils.toJSON(map));
        FileUtils.deleteQuietly(new File("C:\\Users\\RJS\\Desktop\\bp_meta_fields_templates.json"));
    }
}
