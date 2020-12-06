package com.wuminghui.bao02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

//切面类
//@Aspect是aspectj框架中的注解，表示当前类是切面类
//切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码。
//使用位置：类定义的上面。
@Aspect
public class myAspect {
    /*定义后置通知方法，实现切面功能。
        定义要求：1.必须是公共方法public
                  2.方法不能有返回值void
                  3.方法名称自定义
                  4.方法有参数,推荐使用Object  参数名自定义
*/
    /*
    @AfterReturning：后置通知
     属性：1.value  切入点表达式
            2.returning 自定义的变量，用来表示目标方法的返回值的。
                自定义的变量名必须和通知方法的形参名一样。
     使用位置：方法定义的上面。
     特点：1.在目标方法之后执行
            2.能够获取目标方法的返回值，可以根据这个返回值做相应处理功能。
                相当于执行了   Object res = doOther（）；
            3.可以修改这个返回值。
     */
    /*后置通知的执行：
        Object res = doOther（）；
    *   AfterReturning（res）；
    *
    *
    *
    * */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning(Object res){

        System.out.println("后置通知，在目标方法之后执行，得到返回值为：" + res);
        res  =  88;//待测：（值传递，引用传递）证明在测试方法中调用 int res = proxy.doOther("吴明辉", 25);时，返回结果是不能被这个切面函数修改的？？
    }

}
