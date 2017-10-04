package com.example.pver.proxydesign.dynamicproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/3 18:53
 * @package : com.example.pver.proxydesign.dynamicproxy
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private Subject subject;

    public DynamicInvocationHandler(Subject subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Log.e("miss08", "开始执行代理方法，处理的方法是 ： " + method.getName());
        String response = (String) method.invoke(subject, args);
        Log.e("miss08", "业务方法处理完毕,响应结果是 ： " + response);
        return response;
    }

}
