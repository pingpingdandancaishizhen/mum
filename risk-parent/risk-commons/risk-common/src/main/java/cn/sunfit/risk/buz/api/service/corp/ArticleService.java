package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.Article;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.ArticleCategory;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryReq;

public interface ArticleService {

    void changeCorpNoticeStatus(String id, String status);

    void deleteCorpNotice(String id);

    void insertCorpNotice(Article article);

    List<ArticleCategory> queryCategory(String parentId);

    RespPage<List<ArticleQueryDTO>> queryNoticeList(ArticleQueryReq req, String[] typeIdList);

    void reviewCorpNoticeStatus(Article article);

    void updateCorpNotice(Article article);
}
