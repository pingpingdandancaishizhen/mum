package cn.sunfit.risk.buz.api.constants;

public enum ResponseStatus {

    FAILED(0, "失败"),
    SUCCESS(1, "成功"),
    VALIDATION_ERROR(2, "校验失败"),
    PARAM_ERROR(9001, "参数错误"),
    SYSTEM_ERROR(9999, "操作失败，请稍后再试");

    private int status;
    private String name;

    private ResponseStatus(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

}
