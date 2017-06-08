package cn.sunfit.risk.buz.api.vo;

import java.io.Serializable;

/**
 * 
 * @Title: DTree.java
 * @Package com.rjs.rjr.model.system
 * @Description: 树的基本类
 * @author yanlei
 * @date 2016年7月13日 下午6:08:29
 * @version V1.0
 */
public class DTree implements Serializable {

    private static final long serialVersionUID = -4333045937305578861L;

    private String id;

    private String parentId;

    private String name;

    private String isLeaf;

    private String status;

    public String getId() {
        return id;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DTree [id=" + id + ", parentId=" + parentId + ", name=" + name + ", isLeaf=" + isLeaf + ", status="
                + status + "]";
    }

}
