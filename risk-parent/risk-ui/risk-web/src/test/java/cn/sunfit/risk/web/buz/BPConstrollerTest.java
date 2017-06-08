/*******************************************************************************
 * @Title: BPConstrollerTest.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.web.buz;

import org.junit.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**   
 * @Title: BPConstrollerTest.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月22日 上午10:00:56
 * @version V1.0   
 */
public class BPConstrollerTest {

    @Test
    public void testExecusteOperationStart() {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType,
                    "bpId=10001005&bpDefId=1000&operKey=start&formData=%7B%22customer_name%22%3A%22xxx%22%2C%20%22customer_gender%22%3A%22man%22%7D");
            Request request = new Request.Builder().url("http://localhost:8080/risk-web/bp/operation").post(body)
                    .addHeader("apikey", "70cd8da078bb0e7c803be1c6d9a1a749").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b65ecad9-0300-6e57-0d3c-9a28327ddd74")
                    .addHeader("content-type", "application/x-www-form-urlencoded").build();

            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (Exception ex) {
            throw new RuntimeException("execute failed", ex);
        }
    }

    @Test
    public void testExecusteOperationRegister() {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType,
                    "bpId=10001005&bpDefId=1000&operKey=start&formData=%7B%22customer_name%22%3A%22xxx%22%2C%20%22customer_gender%22%3A%22man%22%7D");
            Request request = new Request.Builder().url("http://localhost:8080/risk-web/bp/operation").post(body)
                    .addHeader("apikey", "70cd8da078bb0e7c803be1c6d9a1a749").addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b65ecad9-0300-6e57-0d3c-9a28327ddd74")
                    .addHeader("content-type", "application/x-www-form-urlencoded").build();

            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (Exception ex) {
            throw new RuntimeException("execute failed", ex);
        }
    }

}
