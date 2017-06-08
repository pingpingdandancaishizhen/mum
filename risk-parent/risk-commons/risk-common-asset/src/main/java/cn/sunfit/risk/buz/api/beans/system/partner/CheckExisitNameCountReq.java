package cn.sunfit.risk.buz.api.beans.system.partner;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class CheckExisitNameCountReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = -4242940825513637499L;

    private String id;

    private String name;

    public CheckExisitNameCountReq() {

    }

    public CheckExisitNameCountReq(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
