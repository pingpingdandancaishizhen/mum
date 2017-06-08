package cn.sunfit.risk.credit.server.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.DateUtils;
import orj.worf.util.JsonUtils;
import cn.sunfit.risk.credit.api.beans.ApiLog;
import cn.sunfit.risk.credit.api.beans.Resp;
import cn.sunfit.risk.credit.api.constant.ResponseStatus;
import cn.sunfit.risk.credit.api.service.CJDService;
import cn.sunfit.risk.credit.api.vo.cjd.BuyMantinceHistoryQuery;
import cn.sunfit.risk.credit.api.vo.cjd.CheckBrandQuery;
import cn.sunfit.risk.credit.api.vo.cjd.OrderInfoQuery;
import cn.sunfit.risk.credit.api.vo.cjd.ReportDataQuery;
import cn.sunfit.risk.credit.server.dao.ApiLogDAO;
import cn.sunfit.risk.credit.server.util.CommonHttpUtils;
import cn.sunfit.risk.credit.server.util.IdUtil;
import cn.sunfit.risk.credit.server.util.ServerConfig;
import cn.sunfit.risk.credit.server.util.SignUtils;

/**
 * 车鉴定接口
 * @Title: CJDServiceImpl.java
 * @Package cn.sunfit.risk.credit.server.service
 * @author RJS
 * @date 2017年4月10日 下午5:12:06
 * @version V1.0
 */
@Path("cjd")
@Service("credit.CJDService")
public class CJDServiceImpl implements CJDService {

    private static final Logger logger = Logger.getLogger(CJDServiceImpl.class);

    @Autowired
    private ApiLogDAO apiLogDAO;

    /**
     * 查询账户信息
     * @return
     */
    @POST
    @Path("accountInfo")
    @Override
    public String accountInfo() {
        Resp resp = new Resp();
        Map<String, Object> result = new HashMap<String, Object>();
        String url = ServerConfig.CJD_SERVICE_URL + "/rest/publicif/accountInfo";
        String uid = ServerConfig.CJD_SERVICE_USER_NAME;
        String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
        String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
        String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
        String data = uid + time + pwd;
        try {
            String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
            String[] keys = { "uid", "time", "sign" };
            String[] values = { uid, time, sign };
            String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
            JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");
            if ("1".equals(jo.get("status"))) {
                resp.setMessage(jo.get("message").toString());
                result.put("balance", jo.get("balance"));
                resp.setData(result);
            } else {
                resp = Resp.buildErrorResponse(jo.get("message").toString());
            }
        } catch (Exception e) {
            resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
        }
        saveLog("accountInfo", "", JSONObject.fromObject(resp).toString(), false);
        return JSONObject.fromObject(resp).toString();
    }

    /**
     * 查询支持品牌信息
     * @return
     */
    @POST
    @Path("brandList")
    @Override
    public String brandList() {
        Resp resp = new Resp();
        String url = ServerConfig.CJD_SERVICE_URL + "/rest/publicif/brandList";
        String uid = ServerConfig.CJD_SERVICE_USER_NAME;
        String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
        String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
        String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
        String data = uid + time + pwd;
        try {
            String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
            String[] keys = { "uid", "time", "sign" };
            String[] values = { uid, time, sign };
            String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
            JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");

            if ("1".equals(jo.get("status"))) {
                resp.setMessage(jo.get("message").toString());
                resp.setData(JSONObject.fromObject(rs).getJSONArray("data"));
            } else {
                resp = Resp.buildErrorResponse(jo.get("message").toString());
            }
        } catch (Exception e) {
            resp = Resp.buildErrorResponse("系统错误,请联系管理员");
        }
        saveLog("brandList", "", JSONObject.fromObject(resp).toString(), false);
        return JSONObject.fromObject(resp).toString();
    }

    /**
     * <p>Description:根据车辆识别码 购买维修记录 </p>
     * @author XJ 2017年4月11日 
     * @param req
     * @return
     * @see cn.sunfit.risk.credit.api.service.CJDService#buyMantinceHistory(java.lang.String)
     */
    @POST
    @Path("buyMantinceHistory")
    @Override
    public String buyMantinceHistory(String req) {
        Resp resp = new Resp();
        BuyMantinceHistoryQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, BuyMantinceHistoryQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            String url = ServerConfig.CJD_SERVICE_URL + "/publicif/2.0/buy";
            String uid = ServerConfig.CJD_SERVICE_USER_NAME;
            String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
            String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
            String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
            String data = uid + ob.getVin() + time + pwd;
            try {
                String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
                String[] keys = { "uid", "vin", "time", "sign" };
                String[] values = { uid, ob.getVin(), time, sign };
                String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
                JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");
                if ("1".equals(jo.get("status"))) {
                    resp.setMessage(jo.get("message").toString());
                    result.put("orderId", jo.get("orderId"));
                    resp.setData(result);
                } else {
                    resp = Resp.buildErrorResponse(jo.get("message").toString());
                }
            } catch (Exception e) {
                resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
            }
            saveLog("buyMantinceHistory", req, JSONObject.fromObject(resp).toString(), false);
        }
        return JSONObject.fromObject(resp).toString();
    }

    /**
     * 根据车架号查询是否支持该品牌
     * @param vinCode
     * @return
     */
    @POST
    @Path("checkBrand")
    @Override
    public String checkBrand(String req) {
        Resp resp = new Resp();
        CheckBrandQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, CheckBrandQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            String url = ServerConfig.CJD_SERVICE_URL + "/rest/publicif/checkBrand";
            String uid = ServerConfig.CJD_SERVICE_USER_NAME;
            String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
            String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
            String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
            String data = uid + ob.getVin() + time + pwd;
            try {
                String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
                String[] keys = { "uid", "vin", "time", "sign" };
                String[] values = { uid, ob.getVin(), time, sign };
                String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
                JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");
                if ("1".equals(jo.get("status"))) {
                    resp.setMessage(jo.get("message").toString());
                    resp.setData(result);
                } else {
                    resp = Resp.buildErrorResponse(jo.get("message").toString());
                }
            } catch (Exception e) {
                resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
            }
            saveLog("checkBrand", req, JSONObject.fromObject(resp).toString(), false);
        }
        return JSONObject.fromObject(resp).toString();
    }

    /**
     * 查询订单状态
     * @param vinCode
     * @return
     */
    @POST
    @Path("orderInfo")
    @Override
    public String orderInfo(String req) {
        Resp resp = new Resp();
        OrderInfoQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, OrderInfoQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            String url = ServerConfig.CJD_SERVICE_URL + "/rest/publicif/orderInfo";
            String uid = ServerConfig.CJD_SERVICE_USER_NAME;
            String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
            String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
            String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
            String data = uid + ob.getOrderId() + time + pwd;
            try {
                String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
                String[] keys = { "uid", "orderId", "time", "sign" };
                String[] values = { uid, ob.getOrderId(), time, sign };
                String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
                JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");
                if ("1".equals(jo.get("status"))) {
                    resp.setMessage(jo.get("message").toString());
                    result.put("orderStatus", jo.get("orderStatus"));
                    resp.setData(result);
                } else {
                    resp = Resp.buildErrorResponse(jo.get("message").toString());
                }
            } catch (Exception e) {
                resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
            }
            saveLog("orderInfo", req, JSONObject.fromObject(resp).toString(), false);
        }
        return JSONObject.fromObject(resp).toString();
    }

    @POST
    @Path("reportData")
    @Override
    public String reportData(String req) {
        Resp resp = new Resp();
        ReportDataQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, ReportDataQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            String url = ServerConfig.CJD_SERVICE_URL + "/rest/publicif/2.0/reportData";
            String uid = ServerConfig.CJD_SERVICE_USER_NAME;
            String pwd = ServerConfig.CJD_SERVICE_PASSWORD;
            String privk = ServerConfig.CJD_SERVICE_PRIVATE_KEY;
            String time = DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date());
            String data = uid + ob.getOid() + time + pwd;
            try {
                String sign = SignUtils.sign(data.getBytes("utf-8"), privk);
                String[] keys = { "uid", "oid", "time", "sign" };
                String[] values = { uid, ob.getOid(), time, sign };
                String rs = CommonHttpUtils.HttpClientPost(url, "utf-8", keys, values);
                JSONObject jo = JSONObject.fromObject(rs).getJSONObject("info");
                if ("1".equals(jo.get("status"))) {
                    resp.setMessage(jo.get("message").toString());
                    result.put("orderStatus", jo.get("orderStatus"));
                    resp.setData(result);
                } else {
                    resp = Resp.buildErrorResponse(jo.get("message").toString());
                }
            } catch (Exception e) {
                resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
            }
            saveLog("reportData", req, JSONObject.fromObject(resp).toString(), false);
        }
        return JSONObject.fromObject(resp).toString();
    }

    private void saveLog(String apiName, String req, String resp, boolean cached) {
        ApiLog log = new ApiLog();
        log.setId(IdUtil.geneId());
        log.setApiName(apiName);
        log.setApiPlatform("cjd");
        log.setReq(req);
        log.setReqTime(new Date());
        log.setResp(resp);
        log.setCached(cached);
        apiLogDAO.insert(log);
    }
}
