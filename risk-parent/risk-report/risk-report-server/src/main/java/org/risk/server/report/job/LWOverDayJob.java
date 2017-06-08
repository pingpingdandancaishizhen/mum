package org.risk.server.report.job;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.risk.report.api.service.RepaymentOverdueService;
import org.risk.server.report.util.DigitalSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import orj.worf.scheduler.quartz.job.WorfJob;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.service.corp.CorpService;
import cn.sunfit.risk.buz.api.vo.corp.CorpLwInfoVO;
import cn.sunfit.risk.buz.server.util.HttpUtils;
import cn.sunfit.risk.buz.server.util.JsonUtil;
import cn.sunfit.risk.buz.server.util.ServerConfig;

@DisallowConcurrentExecution
public class LWOverDayJob extends WorfJob {

    private static String createJSONData(Map<String, String> param) throws JsonGenerationException,
            JsonMappingException, IOException {
        param.put("brand", null);
        param.put("series", null);
        param.put("model", null);
        param.put("color", null);
        param.put("masterPhone", null);
        param.put("masterAddress", null);
        param.put("localAddress", null);
        param.put("masterWorkAddress", null);
        param.put("localWordAddress", null);
        param.put("speedCall", null);
        param.put("frameNum", null);
        param.put("engineNum", null);
        param.put("purchaseTime", null);
        param.put("backPay", null);
        param.put("backPayName", null);
        param.put("borrowProperty", null);
        param.put("borrowPropertyName", null);
        param.put("borrowExpires", null);
        param.put("borrowMoney", null);
        param.put("loanTime", null);
        param.put("backStatus", null);
        param.put("residualPrincipal", null);
        param.put("orderStatusName", null);
        param.put("residualPeriod", null);
        param.put("settleTime", null);
        return JsonUtil.objectToJsonStr(param);
    }

    Logger logger = LoggerFactory.getLogger(LWOverDayJob.class);

    @Autowired
    CorpService corpService;

    @Autowired
    ServerConfig serverConfig;

    @Autowired
    RepaymentOverdueService repaymentOverdueService;

    @Override
    public void runCondition(JobExecutionContext arg0, Map<String, String> arg1) {

    }

    @Override
    public void runGeneral(JobExecutionContext arg0) {
        List<String> list = corpService.selectCorpDomain();
        logger.debug("--------->放款统计定时任务执行");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (final String domain : list) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    logger.debug(domain + "--------> creating report");
                    List<Map<String, String>> map = repaymentOverdueService.selectAllOverDay(domain);
                    CorpLwInfoVO corp = corpService.selectLwInfoByDomain(domain);
                    for (Map<String, String> param : map) {
                        if (StringUtils.equals(ProductMedium.C.getStatus(), param.get("medium"))
                                && StringUtils.equals(ProductType.DYDK.getStatus(), param.get("productType"))) {
                            param.remove("medium");
                            param.remove("productType");
                            Map<String, Object> params = new HashMap<>();
                            try {
                                params.put("key", corp.getLwKey());
                                params.put("data", createJSONData(param));
                                String sign = DigitalSignature.getSignature(params, corp.getLwSecret());
                                params.put("sign", sign);
                                logger.info("请求参数：{}", params);
                                String result = "";
                                result = HttpUtils.sendPost(serverConfig.getLw_host()
                                        + "/standard/interface/carControl/saveLoanInfo.json",
                                        JsonUtil.objectToJsonStr(params));
                                logger.info("乐位通知结果：{}", result);
                            } catch (IOException e) {
                                logger.error(e.getMessage(), e);
                            }
                        }
                    }
                }
            });
        }
        cachedThreadPool.shutdown();
    }

}
