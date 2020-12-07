package com.wuminghui.handler;

import com.wuminghui.util.serviceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
   //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了invoke函数");
        //通过代理对象执行方法时，会调用执行invoke（）
        /*实现只有doSome才增加功能，doOther不增加功能*/
        Object res = null;
            String methodName = method.getName();
        if ("doSome".equals(methodName)){
            serviceTools.doLog();
            //执行目标类的方法，通过Method类实现
            res = method.invoke(target, args);//someServiceImpl.doSome   doOther
            //目标方法的执行结果
            serviceTools.doTrans();
        }else{
            res = method.invoke(target, args);//someServiceImpl.doSome   doOther

        }

        return res;
    }
}
