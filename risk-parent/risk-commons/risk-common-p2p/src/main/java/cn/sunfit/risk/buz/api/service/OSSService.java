package cn.sunfit.risk.buz.api.service;

import java.io.InputStream;

public interface OSSService {

    public String buildUrl(String key);

    public void deleteFile(String key);

    public byte[] downloadFile(String key);

    public void uploadFile(String key, byte[] b);

    public void uploadFile(String key, InputStream input);

}
