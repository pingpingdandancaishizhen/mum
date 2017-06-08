package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.corp.CustContact;
import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerAddDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerModifyDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerQueryReq;

public interface CustomerService {

    boolean checkCustomerExist(String id, String uid, String licenseNum, String domain);

    /**
     * 删除客户 软删除,修改状态
     * @Title: deleteCustomer
     * @Description: TODO
     * @param @param domain
     * @param @param id   
     * @return void 
     * @author RJS 2017年1月3日 
     * @throws
     */
    void deleteCustomer(String domain, String id, String uid);

    String insert(CustomerAddDTO customer, List<CustContact> custContacts, String domain);

    RespPage<List<CustomerDTO>> queryAllCustomer(CustomerQueryReq req);

    RespPage<List<CustomerDTO>> queryBlackList(CustomerQueryReq req);

    RespPage<List<CustomerDTO>> queryCustomerList(CustomerQueryReq req);

    Customer selectByPrimaryKey(String id, String domain);

    Customer selectByPrimaryLicenseNum(String licenseNum, String domain);

    List<CustContact> selectCustContactsByCustId(String custId, String domain);

    void update(CustomerModifyDTO customerModifyDTO, List<CustContact> custContacts, String domain);

    /**
     * 
     * @Title: autoSaveCustomer
     * @Description: 借款登记没有选择客户的话就自动创建一个客户
     * @param @param formdata   
     * @return String 
     * @author zhaoziyu 2017年5月8日 
     * @throws
     */
    String autoSaveCustomer(Map<String, String> formdata,CorpUserDTO user);
    
}
