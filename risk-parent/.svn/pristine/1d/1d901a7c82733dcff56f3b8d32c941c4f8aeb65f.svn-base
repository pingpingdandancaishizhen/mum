package cn.sunfit.risk.buz.server.dao.contract;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.contract.CategoryVO;
import cn.sunfit.risk.buz.api.beans.contract.CheckTempNameExisitReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractFieldRel;
import cn.sunfit.risk.buz.api.beans.contract.ContractTemplate;
import cn.sunfit.risk.buz.api.beans.contract.ContractTemplateAddDTO;
import cn.sunfit.risk.buz.api.beans.contract.FieldVO;
import cn.sunfit.risk.buz.api.beans.contract.ProductVO;
import cn.sunfit.risk.buz.api.beans.contract.QueryKeyDTO;
import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerRole;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.vo.contract.ConTempQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.TempPartnerRelDTO;

@Repository
public interface ContractTemplateDAO {
    int addContractFieldRel(@Param("tempIdDTO") TempIdDTO tempIdDTO, @Param("relList") List<ContractFieldRel> relList);

    int addTempPartnerRel(TempPartnerRelDTO dto);

    int disableTempById(TempIdDTO tempIdDTO);

    int getCountByName(CheckTempNameExisitReq req);

    int insert(ContractTemplateAddDTO record);

    List<CategoryVO> queryCategorys(@Param("domain") String domain);

    List<FieldVO> queryFields(QueryKeyDTO queryKeyDTO);

    List<ContractTemplate> queryList(ConTempQueryReq req, RowBounds rowBounds);

    List<ContractTemplate> queryListByProduct(ProductIdDTO dto);

    int queryMainCount(ProductIdDTO dto);

    List<ProductVO> queryProductList(String corpId);

    List<ContractFieldRel> querySelectFieldRel(TempIdDTO tempIdDTO);

    List<PartnerRole> querySelectRoles(TempIdDTO tempIdDTO);

    int removeContractFieldRel(TempIdDTO tempIdDTO);

    void removeRel(TempPartnerRelDTO dto);

    ContractTemplate selectById(TempIdDTO tempIdDTO);

    int update(ContractTemplateAddDTO record);

    void updateOtherToCommon(ContractTemplateAddDTO record);

}