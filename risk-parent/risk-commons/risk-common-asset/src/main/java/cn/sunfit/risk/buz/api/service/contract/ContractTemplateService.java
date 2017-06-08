package cn.sunfit.risk.buz.api.service.contract;

import java.rmi.ServerException;
import java.util.List;

import cn.sunfit.risk.buz.api.beans.contract.CategoryVO;
import cn.sunfit.risk.buz.api.beans.contract.CheckTempNameExisitReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractFieldRel;
import cn.sunfit.risk.buz.api.beans.contract.ContractTemplate;
import cn.sunfit.risk.buz.api.beans.contract.FieldVO;
import cn.sunfit.risk.buz.api.beans.contract.ProductVO;
import cn.sunfit.risk.buz.api.beans.contract.QueryKeyDTO;
import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerRole;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.contract.ConTempQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ConTempSaveReq;

public interface ContractTemplateService {

    /**
     * 
     * @Title: disableTempById
     * @Description: 停用合同模板
     * @param @param id   
     * @return void 
     * @author RJS 2017年2月7日 
     * @throws
     */
    public void disableTempById(TempIdDTO tempIdDTO);

    /**
     * 
     * @Title: getCountByName
     * @Description: 获取已经存在的用户名个数
     * @param @param req
     * @param @return   
     * @return int 
     * @author RJS 2017年3月9日 
     * @throws
     */
    public int getCountByName(CheckTempNameExisitReq req);

    /**
     * 
     * @Title: queryCategorys
     * @Description: 查询合同字段模块
     * @param @param domain
     * @param @return   
     * @return List<CategoryVO> 
     * @author RJS 2017年2月20日 
     * @throws
     */
    List<CategoryVO> queryCategorys(String domain);

    /**
     * 
     * @Title: queryFields
     * @Description: 查询合同字段
     * @param @param queryKeyDTO
     * @param @return   
     * @return List<FieldVO> 
     * @author RJS 2017年2月20日 
     * @throws
     */
    List<FieldVO> queryFields(QueryKeyDTO queryKeyDTO);

    /**
     * 
     * @Title: queryList
     * @Description: 查询合同模板列表
     * @param @param req
     * @param @return   
     * @return List<ContractTemplate> 
     * @author RJS 2017年2月7日 
     * @throws
     */
    public RespPage<List<ContractTemplate>> queryList(ConTempQueryReq req);

    /**
     * 
     * @Title: queryProductList
     * @Description: 获取产品列表
     * @param @param corpId
     * @param @return   
     * @return List<ProductVO> 
     * @author RJS 2017年2月7日 
     * @throws
     */
    List<ProductVO> queryProductList(String corpId);

    /**
     * 
     * @Title: querySelectFieldRel
     * @Description: 获取已保存的字段配置
     * @param @param tempIdDTO
     * @param @return   
     * @return List<ContractFieldRel> 
     * @author RJS 2017年2月22日 
     * @throws
     */
    List<ContractFieldRel> querySelectFieldRel(TempIdDTO tempIdDTO);

    /**
     * 
     * @Title: querySelectRoles
     * @Description: 获取模板已经选择的合作方角色
     * @param @param tempIdDTO
     * @param @return   
     * @return List<PartnerRole> 
     * @author RJS 2017年2月20日 
     * @throws
     */
    List<PartnerRole> querySelectRoles(TempIdDTO tempIdDTO);

    /**
     * @throws ServerException 
     * 
     * @Title: save
     * @Description: 保存合同模板
     * @param @param contractTemplate   
     * @return void 
     * @author RJS 2017年2月7日 
     * @throws
     */
    public void save(ConTempSaveReq req) throws ServerException;

    /**
     * 
     * @Title: addContractFieldRel
     * @Description: TODO
     * @param @param tempId
     * @param @param relList   
     * @return void 
     * @author RJS 2017年2月20日 
     * @throws
     */
    public void saveContractFieldRel(TempIdDTO tempIdDTO, List<ContractFieldRel> relList);

    /**
     * 
     * @Title: selectById
     * @Description: 根据ID获取合同模板
     * @param @param id
     * @param @return   
     * @return ContractTemplate 
     * @author RJS 2017年2月7日 
     * @throws
     */
    public ContractTemplate selectById(TempIdDTO tempIdDTO);

}
