package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.vo.corp.CustomerAddDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerModifyDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerQueryReq;

@Repository
public interface CustomerDAO {
    void insert(CustomerAddDTO record);

    List<CustomerDTO> queryCustomerList(@Param("customer") CustomerQueryReq customer, RowBounds rowBounds);

    Customer selectByPrimaryKey(@Param("id") String id, @Param("domain") String domain);

    Customer selectByLicenseNum(@Param("id") String id, @Param("uid") String uid,
            @Param("licenseNum") String licenseNum, @Param("domain") String domain);

    void update(CustomerModifyDTO customerModifyDTO);

    void deleteCustomer(@Param("domain") String domain, @Param("id") String id);

    List<CustomerDTO> queryAllCustomer(@Param("customer") CustomerQueryReq req, RowBounds rowBounds);

    List<CustomerDTO> queryBlackList(@Param("customer") CustomerQueryReq req, RowBounds rowBounds);

    List<CustomerDTO> queryCustomerByLicenseNum(@Param("domain") String domain, @Param("licenseNum") String licenseNum);

    Customer selectByPrimaryLicenseNum(@Param("licenseNum") String licenseNum, @Param("domain") String domain);

    Customer selectBlackListByLicenseNum(@Param("licenseNum") String licenseNum, @Param("domain") String domain);

}