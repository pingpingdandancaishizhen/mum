package cn.sunfit.risk.buz.api.vo.corp;

import cn.sunfit.risk.buz.api.beans.corp.CorpDataRole;

public class CorpDataRoleDTO extends CorpDataRole {

    private static final long serialVersionUID = 1L;

    private String depts;

    public String getDepts() {
        return depts;
    }

    public void setDepts(String depts) {
        this.depts = depts;
    }

}
