package com.example.pver.proxydesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.pver.proxydesign.dynamicproxy.DynamicInvocationHandler;
import com.example.pver.proxydesign.dynamicproxy.Subject;
import com.example.pver.proxydesign.dynamicproxy.TargetSubject;
import com.example.pver.proxydesign.refelect.Student;
import com.example.pver.proxydesign.staticproxy.IHttpInvokeSubject;
import com.example.pver.proxydesign.staticproxy.ProxySubject;
import com.example.pver.proxydesign.staticproxy.RealSubject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            reflect();
//            dynamicProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 静态代理
     * @author: miss08
     * @date: 2017/10/3  20:14
     * @param:
     */
    public void staticProxy() {
        IHttpInvokeSubject httpInvokeSubject = new ProxySubject(new RealSubject());
        Log.e("miss08", "客户端开始请求服务器数据");
        httpInvokeSubject.invoke("request");
    }

    /**
     * @Description: 动态代理
     * @author: miss08
     * @date: 2017/10/3  20:14
     * @param:
     */
    public void dynamicProxy() {

        Subject targetSubject = new TargetSubject();
        InvocationHandler handler = new DynamicInvocationHandler(targetSubject);
        Log.e("miss08", "开始创建代理类");
        Subject proxySubject = (Subject) Proxy.newProxyInstance(targetSubject.getClass().getClassLoader()
                , targetSubject.getClass().getInterfaces()
                , handler);
        Log.e("miss08", "代理类实例创建成功");
        proxySubject.getResponse("http://192.168.1.100:8080/currentTime");
//        proxySubject.getCookie("http://192.168.1.100:8080/currentTime");
//        proxySubject.getUpdateTime();

    }

    public void reflect() throws Exception {

        //通过反射获取类
        Class<Student> studentClass = Student.class;

        //获取构造时，需要传入的该构造的参数类型
        Class[] classes = new Class[]{String.class, int.class};

        //获取类的参数为String和int类型的public构造函数
        Constructor constructor = studentClass.getConstructor(classes);

        //通过构造参数创建一个Student类的实例
        Student zhangsan = (Student) constructor.newInstance("张三", 18);

        //获取Student对象里名字为“getName”的方法
        Method method = studentClass.getMethod("getName", new Class[]{});

        //执行方法哪个实例的"getName"方法
        String name = (String) method.invoke(zhangsan, new Object[]{});

        //打印我们创建实例对象时传入的name，看是否能通过"getName"方法获取到
        Log.e("miss08", "name = " + name);

    }
}
