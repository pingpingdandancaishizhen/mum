package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFIdNameVO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFMetaDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFMonthlyFee;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProduct;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProductShowVO;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFProductService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.api.vo.solution.dyc.MonthlyFee;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFProductDAO;

@Service("jfjd.productService")
public class JFProductServiceImpl implements JFProductService {

    @Autowired
    private JFProductDAO jFProductDAO;

    @Override
    public JFMetaDTO queryMeta(String prodType, String domain) {
        JFMetaDTO d = jFProductDAO.selectMeta(prodType, domain);
        return d;
    }

    @Override
    public Resp queryMonthlyFee(String productId) {
        JFProduct p = jFProductDAO.selectById(productId);
        if (p == null) {
            return Resp.buildErrorResponse("未获取到产品");
        }
        if (!p.getProductType().equals(ProductType.DYDK.getStatus())
                || !p.getMedium().equals(ProductMedium.C.getStatus())) {
            return Resp.buildErrorResponse("产品类型不是抵押车贷");
        }
        String dycFeeConfigStr = jFProductDAO.selectFeeConfigById(productId);
        if (StringUtils.isBlank(dycFeeConfigStr)) {
            return Resp.buildErrorResponse("未获取到产品费用配置");
        }
        DycFeeConfig config = JsonUtils.parseJSON(dycFeeConfigStr, DycFeeConfig.class);
        if (config == null || config.getMonthlyFee() == null || config.getMonthlyFee().size() <= 0) {
            return Resp.buildErrorResponse("未获取到产品月标配置");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        List<JFMonthlyFee> monthlyFeeList = new ArrayList<JFMonthlyFee>();
        for (MonthlyFee fee : config.getMonthlyFee()) {
            JFMonthlyFee bean = new JFMonthlyFee(fee);
            monthlyFeeList.add(bean);
        }
        result.put("list", monthlyFeeList);
        return new Resp(result);
    }

    @Override
    public List<JFIdNameVO> queryPartnerByProductId(String productId, String domain, String roleId) {
        List<JFIdNameVO> list = jFProductDAO.selectPartner(domain, productId, roleId);
        return list;
    }

    @Override
    public JFProduct queryProduct(String prodType) {
        JFProduct jf = jFProductDAO.selectById(prodType);
        return jf;
    }

    @Override
    public Map<String, Object> queryProducts(String corpId) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<JFProductShowVO> list = jFProductDAO.queryProducts(corpId);
        result.put("list", list);
        return result;
    }

}
