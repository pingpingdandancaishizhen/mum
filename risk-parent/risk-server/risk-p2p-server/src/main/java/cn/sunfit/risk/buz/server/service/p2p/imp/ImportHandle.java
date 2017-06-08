package cn.sunfit.risk.buz.server.service.p2p.imp;

import java.io.IOException;
import java.io.InputStream;

import cn.sunfit.risk.buz.api.vo.p2p.imp.ExcelToBeanResult;

public interface ImportHandle {
    public ExcelToBeanResult excelToBean(String domain, String corpId, String productId, String userId,
            String importCode, InputStream in) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException;
}
