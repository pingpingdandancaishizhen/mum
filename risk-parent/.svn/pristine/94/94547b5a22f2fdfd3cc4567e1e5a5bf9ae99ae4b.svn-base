package cn.sunfit.risk.credit.api.vo.cjd;

import java.io.Serializable;

import orj.worf.util.StringUtils;

public class ReportDataQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String oid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public boolean validate() {
        return StringUtils.isNotEmpty(this.oid);
    }

}
