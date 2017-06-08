package cn.sunfit.risk.buz.api.service.corp;

public interface BlackListService {

    void insert(String domain, String licenseNum, String uid);

    void delete(String domain, String licenseNum, String uid);

    boolean checkCustomerBlackList(String licenseNum, String domain);

}
