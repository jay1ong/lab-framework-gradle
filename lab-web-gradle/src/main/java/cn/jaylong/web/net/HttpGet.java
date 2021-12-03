package cn.jaylong.web.net;

import cn.hutool.http.Method;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/3
 */
class HttpGet implements IHttpRequest {

    @Override
    public HttpUriRequest getHttpUriRequest(String url, List<Header> headers, Map<String, Object> params) {
        //声明请求方式
        //设置content-Type
        return RequestBuilder.create(Method.GET.name())
                .setUri(url)
                .build();
    }
}
