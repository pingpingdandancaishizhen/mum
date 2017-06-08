package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.Article;
import cn.sunfit.risk.buz.api.vo.corp.ArticleCategory;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.ArticleQueryReq;

@Repository
public interface ArticleDAO {

    void changeCorpNoticeStatus(@Param("id") String id, @Param("status") String status);

    void deleteByPrimaryKey(@Param("id") String id);

    int insert(Article record);

    List<ArticleQueryDTO> queryNoticeList(@Param("article") ArticleQueryReq article,
            @Param("typeIdList") String[] typeIdList, RowBounds rowBounds);

    /**
     * 
     * @Title: reviewCorpNoticeStatus
     * @Description: TODO
     * @param @param article   
     * @return void 
     * @author XJ 2016年12月19日 
     * @throws
     */
    void reviewCorpNoticeStatus(Article article);

    List<ArticleCategory> selectArticleCategory(@Param("parentId") String parentId);

    Article selectByPrimaryKey(String id);

    int updateByPrimaryKey(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    void updateCorpNotice(Article article);

}
