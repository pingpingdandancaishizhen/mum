package org.risk.server.report.job;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.risk.report.api.service.RepaymentOverdueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import orj.worf.scheduler.quartz.job.WorfJob;
import cn.sunfit.risk.buz.api.service.corp.CorpService;

@DisallowConcurrentExecution
public class RepaymentOverdueJob extends WorfJob {

    Logger logger = LoggerFactory.getLogger(RepaymentOverdueJob.class);

    @Autowired
    CorpService corpService;

    @Autowired
    RepaymentOverdueService repaymentOverdueService;

    @Override
    public void runCondition(JobExecutionContext content, Map<String, String> param) {

    }

    @Override
    public void runGeneral(JobExecutionContext content) {
        List<String> list = corpService.selectCorpDomain();
        logger.debug("--------->放款统计定时任务执行");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (final String domain : list) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    logger.debug(domain + "--------> creating report");
                    repaymentOverdueService.insertRepaymentOverdue4Report(domain);
                }
            });
        }
        cachedThreadPool.shutdown();
    }

}
