package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CorpDataRoleAddReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private List<String> deptIds;

    private String corpId;

    @NotBlank
    @Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z]{2,20}$")
    private String roleName;

    @Size(min = 0, max = 60)
    private String desc;

    private String deptStr;

    private String selfOnly;

    private String deptOnly;

    public String getCorpId() {
        return corpId;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public String getDeptOnly() {
        return deptOnly;
    }

    public String getDeptStr() {
        return deptStr;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getSelfOnly() {
        return selfOnly;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    public void setDeptOnly(String deptOnly) {
        this.deptOnly = deptOnly;
    }

    public void setDeptStr(String deptStr) {
        this.deptStr = deptStr;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setSelfOnly(String selfOnly) {
        this.selfOnly = selfOnly;
    }

}
