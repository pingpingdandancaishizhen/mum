package cn.sunfit.risk.buz.server.service.contract;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sunfit.risk.buz.api.beans.contract.ContractFieldRel;
import cn.sunfit.risk.buz.api.beans.contract.ContractLoadReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractResource;
import cn.sunfit.risk.buz.api.beans.contract.ContractResourceDTO;
import cn.sunfit.risk.buz.api.beans.contract.ContractResourceSaveReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractTemplate;
import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.contract.UpdateBPContractNoReq;
import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.OSSService;
import cn.sunfit.risk.buz.api.service.contract.ContractResourceService;
import cn.sunfit.risk.buz.api.service.product.contract.ProductContractService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.contract.ContractGenerateReq;
import cn.sunfit.risk.buz.api.vo.product.ProductContractReq;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.contract.ContractResourceDAO;
import cn.sunfit.risk.buz.server.dao.contract.ContractTemplateDAO;
import cn.sunfit.risk.buz.server.dao.corp.ResourcesDAO;
import cn.sunfit.risk.buz.server.util.ContractUtil;
import cn.sunfit.risk.buz.server.util.UrlUtil;
import cn.sunfit.risk.buz.server.util.entity.ContractFillContent;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

@Service("risk.contractResourceService")
public class ContractResourceServiceImpl implements ContractResourceService {

    @Autowired
    private ContractResourceDAO contractResourceDAO;

    @Autowired
    private ContractTemplateDAO contractTemplateDAO;

    @Autowired
    ResourcesDAO resourcesDAO;

    @Autowired
    private BPDAO bPDAO;

    @Autowired
    private OSSService ossServer;

    @Autowired
    private ProductContractService productContractService;

    @Autowired
    private BPLoanDAO bPLoanDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Resp generate(ContractGenerateReq req) throws ServiceException {
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        String productId = bPDAO.getProductByBpId(req.getBpId(), req.getDomain());
        int mainContractCount = contractTemplateDAO.queryMainCount(new ProductIdDTO(req.getDomain(), productId));
        if (mainContractCount < 1) {
            return Resp.buildErrorResponse("合同模板中暂未设置主合同，请先设置主合同");
        }
        List<ContractTemplate> tempList = contractTemplateDAO.queryListByProduct(new ProductIdDTO(req.getDomain(),
                productId));
        if (tempList != null && tempList.size() > 0) {
            Map<String, ContractField> fieldValues = productContractService
                    .getContractFieldsValue(new ProductContractReq(req.getDomain(), req.getBpId(), productId));
            // 清除旧的合同文件资源
            contractResourceDAO.removeContractResourceByBp(req.getBpId(), req.getDomain());
            for (ContractTemplate ct : tempList) {
                String contractNo = IdUtil.generateBPContratNo(productId);
                // 设置合同编号到替换值Map中
                fieldValues.put("he_tong_contract_no", new ContractField("he_tong_contract_no", contractNo,
                        ContractField.ITEM_TYPE_TEXT));
                List<ContractFieldRel> relList = contractTemplateDAO.querySelectFieldRel(new TempIdDTO(req.getDomain(),
                        ct.getId()));
                Resources result = resourcesDAO.selectById(req.getDomain(), ct.getFileResource());
                if (result == null || StringUtils.isBlank(result.getUrl())) {
                    throw new ServiceException("未获取到模板文件");
                }

                if (fieldValues == null || fieldValues.size() <= 0) {
                    throw new ServiceException("未获取到模板字段配置");
                }
                List<ContractFillContent> contractFillList = ContractUtil.createFillContentList(fieldValues, relList);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
                    String key = GlobalConstants.OSS_URL_HEADER
                            + result.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];

                    PdfReader reader = new PdfReader(ossServer.downloadFile(key));
                    PdfStamper stamp = new PdfStamper(reader, baos);
                    ContractUtil.contractSign(stamp, contractFillList.get(0), bf);
                    stamp.close();
                } catch (DocumentException e) {
                    throw new ServiceException("获取模板文件失败");
                } catch (IOException e1) {
                    throw new ServiceException("获取模板文件失败");
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String suffix = ct.getFileName().substring(ct.getFileName().lastIndexOf("."));
                String urlkey = UrlUtil.getUrl("webuploader", dateFormat.format(new Date()), suffix);
                System.out.println("urlkey---->" + urlkey);

                ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
                ossServer.uploadFile(urlkey, in);

                String coverUrl = ossServer.buildUrl(urlkey);
                // 保存全局Resource
                Resources resource = new Resources();
                String resourceId = IdUtil.geneId();
                resource.setCorpId(req.getCorpId());
                resource.setFileName(ct.getFileName());
                resource.setFileType(result.getFileType());
                resource.setUrl(coverUrl);
                resource.setUploadUserId(req.getUserId());
                resource.setBpId(req.getBpId());
                resource.setCategory(null);
                resource.setResourceId(resourceId);
                resource.setUpdateTime(new Date());
                resourcesDAO.insert(req.getDomain(), resource);

                // 保存合同Resource关联
                ContractResourceSaveReq crReq = new ContractResourceSaveReq();
                crReq.setTempId(ct.getId());
                crReq.setBpId(req.getBpId());
                if ("1".equals(ct.getMainFlag())) {
                    crReq.setContractType("main");
                } else {
                    crReq.setContractType("common");
                }
                crReq.setDomain(req.getDomain());
                crReq.setCorpId(req.getCorpId());
                crReq.setUserId(req.getUserId());
                crReq.setUserName(req.getUserName());
                crReq.setResourceId(resourceId);
                crReq.setContractNo(contractNo);
                crReq.setContractName(ct.getTemplateName());
                saveContractResource(crReq);
                if ("1".equals(ct.getMainFlag())) {
                    bPLoanDAO
                            .updateContractNoByBp(new UpdateBPContractNoReq(req.getDomain(), req.getBpId(), contractNo));
                }
                Map<String, String> m = new HashMap<String, String>();
                m.put("contractNo", contractNo);
                m.put("resourceId", resourceId);
                m.put("name", ct.getTemplateName());
                resultList.add(m);
            }
        }
        return new Resp(resultList);
    }

    @Override
    public ContractResource getByBpId(ContractLoadReq req) {
        return contractResourceDAO.getByBpId(req);
    }

    @Override
    public List<ContractResource> queryByBpId(String bpId, String domain) {
        return contractResourceDAO.queryByBpId(bpId, domain);
    }

    @Override
    public void saveContractResource(ContractResourceSaveReq req) {
        ContractResourceDTO crDTO = req.copyToEntity();
        crDTO.setId(IdUtil.geneId());
        contractResourceDAO.addContractResource(crDTO);
    }

}
