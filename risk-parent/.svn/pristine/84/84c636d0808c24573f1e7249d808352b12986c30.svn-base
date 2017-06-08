package cn.sunfit.risk.buz.api.vo.p2p.imp;

import java.io.Serializable;
import java.util.List;

public class ImportResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1174971750822404027L;

    private int successCount;

    private int errCount;

    private List<ImportError> fails;

    private boolean success;

    private String message;

    public ImportResult() {

    }

    public ImportResult(boolean success, int successCount, List<ImportError> fails, String message) {
        this.success = success;
        this.successCount = successCount;
        this.fails = fails;
        this.message = message;
        if (fails != null) {
            errCount = fails.size();
        } else {
            errCount = 0;
        }
    }

    public int getErrCount() {
        return errCount;
    }

    public List<ImportError> getFails() {
        return fails;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setErrCount(int errCount) {
        this.errCount = errCount;
    }

    public void setFails(List<ImportError> fails) {
        this.fails = fails;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

}
