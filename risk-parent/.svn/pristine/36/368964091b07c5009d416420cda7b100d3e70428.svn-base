package cn.sunfit.risk.buz.server.service.contract;

import java.rmi.ServerException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
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
import cn.sunfit.risk.buz.api.service.contract.ContractTemplateService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.contract.ConTempQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ConTempSaveReq;
import cn.sunfit.risk.buz.server.dao.contract.ContractTemplateDAO;

@Service("risk.contractTemplateService")
public class ContractTemplateServiceImpl implements ContractTemplateService {

    @Autowired
    private ContractTemplateDAO contractTemplateDAO;

    @Override
    public void disableTempById(TempIdDTO tempIdDTO) {
        contractTemplateDAO.disableTempById(tempIdDTO);
    }

    @Override
    public int getCountByName(CheckTempNameExisitReq req) {
        return contractTemplateDAO.getCountByName(req);
    }

    private List<ContractTemplate> getTempList(ConTempQueryReq req) {
        List<ContractTemplate> result = contractTemplateDAO.queryList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        return result;
    }

    @Override
    public List<CategoryVO> queryCategorys(String domain) {
        return contractTemplateDAO.queryCategorys(domain);
    }

    @Override
    public List<FieldVO> queryFields(QueryKeyDTO queryKeyDTO) {
        return contractTemplateDAO.queryFields(queryKeyDTO);
    }

    @Override
    public RespPage<List<ContractTemplate>> queryList(ConTempQueryReq req) {
        List<ContractTemplate> result = getTempList(req);
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<ContractTemplate>>(result, totalCount);
    }

    @Override
    public List<ProductVO> queryProductList(String corpId) {
        return contractTemplateDAO.queryProductList(corpId);
    }

    @Override
    public List<ContractFieldRel> querySelectFieldRel(TempIdDTO tempIdDTO) {
        return contractTemplateDAO.querySelectFieldRel(tempIdDTO);
    }

    @Override
    public List<PartnerRole> querySelectRoles(TempIdDTO tempIdDTO) {
        return contractTemplateDAO.querySelectRoles(tempIdDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ConTempSaveReq req) throws ServerException {
        ContractTemplateAddDTO contractTemplateAddDTO = req.copyToDTO();
        if (StringUtils.isBlank(contractTemplateAddDTO.getId())) {
            contractTemplateAddDTO.setId(IdUtil.geneId());
            contractTemplateDAO.insert(contractTemplateAddDTO);
            req.setId(contractTemplateAddDTO.getId());
            contractTemplateDAO.addTempPartnerRel(req.copyToRelDTO());
        } else {
            contractTemplateDAO.update(contractTemplateAddDTO);
            contractTemplateDAO.removeRel(req.copyToRelDTO());
            contractTemplateDAO.addTempPartnerRel(req.copyToRelDTO());
        }
        if ("1".equals(contractTemplateAddDTO.getMainFlag())) {
            contractTemplateDAO.updateOtherToCommon(contractTemplateAddDTO);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveContractFieldRel(TempIdDTO tempIdDTO, List<ContractFieldRel> relList) {
        contractTemplateDAO.removeContractFieldRel(tempIdDTO);
        contractTemplateDAO.addContractFieldRel(tempIdDTO, relList);
    }

    @Override
    public ContractTemplate selectById(TempIdDTO tempIdDTO) {
        return contractTemplateDAO.selectById(tempIdDTO);
    }
}
