package cn.sunfit.risk.buz.api.vo.form;

import java.io.Serializable;

public class Opera implements Serializable {

    private static final long serialVersionUID = 1L;

    private String operation;

    private String operationName;

    private String operationType;

    public Opera() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Opera(String operation, String operationName, String operationType) {
        super();
        this.operation = operation;
        this.operationName = operationName;
        this.operationType = operationType;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperationName() {
        return operationName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

}
