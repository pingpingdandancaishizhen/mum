package cn.sunfit.risk.credit.server.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.credit.api.beans.ApiLog;
import cn.sunfit.risk.credit.api.beans.NFCSCredit;
import cn.sunfit.risk.credit.api.beans.Resp;
import cn.sunfit.risk.credit.api.constant.ResponseStatus;
import cn.sunfit.risk.credit.api.service.NFCSService;
import cn.sunfit.risk.credit.api.vo.nfcs.NFCSQuery;
import cn.sunfit.risk.credit.server.dao.ApiLogDAO;
import cn.sunfit.risk.credit.server.dao.NFCSCreditDAO;
import cn.sunfit.risk.credit.server.util.IdUtil;
import cn.sunfit.risk.credit.server.util.JsonUtil;
import cn.sunfit.risk.credit.server.util.NfcsUtil;

@Path("nfcs")
@Service("credit.NFCSService")
public class NFCSServiceImpl implements NFCSService {

    private static final Logger logger = Logger.getLogger(NFCSServiceImpl.class);

    @Autowired
    private NFCSCreditDAO nfcsCreditDAO;

    @Autowired
    private ApiLogDAO apiLogDAO;

    @POST
    @Path("query")
    @Override
    public String query(String req) {
        Resp resp = new Resp();
        NFCSQuery ob = null;
        try {
            ob = JsonUtils.parseJSON(req, NFCSQuery.class);
        } catch (Exception e) {
            logger.error(e);
            resp = Resp.buildErrorResponse(ResponseStatus.PARAM_ERROR);
        }
        if (ob == null || !ob.validate()) {
            resp = Resp.buildErrorResponse(ResponseStatus.VALIDATION_ERROR);
        } else {
            NFCSCredit record = new NFCSCredit();
            record.setName(ob.getName());
            record.setIdcard(ob.getIdcard());
            record.setPlate(ob.getPlate());
            record = nfcsCreditDAO.selectCreditResultCurDate(record);
            if (record != null) {
                try {
                    resp.setData(JsonUtil.nonDefaultMapper().fromJson(new String(record.getResult(), "UTF-8"),
                            Map.class));
                } catch (UnsupportedEncodingException e) {
                    resp = Resp.buildErrorResponse(ResponseStatus.SYSTEM_ERROR);
                }
                saveLog("query", req, JSONObject.fromObject(resp).toString(), true);
            } else {
                try {
                    Map<String, String> apiResp = NfcsUtil.query(ob.getIdcard(), ob.getName(), ob.getPlate());
                    if (StringUtils.equals(apiResp.get("RESULT_CODE"), "ERR")) {
                        if (StringUtils.isNotEmpty(apiResp.get("VALUE"))) {
                            resp = Resp.buildErrorResponse(apiResp.get("VALUE"));
                        } else {
                            resp = Resp.buildErrorResponse(apiResp.get("MSG"));
                        }
                    } else {
                        resp.setData(new XMLSerializer().read(apiResp.get("VALUE")));
                        record = new NFCSCredit();
                        record.setQueryTime(new Date());
                        record.setName(ob.getName());
                        record.setIdcard(ob.getIdcard());
                        record.setPlate(ob.getPlate());
                        record.setResult(JsonUtil.nonDefaultMapper().toJson(resp.getData()).getBytes("UTF-8"));
                        nfcsCreditDAO.insert(record);
                    }
                } catch (IOException e) {
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
