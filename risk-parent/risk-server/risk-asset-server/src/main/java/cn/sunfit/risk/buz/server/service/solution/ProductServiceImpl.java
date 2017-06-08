package cn.sunfit.risk.buz.server.service.solution;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductCorpVO;
import cn.sunfit.risk.buz.api.vo.solution.ProductModifyReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.api.vo.solution.dyc.MonthlyFee;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.solution.ProductDAO;

@Service("risk.productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private BPMetaDAO bpMetaDAO;

    @Override
    public void modifyFeeConfig(String productId, String feeConfig, String corpId) throws ServiceException {
        long count = productDAO.countByCorpIdProductId(corpId, productId);
        if (count == 0) {
            throw new ServiceException("您无权修改该产品");
        }
        Product p = productDAO.selectByPrimaryKey(productId);
        if (p.getProductType().equals(ProductType.DYDK.getStatus())
                && p.getMedium().equals(ProductMedium.C.getStatus())) {
            // 抵押车贷 修改
            DycFeeConfig config = JsonUtils.parseJSON(feeConfig, DycFeeConfig.class);
            // 修改CONfig
            productDAO.updateFeeConfig(productId, JsonUtils.toJSON(config));
        }
    }

    @Override
    public String queryFeeConfig(String productId) {
        String feeConfig = productDAO.selectFeeConfig(productId);
        return feeConfig;
    }

    @Override
    public BpMetaCorpProductVO queryMetaByProduct(BpMetaQueryReq s) {
        BpMetaCorpProductVO vo = bpMetaDAO.selectMetaByProduct(s);
        return vo;
    }

    @Override
    public List<MonthlyFee> queryMonthlyFee(String productId) {
        Product p = productDAO.selectByPrimaryKey(productId);
        if (p != null && p.getProductType().equals(ProductType.DYDK.getStatus())
                && p.getMedium().equals(ProductMedium.C.getStatus())) {
            String dycFeeConfigStr = productDAO.selectFeeConfig(productId);
            if (StringUtils.isNotBlank(dycFeeConfigStr)) {
                DycFeeConfig config = JsonUtils.parseJSON(dycFeeConfigStr, DycFeeConfig.class);
                if (config != null && config.getMonthlyFee() != null && config.getMonthlyFee().size() > 0) {
                    return config.getMonthlyFee();
                }
            }
        }
        return null;
    }

    @Override
    public RespPage<List<ProductCorpVO>> queryProductByCorp(ProductQueryReq req) {
        List<ProductCorpVO> list = productDAO.selectProductByCorp(req, new RowBounds(req.getOffset(), req.getLimit()));
        int row = CountHelper.getTotalRow();
        return new RespPage<List<ProductCorpVO>>(list, row);
    }

    @Override
    public List<Product> queryProductByCorpId(String corpId) {
        List<Product> list = productDAO.selectProductByCorpId(corpId);
        return list;
    }

    @Override
    public void updateProduct(ProductModifyReq req) throws ServiceException {
        // 判断公司是否有该产品。产品其实应该是一个公司对应一个产品，一个产品对应一个公司
        long c = productDAO.countByCorpIdProductId(req.getCorpId(), req.getId());
        if (c == 0) {
            throw new ServiceException("公司没有该产品");
        }
        Product p = productDAO.selectByPrimaryKey(req.getId());
        p.setProductName(req.getProductName());
        p.setDesc(req.getDesc());
        p.setRequirements(req.getRequirements());
        productDAO.updateByPrimaryKey(p);
    }

}
