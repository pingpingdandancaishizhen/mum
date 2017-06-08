package cn.sunfit.risk.buz.api.vo.solution;

import java.util.List;

public class BPMetaProductNodeVO extends BpMetaCorpProductVO {

    private static final long serialVersionUID = 1L;

    private List<BpMetaNodeVO> bpMetaNodes;

    public BPMetaProductNodeVO convert(BpMetaCorpProductVO node) {
        BPMetaProductNodeVO result = new BPMetaProductNodeVO();
        result.setProductKey(node.getProductKey());
        result.setProductName(node.getProductName());
        return result;
    }

    public List<BpMetaNodeVO> getBpMetaNodes() {
        return bpMetaNodes;
    }

    public void setBpMetaNodes(List<BpMetaNodeVO> bpMetaNodes) {
        this.bpMetaNodes = bpMetaNodes;
    }
}
