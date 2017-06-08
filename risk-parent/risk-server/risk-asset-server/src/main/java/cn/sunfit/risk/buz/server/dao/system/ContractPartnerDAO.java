package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.CheckExisitNameCountReq;
import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartner;
import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartnerAddDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.ExisitPartnerVO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerListVO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRel;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRelSaveDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductVO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerRole;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerSigner;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.RoleIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.RoleProductIdDTO;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerQueryReq;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerRoleRelSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerConfigShowVO;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.buz.api.vo.system.partner.RoleConfigShowVO;

@Repository
public interface ContractPartnerDAO {

    int addPartner(ContractPartnerAddDTO contractPartnerDTO);

    int addPartnerProductRel(PartnerProductRelSaveDTO dto);

    int addPartnerRoleRel(ContractPartnerRoleRelSaveReq req);

    int deletePartner(PartnerIdDTO partnerIdDTO);

    int getExisitNameCount(CheckExisitNameCountReq req);

    List<PartnerSelectVO> queryAllPartnerList(@Param("domain") String domain);

    List<RoleConfigShowVO> queryAllRoles(@Param("domain") String domain);

    List<PartnerProductRel> queryConfigByProduct(ProductIdDTO dto);

    int queryExisitCount(PartnerIdDTO partnerIdDTO);

    List<PartnerProductVO> queryExisitProductRel(PartnerIdDTO dto);

    List<PartnerSelectVO> queryLenderPartnerByProduct(@Param("productId") String productId,
            @Param("domain") String domain);

    List<PartnerListVO> queryList(ContractPartnerQueryReq req, RowBounds rowBounds);

    List<ExisitPartnerVO> queryPartnerByProduct(ProductIdDTO dto);

    List<PartnerConfigShowVO> queryPartnerByRole(RoleIdDTO dto);

    List<PartnerConfigShowVO> queryPartnerByRoleAndProduct(RoleProductIdDTO dto);

    List<PartnerRole> queryPartnerRoleList(@Param("domain") String domain);

    List<PartnerSelectVO> queryPartnersByBp(@Param("bpId") String bpId, @Param("domain") String domain);

    List<RoleConfigShowVO> queryRolesByProduct(ProductIdDTO dto);

    List<PartnerSelectVO> querySelectedPartners(TempIdDTO tempIdDTO);

    List<PartnerRole> querySelectRoles(PartnerIdDTO partnerIdDTO);

    List<PartnerSigner> querySignerByProduct(ProductIdDTO dto);

    int removePartnerProductRel(PartnerProductRelSaveDTO dto);

    void removePartnerRoleRel(PartnerIdDTO partnerIdDTO);

    ContractPartner selectPartner(PartnerIdDTO partnerIdDTO);

    int updatePartner(ContractPartnerAddDTO contractPartnerDTO);
}