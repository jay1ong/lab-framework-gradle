package com.im.web.net;

import com.im.core.exception.BizException;
import com.im.web.enums.HttpException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/1
 */
interface IHttpRequest {

    HttpUriRequest getHttpUriRequest(String url, List<Header> headers, Map<String, Object> params);

    default String request(String url, List<Header> headers, Map<String, Object> params) {
        String entityString;
        HttpEntity httpEntity;
        CloseableHttpResponse response = null;
        //创建http client请求对象
        RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000)
                .setConnectionRequestTimeout(5000).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(defaultRequestConfig).build();
        //执行请求
        try {
            response = httpClient.execute(getHttpUriRequest(url, headers, params));
            //解析返回值
            httpEntity = response.getEntity();
            entityString = EntityUtils.toString(httpEntity);
            return entityString;
        } catch (
                IOException e) {
            e.printStackTrace();
            throw new BizException(HttpException.HTTP_ERROR);
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
