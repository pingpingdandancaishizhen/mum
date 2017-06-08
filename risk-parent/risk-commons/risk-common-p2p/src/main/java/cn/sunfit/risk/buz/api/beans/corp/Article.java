package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class Article extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String corpId;

    private String title;

    private String artInfo;

    private String artWriter;

    private Date artTime;

    private String typeId;

    private String artImg;

    private Boolean isHot;

    private Integer viewCount;

    private String status;

    private String artContent;

    private String artReviewer;

    private Date reviewTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArtReviewer() {
        return artReviewer;
    }

    public void setArtReviewer(String artReviewer) {
        this.artReviewer = artReviewer;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getArtInfo() {
        return artInfo;
    }

    public void setArtInfo(String artInfo) {
        this.artInfo = artInfo == null ? null : artInfo.trim();
    }

    public String getArtWriter() {
        return artWriter;
    }

    public void setArtWriter(String artWriter) {
        this.artWriter = artWriter == null ? null : artWriter.trim();
    }

    public Date getArtTime() {
        return artTime;
    }

    public void setArtTime(Date artTime) {
        this.artTime = artTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getArtImg() {
        return artImg;
    }

    public void setArtImg(String artImg) {
        this.artImg = artImg == null ? null : artImg.trim();
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent == null ? null : artContent.trim();
    }
}
