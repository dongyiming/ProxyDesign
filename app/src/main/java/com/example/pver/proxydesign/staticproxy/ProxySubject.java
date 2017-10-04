package com.example.pver.proxydesign.staticproxy;

import android.util.Log;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/3 2:16
 * @package : com.example.pver.proxydesign
 */
public class ProxySubject implements IHttpInvokeSubject {

    private IHttpInvokeSubject subject;

    public ProxySubject(IHttpInvokeSubject subject) {
        this.subject = subject;
    }

    @Override
    public String invoke(String request) {
        String deRequest = decodeRequest(request);
        String response = subject.invoke(deRequest);
        String enResponse = encodeRequest(response);
        return enResponse;
    }

    //对于所有请求，简单繁琐的编解码工作可以在这里处理
    private String decodeRequest(String request) {
        Log.e("miss08", "对请求数据解码");
        return "解码后的请求";
    }

    private String encodeRequest(String response) {
        Log.e("miss08", "对响应数据编码，发送给客户端");
        return "编码后的响应";
    }
}
