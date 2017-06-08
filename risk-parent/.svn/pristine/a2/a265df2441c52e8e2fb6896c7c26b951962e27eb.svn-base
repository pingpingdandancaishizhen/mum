/*******************************************************************************
 * @Title: BPLoan.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.buz;

import java.math.BigDecimal;

import orj.worf.core.model.BaseObject;

/**
 * 
 * @Title: BPLoan.java
 * @Description: 业务流程的借款信息
 * @author zouxuejun
 * @date 2016年12月8日 下午5:13:35
 * @version V1.0
 */
public class BPLoan extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String bpId;

    private String corpId;

    private String customerId;

    private String carNo;

    private BigDecimal applyAmount;

    private BigDecimal approvedAmount;

    private String repaymentMethod;

    private String applyPeriod;

    private String contractId;

    private String domain;

    public BPLoan() {
        super();
    }

    public BPLoan(String corpId, String bpId) {
        this.corpId = corpId;
        this.bpId = bpId;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public String getApplyPeriod() {
        return applyPeriod;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getContractId() {
        return contractId;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDomain() {
        return domain;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public void setApplyPeriod(String applyPeriod) {
        this.applyPeriod = applyPeriod;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId == null ? null : bpId.trim();
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }
}