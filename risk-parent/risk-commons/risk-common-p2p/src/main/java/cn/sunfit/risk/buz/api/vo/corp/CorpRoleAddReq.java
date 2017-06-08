package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CorpRoleAddReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private List<String> menuIds;

    private List<String> funcIds;
    private String corpId;

    @NotBlank
    @Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z]{2,20}$")
    private String roleName;
    @Size(min = 0, max = 60)
    private String desc;

    @NotBlank
    private String menuStr;

    @NotBlank
    private String funcStr;

    public String getCorpId() {
        return corpId;
    }

    public String getDesc() {
        return desc;
    }

    public List<String> getFuncIds() {
        return funcIds;
    }

    public String getFuncStr() {
        return funcStr;
    }

    public String getId() {
        return id;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public String getMenuStr() {
        return menuStr;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFuncIds(List<String> funcIds) {
        this.funcIds = funcIds;
    }

    public void setFuncStr(String funcStr) {
        this.funcStr = funcStr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }

    public void setMenuStr(String menuStr) {
        this.menuStr = menuStr;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
