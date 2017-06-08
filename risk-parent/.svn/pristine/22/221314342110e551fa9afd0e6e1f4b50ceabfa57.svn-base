package cn.sunfit.risk.web.controller.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.Article;
import cn.sunfit.risk.buz.api.constants.system.SystemNoticeStatus;
import cn.sunfit.risk.buz.api.service.corp.ArticleService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

/**
 * 系统公告Controller
 * @Title: NoticeController.java
 * @Package cn.sunfit.risk.web.controller.system
 * @Description: TODO
 * @author RJS
 * @date 2016年12月23日 下午2:04:46
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/system/notice")
public class NoticeController extends BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 
     * @Title: addNotice
     * @Description: 系统公告
     * @param @param notice
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    public Resp addNotice(Article article) {
        article.setCorpId(getCurrentUser().getCorpId());
        article.setId(IdUtil.geneId());
        article.setArtWriter(getCurrentUser().getId());
        article.setArtTime(new Date());
        article.setIsHot(false);
        article.setViewCount(0);
        article.setStatus(SystemNoticeStatus.CREATE.getStatus());
        articleService.insertCorpNotice(article);
        return new Resp();
    }

    /**
     * 
     * @Title: deleteNotice
     * @Description: 系统公告删除
     * @param @param id
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/deleteNotice", method = RequestMethod.POST)
    public Resp deleteNotice(String id) {
        articleService.deleteCorpNotice(id);
        return new Resp();
    }

    /**
     * 
     * @Title: disableNotice
     * @Description: 系统公告发布
     * @param @param notice
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/disableNotice", method = RequestMethod.POST)
    public Resp disableNotice(String id) {
        articleService.changeCorpNoticeStatus(id, SystemNoticeStatus.DISABLE.getStatus());
        return new Resp();
    }

    /**
     * 
     * @Title: enableNotice
     * @Description: 系统公告发布
     * @param @param notice
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/enableNotice", method = RequestMethod.POST)
    public Resp enableNotice(Article article) {
        article.setReviewTime(new Date());
        article.setArtReviewer(getCurrentUser().getId());
        article.setStatus(SystemNoticeStatus.RELEASED.getStatus());
        articleService.reviewCorpNoticeStatus(article);
        return new Resp();
    }

    /**
     * 
     * @Title: loadNoticeManager
     * @Description: 加载内部公告管理初始页
     * @param @return   
     * @return String 
     * @author XJ 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/loadNoticeManager", method = RequestMethod.GET)
    public String loadNoticeManager(HttpServletRequest request) {
        request.setAttribute("types", articleService.queryCategory("1"));
        request.setAttribute("status", SystemNoticeStatus.values());
        return "/system/notice/loadNoticeManager";
    }

    /**
     * 
     * @Title: modifyNotice
     * @Description: 系统公告
     * @param @param notice
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月15日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/modifyNotice", method = RequestMethod.POST)
    public Resp modifyNotice(Article article) {
        article.setArtWriter(getCurrentUser().getId());
        article.setArtTime(new Date());
        articleService.updateCorpNotice(article);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/queryCorpNotice", method = RequestMethod.POST)
    public Resp queryCorpNotice(ArticleQueryReq req, String typeId) {
        req.setCorpId(getCurrentUser().getCorpId());
        String[] typeParam;
        if (StringUtils.isBlank(typeId)) {
            typeParam = null;
        } else {
            typeParam = new String[] { typeId };
        }
        RespPage<List<ArticleQueryDTO>> pageList = articleService.queryNoticeList(req, typeParam);
        return new Resp(pageList);
    }

}
