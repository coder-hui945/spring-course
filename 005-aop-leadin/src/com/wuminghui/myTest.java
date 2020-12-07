package com.wuminghui;

import com.wuminghui.handler.MyInvocationHandler;
import com.wuminghui.service.SomeService;
import com.wuminghui.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class myTest {
    public static void main(String[] args) {
       /* 原始创建对象方式
       SomeServiceImpl service = new SomeServiceImpl();
        service.doSome();
        System.out.println("#######################");
        service.doOther();*/
        /*使用JDK的proxy创建代理对象*/
        //1.创建目标对象
        SomeServiceImpl service = new SomeServiceImpl();
        //2.创建invocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(service);
        //使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(service.getClass().getClassLoader(),//类的加载器
                                                                service.getClass().getInterfaces(),//类实现的接口
                                                                handler);//所代理的东西
        //通过代理执行方法，会调用handler中的invoke方法
        proxy.doSome();//真实会调用handler中的invoke()方法.dosome()通过包装传递给invoke()的method参数
        System.out.println("+++++++++++++++++++++++++++++++");
        proxy.doOther();

    }

}
