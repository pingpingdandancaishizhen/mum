package cn.sunfit.risk.buz.server.util.api.jfjd.event;

import org.springframework.context.ApplicationEvent;

public class CorpStatusChangeEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 822395607622287691L;

    private String corpId;

    private String status;

    public CorpStatusChangeEvent(Object source, String corpId, String status) {
        super(source);
        this.corpId = corpId;
        this.status = status;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getStatus() {
        return status;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
