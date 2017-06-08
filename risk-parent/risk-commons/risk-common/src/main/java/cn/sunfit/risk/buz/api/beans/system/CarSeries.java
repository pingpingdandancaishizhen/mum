package cn.sunfit.risk.buz.api.beans.system;

import orj.worf.core.model.BaseObject;

public class CarSeries extends BaseObject {
    private static final long serialVersionUID = 1L;

    private Integer seriesId;

    private Integer brandId;

    private String seriesName;

    private Integer showOrder;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName == null ? null : seriesName.trim();
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}