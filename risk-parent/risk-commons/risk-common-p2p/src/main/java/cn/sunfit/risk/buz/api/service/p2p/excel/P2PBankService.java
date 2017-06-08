package cn.sunfit.risk.buz.api.service.p2p.excel;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.p2p.P2PBank;

public interface P2PBankService {

    /**
     * 无条件查询所有的银行
     * @Title: findBank
     * @Description: TODO
     * @param @return   
     * @return List<P2PBank> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    public List<P2PBank> findBank();

    /**
        * 根据bankCode查询银行数据
        * @Title: findByBankCode
        * @Description: TODO
        * @param @param bankCode 银行编码
        * @param @return   
        * @return P2PBank 
        * @author wangguang 2017年5月24日 
        * @throws
        */
    public P2PBank findByBankCode(String bankCode);

    /**
     * 根据第三方支付类型查询所有银行
     * @Title: getBankByThirdType
     * @Description: TODO
     * @param @param thirdType 第三方支付类型
     * @param @return   
     * @return List<P2PBank> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    public List<P2PBank> getBankByThirdType(String thirdType);

    /**
     * 根据银行名称查询银行
     * @Title: getBankcodeByName
     * @Description: TODO
     * @param @param bankName 银行名称
     * @param @return   
     * @return String 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    public String getBankcodeByName(String bankName);

    /**
    * 无条件查询所有的银行
    * @Title: getBankList
    * @Description: TODO
    * @param @return   
    * @return List<Map<String,String>> 
    * @author wangguang 2017年5月15日 
    * @throws
    */
    public List<Map<String, String>> getBankList();
}
