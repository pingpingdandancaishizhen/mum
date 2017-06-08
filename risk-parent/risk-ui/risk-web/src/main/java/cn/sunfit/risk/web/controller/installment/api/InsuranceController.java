package cn.sunfit.risk.web.controller.installment.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.installment.ChannelDTO;
import cn.sunfit.risk.buz.api.beans.installment.api.APIResp;
import cn.sunfit.risk.buz.api.beans.installment.api.BaseResp;
import cn.sunfit.risk.buz.api.beans.installment.api.car.CarInfo;
import cn.sunfit.risk.buz.api.beans.installment.api.coverage.Coverage;
import cn.sunfit.risk.buz.api.beans.installment.api.insurance.Insurance;
import cn.sunfit.risk.buz.api.beans.installment.api.loanperiods.LoanPeriods;
import cn.sunfit.risk.buz.api.beans.installment.api.owner.Owner;
import cn.sunfit.risk.buz.api.beans.installment.api.receiver.Receiver;
import cn.sunfit.risk.buz.api.service.installment.api.InsuranceAPI;

/**
 * 
 * @Title: InsuranceController.java
 * @Package cn.sunfit.risk.web.controller.installment.api
 * @Description:保险接口，用来同步融分期数据
 * @author yanlei
 * @date 2017年4月11日 上午11:12:45
 * @version V1.0
 */
@Controller
@RequestMapping("/v1/Insurance")
public class InsuranceController {

    protected static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

    @Autowired
    private InsuranceAPI insuranceAPI;

    /**
     * 
     * @Title: addCoverageList
     * @Description: 新增具体的险种
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/addCoverageList", method = RequestMethod.POST)
    @ResponseBody
    public String addCoverageList(@RequestBody String requestParam) {
        logger.debug("addCoverageList====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            List<Coverage> coverageList = JsonUtils.parseJSON(requestParam, List.class, Coverage.class);
            insuranceAPI.addCoverageList(coverageList);
        } catch (Exception e) {
            logger.error("addCoverageList====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: addLoanPeriodsList
     * @Description: 新增每一期的分期
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/addLoanPeriodsList", method = RequestMethod.POST)
    @ResponseBody
    public String addLoanPeriodsList(@RequestBody String requestParam) {
        logger.debug("addLoanPeriodsList====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            List<LoanPeriods> loanPeriodsList = JsonUtils.parseJSON(requestParam, List.class, LoanPeriods.class);
            insuranceAPI.addLoanPeriodsList(loanPeriodsList);
        } catch (Exception e) {
            logger.error("addLoanPeriodsList====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: addReceiver
     * @Description: 增加收件人信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/addReceiver", method = RequestMethod.POST)
    @ResponseBody
    public String addReceiver(@RequestBody String requestParam) {
        logger.debug("addReceiver====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            Receiver receiver = JsonUtils.parseJSON(requestParam, Receiver.class);
            insuranceAPI.addReceiver(receiver);
        } catch (Exception e) {
            logger.error("addReceiver====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: queryChannel
     * @Description: 根据渠道编码，查询渠道信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author QuGuanglei 2017年4月24日 
     * @throws
     */
    @RequestMapping(value = "/queryChannel", method = RequestMethod.POST)
    @ResponseBody
    public String queryChannel(@RequestBody String requestParam) {
        logger.debug("queryChannel====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<ChannelDTO> baseResp = new BaseResp<ChannelDTO>();
        try {
            ChannelDTO req = JsonUtils.parseJSON(requestParam, ChannelDTO.class);
            req = insuranceAPI.queryChannel(req);
            baseResp.setData(req);
        } catch (Exception e) {
            logger.error("queryChannel====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: saveOrUpdateCarInfo
     * @Description: 新增或修改车辆信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/saveOrUpdateCarInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrUpdateCarInfo(@RequestBody String requestParam) {
        logger.debug("saveOrUpdateCarInfo====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            CarInfo carInfo = JsonUtils.parseJSON(requestParam, CarInfo.class);
            insuranceAPI.saveOrUpdateCarInfo(carInfo);
        } catch (Exception e) {
            logger.error("saveOrUpdateCarInfo====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: saveOrUpdateInsuranceInfo
     * @Description: 新增或修改保险信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/saveOrUpdateInsuranceInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrUpdateInsuranceInfo(@RequestBody String requestParam) {
        logger.debug("saveOrUpdateInsuranceInfo====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            Insurance insurance = JsonUtils.parseJSON(requestParam, Insurance.class);
            insuranceAPI.saveOrUpdateInsuranceInfo(insurance);
        } catch (Exception e) {
            logger.error("saveOrUpdateInsuranceInfo====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: saveOrUpdateCarInfo
     * @Description: 新增或修改用户基本信息
     * @param @param requestParam
     * @param @param request
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/saveOrUpdateOwnerInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrUpdateOwnerInfo(@RequestBody String requestParam) {
        logger.debug("saveOrUpdateOwnerInfo====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            Owner owner = JsonUtils.parseJSON(requestParam, Owner.class);
            insuranceAPI.saveOrUpdateOwnerInfo(owner);
        } catch (Exception e) {
            logger.error("saveOrUpdateOwnerInfo====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: updateInsuranceBuOwnerId
     * @Description: 根据车主id更新保单的信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/updateInsuranceBuOwnerId", method = RequestMethod.POST)
    @ResponseBody
    public String updateInsuranceBuOwnerId(@RequestBody String requestParam) {
        logger.debug("updateInsuranceBuOwnerId====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            Insurance insurance = JsonUtils.parseJSON(requestParam, Insurance.class);
            insuranceAPI.updateInsuranceBuOwnerId(insurance);
        } catch (Exception e) {
            logger.error("updateInsuranceBuOwnerId====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: updateLoanPeriods
     * @Description: 修改每期还款信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/updateLoanPeriods", method = RequestMethod.POST)
    @ResponseBody
    public String updateLoanPeriods(@RequestBody String requestParam) {
        logger.debug("updateLoanPeriods====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            LoanPeriods loanPeriods = JsonUtils.parseJSON(requestParam, LoanPeriods.class);
            insuranceAPI.updateLoanPeriods(loanPeriods);
        } catch (Exception e) {
            logger.error("updateLoanPeriods====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }

    /**
     * 
     * @Title: updateReceiver
     * @Description: 更新收件人信息
     * @param @param requestParam
     * @param @return   
     * @return String 
     * @author yanlei 2017年4月11日 
     * @throws
     */
    @RequestMapping(value = "/updateReceiver", method = RequestMethod.POST)
    @ResponseBody
    public String updateReceiver(@RequestBody String requestParam) {
        logger.debug("updateReceiver====传入参数：" + requestParam);
        String returnResp = null;
        BaseResp<String> baseResp = new BaseResp<String>();
        try {
            Receiver receiver = JsonUtils.parseJSON(requestParam, Receiver.class);
            insuranceAPI.updateReceiver(receiver);
        } catch (Exception e) {
            logger.error("updateReceiver====异常：" + e.getMessage());
            baseResp.setRespStatus(APIResp.SYSTEM_ERROR);
        }
        returnResp = JsonUtils.toJSON(baseResp);
        return returnResp;
    }
}
