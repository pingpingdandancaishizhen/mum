package cn.sunfit.risk.buz.server.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
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
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.RoleIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.RoleProductIdDTO;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerQueryReq;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerRoleRelSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerConfigShowVO;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.buz.api.vo.system.partner.RoleConfigShowVO;
import cn.sunfit.risk.buz.server.dao.system.ContractPartnerDAO;

@Service("risk.contractPartnerService")
public class ContractPartnerServiceImpl implements ContractPartnerService {

    @Autowired
    private ContractPartnerDAO contractPartnerDAO;

    @Override
    public void deletePartner(PartnerIdDTO partnerDisableDTO) {
        contractPartnerDAO.removePartnerRoleRel(partnerDisableDTO);
        contractPartnerDAO.deletePartner(partnerDisableDTO);
    }

    @Override
    public int getExisitNameCount(CheckExisitNameCountReq req) {
        return contractPartnerDAO.getExisitNameCount(req);
    }

    private List<PartnerListVO> getPartnerList(ContractPartnerQueryReq req) {
        List<PartnerListVO> result = contractPartnerDAO.queryList(req, new RowBounds(req.getOffset(), req.getLimit()));
        return result;
    }

    @Override
    public List<PartnerSelectVO> queryAllPartnerList(String domain) {
        return contractPartnerDAO.queryAllPartnerList(domain);
    }

    @Override
    public List<RoleConfigShowVO> queryAllRoles(String domain) {
        List<RoleConfigShowVO> roleList = contractPartnerDAO.queryAllRoles(domain);
        if (roleList != null && roleList.size() > 0) {
            for (RoleConfigShowVO role : roleList) {
                RoleIdDTO dto = new RoleIdDTO(domain, role.getId());
                role.setPartnerList(contractPartnerDAO.queryPartnerByRole(dto));
            }
        }
        return roleList;
    }

    @Override
    public List<PartnerProductRel> queryConfigByProduct(ProductIdDTO dto) {
        return contractPartnerDAO.queryConfigByProduct(dto);
    }

    @Override
    public int queryExisitCount(PartnerIdDTO partnerIdDTO) {
        return contractPartnerDAO.queryExisitCount(partnerIdDTO);
    }

    @Override
    public List<PartnerSelectVO> queryLenderPartnerByProduct(String productId, String domain) {
        return contractPartnerDAO.queryLenderPartnerByProduct(productId, domain);
    }

    @Override
    public RespPage<List<PartnerListVO>> queryList(ContractPartnerQueryReq contractPartnerQueryReq) {
        List<PartnerListVO> partnerList = getPartnerList(contractPartnerQueryReq);
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<PartnerListVO>>(partnerList, totalCount);
    }

    @Override
    public List<PartnerConfigShowVO> queryPartnerByProductId(String domain, String productId, String roleId) {
        List<PartnerConfigShowVO> list = contractPartnerDAO.queryPartnerByRoleAndProduct(new RoleProductIdDTO(domain,
                roleId, productId));
        return list;
    }

    @Override
    public List<PartnerRole> queryPartnerRoleList(String domain) {
        return contractPartnerDAO.queryPartnerRoleList(domain);
    }

    @Override
    public List<PartnerSelectVO> queryPartnersByBp(String bpId, String domain) {
        return contractPartnerDAO.queryPartnersByBp(bpId, domain);
    }

    @Override
    public List<RoleConfigShowVO> queryRolesByProduct(ProductIdDTO dto) {
        List<RoleConfigShowVO> roleList = contractPartnerDAO.queryRolesByProduct(dto);
        if (roleList != null && roleList.size() > 0) {
            for (RoleConfigShowVO role : roleList) {
                role.setPartnerList(contractPartnerDAO.queryPartnerByRoleAndProduct(new RoleProductIdDTO(dto
                        .getDomain(), role.getId(), dto.getProductId())));
            }
        }
        return roleList;
    }

    @Override
    public List<PartnerSelectVO> querySelectedPartners(TempIdDTO tempIdDTO) {
        return contractPartnerDAO.querySelectedPartners(tempIdDTO);
    }

    @Override
    public List<PartnerRole> querySelectRoles(PartnerIdDTO partnerIdDTO) {
        return contractPartnerDAO.querySelectRoles(partnerIdDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Resp saveContractPartner(ContractPartnerSaveReq req) {
        ContractPartnerAddDTO contractPartnerDTO = req.copyToBaseDTO();
        if (StringUtils.isBlank(contractPartnerDTO.getId())) {
            contractPartnerDTO.setId(IdUtil.geneId());
            contractPartnerDAO.addPartner(contractPartnerDTO);
            ContractPartnerRoleRelSaveReq relReq = new ContractPartnerRoleRelSaveReq(contractPartnerDTO.getId(),
                    req.getRoleIds(), req.getDomain());
            contractPartnerDAO.addPartnerRoleRel(relReq);
        } else {
            List<Map<String, String>> reslult = new ArrayList<Map<String, String>>();
            List<PartnerProductVO> relList = contractPartnerDAO.queryExisitProductRel(new PartnerIdDTO(req.getDomain(),
                    contractPartnerDTO.getId()));
            if (relList != null && relList.size() > 0 && req.getRoleIds() != null) {
                for (PartnerProductVO rel : relList) {
                    if (!req.getRoleIds().contains(rel.getRoleId())) {
                        Map<String, String> bean = new HashMap<String, String>();
                        bean.put("role", rel.getRoleName());
                        bean.put("product", rel.getProductName());
                        reslult.add(bean);
                    }
                }
            }
            if (reslult.size() > 0) {
                String retStr = "";
                for (Map<String, String> bean : reslult) {
                    retStr += "[" + bean.get("product") + "-" + bean.get("role") + "]";
                }
                return Resp.buildErrorResponse("产品配置中配有以下参与方：" + retStr + "，请先取消产品中的配置");
            } else {
                contractPartnerDAO.updatePartner(contractPartnerDTO);
                ContractPartnerRoleRelSaveReq relReq = new ContractPartnerRoleRelSaveReq(contractPartnerDTO.getId(),
                        req.getRoleIds(), req.getDomain());
                contractPartnerDAO.removePartnerRoleRel(new PartnerIdDTO(req.getDomain(), contractPartnerDTO.getId()));
                contractPartnerDAO.addPartnerRoleRel(relReq);
            }
        }
        return new Resp();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Resp savePartnerProductRels(PartnerProductRelSaveDTO dto) {
        List<Map<String, String>> reslult = new ArrayList<Map<String, String>>();
        // 校验新的参与方配置是否去掉了合同模板中已选的配置
        List<ExisitPartnerVO> exisitList = contractPartnerDAO.queryPartnerByProduct(new ProductIdDTO(dto.getDomain(),
                dto.getProductId()));
        if (dto.getRelList() == null || dto.getRelList().size() <= 0) {
            return Resp.buildErrorResponse("参数错误");
        }
        if (exisitList != null && exisitList.size() > 0) {
            for (ExisitPartnerVO vo : exisitList) {
                boolean flag = true;
                for (PartnerProductRel rel : dto.getRelList()) {
                    if (StringUtils.isNotBlank(rel.getPartnerId()) && rel.getPartnerId().equals(vo.getId())
                            && StringUtils.isNotBlank(rel.getRoleId()) && rel.getRoleId().equals(vo.getRole())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    Map<String, String> bean = new HashMap<String, String>();
                    bean.put("role", vo.getRoleName());
                    bean.put("partner", vo.getName());
                    reslult.add(bean);
                }
            }
        }
        if (reslult.size() > 0) {
            String retStr = "";
            for (Map<String, String> bean : reslult) {
                retStr += "[" + bean.get("role") + "-" + bean.get("partner") + "]";
            }
            return Resp.buildErrorResponse("合同模板配置中配有以下参与方：" + retStr + "，请先取消模板中的配置");
        } else {
            contractPartnerDAO.removePartnerProductRel(dto);
            contractPartnerDAO.addPartnerProductRel(dto);
            return new Resp();
        }
    }

    @Override
    public ContractPartner selectContractPartner(PartnerIdDTO partnerIdDTO) {
        ContractPartner cs = contractPartnerDAO.selectPartner(partnerIdDTO);
        if (cs != null) {
            cs.setRoles(contractPartnerDAO.querySelectRoles(partnerIdDTO));
        }
        return cs;
    }

}
