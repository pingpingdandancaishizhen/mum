package cn.sunfit.risk.buz.api.vo.p2p.excel;

import java.util.Date;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

/**
 * 用于查询订单详情的搜索条件
 * add by kevin han 
 * @author mlrc022
 *
 */
public class LoanInfoQueryReq extends CorpReqBase {
    private static final long serialVersionUID = 1L;
    /**
     * 订单号
     */
    private String id;
    /**
     * 产品
     */
    private String productType;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 身份证号
     */
    private String idCard;
    private String eIdCard;
    /**
     * 发标平台的当前发标状态
     * 单据状态
     */
    private Integer aproveStatus;
    /**
     * 创建时间-起始
     */
    private Date createTimeFrom;
    /**
     * 创建时间-截止
     */
    private Date createTimeTo;
    /**
     * 借款性质
     * 新增，结清再贷，展期
     */
    private Integer loanHandleType;
    /**
     * 订单来源
     * 标的来自于公司名
     */
    private String corporation;
    /**
     * 客户类型
     * 个人，企业
     */
    private String customerType;
    /**
     * 第三方订单ID
     */
    private Long thirdLoanId;

    /***
     * 根据客户查询订单，折叠效果排除最新一笔
     * @return
     */
    private String excludeId;
    /**
     * 创建人
     */
    private String createUser;

    private String model;

    /**
     * 多个订单号
     */
    private String ids;

    private String domain;

    /**
     * 车牌号
     */
    private String loancarLicensePlate;

    /**
     * 订单来源
     */
    private String loanSource;

    /**
     * 房产证号
     */
    private String housePropertyNumber;

    public Integer getAproveStatus() {
        return aproveStatus;
    }

    public String getCorporation() {
        return corporation;
    }

    public Date getCreateTimeFrom() {
        return createTimeFrom;
    }

    public Date getCreateTimeTo() {
        return createTimeTo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    @Override
    public String getDomain() {
        return domain;
    }

    public String geteIdCard() {
        return eIdCard;
    }

    public String getExcludeId() {
        return excludeId;
    }

    public String getHousePropertyNumber() {
        return housePropertyNumber;
    }

    public String getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getIds() {
        return ids;
    }

    public String getLoancarLicensePlate() {
        return loancarLicensePlate;
    }

    public Integer getLoanHandleType() {
        return loanHandleType;
    }

    public String getLoanSource() {
        return loanSource;
    }

    public String getModel() {
        return model;
    }

    public String getProductType() {
        return productType;
    }

    public Long getThirdLoanId() {
        return thirdLoanId;
    }

    public void setAproveStatus(Integer aproveStatus) {
        this.aproveStatus = aproveStatus;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setCreateTimeFrom(Date createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public void setCreateTimeTo(Date createTimeTo) {
        this.createTimeTo = createTimeTo;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void seteIdCard(String eIdCard) {
        this.eIdCard = eIdCard;
    }

    public void setExcludeId(String excludeId) {
        this.excludeId = excludeId;
    }

    public void setHousePropertyNumber(String housePropertyNumber) {
        this.housePropertyNumber = housePropertyNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void setLoancarLicensePlate(String loancarLicensePlate) {
        this.loancarLicensePlate = loancarLicensePlate;
    }

    public void setLoanHandleType(Integer loanHandleType) {
        this.loanHandleType = loanHandleType;
    }

    public void setLoanSource(String loanSource) {
        this.loanSource = loanSource;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setThirdLoanId(Long thirdLoanId) {
        this.thirdLoanId = thirdLoanId;
    }

}
