package cn.sunfit.risk.buz.api.vo.corp;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;

public class CorpDeptNodeDTO extends CorpDept {

    private static final long serialVersionUID = 1L;

    private String text;

    private List<CorpDeptNodeDTO> nodes = new ArrayList<CorpDeptNodeDTO>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CorpDeptNodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<CorpDeptNodeDTO> nodes) {
        this.nodes = nodes;
    }

}
