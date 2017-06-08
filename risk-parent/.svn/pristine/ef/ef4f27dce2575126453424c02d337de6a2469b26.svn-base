package cn.sunfit.risk.buz.api.vo.corp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.constants.EducationType;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.customer.CompanyType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.customer.GenderType;
import cn.sunfit.risk.buz.api.constants.customer.HouseType;
import cn.sunfit.risk.buz.api.constants.customer.MaritalStatus;
import cn.sunfit.risk.buz.api.constants.customer.SalaryType;

public class CustomerModifyDTO extends Customer {

    private static final long serialVersionUID = 1L;

    private String domain;

    public String compareOldCustomer(Customer oldCustomer) {
        List<String> logInfos = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE);

        // 客户类型处理(必填字段)
        if (!StringUtils.equals(this.getType(), oldCustomer.getType())) {
            CustomerType oldCustomerType = CustomerType.getTypeNameByTypeId(oldCustomer.getType());
            CustomerType newCustomerType = CustomerType.getTypeNameByTypeId(this.getType());
            logInfos.add("客户类型[" + oldCustomerType.getTypeName() + "]修改为[" + newCustomerType.getTypeName() + "]");
        }

        // 客户姓名处理(必填字段)
        if (!StringUtils.equals(this.getName(), oldCustomer.getName())) {
            logInfos.add("客户姓名[" + oldCustomer.getName() + "]修改为[" + this.getName() + "]");
        }

        // 客户性别处理(必填字段)
        if (!StringUtils.equals(this.getGender(), oldCustomer.getGender())) {
            GenderType oldGenderType = GenderType.getNameByStatus(oldCustomer.getGender());
            GenderType newGenderType = GenderType.getNameByStatus(this.getGender());
            logInfos.add("性别[" + oldGenderType.getName() + "]修改为[" + newGenderType.getName() + "]");
        }

        // 身份证号码处理(必填字段)
        if (!StringUtils.equals(this.getLicenseNum(), oldCustomer.getLicenseNum())) {
            logInfos.add("身份证号码[" + oldCustomer.getLicenseNum() + "]修改为[" + this.getLicenseNum() + "]");
        }

        // 婚姻状况处理
        if (StringUtils.isBlank(this.getMaritalStatus()) && StringUtils.isBlank(oldCustomer.getMaritalStatus())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getMaritalStatus())
                && StringUtils.isBlank(oldCustomer.getMaritalStatus())) {
            MaritalStatus newMaritalStatus = MaritalStatus.getNameByType(this.getMaritalStatus());
            logInfos.add("新增婚姻状况[" + newMaritalStatus.getName() + "]");
        } else if (StringUtils.isBlank(this.getMaritalStatus())
                && StringUtils.isNotBlank(oldCustomer.getMaritalStatus())) {
            MaritalStatus oldMaritalStatus = MaritalStatus.getNameByType(oldCustomer.getMaritalStatus());
            logInfos.add("删除婚姻状况[" + oldMaritalStatus.getName() + "]");
        } else if (!StringUtils.equals(this.getMaritalStatus(), oldCustomer.getMaritalStatus())) {
            MaritalStatus oldMaritalStatus = MaritalStatus.getNameByType(oldCustomer.getMaritalStatus());
            MaritalStatus newMaritalStatus = MaritalStatus.getNameByType(this.getMaritalStatus());
            logInfos.add("婚姻状况[" + oldMaritalStatus.getName() + "]修改为[" + newMaritalStatus.getName() + "]");
        }

        // 子女数目处理
        if (this.getChildCount() == null && oldCustomer.getChildCount() == null) {
            // do nothing
        } else if (this.getChildCount() != null && oldCustomer.getChildCount() == null) {
            logInfos.add("新增子女数目[" + this.getChildCount() + "]");
        } else if (this.getChildCount() == null && oldCustomer.getChildCount() != null) {
            logInfos.add("删除子女数目[" + oldCustomer.getChildCount() + "]");
        } else if (this.getChildCount() != oldCustomer.getChildCount()) {
            logInfos.add("子女数目[" + oldCustomer.getChildCount() + "]修改为[" + this.getChildCount() + "]");
        }

        // 供养人数处理
        if (this.getSupportNum() == null && oldCustomer.getSupportNum() == null) {
            // do nothing
        } else if (this.getSupportNum() != null && oldCustomer.getSupportNum() == null) {
            logInfos.add("新增供养人数[" + this.getSupportNum() + "]");
        } else if (this.getSupportNum() == null && oldCustomer.getSupportNum() != null) {
            logInfos.add("删除供养人数[" + oldCustomer.getSupportNum() + "]");
        } else if (this.getSupportNum() != oldCustomer.getSupportNum()) {
            logInfos.add("供养人数[" + oldCustomer.getSupportNum() + "]修改为[" + this.getSupportNum() + "]");
        }

        // 每月家庭支出处理
        if (this.getHouseSpending() == null && oldCustomer.getHouseSpending() == null) {
            // do nothing
        } else if (this.getHouseSpending() != null && oldCustomer.getHouseSpending() == null) {
            logInfos.add("新增每月家庭支出[" + this.getHouseSpending() + "]");
        } else if (this.getHouseSpending() == null && oldCustomer.getHouseSpending() != null) {
            logInfos.add("删除每月家庭支出[" + oldCustomer.getHouseSpending() + "]");
        } else if (this.getHouseSpending().compareTo(oldCustomer.getHouseSpending()) != 0) {
            logInfos.add("供养每月家庭支出[" + oldCustomer.getHouseSpending() + "]修改为[" + this.getHouseSpending() + "]");
        }

        // 最高学历处理
        if (StringUtils.isBlank(this.getEducation()) && StringUtils.isBlank(oldCustomer.getEducation())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getEducation()) && StringUtils.isBlank(oldCustomer.getEducation())) {
            EducationType newEducationType = EducationType.getNameByStatus(this.getEducation());
            logInfos.add("新增最高学历[" + newEducationType.getName() + "]");
        } else if (StringUtils.isBlank(this.getEducation()) && StringUtils.isNotBlank(oldCustomer.getEducation())) {
            EducationType oldEducationType = EducationType.getNameByStatus(oldCustomer.getEducation());
            logInfos.add("删除最高学历[" + oldEducationType.getName() + "]");
        } else if (!StringUtils.equals(this.getEducation(), oldCustomer.getEducation())) {
            EducationType oldEducationType = EducationType.getNameByStatus(oldCustomer.getEducation());
            EducationType newEducationType = EducationType.getNameByStatus(this.getEducation());
            logInfos.add("最高学历[" + oldEducationType.getName() + "]修改为[" + newEducationType.getName() + "]");
        }

        // 移动电话1处理
        if (StringUtils.isBlank(this.getMobile()) && StringUtils.isBlank(oldCustomer.getMobile())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getMobile()) && StringUtils.isBlank(oldCustomer.getMobile())) {
            logInfos.add("新增移动电话[" + this.getMobile() + "]");
        } else if (StringUtils.isBlank(this.getMobile()) && StringUtils.isNotBlank(oldCustomer.getMobile())) {
            logInfos.add("删除移动电话[" + oldCustomer.getMobile() + "]");
        } else if (!StringUtils.equals(this.getMobile(), oldCustomer.getMobile())) {
            logInfos.add("移动电话[" + oldCustomer.getMobile() + "]修改为[" + this.getMobile() + "]");
        }

        // 移动电话2处理
        if (StringUtils.isBlank(this.getMobile2()) && StringUtils.isBlank(oldCustomer.getMobile2())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getMobile2()) && StringUtils.isBlank(oldCustomer.getMobile2())) {
            logInfos.add("新增移动电话2[" + this.getMobile2() + "]");
        } else if (StringUtils.isBlank(this.getMobile2()) && StringUtils.isNotBlank(oldCustomer.getMobile2())) {
            logInfos.add("删除移动电话2[" + oldCustomer.getMobile2() + "]");
        } else if (!StringUtils.equals(this.getMobile2(), oldCustomer.getMobile2())) {
            logInfos.add("移动电话2[" + oldCustomer.getMobile2() + "]修改为[" + this.getMobile2() + "]");
        }

        // 邮箱处理
        if (StringUtils.isBlank(this.getEmail()) && StringUtils.isBlank(oldCustomer.getEmail())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getEmail()) && StringUtils.isBlank(oldCustomer.getEmail())) {
            logInfos.add("新增邮箱[" + this.getEmail() + "]");
        } else if (StringUtils.isBlank(this.getEmail()) && StringUtils.isNotBlank(oldCustomer.getEmail())) {
            logInfos.add("删除邮箱[" + oldCustomer.getEmail() + "]");
        } else if (!StringUtils.equals(this.getEmail(), oldCustomer.getEmail())) {
            logInfos.add("邮箱[" + oldCustomer.getEmail() + "]修改为[" + this.getEmail() + "]");
        }

        // QQ处理
        if (StringUtils.isBlank(this.getQq()) && StringUtils.isBlank(oldCustomer.getQq())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getQq()) && StringUtils.isBlank(oldCustomer.getQq())) {
            logInfos.add("新增QQ[" + this.getQq() + "]");
        } else if (StringUtils.isBlank(this.getQq()) && StringUtils.isNotBlank(oldCustomer.getQq())) {
            logInfos.add("删除QQ[" + oldCustomer.getQq() + "]");
        } else if (!StringUtils.equals(this.getQq(), oldCustomer.getQq())) {
            logInfos.add("QQ[" + oldCustomer.getQq() + "]修改为[" + this.getQq() + "]");
        }

        // 微信处理
        if (StringUtils.isBlank(this.getWechat()) && StringUtils.isBlank(oldCustomer.getWechat())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getWechat()) && StringUtils.isBlank(oldCustomer.getWechat())) {
            logInfos.add("新增微信[" + this.getWechat() + "]");
        } else if (StringUtils.isBlank(this.getWechat()) && StringUtils.isNotBlank(oldCustomer.getWechat())) {
            logInfos.add("删除微信[" + oldCustomer.getWechat() + "]");
        } else if (!StringUtils.equals(this.getWechat(), oldCustomer.getWechat())) {
            logInfos.add("微信[" + oldCustomer.getWechat() + "]修改为[" + this.getWechat() + "]");
        }

        // 住宅电话处理
        if (StringUtils.isBlank(this.getPhone()) && StringUtils.isBlank(oldCustomer.getPhone())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getPhone()) && StringUtils.isBlank(oldCustomer.getPhone())) {
            logInfos.add("新增住宅电话[" + this.getPhone() + "]");
        } else if (StringUtils.isBlank(this.getPhone()) && StringUtils.isNotBlank(oldCustomer.getPhone())) {
            logInfos.add("删除住宅电话[" + oldCustomer.getPhone() + "]");
        } else if (!StringUtils.equals(this.getPhone(), oldCustomer.getPhone())) {
            logInfos.add("住宅电话[" + oldCustomer.getPhone() + "]修改为[" + this.getPhone() + "]");
        }

        // 现住址入住时间处理
        if (this.getHouseTime() == null && oldCustomer.getHouseTime() == null) {
            // do nothing
        } else if (this.getHouseTime() != null && oldCustomer.getHouseTime() == null) {
            logInfos.add("新增现住址入住时间[" + sdf.format(this.getHouseTime()) + "]");
        } else if (this.getHouseTime() == null && oldCustomer.getHouseTime() != null) {
            logInfos.add("删除现住址入住时间[" + sdf.format(oldCustomer.getHouseTime()) + "]");
        } else if (this.getHouseTime() != null && this.getHouseTime().compareTo(oldCustomer.getHouseTime()) != 0) {
            logInfos.add("现住址入住时间[" + sdf.format(oldCustomer.getHouseTime()) + "]修改为["
                    + sdf.format(this.getHouseTime()) + "]");
        }

        // 现住址类别处理
        if (StringUtils.isBlank(this.getHouseType()) && StringUtils.isBlank(oldCustomer.getHouseType())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getHouseType()) && StringUtils.isBlank(oldCustomer.getHouseType())) {
            HouseType newHouseType = HouseType.getTypeNameByTypeId(this.getHouseType());
            logInfos.add("新增现住址类别[" + newHouseType.getTypeName() + "]");
        } else if (StringUtils.isBlank(this.getHouseType()) && StringUtils.isNotBlank(oldCustomer.getHouseType())) {
            HouseType oldHouseType = HouseType.getTypeNameByTypeId(oldCustomer.getHouseType());
            logInfos.add("删除现住址类别[" + oldHouseType.getTypeName() + "]");
        } else if (!StringUtils.equals(this.getHouseType(), oldCustomer.getHouseType())) {
            HouseType oldHouseType = HouseType.getTypeNameByTypeId(oldCustomer.getHouseType());
            HouseType newHouseType = HouseType.getTypeNameByTypeId(this.getHouseType());
            logInfos.add("现住址类别[" + oldHouseType.getTypeName() + "]修改为[" + newHouseType.getTypeName() + "]");
        }

        // 来本市时间处理
        if (this.getComeTime() == null && oldCustomer.getComeTime() == null) {
            // do nothing
        } else if (this.getComeTime() != null && oldCustomer.getComeTime() == null) {
            logInfos.add("新增来本市时间[" + sdf.format(this.getComeTime()) + "]");
        } else if (this.getComeTime() == null && oldCustomer.getComeTime() != null) {
            logInfos.add("删除来本市时间[" + sdf.format(oldCustomer.getComeTime()) + "]");
        } else if (this.getComeTime() != null && this.getComeTime().compareTo(oldCustomer.getComeTime()) != 0) {
            logInfos.add("来本市时间[" + sdf.format(oldCustomer.getComeTime()) + "]修改为[" + sdf.format(this.getComeTime())
                    + "]");
        }

        // 现住址处理
        if (StringUtils.isBlank(this.getLiveAddr()) && StringUtils.isBlank(oldCustomer.getLiveAddr())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getLiveAddr()) && StringUtils.isBlank(oldCustomer.getLiveAddr())) {
            logInfos.add("新增现住址[" + this.getLiveAddr() + "]");
        } else if (StringUtils.isBlank(this.getLiveAddr()) && StringUtils.isNotBlank(oldCustomer.getLiveAddr())) {
            logInfos.add("删除现住址[" + oldCustomer.getLiveAddr() + "]");
        } else if (!StringUtils.equals(this.getLiveAddr(), oldCustomer.getLiveAddr())) {
            logInfos.add("现住址[" + oldCustomer.getLiveAddr() + "]修改为[" + this.getLiveAddr() + "]");
        }

        // 现住址详细处理
        if (StringUtils.isBlank(this.getLiveAddrDetail()) && StringUtils.isBlank(oldCustomer.getLiveAddrDetail())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getLiveAddrDetail())
                && StringUtils.isBlank(oldCustomer.getLiveAddrDetail())) {
            logInfos.add("新增现住址详细[" + this.getLiveAddrDetail() + "]");
        } else if (StringUtils.isBlank(this.getLiveAddrDetail())
                && StringUtils.isNotBlank(oldCustomer.getLiveAddrDetail())) {
            logInfos.add("删除现住址详细[" + oldCustomer.getLiveAddrDetail() + "]");
        } else if (!StringUtils.equals(this.getLiveAddrDetail(), oldCustomer.getLiveAddrDetail())) {
            logInfos.add("现住址详细[" + oldCustomer.getLiveAddrDetail() + "]修改为[" + this.getLiveAddrDetail() + "]");
        }

        // 户口所在地处理
        if (StringUtils.isBlank(this.getRegistAddr()) && StringUtils.isBlank(oldCustomer.getRegistAddr())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getRegistAddr()) && StringUtils.isBlank(oldCustomer.getRegistAddr())) {
            logInfos.add("新增户口所在地[" + this.getRegistAddr() + "]");
        } else if (StringUtils.isBlank(this.getRegistAddr()) && StringUtils.isNotBlank(oldCustomer.getRegistAddr())) {
            logInfos.add("删除户口所在地[" + oldCustomer.getRegistAddr() + "]");
        } else if (!StringUtils.equals(this.getRegistAddr(), oldCustomer.getRegistAddr())) {
            logInfos.add("户口所在地[" + oldCustomer.getRegistAddr() + "]修改为[" + this.getRegistAddr() + "]");
        }

        // 户口所在地详细处理
        if (StringUtils.isBlank(this.getRegistAddrDetail()) && StringUtils.isBlank(oldCustomer.getRegistAddrDetail())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getRegistAddrDetail())
                && StringUtils.isBlank(oldCustomer.getRegistAddrDetail())) {
            logInfos.add("新增户口所在地详细[" + this.getRegistAddrDetail() + "]");
        } else if (StringUtils.isBlank(this.getRegistAddrDetail())
                && StringUtils.isNotBlank(oldCustomer.getRegistAddrDetail())) {
            logInfos.add("删除户口所在地详细[" + oldCustomer.getRegistAddrDetail() + "]");
        } else if (!StringUtils.equals(this.getRegistAddrDetail(), oldCustomer.getRegistAddrDetail())) {
            logInfos.add("户口所在地详细[" + oldCustomer.getRegistAddrDetail() + "]修改为[" + this.getRegistAddrDetail() + "]");
        }

        // 所属行业处理
        if (StringUtils.isBlank(this.getIndustry()) && StringUtils.isBlank(oldCustomer.getIndustry())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getIndustry()) && StringUtils.isBlank(oldCustomer.getIndustry())) {
            logInfos.add("新增所属行业[" + this.getIndustry() + "]");
        } else if (StringUtils.isBlank(this.getIndustry()) && StringUtils.isNotBlank(oldCustomer.getIndustry())) {
            logInfos.add("删除所属行业[" + oldCustomer.getIndustry() + "]");
        } else if (!StringUtils.equals(this.getIndustry(), oldCustomer.getIndustry())) {
            logInfos.add("所属行业[" + oldCustomer.getIndustry() + "]修改为[" + this.getIndustry() + "]");
        }

        // 公司性质
        if (StringUtils.isBlank(this.getCompanyType()) && StringUtils.isBlank(oldCustomer.getCompanyType())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getCompanyType()) && StringUtils.isBlank(oldCustomer.getCompanyType())) {
            CompanyType newCompanyType = CompanyType.getNameByStatus(this.getCompanyType());
            logInfos.add("新增公司性质[" + newCompanyType.getName() + "]");
        } else if (StringUtils.isBlank(this.getCompanyType()) && StringUtils.isNotBlank(oldCustomer.getCompanyType())) {
            CompanyType oldCompanyType = CompanyType.getNameByStatus(oldCustomer.getCompanyType());
            logInfos.add("删除公司性质[" + oldCompanyType.getName() + "]");
        } else if (!StringUtils.equals(this.getCompanyType(), oldCustomer.getCompanyType())) {
            CompanyType oldCompanyType = CompanyType.getNameByStatus(oldCustomer.getCompanyType());
            CompanyType newCompanyType = CompanyType.getNameByStatus(this.getCompanyType());
            logInfos.add("公司性质[" + oldCompanyType.getName() + "]修改为[" + newCompanyType.getName() + "]");
        }

        // 单位名称处理
        if (StringUtils.isBlank(this.getCompanyName()) && StringUtils.isBlank(oldCustomer.getCompanyName())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getCompanyName()) && StringUtils.isBlank(oldCustomer.getCompanyName())) {
            logInfos.add("新增单位名称[" + this.getCompanyName() + "]");
        } else if (StringUtils.isBlank(this.getCompanyName()) && StringUtils.isNotBlank(oldCustomer.getCompanyName())) {
            logInfos.add("删除单位名称[" + oldCustomer.getCompanyName() + "]");
        } else if (!StringUtils.equals(this.getCompanyName(), oldCustomer.getCompanyName())) {
            logInfos.add("单位名称[" + oldCustomer.getCompanyName() + "]修改为[" + this.getCompanyName() + "]");
        }

        // 所在部门/科室处理
        if (StringUtils.isBlank(this.getDeptName()) && StringUtils.isBlank(oldCustomer.getDeptName())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getDeptName()) && StringUtils.isBlank(oldCustomer.getDeptName())) {
            logInfos.add("新增所在部门/科室[" + this.getDeptName() + "]");
        } else if (StringUtils.isBlank(this.getDeptName()) && StringUtils.isNotBlank(oldCustomer.getDeptName())) {
            logInfos.add("删除所在部门/科室[" + oldCustomer.getDeptName() + "]");
        } else if (!StringUtils.equals(this.getDeptName(), oldCustomer.getDeptName())) {
            logInfos.add("所在部门/科室[" + oldCustomer.getDeptName() + "]修改为[" + this.getDeptName() + "]");
        }

        // 职业处理
        if (StringUtils.isBlank(this.getJob()) && StringUtils.isBlank(oldCustomer.getJob())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getJob()) && StringUtils.isBlank(oldCustomer.getJob())) {
            logInfos.add("新增职业[" + this.getJob() + "]");
        } else if (StringUtils.isBlank(this.getJob()) && StringUtils.isNotBlank(oldCustomer.getJob())) {
            logInfos.add("删除职业[" + oldCustomer.getJob() + "]");
        } else if (!StringUtils.equals(this.getJob(), oldCustomer.getJob())) {
            logInfos.add("职业[" + oldCustomer.getJob() + "]修改为[" + this.getJob() + "]");
        }

        // 入职时间处理
        if (this.getEntryTime() == null && oldCustomer.getEntryTime() == null) {
            // do nothing
        } else if (this.getEntryTime() != null && oldCustomer.getEntryTime() == null) {
            logInfos.add("新增入职时间[" + sdf.format(this.getEntryTime()) + "]");
        } else if (this.getEntryTime() == null && oldCustomer.getEntryTime() != null) {
            logInfos.add("删除入职时间[" + sdf.format(oldCustomer.getEntryTime()) + "]");
        } else if (this.getEntryTime() != null && this.getEntryTime().compareTo(oldCustomer.getEntryTime()) != 0) {
            logInfos.add("入职时间[" + sdf.format(oldCustomer.getEntryTime()) + "]修改为[" + sdf.format(this.getEntryTime())
                    + "]");
        }

        // 月均工资处理
        if (this.getSalary() == null && oldCustomer.getSalary() == null) {
            // do nothing
        } else if (this.getSalary() != null && oldCustomer.getSalary() == null) {
            logInfos.add("新增月均工资[" + this.getSalary() + "]");
        } else if (this.getSalary() == null && oldCustomer.getSalary() != null) {
            logInfos.add("删除月均工资[" + oldCustomer.getSalary() + "]");
        } else if (this.getSalary().compareTo(oldCustomer.getSalary()) != 0) {
            logInfos.add("月均工资[" + oldCustomer.getSalary() + "]修改为[" + this.getSalary() + "]");
        }

        // 每月发薪日处理
        if (this.getSalaryDate() == null && oldCustomer.getSalaryDate() == null) {
            // do nothing
        } else if (this.getSalaryDate() != null && oldCustomer.getSalaryDate() == null) {
            logInfos.add("新增每月发薪日[" + this.getSalaryDate() + "]");
        } else if (this.getSalaryDate() == null && oldCustomer.getSalaryDate() != null) {
            logInfos.add("删除每月发薪日[" + oldCustomer.getSalaryDate() + "]");
        } else if (this.getSalaryDate().compareTo(oldCustomer.getSalaryDate()) != 0) {
            logInfos.add("每月发薪日[" + oldCustomer.getSalaryDate() + "]修改为[" + this.getSalaryDate() + "]");
        }

        // 工资发放形式处理
        if (StringUtils.isBlank(this.getSalaryType()) && StringUtils.isBlank(oldCustomer.getSalaryType())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getSalaryType()) && StringUtils.isBlank(oldCustomer.getSalaryType())) {
            SalaryType newSalaryType = SalaryType.getNameByStatus(this.getSalaryType());
            logInfos.add("新增工资发放形式[" + newSalaryType.getName() + "]");
        } else if (StringUtils.isBlank(this.getSalaryType()) && StringUtils.isNotBlank(oldCustomer.getSalaryType())) {
            SalaryType oldSalaryType = SalaryType.getNameByStatus(oldCustomer.getSalaryType());
            logInfos.add("删除工资发放形式[" + oldSalaryType.getName() + "]");
        } else if (!StringUtils.equals(this.getSalaryType(), oldCustomer.getSalaryType())) {
            SalaryType oldSalaryType = SalaryType.getNameByStatus(oldCustomer.getSalaryType());
            SalaryType newSalaryType = SalaryType.getNameByStatus(this.getSalaryType());
            logInfos.add("工资发放形式[" + oldSalaryType.getName() + "]修改为[" + newSalaryType.getName() + "]");
        }

        // 单位电话处理
        if (StringUtils.isBlank(this.getCompanyPhone()) && StringUtils.isBlank(oldCustomer.getCompanyPhone())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getCompanyPhone()) && StringUtils.isBlank(oldCustomer.getCompanyPhone())) {
            logInfos.add("新增单位电话[" + this.getCompanyPhone() + "]");
        } else if (StringUtils.isBlank(this.getCompanyPhone()) && StringUtils.isNotBlank(oldCustomer.getCompanyPhone())) {
            logInfos.add("删除单位电话[" + oldCustomer.getCompanyPhone() + "]");
        } else if (!StringUtils.equals(this.getCompanyPhone(), oldCustomer.getCompanyPhone())) {
            logInfos.add("单位电话[" + oldCustomer.getCompanyPhone() + "]修改为[" + this.getCompanyPhone() + "]");
        }

        // 单位地址处理
        if (StringUtils.isBlank(this.getCompanyAddr()) && StringUtils.isBlank(oldCustomer.getCompanyAddr())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getCompanyAddr()) && StringUtils.isBlank(oldCustomer.getCompanyAddr())) {
            logInfos.add("新增单位地址[" + this.getCompanyAddr() + "]");
        } else if (StringUtils.isBlank(this.getCompanyAddr()) && StringUtils.isNotBlank(oldCustomer.getCompanyAddr())) {
            logInfos.add("删除单位地址[" + oldCustomer.getCompanyAddr() + "]");
        } else if (!StringUtils.equals(this.getCompanyAddr(), oldCustomer.getCompanyAddr())) {
            logInfos.add("单位地址[" + oldCustomer.getCompanyAddr() + "]修改为[" + this.getCompanyAddr() + "]");
        }

        // 单位地址详细处理
        if (StringUtils.isBlank(this.getCompanyAddrDetail()) && StringUtils.isBlank(oldCustomer.getCompanyAddrDetail())) {
            // do nothing
        } else if (StringUtils.isNotBlank(this.getCompanyAddrDetail())
                && StringUtils.isBlank(oldCustomer.getCompanyAddrDetail())) {
            logInfos.add("新增单位地址详细[" + this.getCompanyAddrDetail() + "]");
        } else if (StringUtils.isBlank(this.getCompanyAddrDetail())
                && StringUtils.isNotBlank(oldCustomer.getCompanyAddrDetail())) {
            logInfos.add("删除单位地址详细[" + oldCustomer.getCompanyAddrDetail() + "]");
        } else if (!StringUtils.equals(this.getCompanyAddrDetail(), oldCustomer.getCompanyAddrDetail())) {
            logInfos.add("单位地址详细[" + oldCustomer.getCompanyAddrDetail() + "]修改为[" + this.getCompanyAddrDetail() + "]");
        }

        String info = logInfos.toString();
        return info.substring(1, info.length() - 1);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
