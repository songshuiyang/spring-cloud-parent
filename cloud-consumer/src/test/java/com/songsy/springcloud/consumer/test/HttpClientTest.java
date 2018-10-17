package com.songsy.springcloud.consumer.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author songshuiyang
 * @date 2018/8/15 15:05
 */
public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        // 创建默认的HttpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 调用6次服务并输出结果
        for(int i = 0; i < 6; i++) {
            // 调用 GET 方法请求服务
            HttpGet httpget = new HttpGet("http://localhost:9050/router");
            // 获取响应
            HttpResponse response = httpclient.execute(httpget);
            // 根据 响应解析出字符串
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
