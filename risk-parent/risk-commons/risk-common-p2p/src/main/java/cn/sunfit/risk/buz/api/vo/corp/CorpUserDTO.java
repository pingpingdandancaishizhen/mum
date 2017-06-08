package cn.sunfit.risk.buz.api.vo.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.constants.RiskSystem;

public class CorpUserDTO extends CorpUser {

    private static final long serialVersionUID = 1L;

    private List<String> roleIds;

    private List<String> dataRoleIds;

    private boolean isAdmin;

    private String corpName;

    private String corpSimpleName;

    private String deptName;
    private String domain;

    private String deptCode;
    private String roleNames;

    private RiskSystem system;

    private List<RiskSystem> systems;

    public String getCorpName() {
        return corpName;
    }

    public String getCorpSimpleName() {
        return corpSimpleName;
    }

    public List<String> getDataRoleIds() {
        return dataRoleIds;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDomain() {
        return domain;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public RiskSystem getSystem() {
        return system;
    }

    public List<RiskSystem> getSystems() {
        return systems;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setCorpSimpleName(String corpSimpleName) {
        this.corpSimpleName = corpSimpleName;
    }

    public void setDataRoleIds(List<String> dataRoleIds) {
        this.dataRoleIds = dataRoleIds;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public void setSystem(RiskSystem system) {
        this.system = system;
    }

    public void setSystems(List<RiskSystem> systems) {
        this.systems = systems;
    }

}
