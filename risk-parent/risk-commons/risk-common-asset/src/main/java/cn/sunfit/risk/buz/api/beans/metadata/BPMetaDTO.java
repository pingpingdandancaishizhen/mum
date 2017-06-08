/*******************************************************************************
 * @Title: BPMetaDTO.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata;

import java.io.Serializable;
import java.util.List;

/**   
 * @Title: BPMetaDTO.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月12日 下午5:18:23
 * @version V1.0   
 */
public class BPMetaDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7186258743102186974L;

    private BPMeta bpMeta;

    private List<BPMetaField> fields;

    private List<BPMetaForm> forms;

    private List<BPMetaNode> nodes;

    private List<BPMetaOperation> operations;

    private List<BPMetaCategory> category;

    public BPMetaDTO(BPMeta bpMeta) {
        this.bpMeta = bpMeta;
    }

    public BPMetaDTO(BPMeta bpMeta, List<BPMetaField> fields, List<BPMetaForm> forms, List<BPMetaNode> nodes,
            List<BPMetaOperation> operations) {
        this.bpMeta = bpMeta;
        this.fields = fields;
        this.forms = forms;
        this.nodes = nodes;
        this.operations = operations;
    }

    public BPMeta getBpMeta() {
        return bpMeta;
    }

    public void setBpMeta(BPMeta bpMeta) {
        this.bpMeta = bpMeta;
    }

    public List<BPMetaField> getFields() {
        return fields;
    }

    public void setFields(List<BPMetaField> fields) {
        this.fields = fields;
    }

    public List<BPMetaForm> getForms() {
        return forms;
    }

    public void setForms(List<BPMetaForm> forms) {
        this.forms = forms;
    }

    public List<BPMetaNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<BPMetaNode> nodes) {
        this.nodes = nodes;
    }

    public List<BPMetaOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<BPMetaOperation> operations) {
        this.operations = operations;
    }

    public List<BPMetaCategory> getCategory() {
        return category;
    }

    public void setCategory(List<BPMetaCategory> category) {
        this.category = category;
    }
}
