package cn.sunfit.risk.buz.server.util.entity;

import java.lang.reflect.Field;

import orj.worf.core.model.BaseObject;

public class ContractStuffing extends BaseObject {

    private Long id;
    private Long conTempId;
    private Integer pageNo;
    private Float posX;
    private Float posY;
    private String colorCode;
    private String valKey;
    private Float fontSize;
    private String valType;
    private Integer maxPage;

    public ContractStuffing() {
        // TODO Auto-generated constructor stub
    }

    public String getColorCode() {
        return colorCode;
    }

    public Long getConTempId() {
        return conTempId;
    }

    public Float getFontSize() {
        return fontSize;
    }

    public Long getId() {
        return id;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Float getPosX() {
        return posX;
    }

    public Float getPosY() {
        return posY;
    }

    public String getValKey() {
        return valKey;
    }

    public String getValType() {
        return valType;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public void setConTempId(Long conTempId) {
        this.conTempId = conTempId;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPosX(Float posX) {
        this.posX = posX;
    }

    public void setPosY(Float posY) {
        this.posY = posY;
    }

    public void setValKey(String valKey) {
        this.valKey = valKey;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Class c = this.getClass();
        Field[] fields = c.getDeclaredFields();
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                buffer.append(field.getName() + ":" + field.get(this).toString() + ",");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                buffer.append(field.getName() + ":" + e.getMessage() + ",");
            }
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("}");
        return buffer.toString();
    }
}
