package cn.jaylong.web.net;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/3
 */
class HttpPost implements IHttpRequest {

    @SneakyThrows
    @Override
    public HttpUriRequest getHttpUriRequest(String url, List<Header> headers, Map<String, Object> params) {
        HttpEntity entity = new StringEntity(JSON.toJSONString(params), CharsetUtil.UTF_8);
        //声明请求方式
        org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost();
        httpPost.setURI(URI.create(url));
        httpPost.setHeader("Content-Type", ContentType.JSON.getValue());
        //设置Content-Type
        if (!headers.isEmpty()) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
            //设置请求 参数的编码格式
            Optional<Header> headerOptional = headers.stream().filter(it -> it.getName().equals("Content-Type")).findFirst();
            if (headerOptional.isPresent()) {
                String contentType = headerOptional.get().getValue();
                if (contentType.equals(ContentType.FORM_URLENCODED.getValue())) {
                    httpPost.setHeader("Content-Type", ContentType.FORM_URLENCODED.getValue());
                    List<NameValuePair> nameValuePairList = new ArrayList<>();
                    for (String key :
                            params.keySet()) {
                        nameValuePairList.add(new BasicNameValuePair(key, Convert.toStr(params.get(key))));
                    }
                    entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
                }
            }
        }
        //声明携带参数
        httpPost.setEntity(entity);
        return httpPost;
    }

}
