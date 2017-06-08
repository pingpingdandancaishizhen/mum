package com.rjs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.metadata.form.EditorInfo;
import cn.sunfit.risk.buz.api.beans.metadata.form.GroupInfo;
import cn.sunfit.risk.buz.api.beans.metadata.form.LayoutInfo;

public class GenerLayout {

    public static void main(String[] args) throws IOException {
        String catgeroy = FileUtils.readFileToString(new File(
                "C:\\Users\\RJS\\Desktop\\bp_meta_category_templates.json"));
        String field = FileUtils.readFileToString(new File("C:\\Users\\RJS\\Desktop\\bp_meta_fields_templates.json"));
        Map catgeroys = JsonUtils.parseJSON(catgeroy, Map.class);

        Map fields = JsonUtils.parseJSON(field, Map.class);
        List<Map> dd = (List<Map>) catgeroys.get("RECORDS");
        List<Map> ff = (List<Map>) fields.get("RECORDS");
        Collections.sort(ff, new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                Integer d1 = Integer.valueOf(o1.get("default_order").toString());
                Integer d2 = Integer.valueOf(o2.get("default_order").toString());
                if (d1.intValue() > d2.intValue()) {
                    return 1;
                } else if (d1.intValue() < d2.intValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        LayoutInfo layout = new LayoutInfo();
        layout.setLayout("form");
        List<GroupInfo> groups = new ArrayList<GroupInfo>();
        for (Map d : dd) {
            GroupInfo g = new GroupInfo();
            g.setKey((String) d.get("category_key"));
            g.setLabel((String) d.get("name"));
            g.setLayout("form");
            List<EditorInfo> editors = new ArrayList<EditorInfo>();
            g.setEditors(editors);
            for (Map f : ff) {
                if (f.get("category").equals(d.get("category_key"))) {
                    EditorInfo e = new EditorInfo();
                    if (f.get("data_provider") == null) {
                        e.setEditor("text");
                    } else {
                        e.setEditor("option");
                    }
                    e.setKey((String) f.get("field_key"));
                    e.setLabel((String) f.get("field_name"));
                    e.setCols(1);
                    e.setRows(1);
                    e.setDataSource((String) f.get("data_provider"));
                    e.setCategory((String) d.get("name"));
                    e.setReadonly(false);
                    e.setRequired(false);
                    editors.add(e);
                }

            }
            groups.add(g);
        }
        // layout.setGroups(groups);
        System.out.println(JsonUtils.toJSON(layout));

    }

}
