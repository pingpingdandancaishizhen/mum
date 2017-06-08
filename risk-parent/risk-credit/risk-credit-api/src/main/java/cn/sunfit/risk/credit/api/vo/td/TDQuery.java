package cn.sunfit.risk.credit.api.vo.td;

import java.io.Serializable;

import orj.worf.util.StringUtils;

/**
 * 聚信立请求报文
 * @Title: JXLQuery.java
 * @Package cn.sunfit.risk.credit.api.vo.jxl
 * @Description: TODO
 * @author XJ
 * @date 2017年5月9日 上午10:55:01
 * @version V1.0
 */
public class TDQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String idcard;

    private String phone;

    public String getIdcard() {
        return idcard;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean validate() {
        return StringUtils.isNotEmpty(this.name) && StringUtils.isNotEmpty(this.idcard)
                && StringUtils.isNotEmpty(this.phone);
    }
}
