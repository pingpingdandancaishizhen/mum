package cn.sunfit.risk.credit.server.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import cn.fraudmetrix.riskservice.RuleDetailClient;
import cn.fraudmetrix.riskservice.RuleDetailResult;
import cn.fraudmetrix.riskservice.object.Environment;
import cn.fraudmetrix.riskservice.ruledetail.BlackListDetail;
import cn.fraudmetrix.riskservice.ruledetail.BlackListHit;
import cn.sunfit.risk.credit.api.beans.Resp;
import cn.sunfit.risk.credit.api.constant.ResponseStatus;
import cn.sunfit.risk.credit.api.service.TDService;
import cn.sunfit.risk.credit.api.vo.FraudApiResponse;
import cn.sunfit.risk.credit.api.vo.td.TDQuery;
import cn.sunfit.risk.credit.server.util.FraudApiInvoker;
import cn.sunfit.risk.credit.server.util.ServerConfig;

/**
 * 同盾接口
 * @Title: TDServiceImpl.java
 * @Package cn.sunfit.risk.credit.server.service
 * @Description: TODO
 * @author XJ
 * @date 2017年4月24日 下午2:32:12
 * @version V1.0
 */
@Path("td")
@Service("credit.TDService")
public class TDServiceImpl implements TDService {

    private static final Logger logger = Logger.getLogger(TDServiceImpl.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        String partnerCode = "rongjinsuo";
        String partnerKey = "18543d2174704e6d9003401fe3166f9f";
        String sequenceId = "1493365733099414S180F2F6E5188780";

        Environment env = Environment.PRODUCT; // Environment.PRODUCT表示调用生产环境, 测试环境请修改为Environment.SANDBOX

        // 调用接口
        RuleDetailClient client = RuleDetailClient.getInstance(partnerCode, env);
        RuleDetailResult result = client.execute(partnerKey, sequenceId);
        if (result == null)
            return;

        // 样例：获取风险名单命中的数据
        List<BlackListDetail> find = result.find(BlackListDetail.class);
        for (BlackListDetail e : find) {
            List<BlackListHit> hits = e.getHits();
            for (BlackListHit hit : hits) {
                // hit中包含了命中风险名单的具体信息
                System.out.println(hit);
            }
        }
    }

    @POST
    @Path("getInfo")
    @Override
    public String getInfo(String req) {
        Resp resp = new Resp();
        TDQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, TDQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            try {
                String partnerCode = ServerConfig.RISK_FRAUDMETRIX_PARTNERCODE;
                String partnerKey = ServerConfig.RISK_FRAUDMETRIX_SECRETKEY;
                Environment env = Environment.PRODUCT; // Environment.PRODUCT表示调用生产环境, 测试环境请修改为Environment.SANDBOX
                RuleDetailClient client = RuleDetailClient.getInstance(partnerCode, env);
                // 调用接口
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("event_id", "loan_off");// 此处填写策略集上的事件标识
                params.put("id_number", ob.getIdcard());// 此处填写策略集上的事件标识
                params.put("account_name", ob.getName());// 此处填写策略集上的事件标识
                params.put("account_mobile", ob.getPhone());// 此处填写策略集上的事件标识
                FraudApiResponse apiResp = new FraudApiInvoker().invoke(params);
                RuleDetailResult result = client.execute(partnerKey, apiResp.getSeq_id());

                resp.setData(result);
            } catch (Exception e) {
                logger.error(e);
                resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
            }
            return JSONObject.fromObject(resp).toString();
        }

        // // 样例：获取风险名单命中的数据
        // List<BlackListDetail> find = result.find(BlackListDetail.class);
        // for (BlackListDetail e : find) {
        // List<BlackListHit> hits = e.getHits();
        // for (BlackListHit hit : hits) {
        // // hit中包含了命中风险名单的具体信息
        // System.out.println(hit);
        // }
        // }
        // resp.setData(result);
        return JSONObject.fromObject(resp).toString();
    }

    @POST
    @Path("query")
    @Override
    public String query(String req) {
        Resp resp = new Resp();
        JSONObject ob = null;
        Map<String, Object> params = new HashMap<String, Object>();
        try {
            ob = JSONObject.fromObject(req);
            params.put("event_id", "loan_off");// 此处填写策略集上的事件标识
            params.put("id_number", ob.get("idNumber").toString());// 此处填写策略集上的事件标识
            params.put("account_name", ob.get("accountName").toString());// 此处填写策略集上的事件标识
            params.put("account_mobile", ob.get("accountMobile").toString());// 此处填写策略集上的事件标识
            FraudApiResponse apiResp = new FraudApiInvoker().invoke(params);
            resp.setData(apiResp);
        } catch (IOException e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(e.getMessage());
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        return JSONObject.fromObject(resp).toString();
    }
}
