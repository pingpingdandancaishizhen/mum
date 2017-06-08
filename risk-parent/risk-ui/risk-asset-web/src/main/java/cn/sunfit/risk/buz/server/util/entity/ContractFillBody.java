package cn.sunfit.risk.buz.server.util.entity;

import java.awt.Color;

public class ContractFillBody {
    /**
     * 字体颜色
     */
    private Color color = Color.black;
    /**
     * 字体大小 7，8，9
     */
    private Float fontSize;
    private Float MatrixX;
    private Float MatrixY;
    private Object showText;
    private String valType;
    private String valKey;
    private int residueRows;
    private int pageTotalRows;
    private int page;
    private final float PDF_MAX_HEIGHT = 841.92f;

    public Color getColor() {
        return color;
    }

    public Float getFontSize() {
        return fontSize;
    }

    public Float getMatrixX() {
        return MatrixX;
    }

    public Float getMatrixY() {
        return MatrixY;
    }

    public int getPage() {
        return page;
    }

    public int getPageTotalRows() {
        return pageTotalRows;
    }

    public float getPDF_MAX_HEIGHT() {
        return PDF_MAX_HEIGHT;
    }

    public int getResidueRows() {
        return residueRows;
    }

    public Object getShowText() {
        return showText;
    }

    public String getValKey() {
        return valKey;
    }

    public String getValType() {
        return valType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    public void setMatrixX(Float matrixX) {
        MatrixX = matrixX;
    }

    public void setMatrixY(Float matrixY) {
        MatrixY = matrixY;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageTotalRows(int pageTotalRows) {
        this.pageTotalRows = pageTotalRows;
    }

    public void setResidueRows(int residueRows) {
        this.residueRows = residueRows;
    }

    public void setShowText(Object showText) {
        this.showText = showText;
    }

    public void setValKey(String valKey) {
        this.valKey = valKey;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

}