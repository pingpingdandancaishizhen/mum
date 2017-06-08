package cn.sunfit.risk.buz.api.beans.system.partner;

import java.rmi.ServerException;
import java.util.List;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class PartnerProductRelSaveReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = -5929071290419221212L;

    /**
     * 所有选中的角色
     * 角色ID_参与方ID
     */
    private List<String> roleList;

    private String productId;

    public PartnerProductRelSaveDTO copyToDTO() throws ServerException {
        PartnerProductRelSaveDTO dto = new PartnerProductRelSaveDTO();
        dto.setDomain(getDomain());
        dto.setProductId(productId);
        if (roleList != null && roleList.size() > 0) {
            for (String id : roleList) {
                String ids[] = id.split("_");
                if (ids == null || ids.length < 2) {
                    throw new ServerException("参数错误");
                }
                dto.addRelList(ids[1], productId, ids[0]);
            }
        }

        return dto;
    }

    public String getProductId() {
        return productId;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

}
