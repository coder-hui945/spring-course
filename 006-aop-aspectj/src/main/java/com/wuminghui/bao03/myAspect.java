package com.wuminghui.bao03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

//切面类
//@Aspect是aspectj框架中的注解，表示当前类是切面类
//切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码。
//使用位置：类定义的上面。
@Aspect
public class myAspect {
    /*环绕通知：
            1.定义格式：
                    1.public
                    2.必须有一个返回值，推荐使用Object类型
                    3.方法名称自定义
                    4.有参数，但是参数固定ProceedingJoinPoint
    *       2.@Around：环绕通知
                    1.属性：value = “切入表达式”
                    2.位置：方法定义的上面
            3.特点：
                    1.它是功能最强的一个通知
                    2.在目标方法的前后都会执行
                    3.控制目标方法是否被调用执行
                    4.能修改目标方法的的执行结果（影响最后的调用结果）
            环绕通知等同于JDK动态代理的 InvocationHandler接口（前后都能加功能）
            ProceedingJoinPoint等同于JDK动态代理的Method（执行目标方法的）
            返回值：目标方法的返回结果，可以被修改。
            环绕通知经常用来做事务，在目标方法之前开启事务，之后提交事务。
    *
    * */
    @Around(value = "execution(* doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        /*实现环绕通知的功能*/
        Object[] args = pjp.getArgs();
        String name = "";
        Object res = null;
        //2.目标方法前面加功能
        System.out.println("执行方法时间：" + new Date());
        /*通过条件来决定目标方法是否被调用*/
        if (args != null &&args.length > 1){
            Object arg = args[0];
            name = (String) arg;
            if ("吴明辉".equals(name)){
                //1.目标方法调用
                res = pjp.proceed();//执行目标方法，相当于Method.invoke()
                res = "888";
            }else{
                System.out.println("没有调用目标方法");
                res = "777";
            }
        }

        //3.执行方法之后加功能

        System.out.println("执行目标方法后的功能。。。");
        //4.返回目标方法的值
        return res;
    }

}
