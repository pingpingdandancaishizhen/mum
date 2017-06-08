package cn.sunfit.risk.buz.server.service.p2p.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.server.service.p2p.imp.handle.CYDImportHandle;
import cn.sunfit.risk.buz.server.service.p2p.imp.handle.XJDImportHandle;

@Service("importOrderFactory")
public class ImportOrderFactory {
    @Autowired
    private XJDImportHandle xjdhandle;

    @Autowired
    private CYDImportHandle cydhandle;

    public ImportHandle getHandle(String productType) {
        switch (productType) {
            case "1":
                return xjdhandle;
            case "2":
                return cydhandle;
            default:
                return null;
        }
    }

}
