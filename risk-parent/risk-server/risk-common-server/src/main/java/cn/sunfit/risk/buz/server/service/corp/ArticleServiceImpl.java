package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.Article;
import cn.sunfit.risk.buz.api.constants.SystemNoticeStatus;
import cn.sunfit.risk.buz.api.service.corp.ArticleService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.ArticleCategory;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.ArticleDAO;

@Service("risk.articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    @Override
    public void changeCorpNoticeStatus(String id, String status) {
        articleDAO.changeCorpNoticeStatus(id, status);
    }

    @Override
    public void deleteCorpNotice(String id) {
        articleDAO.deleteByPrimaryKey(id);
    }

    @Override
    public void insertCorpNotice(Article article) {
        articleDAO.insert(article);
    }

    @Override
    public List<ArticleCategory> queryCategory(String parentId) {
        List<ArticleCategory> list = articleDAO.selectArticleCategory(parentId);
        return list;
    }

    @Override
    public RespPage<List<ArticleQueryDTO>> queryNoticeList(ArticleQueryReq req, String[] typeIdList) {
        List<ArticleQueryDTO> list = articleDAO.queryNoticeList(req, typeIdList,
                new RowBounds(req.getOffset(), req.getLimit()));
        for (ArticleQueryDTO articleQueryDTO : list) {
            SystemNoticeStatus systemNoticeStatus = SystemNoticeStatus.getNameByStatus(articleQueryDTO.getStatus());
            if (systemNoticeStatus != null) {
                articleQueryDTO.setStatusName(systemNoticeStatus.getStatusName());
            }
        }
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<ArticleQueryDTO>>(list, totalCount);
    }

    @Override
    public void reviewCorpNoticeStatus(Article article) {
        articleDAO.reviewCorpNoticeStatus(article);
    }

    @Override
    public void updateCorpNotice(Article article) {
        articleDAO.updateCorpNotice(article);
    }

}
