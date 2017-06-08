package cn.sunfit.risk.buz.api.vo.corp;

import cn.sunfit.risk.buz.api.beans.corp.Customer;

public class CustomerAddDTO extends Customer {

    private static final long serialVersionUID = 1L;

    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
