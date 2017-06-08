package cn.sunfit.risk.buz.api.vo.system;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.system.SystemFunc;
import cn.sunfit.risk.buz.api.beans.system.SystemMenu;

public class SystemMenuFunc extends SystemMenu {

    private static final long serialVersionUID = 1L;

    private List<SystemFunc> funcList;

    public List<SystemFunc> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<SystemFunc> funcList) {
        this.funcList = funcList;
    }

}
