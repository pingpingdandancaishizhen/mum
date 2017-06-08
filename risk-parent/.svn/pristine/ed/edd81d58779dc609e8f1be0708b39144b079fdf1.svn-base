package cn.sunfit.risk.buz.api.service.system;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.CheckExisitNameCountReq;
import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartner;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerListVO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRel;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRelSaveDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerRole;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerQueryReq;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerConfigShowVO;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.buz.api.vo.system.partner.RoleConfigShowVO;

public interface ContractPartnerService {

    /**
     * 
     * @Title: disablePartner
     * @Description: 停用合同合伙人
     * @param @param partnerId   
     * @return void 
     * @author RJS 2017年2月7日 
     * @throws
     */
    public void deletePartner(PartnerIdDTO partnerDisableDTO);

    /**
     * 
     * @Title: getExisitNameCount
     * @Description: 查询已存在的名字数量
     * @param @param req
     * @param @return   
     * @return int 
     * @author RJS 2017年3月10日 
     * @throws
     */
    int getExisitNameCount(CheckExisitNameCountReq req);

    /**
     * 
     * @Title: queryAllPartnerList
     * @Description: 获取所有合伙人
     * @param @return   
     * @return List<ContractSignature> 
     * @author RJS 2017年2月8日 
     * @throws
     */
    public List<PartnerSelectVO> queryAllPartnerList(String domain);

    /**
     * 
     * @Title: queryAllRoles
     * @Description: TODO
     * @param @param domain
     * @param @return   
     * @return List<RoleConfigShowVO> 
     * @author RJS 2017年3月1日 
     * @throws
     */
    public List<RoleConfigShowVO> queryAllRoles(String domain);

    /**
     * 
     * @Title: queryConfigByProduct
     * @Description: 查询已选择的关联
     * @param @param dto
     * @param @return   
     * @return List<PartnerProductRel> 
     * @author RJS 2017年3月1日 
     * @throws
     */
    List<PartnerProductRel> queryConfigByProduct(ProductIdDTO dto);

    /**
     * 
     * @Title: queryExisitCount
     * @Description: 查询参与方是否已经被使用
     * @param @param partnerIdDTO
     * @param @return   
     * @return int 
     * @author RJS 2017年2月25日 
     * @throws
     */
    public int queryExisitCount(PartnerIdDTO partnerIdDTO);

    /**
     * 
     * @Title: queryLenderPartnerByProduct
     * @Description: 根据产品获取放款平台
     * @param @param productId
     * @param @param domain
     * @param @return   
     * @return List<PartnerSelectVO> 
     * @author RJS 2017年4月27日 
     * @throws
     */
    List<PartnerSelectVO> queryLenderPartnerByProduct(String productId, String domain);

    /**
     * 
     * @Title: queryList
     * @Description: 查询合伙人
     * @param @param ContractPartnerQueryReq
     * @param @return   
     * @return RespPage<List<PartnerListVO>> 
     * @author RJS 2017年2月6日 
     * @throws
     */
    public RespPage<List<PartnerListVO>> queryList(ContractPartnerQueryReq contractPartnerQueryReq);

    public List<PartnerConfigShowVO> queryPartnerByProductId(String domain, String productId, String roleId);

    /**
     * 
     * @Title: querySignerRoleList
     * @Description: 获取所有合同方列表
     * @param @return   
     * @return List<SignatureType> 
     * @author RJS 2017年2月6日 
     * @throws
     */
    public List<PartnerRole> queryPartnerRoleList(String domain);

    /**
     * 
     * @Title: queryPartnersByBp
     * @Description: 根据订单ID获取【出借人】和【资金方】
     * @param @param dto
     * @param @return   
     * @return List<PartnerSelectVO> 
     * @author RJS 2017年3月14日 
     * @throws
     */
    List<PartnerSelectVO> queryPartnersByBp(String bpId, String domain);

    /**
     * 
     * @Title: queryRolesByProduct
     * @Description: TODO
     * @param @param domain
     * @param @return   
     * @return List<RoleConfigShowVO> 
     * @author RJS 2017年3月1日 
     * @throws
     */
    public List<RoleConfigShowVO> queryRolesByProduct(ProductIdDTO dto);

    /**
     * 
     * @Title: querySelectedSign
     * @Description: 获取合同模板已选的合伙人
     * @param @param tempId
     * @param @return   
     * @return List<ConSignVO> 
     * @author RJS 2017年2月8日 
     * @throws
     */
    List<PartnerSelectVO> querySelectedPartners(TempIdDTO tempIdDTO);

    /**
     * 
     * @Title: querySelectRoles
     * @Description: 获取已选择的参与方类别
     * @param @param partnerId
     * @param @return   
     * @return List<PartnerRole> 
     * @author RJS 2017年2月13日 
     * @throws
     */
    List<PartnerRole> querySelectRoles(PartnerIdDTO partnerIdDTO);

    /**
     * 
     * @Title: saveContractPartner
     * @Description: 保存合同方
     * @param @param ContractPartnerSaveReq   
     * @return void 
     * @author RJS 2017年2月6日 
     * @throws
     */
    public Resp saveContractPartner(ContractPartnerSaveReq req);

    /**
     * 
     * @Title: savePartnerProductRels
     * @Description: 保存产品参与方配置
     * @param @param dto   
     * @return void 
     * @author RJS 2017年3月1日 
     * @throws
     */
    public Resp savePartnerProductRels(PartnerProductRelSaveDTO dto);

    /**
     * 
     * @Title: selectContractPartner
     * @Description: 根据ID查询单个合伙人
     * @param @param id
     * @param @return   
     * @return ContractSignature 
     * @author RJS 2017年2月6日 
     * @throws
     */
    public ContractPartner selectContractPartner(PartnerIdDTO partnerIdDTO);
}
