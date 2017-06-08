package cn.sunfit.risk.buz.server.util.entity;

import java.util.List;

public class ContractFillContent {
    /*
     * 页码
     */
    private int page = 1;

    private int addToPage = 0;

    private int writeType; // 1-坐标写入，2-表单写入

    private final float PDF_MAX_HEIGHT = 785.92f;

    private List<ContractFillBody> textList;

    private List<ContractFillBody> tableList;

    private List<ContractFillBody> imageList;

    public int getAddToPage() {
        return addToPage;
    }

    public List<ContractFillBody> getImageList() {
        return imageList;
    }

    public int getPage() {
        return page;
    }

    public float getPDF_MAX_HEIGHT() {
        return PDF_MAX_HEIGHT;
    }

    public List<ContractFillBody> getTableList() {
        return tableList;
    }

    public List<ContractFillBody> getTextList() {
        return textList;
    }

    public int getWriteType() {
        return writeType;
    }

    public void setAddToPage(int addToPage) {
        this.addToPage = addToPage;
    }

    public void setImageList(List<ContractFillBody> imageList) {
        this.imageList = imageList;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTableList(List<ContractFillBody> tableList) {
        this.tableList = tableList;
    }

    public void setTextList(List<ContractFillBody> textList) {
        this.textList = textList;
    }

    public void setWriteType(int writeType) {
        this.writeType = writeType;
    }

}
