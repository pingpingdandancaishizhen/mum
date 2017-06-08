package cn.sunfit.risk.buz.api.vo;

import java.io.Serializable;

public class ReqBase implements Serializable {

    private static final long serialVersionUID = 4211534854281458429L;

    public final static int NO_ROW_OFFSET = 0;

    public final static int NO_ROW_LIMIT = Integer.MAX_VALUE;

    private int paseSize = 20;

    private int currentPage = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLimit() {
        return paseSize;
    }

    public int getOffset() {
        return (currentPage - 1) * paseSize;
    }

    public int getPaseSize() {
        return paseSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPaseSize(int paseSize) {
        this.paseSize = paseSize;
    }

}
