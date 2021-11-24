package com.im.web.net;

import cn.hutool.http.Method;
import lombok.experimental.UtilityClass;
import org.apache.http.Header;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/3
 */
@UtilityClass
public class HttpRequestHelper {

    private static final Map<String, IHttpRequest> httpRequestMap = new HashMap<>();

    static {
        httpRequestMap.put(Method.POST.name(), new HttpPost());
        httpRequestMap.put(Method.GET.name(), new HttpGet());
    }

    public String request(String method, String url, List<Header> headers, Map<String, Object> params) {
        return httpRequestMap.get(method).request(url, headers, params);
    }

}
