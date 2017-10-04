package com.example.pver.proxydesign.staticproxy;

import android.util.Log;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/3 2:12
 * @package : com.example.pver.proxydesign
 */
public class RealSubject implements IHttpInvokeSubject {

    @Override
    public String invoke(String request) {

        //具体业务逻辑
        Log.e("miss08", "开始处理请求中...");
        Log.e("miss08", "请求处理完毕，返回响应数据");
        return "response";
    }
}
