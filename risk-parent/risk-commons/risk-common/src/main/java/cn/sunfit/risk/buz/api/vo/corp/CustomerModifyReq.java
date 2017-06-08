package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.beans.corp.CustContact;

public class CustomerModifyReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String id;

    private String uid;

    private String corpId;

    @NotBlank(message = "客户类型不能为空")
    private String type;

    @NotBlank(message = "客户名不能为空")
    @Pattern(regexp = "^[A-Za-z\u4e00-\u9fa5]{2,20}$", message = "客户名为2-20位中文或英文")
    private String name;

    @NotBlank(message = "性别不能为空")
    private String gender;

    private Integer age;

    private Date birthday;

    private Date idCardVaild;

    @NotBlank(message = "身份证号码不能为空")
    private String licenseNum;

    private String maritalStatus;

    private Integer childCount;

    private Integer supportNum;

    private BigDecimal houseSpending;

    private String education;

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式不正确")
    private String mobile;

    private String mobile2;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String qq;

    private String wechat;

    private String phone;

    private Date houseTime;

    private String houseType;

    private Date comeTime;

    private String registAddr;

    private String registAddrDetail;

    private String liveAddr;

    private String liveAddrDetail;

    private String jobType;

    private String industry;

    private String companyType;

    private String companyName;

    private String deptName;

    private String job;

    private String jobTitle;

    private Date entryTime;

    private BigDecimal salary;

    private Integer salaryDate;

    private String salaryType;

    private String companyPhone;

    private String companyAddr;

    private String companyAddrDetail;

    private String status;

    private String idCardFront;

    private String idCardBack;

    private String creditReport;

    private String resourceId;

    private Date createTime;

    private Date updateTime;

    private List<CustContact> custContacts;

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public Date getComeTime() {
        return comeTime;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public String getCompanyAddrDetail() {
        return companyAddrDetail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreditReport() {
        return creditReport;
    }

    public List<CustContact> getCustContacts() {
        return custContacts;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDomain() {
        return domain;
    }

    public String getEducation() {
        return education;
    }

    public String getEmail() {
        return email;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public String getGender() {
        return gender;
    }

    public BigDecimal getHouseSpending() {
        return houseSpending;
    }

    public Date getHouseTime() {
        return houseTime;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getId() {
        return id;
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public Date getIdCardVaild() {
        return idCardVaild;
    }

    public String getIndustry() {
        return industry;
    }

    public String getJob() {
        return job;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public String getLiveAddr() {
        return liveAddr;
    }

    public String getLiveAddrDetail() {
        return liveAddrDetail;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getQq() {
        return qq;
    }

    public String getRegistAddr() {
        return registAddr;
    }

    public String getRegistAddrDetail() {
        return registAddrDetail;
    }

    public String getResourceId() {
        return resourceId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Integer getSalaryDate() {
        return salaryDate;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public String getStatus() {
        return status;
    }

    public Integer getSupportNum() {
        return supportNum;
    }

    public String getType() {
        return type;
    }

    public String getUid() {
        return uid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getWechat() {
        return wechat;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public void setComeTime(Date comeTime) {
        this.comeTime = comeTime;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public void setCompanyAddrDetail(String companyAddrDetail) {
        this.companyAddrDetail = companyAddrDetail;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreditReport(String creditReport) {
        this.creditReport = creditReport;
    }

    public void setCustContacts(List<CustContact> custContacts) {
        this.custContacts = custContacts;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHouseSpending(BigDecimal houseSpending) {
        this.houseSpending = houseSpending;
    }

    public void setHouseTime(Date houseTime) {
        this.houseTime = houseTime;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public void setIdCardVaild(Date idCardVaild) {
        this.idCardVaild = idCardVaild;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public void setLiveAddr(String liveAddr) {
        this.liveAddr = liveAddr;
    }

    public void setLiveAddrDetail(String liveAddrDetail) {
        this.liveAddrDetail = liveAddrDetail;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setRegistAddr(String registAddr) {
        this.registAddr = registAddr;
    }

    public void setRegistAddrDetail(String registAddrDetail) {
        this.registAddrDetail = registAddrDetail;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setSalaryDate(Integer salaryDate) {
        this.salaryDate = salaryDate;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public CustomerModifyDTO toCustomerModifyDTO() {
        CustomerModifyDTO customer = new CustomerModifyDTO();
        customer.setId(this.id);
        customer.setCorpId(this.corpId);
        customer.setUid(this.uid);
        customer.setName(this.name);
        customer.setType(this.type);
        customer.setAge(this.age);
        customer.setBirthday(this.birthday);
        customer.setIdCardVaild(this.idCardVaild);
        customer.setChildCount(this.childCount);
        customer.setComeTime(this.comeTime);
        customer.setCompanyAddr(this.companyAddr);
        customer.setCompanyName(this.companyName);
        customer.setCompanyPhone(this.companyPhone);
        customer.setCompanyType(this.companyType);
        customer.setCreateTime(this.createTime);
        customer.setDeptName(this.deptName);
        customer.setEducation(this.education);
        customer.setEmail(this.email);
        customer.setEntryTime(this.entryTime);
        customer.setGender(this.gender);
        customer.setHouseSpending(this.houseSpending);
        customer.setHouseTime(this.houseTime);
        customer.setHouseType(this.houseType);
        customer.setIndustry(this.industry);
        customer.setJob(this.job);
        customer.setJobType(this.jobType);
        customer.setJobTitle(this.jobTitle);
        customer.setLicenseNum(this.licenseNum);
        customer.setLiveAddr(this.liveAddr);
        customer.setMaritalStatus(this.maritalStatus);
        customer.setMobile(this.mobile);
        customer.setMobile2(this.mobile2);
        customer.setPhone(this.phone);
        customer.setQq(this.qq);
        customer.setRegistAddr(this.registAddr);
        customer.setSalary(this.salary);
        customer.setSalaryDate(this.salaryDate);
        customer.setSalaryType(this.salaryType);
        customer.setStatus(this.status);
        customer.setSupportNum(this.supportNum);
        customer.setUpdateTime(this.updateTime);
        customer.setWechat(this.wechat);
        customer.setDomain(this.domain);
        customer.setRegistAddrDetail(this.registAddrDetail);
        customer.setLiveAddrDetail(this.liveAddrDetail);
        customer.setCompanyAddrDetail(this.companyAddrDetail);
        customer.setIdCardFront(this.idCardFront);
        customer.setIdCardBack(this.idCardBack);
        customer.setCreditReport(this.creditReport);
        customer.setResourceId(this.resourceId);
        return customer;
    }

}
