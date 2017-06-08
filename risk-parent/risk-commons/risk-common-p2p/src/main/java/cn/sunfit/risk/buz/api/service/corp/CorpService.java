package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.vo.corp.CorpLwInfoVO;
import cn.sunfit.risk.buz.api.vo.corp.CorpUpdateReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpVO;

public interface CorpService {
    /**
     * 
     * @Title: queryCorpInfo
     * @Description: 查询公司信息
     * @param @param corpId
     * @param @return   
     * @return CorpVO 
     * @author XFL 2017年2月15日 
     * @throws
     */
    CorpVO queryCorpInfo(String corpId);

    /**
     * 
     * @Title: selectCorpDomain
     * @Description: 查询所有公司domain
     * @param @return   
     * @return List<String> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    List<String> selectCorpDomain();

    /**
     * 
     * @Title: selectLwInfoByDomain
     * @Description: 查询公司对应乐位接口配置
     * @param @param domain
     * @return CorpLwInfoVO
     * @author XJ 2017年2月15日 
     * @throws
     */
    CorpLwInfoVO selectLwInfoByDomain(String domain);

    /**
     * 
     * @Title: updateCorpInfo
     * @Description: 修改公司信息
     * @param @param corp   
     * @return void 
     * @author XFL 2017年2月15日 
     * @throws
     */
    void updateCorpInfo(CorpUpdateReq corp);
}
