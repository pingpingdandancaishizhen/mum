package cn.sunfit.risk.credit.server.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SignUtils {

    /** 指定加密算法为RSA */
    private static final String ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";

    public static String sign(byte[] data, String privateKey) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] keyBytes = decoder.decodeBuffer(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        BASE64Encoder en = new BASE64Encoder();
        return en.encode(signature.sign());
    }

}
