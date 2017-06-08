package cn.sunfit.risk.web.controller.installment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunfit.risk.buz.api.beans.installment.ChannelDTO;
import cn.sunfit.risk.buz.api.service.installment.ChannelService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;

/**
 * 
 * @Title: ChannelController.java
 * @Package cn.sunfit.risk.web.controller.installment.web
 * @Description: 渠道商管理
 * @author QuGuanglei
 * @date 2017年4月25日 上午11:35:26
 * @version V1.0
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    /**
     * 
     * @Title: channelManage
     * @Description: 渠道商列表页
     * @param @return   
     * @return String 
     * @author QuGuanglei 2017年4月25日 
     * @throws
     */
    @RequestMapping("/channelManage")
    public String channelManage() {
        return "/installment/channel/channelManage";
    }

    /**
     * 
     * @Title: edit
     * @Description: 新增、修改渠道商页面
     * @param @return   
     * @return String 
     * @author QuGuanglei 2017年4月25日 
     * @throws
     */
    @RequestMapping("/edit")
    public ModelAndView edit(ModelAndView mv, ChannelDTO channel) {
        if (channel != null && channel.getChannelId() != null) {
            channel = channelService.getChannel(channel);
            mv.addObject("channel", channel);
        }
        mv.setViewName("/installment/channel/channelEdit");
        return mv;
    }

    /**
     * 
     * @Title: loadAllChannel
     * @Description: 渠道商列表数据
     * @param @param channel
     * @param @return   
     * @return Resp 
     * @author QuGuanglei 2017年4月25日 
     * @throws
     */
    @ResponseBody
    @RequestMapping("/loadAllChannel")
    public Resp loadAllChannel(ChannelDTO channel) {
        RespPage<List<ChannelDTO>> info = channelService.queryAllChannel(channel);
        return new Resp(info);
    }

}
