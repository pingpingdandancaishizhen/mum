package cn.sunfit.risk.credit.server.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.credit.api.beans.ApiLog;
import cn.sunfit.risk.credit.api.beans.JxlCredit;
import cn.sunfit.risk.credit.api.beans.Resp;
import cn.sunfit.risk.credit.api.constant.ResponseStatus;
import cn.sunfit.risk.credit.api.service.JXLService;
import cn.sunfit.risk.credit.api.vo.jxl.JXLQuery;
import cn.sunfit.risk.credit.server.dao.ApiLogDAO;
import cn.sunfit.risk.credit.server.dao.JxlCreditDAO;
import cn.sunfit.risk.credit.server.util.HttpClientUtils;
import cn.sunfit.risk.credit.server.util.IdUtil;
import cn.sunfit.risk.credit.server.util.JsonUtil;
import cn.sunfit.risk.credit.server.util.ServerConfig;

@Path("jxl")
@Service("credit.JXLService")
public class JXLServiceImpl implements JXLService {

    private static final Logger logger = Logger.getLogger(JXLServiceImpl.class);

    @Autowired
    private JxlCreditDAO JxlCreditDAO;

    @Autowired
    private ApiLogDAO apiLogDAO;

    @Override
    @POST
    @Path("query")
    public String query(String req) {
        Resp resp = new Resp();
        JXLQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, JXLQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            JxlCredit record = new JxlCredit();
            record.setName(ob.getName());
            record.setIdcard(ob.getIdcard());
            record.setPhone(ob.getPhone());
            record = JxlCreditDAO.selectCreditResultCurDate(record);
            if (record != null) {
                try {
                    resp.setData(JsonUtil.nonDefaultMapper().fromJson(new String(record.getResult(), "UTF-8"),
                            Map.class));
                } catch (UnsupportedEncodingException e) {
                    resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
                }
                saveLog("query", req, JSONObject.fromObject(resp).toString(), true);
            } else {
                Map<String, Object> map = new HashMap<String, Object>();
                try {
                    // 通过接口向聚信立查询用户基本信息获取报告状态
                    map.put("org_name", ServerConfig.JXL_SERVICE_ORG_NAME);
                    map.put("access_token", ServerConfig.JXL_SERVICE_ACCESS_TOKEN);
                    map.put("client_secret", ServerConfig.JXL_SERVICE_CLIENT_SECRET);
                    map.put("name", ob.getName());
                    map.put("idcard", ob.getIdcard());
                    map.put("phone", ob.getPhone());
                    Map<String, Object> resultMap = HttpClientUtils.httpGet(map, ServerConfig.JXL_SERVICE_URL
                            + "/access_report_data");
                    if (resultMap != null && "true".equals(resultMap.get("success"))) {
                        record = new JxlCredit();
                        record.setQueryTime(new Date());
                        record.setName(ob.getName());
                        record.setIdcard(ob.getIdcard());
                        record.setPhone(ob.getPhone());
                        record.setResult(JsonUtil.nonDefaultMapper().toJson(resultMap).getBytes("UTF-8"));
                        JxlCreditDAO.insert(record);
                    }
                    resp.setData(resultMap);
                } catch (Exception e) {
                    logger.error(e);
                    resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
                }
                saveLog("query", req, JSONObject.fromObject(resp).toString(), false);
            }
        }
        return JSONObject.fromObject(resp).toString();
    }

    private void saveLog(String apiName, String req, String resp, boolean cached) {
        ApiLog log = new ApiLog();
        log.setId(IdUtil.geneId());
        log.setApiName(apiName);
        log.setApiPlatform("jxl");
        log.setReq(req);
        log.setReqTime(new Date());
        log.setResp(resp);
        log.setCached(cached);
        apiLogDAO.insert(log);
    }

}
