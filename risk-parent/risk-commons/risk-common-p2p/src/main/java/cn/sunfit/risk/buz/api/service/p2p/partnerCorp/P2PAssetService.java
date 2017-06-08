package cn.sunfit.risk.buz.api.service.p2p.partnerCorp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.P2PAsset;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetDTO;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetQueryReq;

public interface P2PAssetService {

    /**
     * 根据企业简称，资产方id校验是否企业简称重复
     * @Title: checkCorpAbbreviation
     * @Description: TODO
     * @param @param asset  企业简称，资产方id
     * @param @return   
     * @return List<P2PAsset> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PAsset> checkCorpAbbreviation(P2PAsset asset);

    /**
     * 根据公司名称，资产方id校验公司名称是否重复
     * @Title: checkCorpName
     * @Description: TODO
     * @param @param asset 公司名称，资产方id
     * @param @return   
     * @return List<P2PAsset> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PAsset> checkCorpName(P2PAsset asset);

    /**
     * 校验机构代码的重复性
     * @Title: checkInstitutionCode
     * @Description: TODO
     * @param @param asset 机构代码，资产方id
     * @param @return   
     * @return List<P2PAsset> 
     * @author wangguang 2017年5月17日 
     * @throws
     */
    List<P2PAsset> checkInstitutionCode(P2PAsset asset);

    /**
     * 插入资产方
     * @Title: insert
     * @Description: TODO
     * @param @param asset 资产方所有相关字段
     * @return void 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    void insert(P2PAsset asset);

    /**
     * 根据企业名称，状态，创建时间等筛选条件查询资产方
     * @Title: queryAssetList
     * @Description: TODO
     * @param @param req 企业名称，状态，创建时间等筛选条件
     * @param @return   
     * @return RespPage<List<P2PAssetDTO>> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    public RespPage<List<P2PAssetDTO>> queryAssetList(P2PAssetQueryReq req);

    /**
     * 根据资产方id查询
     * @Title: selectByPrimaryKey
     * @Description: TODO
     * @param @param id 资产方id
     * @param @param domain 域名
     * @param @return   
     * @return P2PAsset 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    P2PAsset selectByPrimaryKey(String id, String domain);

    /**
     * 更新资产方的所有相关字段数据
     * @Title: updateByPrimaryKey
     * @Description: TODO
     * @param @param asset   资产方的所有相关字段数据
     * @return void 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    void updateByPrimaryKey(P2PAsset asset);

}
