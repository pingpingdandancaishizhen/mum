package cn.sunfit.risk.buz.server.service.p2p.imp;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPAttr;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.constants.form.FormModelType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.p2p.activiti.SuperFormService;
import cn.sunfit.risk.buz.api.service.p2p.imp.ImportOrderService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ExcelToBeanResult;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportBean;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportError;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportResult;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;

@Service("risk.p2p.importOrderService")
public class ImportOrderServiceImpl implements ImportOrderService {

    Logger logger = LoggerFactory.getLogger(ImportOrderServiceImpl.class);

    @Autowired
    P2PProductService p2PProductService;

    @Autowired
    BPAttrDAO bpAttrDAO;

    @Autowired
    LoanInfoDAO loanInfoDAO;

    @Autowired
    private ImportOrderFactory factory;
    @Autowired
    private SuperFormService superFormService;
    @Autowired
    private BPMetaDAO bpMetaDAO;

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 120)
    public ImportResult importExcel(CorpUserDTO user, byte[] bytes, String productCode, String importCode)
            throws ServiceException {
        // 根据code查prodcut_type
        P2PProduct product = p2PProductService.findByProductCode(productCode, user.getDomain());
        String productType = null;
        BpMetaCorpProductVO meta = null;
        if (product != null) {
            productType = product.getProductType();
            meta = bpMetaDAO.selectMetaByProduct(new BpMetaQueryReq(productCode, true, user.getDomain()));
        } else {
            throw new ServiceException("获取产品类型失败");
        }
        // 根据productType 获取处理类
        ImportHandle h = factory.getHandle(productType);
        if (h == null) {
            throw new ServiceException("暂不支持此种类型P2P产品");
        }
        CydFeeConfig feeConfig = JsonUtils.parseJSON(product.getFeeConfig(), CydFeeConfig.class);
        // 转值 验证 插入
        try {
            ExcelToBeanResult result = h.excelToBean(user.getDomain(), user.getCorpId(), productCode, user.getId(),
                    importCode, new ByteArrayInputStream(bytes));
            List<ImportBean> importList = result.getImports();
            List<ImportError> errList = result.getErrors();
            boolean success = result.getSuccess();
            String message = result.getMessage();

            if (importList != null && importList.size() > 0) {
                for (ImportBean bean : importList) {
                    if (bean.getLoaninfo() != null) {
                        loanInfoDAO.insertLoanInfo(user.getDomain(), bean.getLoaninfo());
                    }
                    // if (bean.getAttrs() != null && bean.getAttrs().size() > 0) {
                    // for (BPAttr attr : bean.getAttrs()) {
                    // bpAttrDAO.insertAttr(attr);
                    // }
                    // }
                    this.submit2Flow(bean.getLoaninfo(), bean.getAttrs(), user, product, meta, feeConfig);
                }
            }
            return new ImportResult(success, importList == null ? 0 : importList.size(), errList, message);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("批量导入失败");
        }
    }

    private void submit2Flow(LoanInfoBean bean, List<BPAttr> attrs, CorpUserDTO user, P2PProduct p,
            BpMetaCorpProductVO meta, CydFeeConfig feeConfig) {
        FormQuery req = new FormQuery();
        req.setBpDefId(meta.getBpDefId());
        req.setBpDefKey(meta.getBpDefKey());
        req.setBpId(bean.getBpId());
        req.setCorpInfo(user);
        req.setModel(FormModelType.HANDLE.getTypeId());
        req.setProductId(p.getProductCode());
        req.setProductType(p.getProductType());
        req.setLoanInfoId(bean.getId().toString());
        Map<String, String> formdata = toMap(attrs);
        formdata.put("to_node", feeConfig.getAutoTypeCheck() == null ? "" : feeConfig.getAutoTypeCheck());
        superFormService.submit(req, formdata);
    }

    private Map<String, String> toMap(List<BPAttr> attrs) {
        Map<String, String> map = new HashMap<String, String>();
        for (BPAttr attr : attrs) {
            map.put(attr.getAttrName(), attr.getAttrValue());
        }
        return map;
    }
}
