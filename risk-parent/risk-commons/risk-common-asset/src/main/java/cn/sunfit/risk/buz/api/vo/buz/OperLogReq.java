package cn.sunfit.risk.buz.api.vo.buz;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class OperLogReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String bpId;

    private String start;

    private String end;

    private String operUserName;

    public String getBpId() {
        return bpId;
    }

    public String getEnd() {
        if (StringUtils.isBlank(end)) {
            end = null;
        }
        return end;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public String getStart() {
        if (StringUtils.isBlank(start)) {
            start = null;
        }
        return start;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public void setStart(String start) {
        this.start = start;
    }

}
