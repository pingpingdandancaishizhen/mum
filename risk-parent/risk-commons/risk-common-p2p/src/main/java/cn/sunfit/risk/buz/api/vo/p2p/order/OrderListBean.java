package cn.sunfit.risk.buz.api.vo.p2p.order;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import orj.worf.core.model.BaseObject;

/**
 * 
 * @Title: OrderListBean.java
 * @Package cn.sunfit.risk.buz.api.vo.p2p.order
 * @Description: 导入现金贷模板的VO,提供查询和编辑
 * @author RJS
 * @date 2017年5月10日 上午10:31:26
 * @version V1.0
 */
public class OrderListBean extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 506215415880615490L;

    private Long id;
    private String plusIdIcon;

    private String bpDefId;
    private String bpDefKey;
    private String deptId;
    private String productType;

    /**
     * 系统订单ID
     */
    private String bpId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 身份证号
     */
    private String eidCard;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品类型
     */
    private String productTypeName;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 房地产证号
     */
    private String houseCertificate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 借款金额
     */
    private BigDecimal loanMoney;

    /**
     * 保证金
     */
    private BigDecimal bzjMoney;

    /**
     * 借款期限
     */
    private String loanPeriod;

    /**
     * 还款方式
     */
    private String repayType;

    /**
     * 借款用途
     */
    private String loanPurpose;

    /**
     * 借款性质
     */
    private String loanHandleType;

    /**
     * 单据状态Key
     */
    private String currTaskKey;

    /**
     * 单据状态名称
     */
    private String currTaskName;

    /**
     * 订单来源
     */
    private String corporation;

    private String corporationName;

    /**
     * 订单新增方式
     */
    private String importWay;

    /**
     * 录单人
     */
    private String createUser;

    /**
     * 单据状态？
     */
    private String aproveStatus;

    private String aproveStatusStr;

    public String getAproveStatus() {
        return aproveStatus;
    }

    public String getAproveStatusStr() {
        return aproveStatusStr;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpDefKey() {
        return bpDefKey;
    }

    public String getBpId() {
        return bpId;
    }

    public BigDecimal getBzjMoney() {
        return bzjMoney;
    }

    public String getBzjMoneyStr() {
        if (this.bzjMoney != null) {
            return new DecimalFormat("0.00").format(this.bzjMoney.doubleValue());
        } else {
            return "";
        }

    }

    public String getCarNo() {
        return carNo;
    }

    public String getCorporation() {
        return corporation;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCurrTaskKey() {
        return currTaskKey;
    }

    public String getCurrTaskName() {
        return currTaskName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getEidCard() {
        return eidCard;
    }

    public String getGender() {
        return gender;
    }

    public String getHouseCertificate() {
        return houseCertificate;
    }

    public Long getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getImportWay() {
        return importWay;
    }

    public String getLoanApplyPeriodStr() {
        if (StringUtils.startsWith(loanPeriod, "M")) {
            return loanPeriod.replace("M", "") + "个月";
        } else if (StringUtils.startsWith(loanPeriod, "D")) {
            return loanPeriod.replace("D", "") + "天";
        } else {
            return "";
        }
    }

    public String getLoanHandleType() {
        return loanHandleType;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public String getLoanMoneyStr() {
        if (this.loanMoney != null) {
            return new DecimalFormat("0.00").format(this.loanMoney.doubleValue());
        } else {
            return "";
        }

    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPlusIdIcon() {
        return plusIdIcon;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setAproveStatus(String aproveStatus) {
        this.aproveStatus = aproveStatus;
    }

    public void setAproveStatusStr(String aproveStatusStr) {
        this.aproveStatusStr = aproveStatusStr;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setBpDefKey(String bpDefKey) {
        this.bpDefKey = bpDefKey;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBzjMoney(BigDecimal bzjMoney) {
        this.bzjMoney = bzjMoney;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCurrTaskKey(String currTaskKey) {
        this.currTaskKey = currTaskKey;
    }

    public void setCurrTaskName(String currTaskName) {
        this.currTaskName = currTaskName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setEidCard(String eidCard) {
        this.eidCard = eidCard;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHouseCertificate(String houseCertificate) {
        this.houseCertificate = houseCertificate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setImportWay(String importWay) {
        this.importWay = importWay;
    }

    public void setLoanHandleType(String loanHandleType) {
        this.loanHandleType = loanHandleType;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPlusIdIcon(String plusIdIcon) {
        this.plusIdIcon = plusIdIcon;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }
}
