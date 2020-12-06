package com.wuminghui.bao05;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//切面类
//@Aspect是aspectj框架中的注解，表示当前类是切面类
//切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码。
//使用位置：类定义的上面。
@Aspect
public class myAspect {
    /*使用Pointcut：定义，管理切入点，减少代码冗余
    * 属性：value（"切入点表达式"）
    * 位置：自定义方法上面
    * 特点：当在一个方法上使用Pointcut，这个方法的名称就可以作为pointcut起的别名了，
    * 其他通知中的value属性就可以直接使用别名（定义的方法名+()）。
    *
    * */
    @Pointcut(value = "execution(* doOther(..))")
    public void point(){}
    @Before(value = "point()")
    public void myBefore(){
        System.out.println("前置通知执行切面功能####");
    }
    @AfterReturning(value = "point()",returning = "res")
    public void myAfterReturning(Object res){

        System.out.println("后置通知，在目标方法之后执行，得到返回值为：" + res);

    }

}
