package cn.sunfit.risk.buz.api.beans.system;

import orj.worf.core.model.BaseObject;

public class SystemUrl extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String urlId;

    private String urlName;

    private String actionUrl;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId == null ? null : urlId.trim();
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName == null ? null : urlName.trim();
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }
}