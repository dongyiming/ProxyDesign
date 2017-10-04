package com.example.pver.proxydesign.dynamicproxy;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/3 18:45
 * @package : com.example.pver.proxydesign.dynamicproxy
 */
public interface Subject {

    public String getResponse(String url);

    public void getCookie(String url);

    public String getUpdateTime();
}
