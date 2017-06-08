/*******************************************************************************
 * @Title: BPAllDTO.java
 *
 * @Copyright (c) 2017 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.web.bean;

import java.io.Serializable;
import java.util.List;

import cn.sunfit.risk.buz.api.beans.buz.BPDTO;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaDTO;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;

/**   
 * @Title: BPNodeDTO.java
 * @Description: 包含BP数据和BP定义元数据
 * @author zouxuejun
 * @date 2017年1月3日 下午4:22:17
 * @version V1.0   
 */
public class BPNodeDTO implements Serializable {

    private static final long serialVersionUID = 1143890860768782151L;

    private BPDTO bpDTO;

    private BPMetaDTO bpMetaDTO;

    private BPMetaForm currentForm;

    private BPMetaNode currentNode;

    private List<BPMetaOperation> operations;

    public BPNodeDTO(BPDTO bp, BPMetaDTO bpMeta, BPMetaNode currentNode, BPMetaForm currentForm) {
        this.bpDTO = bp;
        this.bpMetaDTO = bpMeta;
        this.currentForm = currentForm;
        this.currentNode = currentNode;
    }

    public BPDTO getBpDTO() {
        return bpDTO;
    }

    public void setBpDTO(BPDTO bpDTO) {
        this.bpDTO = bpDTO;
    }

    public BPMetaDTO getBpMetaDTO() {
        return bpMetaDTO;
    }

    public void setBpMetaDTO(BPMetaDTO bpMetaDTO) {
        this.bpMetaDTO = bpMetaDTO;
    }

    public BPMetaForm getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(BPMetaForm currentForm) {
        this.currentForm = currentForm;
    }

    public BPMetaNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(BPMetaNode currentNode) {
        this.currentNode = currentNode;
    }

    public List<BPMetaOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<BPMetaOperation> operations) {
        this.operations = operations;
    }

}
