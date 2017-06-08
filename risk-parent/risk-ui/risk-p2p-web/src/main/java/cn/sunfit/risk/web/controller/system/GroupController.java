package cn.sunfit.risk.web.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpGroup;
import cn.sunfit.risk.buz.api.service.corp.CorpGroupService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.GroupQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/group")
public class GroupController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private CorpGroupService corpGroupService;

    /**
     * 
     * @Title: loadGroupList
     * @Description: 跳转用户组
     * @param @return   
     * @return String 
     * @author XFL 2016年12月12日 
     * @throws
     */
    @RequestMapping(value = "/loadGroupList", method = RequestMethod.GET)
    public String loadGroupList() {
        return "";
    }

    /**
     * 
     * @Title: queryGroupList
     * @Description: 查询用户组列表
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月12日 
     * @throws
     */
    @RequestMapping(value = "/queryGroupList", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryGroupList(GroupQueryReq req) {
        req.setCorpId(getCurrentUser().getCorpId());
        RespPage<List<CorpGroup>> r = corpGroupService.queryGroupList(req);
        return new Resp(r);
    }

}
