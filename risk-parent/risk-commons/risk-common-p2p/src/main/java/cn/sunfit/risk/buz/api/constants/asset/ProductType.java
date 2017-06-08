package cn.sunfit.risk.buz.api.constants.asset;

/**
 * 
 * @Title: ProductType.java
 * @Package cn.sunfit.risk.buz.api.constants
 * @Description: 产品类型，即担保类型
 * @author XFL
 * @date 2016年12月29日 下午4:53:40
 * @version V1.0
 */
public enum ProductType {

    DYDK("1", "信用贷"),
    XYDK("2", "车易贷"),
    ZYDK("3", "房易贷"),
    BZDK("5", "融分期"),
    PJTX("6", "融租赁");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (ProductType userStatusType : ProductType.values()) {
            if (userStatusType.status.equals(status)) {
                return userStatusType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (ProductType userStatusType : ProductType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    ProductType(String status, String label) {
        this.status = status;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

}
