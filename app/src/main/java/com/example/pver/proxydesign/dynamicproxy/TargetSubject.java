package com.example.pver.proxydesign.dynamicproxy;

import android.util.Log;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/3 18:50
 * @package : com.example.pver.proxydesign.dynamicproxy
 */
public class TargetSubject implements Subject {

    @Override
    public String getResponse(String url) {
        Log.e("miss08", "执行业务方法：getResponse ." + url);
        return "2017/10/03 21:56";
    }

    @Override
    public void getCookie(String url) {
        Log.e("miss08", "执行业务方法：getCookie ." + url);
    }

    @Override
    public String getUpdateTime() {

        Log.e("miss08", "执行业务方法：getUpdateTime .");
        long time = System.currentTimeMillis();
        return String.valueOf(time);
    }
}
