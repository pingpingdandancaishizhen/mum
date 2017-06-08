package cn.sunfit.risk.buz.api.vo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DistrictNodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String address;

    private List<DistrictNodeDTO> nodes = new ArrayList<DistrictNodeDTO>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DistrictNodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<DistrictNodeDTO> nodes) {
        this.nodes = nodes;
    }

}
