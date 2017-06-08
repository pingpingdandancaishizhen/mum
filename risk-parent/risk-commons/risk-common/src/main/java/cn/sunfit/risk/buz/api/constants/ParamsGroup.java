package cn.sunfit.risk.buz.api.constants;

	public enum ParamsGroup {
		YXZL("1","影像资料"),
		SRZL("2","收入资料");


	    /**
	     * 根据用户状态，返回用户状态标签
	     */
	    public static String getLabelByStatus(String status) {
	        for (ParamsGroup paramsGroup : ParamsGroup.values()) {
	            if (paramsGroup.status.equals(status)) {
	                return paramsGroup.getLabel();
	            }
	        }
	        return "";
	    }

	    /**
	     * 根据用户状态标签，返回用户状态
	     */
	    public static String getStatusByLabel(String label) {
	        for (ParamsGroup paramsGroup : ParamsGroup.values()) {
	            if (paramsGroup.label.equals(label)) {
	                return paramsGroup.getStatus();
	            }
	        }
	        return "";
	    }

	    private String status;

	    private String label;

	    ParamsGroup(String status, String label) {
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


